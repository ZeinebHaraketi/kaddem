package tn.esprit.springboot.kaddem1.util;
import java.io.IOException;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import tn.esprit.springboot.kaddem1.entity.Projet;

import com.lowagie.text.Document;

import com.lowagie.text.DocumentException;

import com.lowagie.text.Font;

import com.lowagie.text.FontFactory;

import com.lowagie.text.PageSize;

import com.lowagie.text.Paragraph;

import com.lowagie.text.Phrase;

import com.lowagie.text.pdf.CMYKColor;

import com.lowagie.text.pdf.PdfPCell;

import com.lowagie.text.pdf.PdfPTable;

import com.lowagie.text.pdf.PdfWriter;

public class PdfGenerator {

    public void generate(List<Projet> listP,HttpServletResponse response)throws DocumentException, IOException
    {
        // Creating the Object of Document

        Document document = new Document(PageSize.A4);

        // Getting instance of PdfWriter

        PdfWriter.getInstance(document, response.getOutputStream());

        // Opening the created document to change it

        document.open();

        // Creating font

        // Setting font style and size

        Font fontTiltle = FontFactory.getFont(FontFactory.TIMES_ROMAN);

        fontTiltle.setSize(20);

        // Creating paragraph

        Paragraph paragraph1 = new Paragraph("List of Projects", fontTiltle);

        // Aligning the paragraph in the document

        paragraph1.setAlignment(Paragraph.ALIGN_CENTER);

        // Adding the created paragraph in the document

        document.add(paragraph1);

        // Creating a table of the 4 columns

        PdfPTable table = new PdfPTable(2);

        // Setting width of the table, its columns and spacing

        table.setWidthPercentage(100f);

        table.setWidths(new int[] {3,3});

        table.setSpacingBefore(5);

        // Create Table Cells for the table header

        PdfPCell cell = new PdfPCell();

        // Setting the background color and padding of the table cell

        cell.setBackgroundColor(CMYKColor.BLUE);

        cell.setPadding(5);

        // Creating font

        // Setting font style and size

        Font font = FontFactory.getFont(FontFactory.TIMES_ROMAN);

        font.setColor(CMYKColor.WHITE);

        // Adding headings in the created table cell or  header

        // Adding Cell to table

        cell.setPhrase(new Phrase("ID", font));

        table.addCell(cell);

        cell.setPhrase(new Phrase("Description", font));

        table.addCell(cell);


        // Iterating the list of Projects

        for (Projet projet: listP){
            // Adding project id

            table.addCell(String.valueOf(projet.getIdProjet()));

            // Adding project description

            table.addCell(projet.getDescription());

        }

        // Adding the created table to the document

        document.add(table);

        // Closing the document

        document.close();

    }
}
