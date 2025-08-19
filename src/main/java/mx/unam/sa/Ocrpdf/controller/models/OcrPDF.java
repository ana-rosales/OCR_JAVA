/*
 * (c) UNAM, 2023
 */
package mx.unam.sa.Ocrpdf.controller.models;

import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import net.sourceforge.tess4j.Tesseract;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.ImageType;
import org.apache.pdfbox.rendering.PDFRenderer;

/**
 *
 * @author israel1971
 */
public class OcrPDF {

    public static String getText(File file) throws Exception {
        String result = "";
        try {
            /*PDDocument document = PDDocument.load (file);
            PDFRenderer pdfRenderer = new PDFRenderer(document);
            StringBuilder out = new StringBuilder();

            for (int page = 0; page < document.getNumberOfPages(); page++) { //escanea varias img
                BufferedImage bim = pdfRenderer.renderImageWithDPI(page, 300, ImageType.RGB);
        		BufferedImage bim = ImageIO.read(file);

                File temp = File.createTempFile("tempfile", ".png");
                ImageIO.write(bim, "png", temp);	//guarda un png con la img de la pagina*/
                
                Tesseract tesseract = new Tesseract();
                tesseract.setDatapath("./src/main/resources/tessdata");
                tesseract.setLanguage("spa");
                tesseract.setPageSegMode(1);
                tesseract.setOcrEngineMode(1);
                result = tesseract.doOCR(/*temp*/file);
                /*temp.delete();
            }
            document.close();*/
            return result;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    
 }
