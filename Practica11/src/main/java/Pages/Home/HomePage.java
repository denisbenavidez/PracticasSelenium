package Pages.Home;

import Pages.Page;
import Util.Products;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage extends Page {

    @FindBy(xpath = "//li[@class = 'product-item' ]") //CUADRICULA DE CADA PRODUCTO
    private List<WebElement> products;

    public HomePage(WebDriver driver) { //CONSTRUCTOR
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public Products getProductByName(String name){ //FUNCION PARA RETORNAR PRODUCTO (name nombre del producto que se va a buscar)

        Actions actions = new Actions(driver);

        for (WebElement product : products){ //BUCLE PARA RECORRER LOS PRODUCTOS EN NUESTRO LISTADO DE ELEMENTOS
            if (this.fiendElement(product.findElement(By.xpath("div/div/strong/a"))).getText().contains(name)){ //(name) argumento que estamos recibiendo
                //findElement accedemos al elemento obteniendo el nombre de ese elemento para llegar ahi debemos entrar a dos div y un strong para llegar al <a tittle>Radiant Tee</a>  NO HACEMOS REFERENCIA AL LI PORQUE ESE YA LO TENEMOS EN EL XPATH

                actions.moveToElement(product).perform(); //USAMOS LA CLASE ACTION PARA POSICIONARNOS SOBRE EL PRODUCTO CON MOVETOELEMENT
                return this.getProduct(product); //ACCEDEMOS A LA FUNCION
            }
        }
        return null;
    }

    private Products getProduct(WebElement product){ //FUNCION PARA RETORNAR PRODUCTO
        return new Products(product);
    }
}