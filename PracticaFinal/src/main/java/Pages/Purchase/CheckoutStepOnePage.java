package Pages.Purchase;

import Pages.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutStepOnePage extends Page {

    public CheckoutStepOnePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy (id = "first-name")
    private WebElement inputFirtname;

    @FindBy (id = "last-name")
    private WebElement inputLastname;

    @FindBy (id = "postal-code")
    private WebElement inputPostalcode;

    @FindBy (id = "continue")
    private WebElement btnContinue;

    public WebElement getInputFirtname(){
        return this.fiendElement(inputFirtname);
    }

    public WebElement getInputLastname(){
        return this.fiendElement(inputLastname);
    }

    public WebElement getInputPostalcode(){
        return this.fiendElement(inputPostalcode);
    }

    public WebElement getBtnContinue(){
        return this.fiendElement(btnContinue);
    }
}
