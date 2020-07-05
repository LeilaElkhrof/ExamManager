package com.fstg.gestion.exams.model.service.util;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;


import com.fstg.gestion.exams.beans.Exam;
import com.fstg.gestion.exams.beans.ExamEtudiant;
import com.fstg.gestion.exams.beans.Salle;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class PdfUtil {
	

	public static  int imprimerListeSalle(List<Salle> salles) throws Exception, DocumentException {
		Document document = new Document();
		//PdfWriter.getInstance(document, new FileOutputStream("C:\\Users\\LEILA\\pfe\\pdf\\Salles.pdf"));
		PdfWriter.getInstance(document, new FileOutputStream("C:\\Users\\HPELITEBOOK\\Documents\\pdf\\Salles.pdf"));
		document.open();
		
		Image img;
		try {
			img = Image.getInstance("logo.PNG");
			img.setWidthPercentage(1f);
			img.setAlignment(Element.ALIGN_TOP);
			img.setAlignment(Element.ALIGN_RIGHT);
			document.add(img);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Font font = FontFactory.getFont(FontFactory.TIMES_BOLD, 16, BaseColor.BLACK);
		Paragraph titre = new Paragraph("\n\n\n La liste des salles\n\n", font);
		titre.setAlignment(Element.ALIGN_CENTER);
		 document.add(titre);
		 
		PdfPTable table = new PdfPTable(4);
		table.setWidthPercentage(105);
		table.setSpacingBefore(11f);
		table.setSpacingAfter(11f);
		float colWidth[] = {2f, 2f, 2f, 2f};
		table.setWidths(colWidth);
		
	
		addTableHeader(table);
		addRows(table, salles);		
		document.add(table);
		
		document.close();
		return 1;
	}
	
	private static void addTableHeader(PdfPTable table) {
	    Stream.of("Désignation", "Capacité", "Type", "Etat")
	      .forEach(columnTitle -> {
	        PdfPCell header = new PdfPCell();
	        header.setBackgroundColor(BaseColor.LIGHT_GRAY);
	        header.setBorderWidth(1);
	        header.setHorizontalAlignment(Element.ALIGN_CENTER);
	        header.setPhrase(new Phrase(columnTitle));
	        table.addCell(header);
	    });
	}
	
	private static void addRows(PdfPTable table, List<Salle> salles) {
		for(Salle salle: salles) {
			    table.addCell(salle.getDesignation());
			    table.addCell(Integer.toString(salle.getCapacite()));
			    table.addCell(salle.getType());
			    table.addCell(salle.getEtat());
			 
		}
	   
	}
	
	public static int imprimerListeEtudiants(List<ExamEtudiant> examEtudiants, Exam exam) throws DocumentException, FileNotFoundException {
		Document document = new Document();
		//PdfWriter.getInstance(document, new FileOutputStream("C:\\Users\\LEILA\\pfe\\pdf\\Etudiants "+exam.getReference()+ " " + exam.getFiliere().getLibelle()+new Date().getTime()+ " .pdf"));
		PdfWriter.getInstance(document, new FileOutputStream("C:\\Users\\HPELITEBOOK\\Documents\\pdf\\Etudiants "+exam.getReference()+ " " + exam.getFiliere().getLibelle()+new Date().getTime()+ " .pdf"));
		
		document.open();
		
		Image img;
		try {
			img = Image.getInstance("logo.PNG");
			img.setWidthPercentage(1f);
			img.setAlignment(Element.ALIGN_TOP);
			img.setAlignment(Element.ALIGN_CENTER);
			document.add(img);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Font font = FontFactory.getFont(FontFactory.TIMES_BOLD, 16, BaseColor.BLACK);
		Paragraph titre = new Paragraph( "\n\n Répartitions des étudiants " +exam.getFiliere().getLibelle() + " "+exam.getModule().getSemestre().getLibelle()+"\n Examen: "+exam.getModule().getLibelle()+ ", Le "+DateUtil.parseDate(exam.getDateDepart())+ ", du "+ DateUtil.parsehour(exam.getDateDepart())+ " à "+ DateUtil.parsehour(exam.getDateFin()) + "\n\n" , font);
		titre.setAlignment(Element.ALIGN_CENTER);
		 document.add(titre);
		 
		PdfPTable table = new PdfPTable(4);
		table.setWidthPercentage(105);
		table.setSpacingBefore(11f);
		table.setSpacingAfter(11f);
		float colWidth[] = {2f, 2f, 2f, 2f,};
		table.setWidths(colWidth);
		
	
		addTableHeader1(table);
		addRows1(table, examEtudiants);		
		document.add(table);
		
		document.close();
		return 1;
	}
	
	private static void addTableHeader1(PdfPTable table) {
	    Stream.of("CNE", "Nom", "Prénom", "Salle")
	      .forEach(columnTitle -> {
	        PdfPCell header = new PdfPCell();
	        header.setBackgroundColor(BaseColor.LIGHT_GRAY);
	        header.setBorderWidth(1);
	        header.setHorizontalAlignment(Element.ALIGN_CENTER);
	        header.setPhrase(new Phrase(columnTitle));
	        table.addCell(header);
	    });
	}
	
	private static void addRows1(PdfPTable table, List<ExamEtudiant> examEtudiants) {
		for(ExamEtudiant examEtudiant: examEtudiants) {
			    table.addCell(examEtudiant.getEtudiant().getCne());
			    table.addCell(examEtudiant.getEtudiant().getNom());
			    table.addCell(examEtudiant.getEtudiant().getPrenom());
			    table.addCell(examEtudiant.getSalle().getDesignation());
			 
		}
	   
	}
}
