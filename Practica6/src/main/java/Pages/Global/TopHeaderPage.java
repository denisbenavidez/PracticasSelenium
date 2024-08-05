package Pages.Global;
//CLASE TOPHEADERPAGE
import Pages.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TopHeaderPage extends Page { //ESTA CLASE REPRESETA LA PARTE SUPERIOR DE LA PAGINA, HEREDAMOS LA CLASE PAGE

    //USAMOS FindBy para localizar el link 'Create An Account' por su path
    @FindBy(xpath = "//div[@class='panel header']//a[normalize-space()='Create an Account']") private WebElement createAccountLink; //Almacenamos el elemento en la variable WebElement. Es buena practica poner el tipo de elemento al final
    @FindBy(xpath = "//div[@class='panel header']//a[contains(text(),'Sign In')]") private WebElement singInLink;

    public TopHeaderPage(WebDriver driver) { //METODO CONSTRUCTOR (PARAMETRO driver que es una instancia de WebDriver de Selenium para controlar el navegador)
        super(driver); // Llama al constructor de la clase base Page con el objeto WebDriver, permitiendo que la clase base también tenga acceso al WebDriver.
        PageFactory.initElements(driver, this); //Inicializa los elementos web de la página TopHeaderPage usando las anotaciones @FindBy.
    }

    public WebElement getCreateAccountLink(){ //método es público, lo que significa que puede ser accedido desde fuera de la clase TopHeaderPage, devuelve un elemento WebElement que es una interfaz de selenium para interactuar con elementos web de una pagina
        return this.fiendElement(createAccountLink); //devuelve el elemento web que representa el enlace "Create An Account" en la página. Utiliza el método findElement (de la clase base Page) para localizar y asegurar que el elemento esté visible y listo para ser interactuado antes de devolverlo
    }

    public WebElement getSingInLink(){
        return  this.fiendElement(singInLink);
    }

}
