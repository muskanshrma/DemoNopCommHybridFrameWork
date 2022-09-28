package Pages;

import org.openqa.selenium.WebDriver;

public class PageFactory {
    WebDriver driver;
    private RegisterUser register;

    public PageFactory(WebDriver driver) {
        this.driver = driver;
    }

    public RegisterUser getRegisterUser() {
        if (register == null) {
            register = new RegisterUser(driver);
        }
        return register;
    }

}