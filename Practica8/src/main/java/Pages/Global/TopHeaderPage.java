package Pages.Global;
//CLASE TOPHEADERPAGE
import Pages.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TopHeaderPage extends Page {


    @FindBy(xpath = "//div[@class='panel header']//a[normalize-space()='Create an Account']") private WebElement createAccountLink;
    @FindBy(xpath = "//div[@class='panel header']//a[contains(text(),'Sign In')]") private WebElement singInLink;

    public TopHeaderPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public WebElement getCreateAccountLink(){
        return this.fiendElement(createAccountLink);
    }

    public WebElement getSingInLink(){
        return  this.fiendElement(singInLink);
    }

}
