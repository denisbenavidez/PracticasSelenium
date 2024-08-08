package Pages.Account;

import Pages.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountCreatedPage extends Page {
    public AccountCreatedPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);

    }

    @FindBy (xpath = "//a[@class='btn btn-primary']")
    private WebElement accountCreatedBtn;


    public WebElement getAccountCreatedBtn(){
        return this.fiendElement(accountCreatedBtn);
    }

}
