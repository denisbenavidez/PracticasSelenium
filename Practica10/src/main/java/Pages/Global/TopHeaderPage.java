package Pages.Global;
//CLASE TOPHEADERPAGE
import Pages.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TopHeaderPage extends Page {

    public TopHeaderPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//div[@class='panel header']//a[normalize-space()='Create an Account']")
    private WebElement createAccountLink;

    @FindBy(xpath = "//div[@class='panel header']//a[contains(text(),'Sign In')]")
    private WebElement singInLink;

    @FindBy(xpath = "//a[@class='action showcart']") //CARRITO DE COMPRAS
    private WebElement cartBtn;

    @FindBy(id = "top-cart-btn-checkout") //CHECKOUT BTN
    private WebElement checkoutButton;

    public WebElement getCreateAccountLink(){
        return this.fiendElement(createAccountLink);
    }

    public WebElement getSingInLink(){
        return this.fiendElement(singInLink);
    }

    public WebElement getCartBtn(){
        return this.fiendElement(cartBtn);
    }

    public WebElement getCheckoutButton(){
        return this.fiendElement(checkoutButton);
    }

    public void clickCheckoutButton(){
        this.getCheckoutButton().click();
    }

}
