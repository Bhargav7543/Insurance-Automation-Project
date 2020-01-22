package tests;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import utility.CommonFunctions;
import utility.ReadPropertyConfig;
import utility.ReportsClass;
import utility.ScreenCaptureUtilies;

public class PDFRead_Test {

	ReadPropertyConfig readPro = new ReadPropertyConfig();
	String pdfURLPath = readPro.getPdfURLPath();
	String pdfFilePath = readPro.getPdfFilePath();
	WebDriver driver;
	
	
	@BeforeMethod
	public void beforeMethod() {
		ReportsClass.startUp();
		ReportsClass.initialisation("PDFRead_Test");
	}

	@Test
	public void pdfRead_Test() throws Exception {
		CommonFunctions.PdfReaderFromURL(pdfURLPath, "For most of the examples given in this tutorial");
		CommonFunctions.PdfReader(pdfFilePath, "But not as boring as watching");
		ReportsClass.logStat(Status.PASS, "Successfully Data from PDF File !!!");
	}

	@AfterMethod
	public void afterMethod(ITestResult result) {
		if(ITestResult.FAILURE == result.getStatus()){
			ScreenCaptureUtilies.captureScreenshot(driver, result.getName());
		}
		ReportsClass.endTest();
	}
}
