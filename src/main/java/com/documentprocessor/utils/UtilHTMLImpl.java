package com.documentprocessor.utils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

public class UtilHTMLImpl implements UtilHTML{

    StringBuilder html;
    Map<String, Integer> contadorDocs;
    Map<String, Double> sumaMontos;
    String outputDir;

    public UtilHTMLImpl(Map<String, Integer> contadorDocs,Map<String, Double> sumaMontos, String outputDir){

        this.contadorDocs=contadorDocs;
        this.sumaMontos=sumaMontos;
        this.outputDir=outputDir;
        
    }



    public void createReport(){

        // Generar Títulos HTML
        StringBuilder html = new StringBuilder();
        html.append("<html><head><title>Reporte</title></head><body>");
        html.append("<h1>Reporte de Cuadratura</h1><table border='1'>");
    

        int totalDocs = 0;
        double totalMontos = 0;
        String rowTitle="<tr><th></th>";
        String rowCount="<tr><td>Cantidad Docs</td>";
        String rowTotalMonto="<tr><th>Total a Pagar</th>";
        for (String medio : contadorDocs.keySet()) {

            rowTitle=rowTitle+"<th>"+medio+"</th>";

            int count = contadorDocs.get(medio);
            rowCount= rowCount+"<td>"+count+"</td>";
            totalDocs += count;

            double total = sumaMontos.get(medio);
            rowTotalMonto= rowTotalMonto+String.format("<th>%.2f</th>",total);
            totalMontos += total;
        }

        rowTitle=rowTitle+"<th>"+"TOTALES"+"</th>";
        rowTitle=rowTitle+"</tr>";
        html.append(rowTitle);

        rowCount=rowCount+"<td>"+totalDocs+"</td";
        rowCount=rowCount+"</tr>";
        html.append(rowCount);

        rowTotalMonto=rowTotalMonto+String.format("<th>%.2f</th>",totalMontos);
        rowTotalMonto=rowTotalMonto+"</tr>";
        html.append(rowTotalMonto);

        html.append("</table></body></html>");

        try {
            Files.write(Paths.get(outputDir, "reporte.html"), html.toString().getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
             System.out.println("Error al escribir reporte :"+e.getMessage());
        }

    }
}
