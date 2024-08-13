package Pages.Purchase;

import Pages.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage extends Page {

    public CartPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy (id = "checkout")
    private WebElement btnCheckout;

    public WebElement getBtnCheckout(){
        return this.fiendElement(btnCheckout);
    }
}
