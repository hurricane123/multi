package com.hurricane.learn.springboot.web.controller;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.export.JRXlsExporterParameter;
import net.sf.jasperreports.engine.util.JRLoader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hurricane.learn.springboot.web.entity.User;
import com.hurricane.learn.springboot.web.service.UserService;
import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

@RequestMapping("user")
@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("userData")
	public Object userData(@RequestParam Map map) {
		Object object = map.get("page");
		Object object2 = map.get("rows");
		int page = Integer.parseInt((String) Optional.ofNullable(object).orElse("1"));
		int size = Integer.parseInt((String) Optional.ofNullable(object2).orElse("5"));
		Object object3 = userService.getUserByPage(page, size);
		return object3;
	}
	
	@RequestMapping("export")
	public void exportUserData(@RequestParam Map map,HttpServletResponse response) {
		Object object = map.get("page");
		Object object2 = map.get("size");
		int page = Integer.parseInt((String) Optional.ofNullable(object).orElse("1"));
		int size = Integer.parseInt((String) Optional.ofNullable(object2).orElse("5")) ;
		response.setHeader("Content-disposition","attachment;filename=userInfo.pdf");
		try {
			ServletOutputStream outputStream = response.getOutputStream();
			outputPdf((page-1)*size, size,outputStream);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void outputPdf(int begin, int size,OutputStream out) throws ClassNotFoundException, SQLException, FileNotFoundException, JRException {
		JasperReport report = (JasperReport)JRLoader.loadObject(UserController.class.getClassLoader().getResourceAsStream("userReport.jasper"));
	    Map parameters = new HashMap();
	    parameters.put("begin", begin);
	    parameters.put("size", size);
		System.out.println(begin);
		System.out.println(size);
	    Class.forName("com.mysql.jdbc.Driver");
	    Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/temp", "root", "root");
		System.out.println("Connection1 Successful!");
		
	    JasperPrint jasperPrint = JasperFillManager.fillReport(report, parameters, conn);
	    
	    JRPdfExporter exporter = new JRPdfExporter();   
        exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, out);  
        exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);              

        exporter.setParameter(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS, Boolean.TRUE); // 删除记录最下面的空行
        exporter.setParameter(JRXlsExporterParameter.IS_ONE_PAGE_PER_SHEET, Boolean.FALSE);// 删除多余的ColumnHeader
        exporter.setParameter(JRXlsExporterParameter.IS_WHITE_PAGE_BACKGROUND, Boolean.FALSE);// 显示边框
        exporter.exportReport();
        
	    conn.close();
	}
	
	@RequestMapping("exportUsePoi")
	public void exportUserDataUsePoi(@RequestParam Map map,HttpServletResponse response) {
		Object object = map.get("page");
		Object object2 = map.get("size");
		int page = Integer.parseInt((String) Optional.ofNullable(object).orElse("1"));
		int size = Integer.parseInt((String) Optional.ofNullable(object2).orElse("5")) ;
		response.setHeader("Content-disposition","attachment;filename=userInfo.pdf");
		try {
			ServletOutputStream outputStream = response.getOutputStream();
			outputPdfUsePoi((page-1)*size, size,outputStream);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void outputPdfUsePoi(int begin, int size,OutputStream out) throws Exception {
		List<User> userByRange = userService.getUserByRange(begin, size);
		if (userByRange!=null && userByRange.size()>0) {
			Document document = new Document();
			BaseFont bfChinese = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", false);
			Font fontZH = new Font(bfChinese, 12.0F, 0);
			PdfWriter writer = PdfWriter.getInstance(document, out);
			document.open();
			String title = "用户信息";
			document.add(new Paragraph(new Chunk(title, fontZH).setLocalDestination(title)));
			document.add(new Paragraph("\n"));
			PdfPTable table = new PdfPTable(3);
			table.setWidthPercentage(100.0F);
			table.setHeaderRows(1);
			table.getDefaultCell().setHorizontalAlignment(1);
			table.addCell(new Paragraph("ID", fontZH));
			table.addCell(new Paragraph("用户名", fontZH));
			table.addCell(new Paragraph("密码", fontZH));
			for (User user : userByRange) {
				table.addCell(new Paragraph(user.getId()+"", fontZH));
				table.addCell(new Paragraph(user.getUsername(), fontZH));
				table.addCell(new Paragraph(user.getPassword(), fontZH));
			}
			document.add(table);
			document.add(new Paragraph("\n"));
			
			writer.flush();
			document.close();
		}
	}

}
