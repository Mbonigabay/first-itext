package dev.mbonigabay.firstitext;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import dev.mbonigabay.firstitext.service.PdfFileService;

@SpringBootApplication
public class FirstItextApplication {
    public static void main(String[] args) throws IOException {
        SpringApplication.run(FirstItextApplication.class, args);

        System.out.println("Application started run");
        PdfFileService.simplePdfCreation();
        PdfFileService.linePdfCreation();
        System.out.println("PDF created");

    }

}
