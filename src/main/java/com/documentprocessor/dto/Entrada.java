package com.documentprocessor.dto;

public class Entrada {
        String DocType;
        String NroDocInterno;
        String ContentBase64;
        
        public String getDocType() {
            return DocType;
        }
        public void setDocType(String docType) {
            DocType = docType;
        }
        public String getNroDocInterno() {
            return NroDocInterno;
        }
        public void setNroDocInterno(String nroDocInterno) {
            NroDocInterno = nroDocInterno;
        }
        public String getContentBase64() {
            return ContentBase64;
        }
        public void setContentBase64(String contentBase64) {
            ContentBase64 = contentBase64;
        }

        
}
