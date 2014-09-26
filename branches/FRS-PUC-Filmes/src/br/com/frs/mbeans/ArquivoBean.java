package br.com.frs.mbeans;

import java.io.IOException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.dom4j.DocumentException;

import com.lowagie.text.BadElementException;
import com.lowagie.text.Document;
import com.lowagie.text.PageSize;

@ManagedBean
@ViewScoped
public class ArquivoBean {  
	  
	  
	    public void gerarXLS(Object document) {  
	        HSSFWorkbook wb = (HSSFWorkbook) document;  
	        HSSFSheet sheet = wb.getSheetAt(0);  
	        HSSFRow header = sheet.getRow(0);  
	  
	        HSSFCellStyle cellStyle = wb.createCellStyle();  
	        cellStyle.setFillForegroundColor(HSSFColor.GREEN.index);  
	        cellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);  
	  
	        for (int i = 0; i < header.getPhysicalNumberOfCells(); i++) {  
	            HSSFCell cell = header.getCell(i);	  
	            cell.setCellStyle(cellStyle);  
	        }  
	    }  
	  
	  
	   
	    public void gerarPDF(Object document) throws IOException, DocumentException, BadElementException, com.lowagie.text.DocumentException {  
	        Document pdf = (Document) document;  
	        pdf.open();  
	        pdf.setPageSize(PageSize.A4);  
	  
	        /*ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();  
	        String logo = servletContext.getRealPath("") + File.separator + "images" + File.separator + "prime_logo.png";  
	  
	        pdf.add(Image.getInstance(logo));*/  
	    }  
	      
	} 
