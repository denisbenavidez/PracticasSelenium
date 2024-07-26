import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Practica3 {

    static ChromeDriver driver;

    @BeforeClass
    public static void beforeClass(){
        driver = new ChromeDriver();
    }

    @Before
    public void beforeTest(){
        driver.get("https://www.saucedemo.com");
        driver.manage().window().maximize();
    }

    @Test
    public void test() throws InterruptedException {
        WebElement userName = driver.findElement(By.id("user-name"));
        WebElement passWord = driver.findElement(By.id("password"));
        WebElement loginBtn = driver.findElement(By.id("login-button"));

        Actions actions = new Actions(driver);
        actions.click(userName).sendKeys("standard_user").perform();
        actions.click(passWord).sendKeys("secret_sauce").perform();
        actions.click(loginBtn).perform();
        Thread.sleep(3000);
    }

    @After
    public void afterTest(){
        driver.close();
    }

    @AfterClass
    public static void afterClass(){
        System.out.println("After Class");
    }
}
