package Pages.Account;

import Pages.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeleteAccountPage extends Page {
    public DeleteAccountPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);

    }

    @FindBy (xpath = "//a[@class='btn btn-primary']")
    private WebElement DeletedAccountBtn;

    public WebElement getDeletedAccountBtn(){
        return this.fiendElement(DeletedAccountBtn);
    }




}
