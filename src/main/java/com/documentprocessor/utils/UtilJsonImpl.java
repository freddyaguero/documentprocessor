package com.documentprocessor.utils;


import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.*;
import java.util.zip.*;

import com.documentprocessor.dto.Documento;
import com.documentprocessor.dto.Entrada;
import com.documentprocessor.dto.Lote;
import com.google.gson.Gson;

public class UtilJsonImpl implements UtilJson{

    Lote lote;
    Gson gson;

    public UtilJsonImpl(String inputPath, String outputDir){

        // Leer archivo JSON
        try {
            Files.createDirectories(Paths.get(outputDir));
        } catch (IOException e) {
            System.out.println("Error al crear directorio de salida: "+e.getMessage());
        }
        Gson gson = new Gson();
        Reader reader=null;
        try {
            reader = new FileReader(inputPath);
        } catch (FileNotFoundException e) {
            System.out.println("Error al leer archivo de entrada: "+e.getMessage());
        }
        Lote lote = gson.fromJson(reader, Lote.class);
        this.lote=lote;
        this.gson=gson;

    }

    public Lote getLote() {
        return lote;
    }


    public Documento getDocument(Entrada entrada){
         byte[] gzipData = Base64.getDecoder().decode(entrada.getContentBase64());
            String jsonStr="";

            try {
                jsonStr = new String(unzipGZIP(gzipData), StandardCharsets.UTF_8);
            } catch (IOException e) {
                System.out.println("Error al unzipGZIP :"+e.getMessage());
            }

            Documento doc = gson.fromJson(jsonStr, Documento.class);

            return doc;
    }

     private static byte[] unzipGZIP(byte[] comprimido) throws IOException {
        try (ByteArrayInputStream bais = new ByteArrayInputStream(comprimido);
             GZIPInputStream gis = new GZIPInputStream(bais);
             ByteArrayOutputStream baos = new ByteArrayOutputStream()) {

            byte[] buffer = new byte[4096];
            int leido;
            while ((leido = gis.read(buffer)) != -1) {
                baos.write(buffer, 0, leido);
            }
            return baos.toByteArray();
        }
    }
    
}
