package Pages.Purchase;

import Pages.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutStepTwoPage extends Page {
    public CheckoutStepTwoPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy (id = "finish")
    private WebElement btnFinish;

    public WebElement getBtnFinish(){
        return this.fiendElement(btnFinish);
    }
}
