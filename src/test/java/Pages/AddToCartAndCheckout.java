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
    By emailId = By.xpath("//input[@name='Email']");
    By password = By.xpath("//input[@name='Password']");
    By loginButton = By.xpath("//button[contains(@class, 'login-button')]");
    By computers = By.xpath("(//a[contains(text(), 'Computers')])[1]");
    By notebooks = By.linkText("Notebooks");
    By addToCart = By.xpath("(//button[contains(@class,'add-to-cart-button')])[1]");
    By product = By.xpath("(//button[contains(@class, 'product-box-add-to-cart-button')])[1]");
    By shopCart = By.xpath("//a[contains(text(), 'shopping cart')]");
    By terms = By.xpath("//input[@name='termsofservice']");
    By checkout = By.xpath("//button[@name='checkout']");
    By country = By.xpath("//select[@name='BillingNewAddress.CountryId']");
    By stateProvince = By.xpath("//select[@name='BillingNewAddress.StateProvinceId']");
    By UsCountry = By.xpath("//option[@value='1'][contains(text(),'United States')]");
    By state = By.xpath("//option[@value='52'][contains(text(),'Alaska')]");
    By cityName = By.xpath("//input[@name='BillingNewAddress.City']");
    By address = By.xpath("//input[@name='BillingNewAddress.Address1']");
    By zip = By.xpath("//input[@name='BillingNewAddress.ZipPostalCode']");
    By phone = By.xpath("//input[@name='BillingNewAddress.PhoneNumber']");
    By cont = By.xpath("(//button[contains(text(), 'Continue')])[1]");
    By continueButton1 = By.xpath("//button[contains(@class, 'new-address-next-step-button')]");
    By continueButton2 = By.xpath("//button[contains(@class, 'shipping-method-next-step-button')]");
    By continueButton3 = By.xpath("//button[contains(@class, 'shipping-method-next-step-button')]");
    By continueButton4 = By.xpath("//button[contains(@class, 'payment-method-next-step-button')]");
    By continueButton5 = By.xpath("//button[contains(@class, 'button-1 payment-info-next-step-button')]");
    By confirm = By.xpath("//button[contains(@class, 'button-1 confirm-order-next-step-button')]");
    By orderPlacedVerification = By.xpath("//h1[contains(text(),'Thank you')]");

    public AddToCartAndCheckout(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void addToCart()  throws IOException {
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
        driver.findElement(emailId).sendKeys(email);
        driver.findElement(password).sendKeys(pass);
        driver.findElement(loginButton).click();
        driver.findElement(computers).click();
        driver.findElement(notebooks).click();
        driver.findElement(product).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(addToCart));
        driver.findElement(addToCart).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(shopCart));
        driver.findElement(shopCart).click();
        wait.until(ExpectedConditions.elementToBeClickable(terms));
        driver.findElement(terms).click();
        driver.findElement(checkout).click();
        driver.findElement(country).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(UsCountry));
        driver.findElement(UsCountry).click();
        driver.findElement(stateProvince).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(state));
        driver.findElement(state).click();
        driver.findElement(cityName).sendKeys(city);
        driver.findElement(address).sendKeys(add);
        driver.findElement(zip).sendKeys(zipcode);
        driver.findElement(phone).sendKeys(num);
        driver.findElement(cont).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(continueButton1));
        driver.findElement(continueButton1).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(continueButton2));
        driver.findElement(continueButton2).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(continueButton3));
        driver.findElement(continueButton3).click();
        driver.findElement(continueButton4).click();
        driver.findElement(continueButton5).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(confirm));
        driver.findElement(confirm).click();
    }

    public void verifyOrderPlaced() throws IOException {
        boolean isResultDisplayed = driver.findElement(orderPlacedVerification).isDisplayed();
        org.testng.Assert.assertTrue(isResultDisplayed, "Order not placed");
    }
}