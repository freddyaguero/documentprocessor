package com.documentprocessor.utils;
import java.io.File;

import javax.xml.parsers.*;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.*;

import com.documentprocessor.dto.Documento;

public class LoteOutImpl implements LoteOut {

    Element root;
    Document xmlDoc;

    public LoteOutImpl(){
        
        // Generar XML en constructor
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder=null;
        try {
            builder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            System.out.println("Error al ParserConfigurationException xml  :"+e.getMessage());
        }
        Document xmlDoc = builder.newDocument();

        Element root = xmlDoc.createElement("DTE");
        root.setAttribute("version", "1.0");
        xmlDoc.appendChild(root);

        this.xmlDoc=xmlDoc;
        this.root=root;
    }


    public void appendChild(Documento doc){

            //Agrega hijo
            Element documento = xmlDoc.createElement("Documento");
            documento.setAttribute("ID", doc.getId());
            root.appendChild(documento);

            documento.appendChild(createElement(xmlDoc, "Cliente", doc.getName()));
            documento.appendChild(createElement(xmlDoc, "Tipo", doc.getType()));
            documento.appendChild(createElement(xmlDoc, "TotalAPagar", doc.getTotalAPagar()));
            documento.appendChild(createElement(xmlDoc, "MedioPago", doc.getMedioPago()));
    }

    public void writeDocument(String outputDir, String documentName){

        // Escribir archivo XML
        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer transformer=null;
        try {
            transformer = tf.newTransformer();
        } catch (TransformerConfigurationException e) {
            System.out.println("Error TransformerConfigurationException  :"+e.getMessage());
        }
        transformer.setOutputProperty("encoding", "ISO-8859-1");
        transformer.setOutputProperty("indent", "yes");
        DOMSource source = new DOMSource(xmlDoc);
        StreamResult result = new StreamResult(new File(outputDir + "/" + documentName+ ".xml"));
        try {
            transformer.transform(source, result);
        } catch (TransformerException e) {
             System.out.println("Error TransformerException  :"+e.getMessage());
        }
    }

    private static Element createElement(Document doc, String nombre, String valor) {
        //Crea atributo
        Element el = doc.createElement(nombre);
        el.setTextContent(valor);
        return el;
    }
}
