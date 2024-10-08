package Sanity;

import Data.DataProviderCustomer;
import Pages.Account.CreateAccountPage;
import Pages.Global.TopHeaderPage;
import TestCaseImplements.TestCase;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CreateAccountTest extends TestCase {

    @Test
    public void createAccountUser(){
        TopHeaderPage topHeaderPage = new TopHeaderPage(driver);
        topHeaderPage.getCreateAccountLink().click();

        CreateAccountPage createAccount = new CreateAccountPage(driver);
        createAccount.getFirstNameInput().sendKeys("Pedro");
        createAccount.setLastNameInput("Torres"); //2
        createAccount.getEmailInput().sendKeys(getEmailRandom());
        createAccount.getPasswordInput().sendKeys("Pedro@12345");
        createAccount.getConfirmPasswordInput().sendKeys("Pedro@12345");
        createAccount.getCreateAccountButton().click();

        Assert.assertTrue(createAccount.isTextPresent("Thank you for registering with Main Website Store."));
    }

    @Test
    public void validateReistrationForm(){

        String errorMsg = "This is a required field.";

        SoftAssert softAssert = new SoftAssert();


        TopHeaderPage topHeaderPage = new TopHeaderPage(driver);
        CreateAccountPage createAccount = new CreateAccountPage(driver);


        topHeaderPage.getCreateAccountLink().click();
        createAccount.getCreateAccountButton().click();


        softAssert.assertEquals(createAccount.getFirstNameErrorMessage().getText(), errorMsg);
        softAssert.assertEquals(createAccount.getLastNameErrorMessage().getText(), errorMsg);
        softAssert.assertEquals(createAccount.getEmailErrorMessage().getText(), errorMsg);
        softAssert.assertEquals(createAccount.getPasswordErrorMessage().getText(), errorMsg);
        softAssert.assertEquals(createAccount.getConfirmPasswordErrorMessage().getText(), errorMsg);
        softAssert.assertAll();
    }

    @Test
    (dataProvider = "dataCustomer", dataProviderClass = DataProviderCustomer.class)
    public void createAccountUserWithDataProvider(String firstName, String lastName, String email, String password, String confirmPassword){

        TopHeaderPage topHeaderPage = new TopHeaderPage(driver);
        CreateAccountPage createAccount = new CreateAccountPage(driver);

        topHeaderPage.getCreateAccountLink().click();
        createAccount.getFirstNameInput().sendKeys(firstName);
        createAccount.setLastNameInput(lastName);
        createAccount.getEmailInput().sendKeys(email);
        createAccount.getPasswordInput().sendKeys(password);
        createAccount.getConfirmPasswordInput().sendKeys(confirmPassword);
        createAccount.getCreateAccountButton().click();
        Assert.assertTrue(createAccount.isTextPresent("Thank you for registering with Main Website Store."));
    }
}
