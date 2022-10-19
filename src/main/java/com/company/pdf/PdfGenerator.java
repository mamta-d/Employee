package com.company.pdf;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

import com.company.entity.Employee;
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
@Component
public class PdfGenerator {
	public void generate(List < Employee > l, HttpServletResponse response) throws DocumentException, IOException {

	    Document document = new Document(PageSize.A4);

	    PdfWriter.getInstance(document, response.getOutputStream());

	    document.open();

	    Font fontTiltle = FontFactory.getFont(FontFactory.TIMES_ROMAN);

	    fontTiltle.setSize(20);

	    Paragraph paragraph1 = new Paragraph("List of the Employee", fontTiltle);

	    paragraph1.setAlignment(Paragraph.ALIGN_CENTER);
	    
	    document.add(paragraph1);

	    PdfPTable table = new PdfPTable(4);
	    
	    table.setWidthPercentage(100.0f);

	    table.setWidths(new int[] {3,3,3,3});

	    table.setSpacingBefore(5);

	    PdfPCell cell = new PdfPCell();

	    cell.setBackgroundColor(CMYKColor.BLUE);

	    cell.setPadding(5);

	    Font font = FontFactory.getFont(FontFactory.TIMES_ROMAN);

	    font.setColor(CMYKColor.WHITE);

	    cell.setPhrase(new Phrase("ID", font));

	    table.addCell(cell);

	    cell.setPhrase(new Phrase(" Name", font));

	    table.addCell(cell);

	    cell.setPhrase(new Phrase("Address", font));

	    table.addCell(cell);

	    cell.setPhrase(new Phrase("Mobile No", font));

	    table.addCell(cell);


	    for (Employee e: l) {


	      table.addCell(String.valueOf(e.getEmpId()));

	      table.addCell(e.getEmpName());

	      table.addCell(e.getEmpAddress());
	      table.addCell(String.valueOf(e.getEmpPhone()));

	    }

	   

	    document.add(table);


	    document.close();

	  }

	}


