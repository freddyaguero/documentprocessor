package com.documentprocessor.utils;

import com.documentprocessor.dto.Documento;

public interface LoteOut {

    public void appendChild(Documento doc);
    public void writeDocument(String outputDir, String documentName);
}
