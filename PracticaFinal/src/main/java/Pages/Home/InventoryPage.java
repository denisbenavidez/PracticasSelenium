package Pages.Home;

import Pages.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InventoryPage extends Page {
    public InventoryPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy (name = "add-to-cart-sauce-labs-backpack")
    private WebElement btnAddToCartSauceBackPack;

    @FindBy (name = "add-to-cart-sauce-labs-bike-light")
    private WebElement btnAddToCartSauceLabsBolt;

    @FindBy (className = "shopping_cart_link")
    private WebElement linkCart;

    public WebElement getBtnAddToCartSauceBackPack(){
        return this.fiendElement(btnAddToCartSauceBackPack);
    }

    public WebElement getBtnAddToCartSauceLabsBolt(){
        return this.fiendElement(btnAddToCartSauceLabsBolt);
    }

    public WebElement getLinkCart(){
        return this.fiendElement(linkCart);
    }
}
