package Sanity;

import Data.DataProviderCustomer;
import Pages.Account.SingInPage;
import Pages.Global.TopHeaderPage;
import TestCaseImplements.TestCase;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SignInTest extends TestCase {
    @Test
    public void signInUser(){
        TopHeaderPage topHeaderPage = new TopHeaderPage(driver);
        topHeaderPage.getSingInLink().click();

        SingInPage singIn = new SingInPage(driver);
        singIn.getLoginUserName().sendKeys("pedro863@yogmail.com");
        singIn.getLoginPassword().sendKeys("Pedro@12345");
        singIn.getBtnSignIn().click();
        Assert.assertTrue(singIn.isTextPresent("Welcome, Pedro Torres!"));
    }

    @Test
    public void signInUserRequired(){
        String errorMsg = "This is a required field.";
        SoftAssert softAssert = new SoftAssert();

        TopHeaderPage topHeaderPage = new TopHeaderPage(driver);
        topHeaderPage.getSingInLink().click();

        SingInPage singIn = new SingInPage(driver);
        singIn.getBtnSignIn().click();

        softAssert.assertEquals(singIn.getEmailError().getText(),errorMsg);
        softAssert.assertEquals(singIn.getPasswordError().getText(),errorMsg);
        softAssert.assertAll();
    }


    @Test
    (dataProvider = "dataCustomerLogin", dataProviderClass = DataProviderCustomer.class)
    public void signInDataProvider(String email, String password, boolean shouldSucced){
        TopHeaderPage topHeaderPage = new TopHeaderPage(driver);
        topHeaderPage.getSingInLink().click();

        SingInPage singInPage = new SingInPage(driver);
        singInPage.getLoginUserName().sendKeys(email);
        singInPage.getLoginPassword().sendKeys(password);
        singInPage.getBtnSignIn().click();

        if (shouldSucced) {
            // inicio de sesión exitoso

        } else {
            // inicio de sesión fallido
            Assert.assertTrue(singInPage.isTextPresent("The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later."));
        }
    }
}
