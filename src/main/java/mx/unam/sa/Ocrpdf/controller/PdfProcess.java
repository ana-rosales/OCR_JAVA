/*
 * (c) UNAM, 2023
 */
package mx.unam.sa.Ocrpdf.controller;

import mx.unam.sa.Ocrpdf.controller.service.PdfService;

//import java.io.File;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


/**
 *
 * @author israel1971
 */
@RestController
public class PdfProcess {
    
    @Autowired
    PdfService pdfService;
    
    @GetMapping
    public ResponseEntity<String> inicial() {
        return new ResponseEntity<String>("OK", HttpStatus.OK);    
    }   
    
    @PostMapping("/process")
    public ResponseEntity<String> handleFileUpload(@RequestParam("file") MultipartFile file) {
        try {
            String result = pdfService.getContenido(file);
            return new ResponseEntity<String>(result, HttpStatus.OK);    
        } catch (Exception e) {
            e.printStackTrace();
            
            return new ResponseEntity<>("Error al subir el archivo", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
