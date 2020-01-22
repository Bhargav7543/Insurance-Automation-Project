package tests;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import baseClass.TestBase;
import pageObject.Carpeesh_Page;
import utility.ReadPropertyConfig;
import utility.ReportsClass;
import utility.ScreenCaptureUtilies;

public class Carpeesh_Test extends TestBase {

	ReadPropertyConfig readPro = new ReadPropertyConfig();
	String url = readPro.getCarpeeshUrl();
	String sheetOne = readPro.getSheetOne();

	@BeforeMethod
	public void beforeMethod() throws Exception {
		Carpeesh_Page carpeeshPage = new Carpeesh_Page();
		ReportsClass.initialisation("Carpeesh_Test");
		openBrowser(url);
		carpeeshPage.clickIAgreeButton();
	}

	@Test
	public void carpeesh() throws Exception {
		Carpeesh_Page carpeeshPage = new Carpeesh_Page();
		carpeeshPage.enterPolicyHolderDetails(sheetOne, 8);
		ReportsClass.logStat(Status.PASS, "Carpeesh_Test : PASSED Successfully !!!");
	}

	@AfterMethod
	public void afterMethod(ITestResult result) {
		if(ITestResult.FAILURE == result.getStatus()){
			ScreenCaptureUtilies.captureScreenshot(driver, result.getName());
		}
	}
}
