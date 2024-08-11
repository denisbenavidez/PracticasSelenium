package Cucumber;

import Pages.Account.CreateAccountPage;
import Pages.Global.TopHeaderPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class CreateAccountTest {

    static WebDriver driver = new ChromeDriver();

    @Given("En el menu dar click en el link de registro")
    public void en_el_menu_dar_click_en_el_link_de_registro() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://magento.softwaretestingboard.com/");

        TopHeaderPage topHeaderPage = new TopHeaderPage(driver);
        topHeaderPage.getCreateAccountLink().click(); //Segun el nombre de la funcion llega hasta el paso dar click en el menu de registro
    }

    @When("El formulario se cargue y llene los datos")
    public void el_formulario_se_cargue_y_llene_los_datos() {
        CreateAccountPage createAccount = new CreateAccountPage(driver);
        createAccount.getFirstNameInput().sendKeys("Pedro");
        createAccount.setLastNameInput("Torres"); //2
        createAccount.getEmailInput().sendKeys("Pedro12345@toymail.com");
        createAccount.getPasswordInput().sendKeys("Pedro@12345");
        createAccount.getConfirmPasswordInput().sendKeys("Pedro@12345");
    }

    @When("Click en el boton enviar")
    public void click_en_el_boton_enviar() {
        CreateAccountPage createAccount = new CreateAccountPage(driver);
        createAccount.getCreateAccountButton().click();
    }

    @Then("Se creara el usuario y se debe mostrar la pagina de la cuenta")
    public void se_creara_el_usuario_y_se_debe_mostrar_la_pagina_de_la_cuenta() {
        CreateAccountPage createAccount = new CreateAccountPage(driver);
        Assert.assertTrue(createAccount.isTextPresent("Thank you for registering with Main Website Store."));
    }

}
