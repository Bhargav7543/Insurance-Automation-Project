package pageObject;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.util.DateFormatConverter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import baseClass.TestBase;
import locators.Locators.carpeeshLocators;
import utility.ReadPropertyConfig;
import utility.Xls_Reader;

public class Carpeesh_Page extends TestBase implements carpeeshLocators {
	ReadPropertyConfig readPro = new ReadPropertyConfig();
	String path = readPro.getExcelPath();
	Xls_Reader reader = new Xls_Reader(path);

	@FindBy(xpath = I_AGREE_BUTTON)
	WebElement iAgreeButton;
	@FindBy(id = "first_name")
	WebElement firstName;
	@FindBy(id = "last_name")
	WebElement familyName;
	@FindBy(id = "salutation")
	WebElement saluTation;
	@FindBy(id = "date_field")
	WebElement dateField;
	@FindBy(id = "month_field")
	WebElement monthField;
	@FindBy(id = "year_field")
	WebElement yearField;

	public Carpeesh_Page() {
		PageFactory.initElements(driver, this);
	}

	public void clickIAgreeButton() throws Exception {
		iAgreeButton.click();
		waitFor2Sec();
	}

	public void enterPolicyHolderDetails(String sheetName, int rowNum) throws Exception {
		String salutatin = reader.getCellData(sheetName, "Salutation", rowNum);
		String fName = reader.getCellData(sheetName, "First_Name", rowNum);
		String famlyName = reader.getCellData(sheetName, "Family_Name", rowNum);

		Select drpSalutation = new Select(saluTation);
		drpSalutation.selectByValue(salutatin);
		firstName.sendKeys(fName);
		familyName.sendKeys(famlyName);
		waitFor5Sec();
	}
}
