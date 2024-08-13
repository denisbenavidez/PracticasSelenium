package Sanity;

import Pages.Account.LoginPage;
import Pages.Home.InventoryPage;
import Pages.Purchase.CartPage;
import Pages.Purchase.CheckoutCompletePage;
import Pages.Purchase.CheckoutStepOnePage;
import Pages.Purchase.CheckoutStepTwoPage;
import TestCaseImplements.TestCase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PurcharseProcessTest extends TestCase {

    @Test
    public void loginUser(){

        LoginPage loginPage = new LoginPage(driver);
        loginPage.getInputUserName().sendKeys("standard_user");
        loginPage.getInputPassword().sendKeys("secret_sauce");
        loginPage.getBtnLogin().click();

        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.getBtnAddToCartSauceBackPack().click();
        inventoryPage.getBtnAddToCartSauceLabsBolt().click();
        inventoryPage.getLinkCart().click();

        CartPage cartPage = new CartPage(driver);
        cartPage.getBtnCheckout().click();

        CheckoutStepOnePage checkoutStepOnePage = new CheckoutStepOnePage(driver);
        Assert.assertTrue(checkoutStepOnePage.isTextPresent("Checkout: Your Information"));
        checkoutStepOnePage.getInputFirtname().sendKeys("Denis");
        checkoutStepOnePage.getInputLastname().sendKeys("Lovos");
        checkoutStepOnePage.getInputPostalcode().sendKeys("503");
        checkoutStepOnePage.getBtnContinue().click();

        CheckoutStepTwoPage checkoutStepTwoPage = new CheckoutStepTwoPage(driver);
        Assert.assertTrue(checkoutStepTwoPage.isTextPresent("SauceCard #31337"));
        checkoutStepTwoPage.getBtnFinish().click();

        CheckoutCompletePage checkoutCompletePage = new CheckoutCompletePage(driver);
        Assert.assertTrue(checkoutCompletePage.isTextPresent("Thank you for your order!"));
        checkoutCompletePage.getBtnBackHome().click();
    }
}
