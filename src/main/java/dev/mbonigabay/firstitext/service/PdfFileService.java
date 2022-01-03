package dev.mbonigabay.firstitext.service;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.itextpdf.io.font.FontConstants;
import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfPage;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.canvas.PdfCanvas;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.List;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;

import org.springframework.stereotype.Service;

@Service
public class PdfFileService {
    public static void simplePdfCreation() throws IOException {
        String filepath = "/home/yusuf/Videos/Dev/Projects/+Study/SpringBoot/first-itext/simple.pdf";

        try {
            PdfWriter writer = new PdfWriter(filepath);
            PdfDocument pdfdoc = new PdfDocument(writer);
            Document document = new Document(pdfdoc);

            PdfFont font = PdfFontFactory.createFont(FontConstants.HELVETICA_BOLD); 

            String p = "The journey commenced with a single tutorial on HTML in 2006"
                    + "and elated by the response it generated, we worked our way to adding fresh" +
                    "tutorials to our repository which now proudly flaunts a wealth of tutorials " +
                    "and allied articles on topics ranging from programming languages to web designing " +
                    "to academics and much more.";
            Paragraph para = new Paragraph(p);

            // Creating a list
            List list = new List();
            list.setFont(font);
            list.add("Java");
            list.add("JavaFX");
            list.add("Apache Tika");
            list.add("OpenCV");

            // Creating an ImageData object
            String imageFile = "/home/yusuf/Pictures/test.png";
            ImageData data = ImageDataFactory.create(imageFile);
            // Creating an Image object
            Image img = new Image(data);

            // Creating a table object
            float[] pointColumnWidths = { 150F, 150F, 150F, 150f };
            Table table = new Table(pointColumnWidths);

            // Adding cells to the table
            table.addCell(new Cell().add("Id"));
            table.addCell(new Cell().add("Name"));
            table.addCell(new Cell().add("Designation"));
            table.addCell(new Cell().add("Skills"));
            // table.addCell(new Cell().add("image"));
            table.addCell(new Cell().add("1001"));
            table.addCell(new Cell().add("Raju"));
            table.addCell(new Cell().add("Programmer"));
            table.addCell(new Cell().add(list));
            // table.addCell(new Cell().add(img.setAutoScale(true)));

            document.add(para);
            document.add(list);
            document.add(table);
            document.add(img);
            document.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void linePdfCreation() {
        String filepath = "/home/yusuf/Videos/Dev/Projects/+Study/SpringBoot/first-itext/line.pdf";

        try (PdfWriter writer = new PdfWriter(filepath)) {
            PdfDocument pdfdoc = new PdfDocument(writer);
            Document document = new Document(pdfdoc);
            // Creating a new page
            PdfPage pdfPage = pdfdoc.addNewPage();

            // Creating a PdfCanvas object
            PdfCanvas canvas = new PdfCanvas(pdfPage);

            // Initial point of the line
            canvas.moveTo(100, 300);

            // Drawing the line
            canvas.lineTo(500, 300);

            // Closing the path stroke
            canvas.closePathStroke();

            // Closing the document
            document.close();

            System.out.println("Object drawn on pdf successfully");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
