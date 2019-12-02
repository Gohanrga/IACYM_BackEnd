package com.acym.service.report;

import org.springframework.stereotype.Service;

@Service
public class ReportService {
	public String generateReport() {
		try {
			return "";
		}
		catch(Exception e) {
			e.printStackTrace();
			return e.getMessage();
		}
	}
}
