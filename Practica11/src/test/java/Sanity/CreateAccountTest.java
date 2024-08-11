package Sanity;
//Contiene pruebas para crear una cuenta y validar el formulario de registro
import Data.DataProviderCustomer;
import Pages.Account.CreateAccountPage;
import Pages.Global.TopHeaderPage;
import TestCaseImplements.TestCase;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CreateAccountTest extends TestCase {

    @Test(groups = {"smokeTest"}) //Las agrupaciones de caso de pruebas sirven para realizar casos de pruebas para diferentes escenarios
    public void createAccountUser(){
        TopHeaderPage topHeaderPage = new TopHeaderPage(driver); // Crea una instancia de TopHeaderPage, pasando el driver para interactuar con el navegador.
        topHeaderPage.getCreateAccountLink().click(); //Obtenemos el enlace y hacemos click en el navegador en el boton crear cuenta

        CreateAccountPage createAccount = new CreateAccountPage(driver); //Crea una instancia de CreateAccountPage para interactuar con los elementos en la página de creación de cuenta.
        createAccount.getFirstNameInput().sendKeys("Pedro"); //1 //ES BUENA PRACTICA TERMINAR NUESTROS METODOS CON EL NOMBBRE DEL ELEMENTO
        createAccount.setLastNameInput("Torres"); //2
        createAccount.getEmailInput().sendKeys(getEmailRandom());
        createAccount.getPasswordInput().sendKeys("Pedro@12345");
        createAccount.getConfirmPasswordInput().sendKeys("Pedro@12345");
        createAccount.getCreateAccountButton().click();
        //Verifica que el texto "Thank you for registering with Main Website Store." esté presente en la página después de la creación de la cuenta para confirmar que el registro fue exitoso.
        Assert.assertTrue(createAccount.isTextPresent("Thank you for registering with Main Website Store."));
    }

    @Test(groups = {"smokeTest"})//softAssert ejecuta todoo el caso de prueba y si alguno falla la prueba continua hasta llegar a assertAll que verifica
    public void validateReistrationForm(){

        String errorMsg = "This is a required field."; //Define el mensaje de error esperado para los campos requeridos.

        SoftAssert softAssert = new SoftAssert(); //Crea una instancia de SoftAssert, que permite acumular múltiples aserciones y reportarlas todas juntas al final.

        //Crea instancias de las páginas necesarias para la prueba.
        TopHeaderPage topHeaderPage = new TopHeaderPage(driver);
        CreateAccountPage createAccount = new CreateAccountPage(driver);

        //Navega a la página de creación de cuenta y hace clic en el botón para enviar el formulario sin completar los campos.
        topHeaderPage.getCreateAccountLink().click();
        createAccount.getCreateAccountButton().click();

        //softAssert ejecuta todoo el caso de prueba y si alguno falla la prueba continua hasta llegar a assertAll que verifica si se cumplieron todos y si no se lanza la excepcion a diferencia del assert normal que se lanza la excepcion inmediatamente
        //Verifica que el mensaje de error esperado esté presente en cada campo requerido.
        softAssert.assertEquals(createAccount.getFirstNameErrorMessage().getText(), errorMsg);
        softAssert.assertEquals(createAccount.getLastNameErrorMessage().getText(), errorMsg);
        softAssert.assertEquals(createAccount.getEmailErrorMessage().getText(), errorMsg);
        softAssert.assertEquals(createAccount.getPasswordErrorMessage().getText(), errorMsg);
        softAssert.assertEquals(createAccount.getConfirmPasswordErrorMessage().getText(), errorMsg);
        softAssert.assertAll();
    }

    @Test
    (dataProvider = "dataCustomer", dataProviderClass = DataProviderCustomer.class)
    public void createAccountUserWithDataProvider(String firstName, String lastName, String email, String password, String confirmPassword){ //LES PROPORCIONAMOS LOS 5 PARAMETROS DE LA FUNCION GETCUSTOMERDATA DE LA CLASE DATAPROVIDERCUSTOMER

        TopHeaderPage topHeaderPage = new TopHeaderPage(driver);
        CreateAccountPage createAccount = new CreateAccountPage(driver);

        topHeaderPage.getCreateAccountLink().click();
        createAccount.getFirstNameInput().sendKeys(firstName); //ASIGNAMOS LOS PARAMETROS DE LA FUNCION
        createAccount.setLastNameInput(lastName);
        createAccount.getEmailInput().sendKeys(email);
        createAccount.getPasswordInput().sendKeys(password);
        createAccount.getConfirmPasswordInput().sendKeys(confirmPassword);
        createAccount.getCreateAccountButton().click();
        Assert.assertTrue(createAccount.isTextPresent("Thank you for registering with Main Website Store."));
    }
}
