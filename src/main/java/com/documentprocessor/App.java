package com.documentprocessor;

import java.util.*;

import com.documentprocessor.dto.Documento;
import com.documentprocessor.utils.LoteOut;
import com.documentprocessor.utils.LoteOutImpl;
import com.documentprocessor.utils.UtilHTML;
import com.documentprocessor.utils.UtilHTMLImpl;
import com.documentprocessor.utils.UtilJsonImpl;

public class App {

    public static final String NAME_XML="lote";

    public static void main(String[] args) throws Exception {
        long startTime = System.currentTimeMillis();
        System.out.println("tiempo Inicio: " + startTime + " ms");

        String inputPath = "lote.ejemplo.json";
        String outputDir = "output";

        UtilJsonImpl utilJson= new UtilJsonImpl(inputPath,outputDir);

        // Para el reporte de resumen
        Map<String, Integer> contadorDocs = new HashMap<>();
        Map<String, Double> sumaMontos = new HashMap<>();

        //Crea xml
        LoteOut loteOut= new LoteOutImpl();

        // Recorre los documentos json
        utilJson.getLote().getDocuments().forEach( entrada -> {

            //Lee documento json
            Documento doc = utilJson.getDocument(entrada);

            // Agrega hijo a xml
            loteOut.appendChild(doc);

            // Acumular totales para reporte
            contadorDocs.merge(doc.getMedioPago(), 1, Integer::sum);
            sumaMontos.merge(doc.getMedioPago(), Double.parseDouble(doc.getTotalAPagar()), Double::sum);

        });   

        // Escribir archivo xml
        loteOut.writeDocument(outputDir, NAME_XML);

        // Genera reporte HTML
        UtilHTML utilHTML=new UtilHTMLImpl(contadorDocs, sumaMontos, outputDir);
        utilHTML.createReport();

        long endTime = System.currentTimeMillis();
        System.out.println("Tiempo Fin: " + endTime + " ms");
        System.out.printf("✅ Proceso terminado. Tiempo total: %.2f segundos%n", (endTime - startTime) / 1000.0);
    }
}
