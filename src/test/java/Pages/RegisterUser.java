package Pages;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

public class RegisterUser {
    WebDriver driver;
    WebDriverWait wait;

    By registerTab = By.xpath("//a[contains(@class, 'register')]");
    By firstName = By.xpath("//input[@name='FirstName']");
    By lastName = By.xpath("//input[@name='LastName']");
    By emailid = By.xpath("//input[@name='Email']");
    By password = By.xpath("//input[@name='Password']");
    By confirmPassword = By.xpath("//input[@name='ConfirmPassword']");
    By registerButton = By.xpath("//button[contains(@class, 'register')]");
    By registerVerify = By.xpath("//div[contains(text(),'Your registration completed')]");
    By continueButton = By.xpath("//a[contains(@class,'register-continue-button')]");

    public RegisterUser(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void registerUser() throws IOException {
        String path = System.getProperty("user.dir") + "//src//test//java//TestData//DemoNopRegister.xlsx";
        FileInputStream prop1 = null;
        try {
            prop1 = new FileInputStream(path);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        XSSFWorkbook wb = new XSSFWorkbook(prop1);
        XSSFSheet sheet = wb.getSheet("Sheet1");
        String fName = sheet.getRow(1).getCell(0).getStringCellValue();
        String lName = sheet.getRow(1).getCell(1).getStringCellValue();
        String email = sheet.getRow(1).getCell(2).getStringCellValue();
        String pass = sheet.getRow(1).getCell(3).getStringCellValue();

        driver.findElement(registerTab).click();
        driver.findElement(firstName).sendKeys(fName);
        driver.findElement(lastName).sendKeys(lName);
        driver.findElement(emailid).sendKeys(email);
        driver.findElement(password).sendKeys(pass);
        driver.findElement(confirmPassword).sendKeys(pass);
        driver.findElement(registerButton).click();
    }

    public void verifyHomepage() throws IOException {
        boolean isResultDisplayed = driver.findElement(registerVerify).isDisplayed();
        org.testng.Assert.assertTrue(isResultDisplayed, "Registration error");
        driver.findElement(continueButton).click();
    }
}