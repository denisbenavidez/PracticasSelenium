package TestCaseImplements;
//CLASE BASE PARA LAS PRUEBAS
import Util.CustomException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.util.Random;

public class TestCase {

    protected static WebDriver driver;

    @BeforeClass
    public void setUp(){

    }

    @BeforeMethod
    public void beforeMethod(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://magento.softwaretestingboard.com/");
    }

    @AfterMethod
    public void afterMethod(ITestResult result){
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
        if (!condition){
            throw new CustomException(this.getClass().getName(), "Test failedddddddd", driver);
        }
    }
}
