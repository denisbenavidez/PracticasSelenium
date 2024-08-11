package Sanity;

import Pages.Account.CheckoutPage;
import Pages.Global.ProductPage;
import Pages.Global.TopHeaderPage;
import Pages.Home.HomePage;
import TestCaseImplements.TestCase;
import Util.Products;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageHotSellerTest extends TestCase {

    @Test
    public void test(){
        HomePage home = new HomePage(driver);
        Actions actions = new Actions(driver);

        Products item = home.getProductByName("Breathe-Easy Tank");
        actions.moveToElement(item.getProductWebElement()).click().perform();

        ProductPage productPage = new ProductPage(driver);
        productPage.getSize(ProductPage.size.MEDIUM).click();
        productPage.getColor(ProductPage.color.PURPLE).click();
        productPage.getAddToCartButton().click();
        Assert.assertTrue(productPage.isTextPresent("You added Breathe-Easy Tank to your"));

        TopHeaderPage topHeaderPage = new TopHeaderPage(driver);
        topHeaderPage.getCartBtn().click();
        topHeaderPage.clickCheckoutButton();

        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.getEmailField().sendKeys(getEmailRandom());
        checkoutPage.getFirstNameInput().sendKeys("Pedro");
        checkoutPage.getLastNameInput().sendKeys("Torres");
        checkoutPage.getCompanyInput().sendKeys("Main Website Store");
        checkoutPage.getCityInput().sendKeys("Santa tecla");
        checkoutPage.getStreetInput().sendKeys("Calle 2");
        checkoutPage.selectDropdown("Florida");
        checkoutPage.getStateDropdown().submit();
        checkoutPage.getZipCodeInput().sendKeys("33101");
        checkoutPage.setCountryDropdown("El Salvador").click();
        checkoutPage.getPhoneInput().sendKeys("77777777");
        checkoutPage.getShippingRadio().click();
        checkoutPage.getNextButton().click();
    }
}
