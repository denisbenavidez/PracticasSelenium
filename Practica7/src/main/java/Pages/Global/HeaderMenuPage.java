package Pages.Global;

import Pages.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HeaderMenuPage extends Page {

    public HeaderMenuPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//a[normalize-space()='Signup / Login']")
    private WebElement  signUpLoginLink;

    @FindBy(xpath = "//li[10]//a[1]")
    private WebElement signUpLoginLogged;

    @FindBy(xpath = "//a[normalize-space()='Delete Account']")
    private WebElement signUpDeleteAccount;


    public WebElement getSignUpLoginLink(){
        return this.fiendElement(signUpLoginLink);
    }

    public WebElement getSignUpLoginLogged(){
        return this.fiendElement(signUpLoginLogged);
    }

    public WebElement getSignUpDeleteAccount(){
        return this.fiendElement(signUpDeleteAccount);
    }



}
