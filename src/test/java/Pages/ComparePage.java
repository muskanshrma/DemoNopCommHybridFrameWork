package Pages;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

public class ComparePage {
    WebDriver driver;
    WebDriverWait wait;

    By login = By.xpath("//a[contains(text(),'Log in')]");
    By emailid = By.xpath("//input[@name='Email']");
    By password = By.xpath("//input[@name='Password']");
    By loginButton = By.xpath("//button[contains(@class, 'login-button')]");
    By computers = (By.xpath("(//a[contains(text(), 'Computers')])[1]"));
    By notebooks = By.linkText("Notebooks");
    By compare1 = By.xpath("(//button[contains(@class, 'compare-list')])[1]");
    By compare2 = By.xpath("(//button[contains(@class, 'compare-list')])[2]");
    By productComparison = By.xpath("//a[contains(text(),'product comparison')]");
    By comparisonPageVerification = By.xpath("//h1[contains(text(),'Compare')]");

    public ComparePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void compare() throws IOException {
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

        driver.findElement(login).click();
        driver.findElement(emailid).sendKeys(email);
        driver.findElement(password).sendKeys(pass);
        driver.findElement(loginButton).click();
        driver.findElement(computers).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(notebooks));
        driver.findElement(notebooks).click();
        driver.findElement(compare1).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(compare2));
        driver.findElement(compare2).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(productComparison));
        driver.findElement(productComparison).click();
    }

    public void verifyComparison() throws IOException {
        boolean isResultDisplayed = driver.findElement(comparisonPageVerification).isDisplayed();
        org.testng.Assert.assertTrue(isResultDisplayed, "Comparison error");
    }
}