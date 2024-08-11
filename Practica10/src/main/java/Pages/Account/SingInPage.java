package Pages.Account;

import Pages.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.xml.xpath.XPath;

public class SingInPage extends Page {


    public SingInPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "login[username]")
    private WebElement loginUserName;

    @FindBy(name = "login[password]")
    private WebElement loginPassword;

    @FindBy(xpath = "//fieldset[@class='fieldset login']//span[contains(text(),'Sign In')]")
    private WebElement btnSignIn;

    @FindBy(xpath = "//span[@class='customer-name active']//button[@type='button']")
    private WebElement btnFlecha;

    @FindBy(xpath = "//div[@aria-hidden='false']//a[normalize-space()='My Account']")
    private WebElement myAccount;

    @FindBy(xpath = "//div[@id='email-error']")
    private WebElement emailError;

    @FindBy(xpath = "//div[@id='pass-error']")
    private WebElement passwordError;

    public WebElement getLoginUserName(){
        return this.fiendElement(loginUserName);
    }

    public WebElement getLoginPassword(){
        return this.fiendElement(loginPassword);
    }

    public WebElement getBtnSignIn(){
        return this.fiendElement(btnSignIn);
    }

    public WebElement getBtnFlecha(){
        return this.fiendElement(btnFlecha);
    }

    public WebElement getMyAccount(){
        return this.fiendElement(myAccount);
    }

    public WebElement getEmailError(){
        return this.fiendElement(emailError);
    }

    public WebElement getPasswordError(){
        return this.fiendElement(passwordError);
    }
}
