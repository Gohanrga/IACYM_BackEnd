package com.acym.controller.report;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.engine.util.JRSaver;

@RestController
@RequestMapping("/api")
public class PdfController {
	
	@Autowired
    ApplicationContext context;
	
	@GetMapping(path = "/reporte")
    @ResponseBody	
	public void getPDF(HttpServletResponse response)throws Exception {
		Resource resource = context.getResource("classpath:PromsesasDeFe.jrxml");
		File file = ResourceUtils.getFile("classpath:PromsesasDeFe.jrxml");
		System.out.println(file.getAbsolutePath());
		//Compile to jasperReport
		
        InputStream inputStream = resource.getInputStream();
        JasperReport report = JasperCompileManager.compileReport(inputStream);
      //Parameters Set
        Map<String, Object> params = new HashMap<>();

        //List<Car> cars = (List<Car>) carRepository.findAll();

        //Data source Set
        //JRDataSource dataSource = new JRBeanCollectionDataSource(cars);
        //params.put("datasource", dataSource);
        
        
        //Make jasperPrint
        JasperPrint jasperPrint = JasperFillManager.fillReport(report, params, this.getConecction());
        //Media Type
        response.setContentType(MediaType.APPLICATION_PDF_VALUE);
        //Export PDF Stream
        JasperExportManager.exportReportToPdfStream(jasperPrint, response.getOutputStream());
	}
	
	private Connection getConecction() {
		Connection conn = null;
		try {
	        Class.forName("com.mysql.jdbc.Driver");
	        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/IACYM_BD","root","Gohanrga01");
	    } catch (SQLException ex) {
	    	ex.printStackTrace();
	    } catch (ClassNotFoundException ex) {
	    	ex.printStackTrace();
	    }
		return conn;
	}
	
}
