/*
 * (c) UNAM, 2023
 */
package mx.unam.sa.Ocrpdf.controller.models;

import java.io.File;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

/**
 *
 * @author israel1971
 */
public class OcrPDFTest {

    public OcrPDFTest() {
    }

//    @Test
    public void testGetText() {
        System.out.println("testGetText");
        OcrPDF ocrPDF = new OcrPDF();

        String filePath = "C:\\temp\\oficios\\docto.pdf";;
        File file = new File(filePath);
        
        try {
            ocrPDF.getText(file);
        } catch (Exception e) {
            assertTrue(false);
        }
        

    }

}
