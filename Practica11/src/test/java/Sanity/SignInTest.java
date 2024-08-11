package Sanity;

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
}
