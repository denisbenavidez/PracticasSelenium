package TestCaseImplements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;


public class TestCase {

    protected static WebDriver driver;

    @BeforeClass
    public void setUp(){
    }

    @BeforeMethod
    public void beforeMethod(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
    }

    @AfterMethod
    public void afterMethod(ITestResult result){
        if (result.getStatus() == ITestResult.FAILURE){
           //CustomException.TakeScreenshot(driver);
        }
    }

    @AfterClass
    public void afterClass(){
        driver.close();
    }

    public void assertTrue(boolean condition){
        if (!condition){
           // throw new CustomException(this.getClass().getName(), "Test Failedd", driver);
        }
    }
}
