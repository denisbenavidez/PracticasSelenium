package Pages.Purchase;

import Pages.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutCompletePage extends Page {
    public CheckoutCompletePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy (id = "back-to-products")
    private WebElement btnBackHome;

    public WebElement getBtnBackHome(){
        return this.fiendElement(btnBackHome);
    }
}