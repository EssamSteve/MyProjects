/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ocr;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.ITesseract.RenderedFormat;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.Tesseract1;
import net.sourceforge.tess4j.TesseractException;
import net.sourceforge.tess4j.util.LoadLibs;
import net.sourceforge.tess4j.util.PdfUtilities;


/**
 *
 * @author essam
 */
public class OCRAPP_Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, TesseractException {
      
        File imageFile = new File("F:\\Tesseract\\TestData\\CAP-XX-Annual-Report-FY16.pdf");
        Tesseract instance = new Tesseract(); //
        
        // loading tessdata ? i don't know yet 
        File tessDataFolder = LoadLibs.extractTessResources("tessdata");
        instance.setDatapath(tessDataFolder.getAbsolutePath());
        
        //PDF FORMAT TO RENDER THE RESULT
        List<RenderedFormat> list = new ArrayList<>();
            list.add(RenderedFormat.PDF);
        //LANGUAGE
        instance.setLanguage("eng");
        //->HTML
        instance.setHocr(true);
        // IT HAS 3 MODES .... CUBE->1(for arabic(connedted character *_*)) AND TESSERACT->0 OR BOTH ->2
        instance.setOcrEngineMode(2);
        // create document ... specify (file loc to processd,out but file without .extension ^_^,render format)
        instance.createDocuments(imageFile.getAbsolutePath(), "F:\\Tesseract\\TestData\\CAP-XX-Annual-Report-FY16_OCR", list);

    }

}
