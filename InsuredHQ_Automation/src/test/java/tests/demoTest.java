package tests;

import utility.ReadPropertyConfig;
import utility.Xls_Reader;

public class demoTest {

	public static void main(String[] args) {
		ReadPropertyConfig readPro = new ReadPropertyConfig();
		String excelFile = readPro.getExcelPath();
		Xls_Reader reader = new Xls_Reader(excelFile);
		String sheetName = "Part-2";
		String data = reader.getCellData(sheetName, 1, 2);
		System.out.println(data);

		int rowCount = reader.getRowCount(sheetName);
		System.out.println("Total Raw Count:" + rowCount);
		
		String data1 = reader.getCellData(sheetName, "Postal Address1", 2);
		System.out.println("*******************"+data1);
	}

}
