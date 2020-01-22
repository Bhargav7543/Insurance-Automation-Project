package utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadPropertyConfig {
	Properties configProperty;
	Properties dataProperty;

	public ReadPropertyConfig() {
		File src = new File("./Configuration/config.properties");
		File src1 = new File("./Configuration/testdata.properties");

		try {
			FileInputStream fis = new FileInputStream(src);
			configProperty = new Properties();
			configProperty.load(fis);

			FileInputStream fis1 = new FileInputStream(src1);
			dataProperty = new Properties();
			dataProperty.load(fis1);
		} catch (Exception e) {
			System.out.println("Exception is" + e.getMessage());
		}
	}

	// Excel Property
	public String getExcelPath() {
		String excelPath = configProperty.getProperty("EXCEL_FILE");
		return excelPath;
	}

	public String getSheetOne() {
		String sheetOne = dataProperty.getProperty("PART_ONE");
		return sheetOne;
	}

	public String getSheetTwo() {
		String sheetTwo = dataProperty.getProperty("PART_TWO");
		return sheetTwo;
	}

	public String getSheetThree() {
		String sheetThree = dataProperty.getProperty("PART_Three");
		return sheetThree;
	}

	public String getSheetFour() {
		String sheetFour = dataProperty.getProperty("PART_FOUR");
		return sheetFour;
	}

	public String getCarpeeshUrl() {
		String carpeeshUrl = dataProperty.getProperty("CARPEESH_URL");
		return carpeeshUrl;
	}
	
	//Extent Report get Property
		public String getExtentReportPath(){
			String extentReport = configProperty.getProperty("EXTENT_REPORT_PATH");
			return extentReport;
		}
		
	//Pdf File get Property
		public String getPdfFilePath(){
			String pdfFile = configProperty.getProperty("PDF_FILE_PATH");
			return pdfFile;
		}
		
		public String getPdfURLPath(){
			String pdfFile = configProperty.getProperty("PDF_URL_PATH");
			return pdfFile;
		}
}
