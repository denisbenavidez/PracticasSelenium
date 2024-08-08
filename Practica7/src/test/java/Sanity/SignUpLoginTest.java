package Sanity;

import Pages.Account.AccountCreatedPage;
import Pages.Account.DeleteAccountPage;
import Pages.Account.LoginPage;
import Pages.Account.SignUpPage;
import Pages.Global.HeaderMenuPage;
import TestCaseImplements.TestCase;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.Driver;

public class SignUpLoginTest extends TestCase {

    @Test
    public void signUpLogin(){
        HeaderMenuPage headerMenuPage = new HeaderMenuPage(driver);
        headerMenuPage.getSignUpLoginLink().click();

        LoginPage loginPage = new LoginPage(driver);
        Assert.assertTrue(loginPage.isTextPresent("New User Signup!"));

        loginPage.getSingUpName().sendKeys("Denis");
        loginPage.getSingUpEmail().sendKeys(getEmailRandom());
        loginPage.getSingUpBtn().click();

        SignUpPage singUpPage = new SignUpPage(driver);
        singUpPage.getSignUpRadioTittle().click();
        singUpPage.getSignUpPassword().sendKeys("Denis12456");
        singUpPage.setSignUpDay("15");
        singUpPage.setSignUpMonth("July");
        singUpPage.setSignUpYear("2021");
        singUpPage.getSignUpCheckBoxNews().click();
        singUpPage.getSignUpCheckBoxOffers().click();
        singUpPage.getSignUpFirtName().sendKeys("Denis");
        singUpPage.getSignUpLastName().sendKeys("Lovos");
        singUpPage.getSignUpCompany().sendKeys("Company Lovos");
        singUpPage.getSignUpAddress().sendKeys("11 calle oriente");
        singUpPage.getSignUpAddress2().sendKeys("San Salvador");
        singUpPage.setSignUpCountry("India");
        singUpPage.getSignUpState().sendKeys("San Salvador");
        singUpPage.getSignUpCity().sendKeys("San Salvador");
        singUpPage.getSignUpZipCode().sendKeys("503");
        singUpPage.getSignUpNumber().sendKeys("123456789");
        singUpPage.getSignUpBtnCreateAccount().click();

        AccountCreatedPage accountCreatedPage = new AccountCreatedPage(driver);
        Assert.assertTrue(accountCreatedPage.isTextPresent("Account Created!"));
        accountCreatedPage.getAccountCreatedBtn().click();

        headerMenuPage.getSignUpLoginLogged().isEnabled();
        headerMenuPage.getSignUpDeleteAccount().click();

        DeleteAccountPage deleteAccountPage = new DeleteAccountPage(driver);
        Assert.assertTrue(accountCreatedPage.isTextPresent("Account Deleted!"));
        deleteAccountPage.getDeletedAccountBtn().click();

    }
}
