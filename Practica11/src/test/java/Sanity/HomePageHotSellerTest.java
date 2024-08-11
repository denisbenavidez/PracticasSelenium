package Sanity;

import Pages.Account.CheckoutPage;
import Pages.Account.ReviewPaymentPage;
import Pages.Global.ProductPage;
import Pages.Global.TopHeaderPage;
import Pages.Home.HomePage;
import TestCaseImplements.TestCase;
import Util.Products;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.junit.Assert.assertTrue;

public class HomePageHotSellerTest extends TestCase {

    @Test(groups = {"customerTest"})
    public void test(){
        HomePage home = new HomePage(driver);
        Actions actions = new Actions(driver);

        Products item = home.getProductByName("Breathe-Easy Tank"); //NOMBRE DEL PRODUCTO QUE QUEREMOS BUSCAR
        actions.moveToElement(item.getProductWebElement()).click().perform(); //getProductWebElement es de la clase products

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
        checkoutPage.selectDropdown("Florida"); //Le proporcionamos el estado
        checkoutPage.getStateDropdown().submit(); //Y ahora lo seleccionamos el estado con submit()
        checkoutPage.getZipCodeInput().sendKeys("33101");
        checkoutPage.setCountryDropdown("El Salvador").click();
        checkoutPage.getPhoneInput().sendKeys("77777777");
        checkoutPage.getShippingRadio().click();
        checkoutPage.getNextButton().click();

        ReviewPaymentPage reviewPaymentPage = new ReviewPaymentPage(driver);
        reviewPaymentPage.getPlaceOrderButton().click();
        assertTrue(reviewPaymentPage.isTextPresent("gracias"));

    }
}
