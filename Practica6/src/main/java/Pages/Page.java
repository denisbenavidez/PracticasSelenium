package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.function.Function;

public class Page { // ESTA CLASE PAGE CONTENDRA TODAS LAS FUNCIONES QUE NECESITARAN LAS DEMAS CLASES

    protected WebDriver driver;
    protected WebDriverWait wait; //WebDriverWait es una clase de Selenium utilizada para aplicar esperas explícitas. se le asignamos a la variable wait
    private static final int WAIT_TIMEOUT = 10; //Al ser static final, su valor es constante y no puede ser modificado.
    private static final int POLLING_TIME = 1;

    public Page(WebDriver driver){ //El constructor toma un objeto WebDriver como argumento y lo asigna al atributo driver de la clase. Esto permite que todas las instancias de Page y sus subclases utilicen este WebDriver para interactuar con el navegador.
        this.driver = driver;
    }

    public WebElement fiendElement(WebElement element){
        return this.fluentWaitElement(element);
    }

    private WebElement fluentWaitElement(WebElement element){
        Wait<WebDriver> wait = new FluentWait<WebDriver>(this.driver)
                .withTimeout(Duration.ofSeconds(WAIT_TIMEOUT))
                .pollingEvery(Duration.ofSeconds(POLLING_TIME))
                .ignoring(NoSuchElementException.class);
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public WebElement fiendElement(By locator){ //METODO PARA NUESTRO METODO GOTOMENU EN MENUPAGE
        Wait<WebDriver> wait = fluentWait();
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    private Wait<WebDriver> fluentWait(){ //FUNCION PARA NO REPETIR CODIGO DEL FLUENTWAIT
        return new FluentWait<WebDriver>(this.driver)
                .withTimeout(Duration.ofSeconds(WAIT_TIMEOUT))
                .pollingEvery(Duration.ofSeconds(POLLING_TIME))
                .ignoring((NoSuchElementException.class));
    }

    public Boolean isTextPresent(String txt){ //FUNCION PARA BUSCAR TEXTO (String textoQueVamosApasar)
            Wait<WebDriver> wait = fluentWait(); //LLAMAMOS LA FUNCION WAIT
            return wait.until(new Function<WebDriver, Boolean>() {
                public Boolean apply(WebDriver driver) {
                    return driver.getPageSource().contains(txt);
                }
            });
    }
}
