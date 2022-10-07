package Pages;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

public class MyAccountPage {

    WebDriver driver;
    WebDriverWait wait;
    By login = By.xpath("//a[contains(text(),'Log in')]");
    By emailId = By.xpath("//input[@name='Email']");
    By password = By.xpath("//input[@name='Password']");
    By loginButton = By.xpath("//button[contains(@class, 'login-button')]");
    By myAccount = By.xpath("//a[contains(@class,'account')]");
    By lastName = By.xpath("//input[@name='LastName']");
    By saveButton = By.xpath("//button[contains(@class,'save')]");
    By logoutButton = By.xpath("//a[contains(@class,'logout')]");

    public MyAccountPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void editDetails() throws IOException {
        String path = System.getProperty("user.dir") + "//src//test//java//TestData//DemoNopRegister.xlsx";
        FileInputStream prop1 = null;
        try {
            prop1 = new FileInputStream(path);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        XSSFWorkbook wb = new XSSFWorkbook(prop1);
        XSSFSheet sheet = wb.getSheet("Sheet1");
        String email = sheet.getRow(1).getCell(2).getStringCellValue();
        String pass = sheet.getRow(1).getCell(3).getStringCellValue();
        String newLastName = sheet.getRow(1).getCell(1).getStringCellValue();
        driver.findElement(login).click();
        driver.findElement(emailId).sendKeys(email);
        driver.findElement(password).sendKeys(pass);
        driver.findElement(loginButton).click();
        driver.findElement(myAccount).click();
        driver.findElement(lastName).clear();
        driver.findElement(lastName).clear();
        driver.findElement(lastName).sendKeys(newLastName);
        driver.findElement(saveButton).click();
    }
    public void verifyEdit() throws IOException {
        boolean isResultDisplayed = driver.findElement(logoutButton).isDisplayed();
        org.testng.Assert.assertTrue(isResultDisplayed, "Update details error");
        driver.findElement(logoutButton).click();
    }
}