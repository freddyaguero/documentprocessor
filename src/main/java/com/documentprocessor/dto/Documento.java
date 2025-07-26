package com.documentprocessor.dto;

public class Documento {
        String id;
        String name;
        String type;
        String totalAPagar;
        String medioPago;
        
        public String getId() {
            return id;
        }
        public void setId(String id) {
            this.id = id;
        }
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public String getType() {
            return type;
        }
        public void setType(String type) {
            this.type = type;
        }
        public String getTotalAPagar() {
            return totalAPagar;
        }
        public void setTotalAPagar(String totalAPagar) {
            this.totalAPagar = totalAPagar;
        }
        public String getMedioPago() {
            return medioPago;
        }
        public void setMedioPago(String medioPago) {
            this.medioPago = medioPago;
        }


        
    }
