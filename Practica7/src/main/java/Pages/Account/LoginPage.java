package Pages.Account;

import Pages.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends Page {

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy (xpath = "//input[@placeholder='Name']")
    private WebElement singUpName;

    @FindBy (xpath = "//input[@data-qa='signup-email']")
    private WebElement singUpEmail;

    @FindBy (xpath = "//button[normalize-space()='Signup']")
    private WebElement singUpBtn;

    public WebElement getSingUpName(){
        return this.fiendElement(singUpName);
    }

    public WebElement getSingUpEmail(){
        return this.fiendElement(singUpEmail);
    }

    public WebElement getSingUpBtn(){
        return this.fiendElement(singUpBtn);
    }
}
