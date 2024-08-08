package TestCaseImplements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.util.Random;

public class TestCase {

    protected static WebDriver driver;

    @BeforeClass
    public void beforeClass(){

    }

    @BeforeMethod
    public void beforeMethod(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://automationexercise.com/");
    }

    @AfterMethod
    public void afterMethod(){

    }

    @AfterClass
    public void afterClass(){

    }

    public String getEmailRandom(){ //Funcion para crear correos para hacer dinamico nuestra automatizacion
        Random rand = new Random();
        return "denis" + rand.nextInt(1000) + "@yogmail.com";
    }
}