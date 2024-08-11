package TestCaseImplements;
//CLASE BASE PARA LAS PRUEBAS
import Util.CustomException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.util.Random;

public class TestCase {
    //Al ser static la variable driver, es accesible desde cualquier metodo de la clase TestCase, lo que permite el acceso a cualuier metodo en la prueba
    //Al ser protected las subclases de TestCase peuden reutilizar el mismo WebDriver
    protected static WebDriver driver;

    @BeforeClass
    public void setUp(){
        //driver = new ChromeDriver();
    }

    @BeforeMethod(alwaysRun= true) //(ESTE METODO SIEMPRE SE VA A EJECUTAR)
    public void beforeMethod(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://magento.softwaretestingboard.com/");
    }

    @AfterMethod //captura 1
    public void afterMethod(ITestResult result){ //ItestResult va capturando los estados del caso de prueba
        if (result.getStatus() == ITestResult.FAILURE){ //SI FALLO EL CASO DE PRUEBA QUE TOME LA CAPTURA DE CAPANTALLA
            CustomException.takeScreenshot(driver); //LLAMAMOS LA FUNCION
        }
    }

    @AfterClass
    public void afterClass(){
    }

    public String getEmailRandom(){ //Funcion para crear correos para hacer dinamico nuestra automatizacion
        Random rand = new Random();
        return "pedro" + rand.nextInt(1000) + "@yogmail.com";
    }

    public void assertTrue(boolean condition){ //captura 2
        if (!condition){ //si la conficion fallo
            throw new CustomException(this.getClass().getName(), "Test failedddddddd", driver); //Creamos exception con throw new para tener nuestro propio assert
        }
    }



}
