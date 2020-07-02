package com.fstg.gestion.exams.model.service.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.fstg.gestion.exams.beans.Exam;
import com.fstg.gestion.exams.beans.ExamEtudiant;
  

public class ExcelUtil {
	
	public static int exportExcel(List<ExamEtudiant> examEtudiants, Exam exam) throws IOException {
		//Create workbook in .xlsx format
		XSSFWorkbook workbook = new XSSFWorkbook();
		FileOutputStream out = new FileOutputStream(new File("C:\\Users\\LEILA\\pfe\\excel\\Etudiants "+ exam.getFiliere().getLibelle()+ " " +exam.getReference() + new Date().getTime()+ ".xlsx"));
		//Create sheet
		XSSFSheet Spreadsheet = workbook.createSheet("Etudiants");
		//Create top row with column headings 
		String[] columnHeadings = { "Cne", "Nom", "Prénom", "Salle/Amphi"};
	    CellStyle headerStyle = workbook.createCellStyle();
		headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		headerStyle.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.index);
		
		//Create the header row 
		Row headerRow = Spreadsheet.createRow(0);
		for(int i=0; i< columnHeadings.length; i++){
			Cell cell = headerRow.createCell(i);
			cell.setCellValue(columnHeadings[i]);
		    cell.setCellStyle(headerStyle);
		}
		
		
	 
		int rownums = 1;
	  for(ExamEtudiant examEtudiant : examEtudiants) {
	    	Row row = Spreadsheet.createRow(rownums++);
	    	row.createCell(0).setCellValue(examEtudiant.getEtudiant().getCne());
	    	row.createCell(1).setCellValue(examEtudiant.getEtudiant().getNom());
	    	row.createCell(2).setCellValue(examEtudiant.getEtudiant().getPrenom());
	    	row.createCell(3).setCellValue(examEtudiant.getSalle().getDesignation());
	    
	  }
	    for(int i=0; i<columnHeadings.length; i++) {
	    	Spreadsheet.autoSizeColumn(i);
	    }
		workbook.write(out);
		out.close();
		workbook.close(); 
		return 1;
	}
	

}
