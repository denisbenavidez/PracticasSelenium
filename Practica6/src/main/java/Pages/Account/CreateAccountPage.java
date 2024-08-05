package Pages.Account;
// maneja la página de creación de cuenta, definiendo elementos de la página y métodos para interactuar con ellos
import Pages.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateAccountPage extends Page {

    public CreateAccountPage(WebDriver driver) { //Llama al constructor de la clase base Page con el driver.
        super(driver);
        PageFactory.initElements(driver, this); //para inicializar todos los elementos de la página que están anotados con @FindBy.
    }

    //Los elementos en la página de creación de cuenta se localizan mediante anotaciones @FindBy.
    @FindBy(id = "firstname") //Asociamos el elemento a la variable private
    private WebElement firstName;

    @FindBy(id = "lastname")
    private WebElement lastName;

    @FindBy(id = "email_address")
    private WebElement email;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(id = "password-confirmation")
    private WebElement confirmPassword;

    @FindBy(xpath = "//button[@title='Create an Account']//span[contains(text(),'Create an Account')]")
    private WebElement createAccountButton;

    @FindBy(id = "firstname-error") //MENSAJES DE CAMPOS REQUERIDOS
    private WebElement firstNameErrorMessage;

    @FindBy(id = "lastname-error")
    private WebElement lastNameErrorMessage;

    @FindBy(id = "email_address-error")
    private WebElement emailErrorMessage;

    @FindBy(id = "password-error")
    private WebElement passwordErrorMessage;

    @FindBy(id = "password-confirmation-error")
    private WebElement confirmPasswordErrorMessage;


    public WebElement getFirstNameInput(){ //FORMA 1 DE ENVIAR DATOS AL TEST: DE ESTA FORMA OBTENEMOS TODO EL ELEMENTO WEB QUE NOS PERMITE HACER MAS ACCIONES
        return this.fiendElement(firstName); //Devuelven los elementos web correspondientes usando el método fiendElement para asegurar que los elementos sean visibles e interactuables.

    }

    public void setLastNameInput(String lastName){ //FORMA 2 DE ENVIAR DATOS AL TEST: EN ESTE CASO AL SER TIPO VOID NO RETORNA NADA POR LO QUE TENEMOS MENOS ACCIONES
        WebElement lastNameInput = this.fiendElement(this.lastName);
        lastNameInput.sendKeys(lastName); //Establece el valor del campo de apellido. Aquí, el método sendKeys se usa para enviar texto al campo.
    }

    public WebElement getEmailInput(){
        return this.fiendElement(email);
    }

    public WebElement getPasswordInput(){
        return this.fiendElement(password);
    }

    public WebElement getConfirmPasswordInput(){
        return this.fiendElement(confirmPassword);
    }

    public WebElement getCreateAccountButton(){
        return this.fiendElement(createAccountButton);
    }

    public WebElement getFirstNameErrorMessage(){ //CREAMOS FUNCIONES PARA ACCEDER A LOS WEBELEMENTS
        return this.fiendElement(firstNameErrorMessage);
    }

    public WebElement getLastNameErrorMessage(){
        return this.fiendElement(lastNameErrorMessage);
    }

    public WebElement getEmailErrorMessage(){
        return this.fiendElement(emailErrorMessage);
    }

    public WebElement getPasswordErrorMessage(){
        return this.fiendElement(passwordErrorMessage);
    }

    public WebElement getConfirmPasswordErrorMessage(){
        return this.fiendElement(confirmPasswordErrorMessage);
    }
}
