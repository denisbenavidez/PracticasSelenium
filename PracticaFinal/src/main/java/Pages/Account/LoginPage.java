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

    @FindBy (id = "user-name")
    private WebElement inputUserName;

    @FindBy (id = "password")
    private WebElement inputPassword;

    @FindBy (id = "login-button")
    private WebElement btnLogin;


    public WebElement getInputUserName(){
        return this.fiendElement(inputUserName);
    }

    public WebElement getInputPassword(){
        return this.fiendElement(inputPassword);
    }

    public WebElement getBtnLogin(){
        return this.fiendElement(btnLogin);
    }
}
