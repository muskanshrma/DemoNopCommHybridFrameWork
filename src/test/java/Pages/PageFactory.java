package Pages;

import org.openqa.selenium.WebDriver;

public class PageFactory {
    WebDriver driver;
    private RegisterUser register;
    private ComparePage comparison;

    public PageFactory(WebDriver driver) {
        this.driver = driver;
    }

    public RegisterUser getRegisterUser() {
        if (register == null) {
            register = new RegisterUser(driver);
        }
        return register;
    }
    public ComparePage getComparePage() {
        if (comparison == null) {
            comparison = new ComparePage(driver);
        }
        return comparison;
    }

}