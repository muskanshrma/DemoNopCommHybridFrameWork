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

public class AddToCartAndCheckout {
    WebDriver driver;
    WebDriverWait wait;

    By login = By.xpath("//a[contains(text(),'Log in')]");
    By emailid = By.xpath("//input[@name='Email']");
    By password = By.xpath("//input[@name='Password']");
    By loginButton = By.xpath("//button[contains(@class, 'login-button')]");
    By computers = By.xpath("(//a[contains(text(), 'Computers')])[1]");
    By notebooks = By.linkText("Notebooks");
    By addToCart = By.xpath("(//button[contains(@class, 'add-to-cart')])[1]");
    By terms = By.xpath("//input[@name='termsofservice']");
    By cart = By.xpath("//span[contains(text(), 'Shopping cart')]");
    By checkout = By.xpath("//button[@name='checkout']");
    By country = By.xpath("//select[@name='BillingNewAddress.CountryId']");
    By UsCountry = By.xpath("//option[@value='1'][contains(text(),'United States')]");
    By cityName = By.xpath("//input[@name='BillingNewAddress.City']");
    By address = By.xpath("//input[@name='BillingNewAddress.Address1']");
    By zip = By.xpath("//input[@name='BillingNewAddress.ZipPostalCode']");
    By phone = By.xpath("//input[@name='BillingNewAddress.PhoneNumber']");
    By cont = By.xpath("(//button[contains(text(), 'Continue')])[1]");
    By confirm = By.xpath("//button[contains(text(), 'Confirm')]");
    By continueButton = By.xpath("//button[contains(text(), 'Continue')]");

    public AddToCartAndCheckout(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void addToCart() throws IOException {
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
        XSSFSheet sheet2 = wb.getSheet("Sheet2");
        String city = sheet2.getRow(1).getCell(0).getStringCellValue();
        String add = sheet2.getRow(1).getCell(1).getStringCellValue();
        String zipcode = sheet2.getRow(1).getCell(2).getStringCellValue();
        String num = sheet2.getRow(1).getCell(3).getStringCellValue();

        driver.findElement(login).click();
        driver.findElement(emailid).sendKeys(email);
        driver.findElement(password).sendKeys(pass);
        driver.findElement(loginButton).click();
        driver.findElement(computers).click();
        driver.findElement(notebooks).click();
        driver.findElement(addToCart).click();
        driver.findElement(addToCart).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(cart));
        driver.findElement(cart).click();
        driver.findElement(terms).click();
        driver.findElement(checkout).click();
        driver.findElement(terms).click();
        driver.findElement(checkout).click();
        driver.findElement(country).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(UsCountry));
        driver.findElement(UsCountry).click();
        driver.findElement(cityName).sendKeys(city);
        driver.findElement(address).sendKeys(add);
        driver.findElement(zip).sendKeys(zipcode);
        driver.findElement(phone).sendKeys(num);
        driver.findElement(cont).click();
        driver.findElement(continueButton).click();
        driver.findElement(continueButton).click();
        driver.findElement(continueButton).click();
        driver.findElement(confirm).click();
    }
}