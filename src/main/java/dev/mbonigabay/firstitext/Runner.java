package dev.mbonigabay.firstitext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

import dev.mbonigabay.firstitext.service.PdfFileService;

public class Runner implements ApplicationRunner {
    @Autowired
    private PdfFileService pdfFileService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("Application started run");
        // pdfFileService.pdfCreation();
        System.out.println("PDF created");
    }
    
}
