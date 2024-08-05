import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.NoSuchElementException;

public class Practica4 {
    static ChromeDriver driver;

    @BeforeClass
    public static void beforeClass(){
        driver = new ChromeDriver();
    }

    @Before
    public void beforeTest(){
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();
    }

    @Test
    public void testEsperaImplicita() throws InterruptedException {
        
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        
        WebElement loginBtn = driver.findElement(By.xpath("//button[text() = ' Login ']"));

        Actions actions = new Actions(driver);
        actions.click(loginBtn).perform();

        WebElement RequiredMsg = driver.findElement(By.className("oxd-input-group__message"));
        Assert.assertEquals("Required", RequiredMsg.getText());
    }
    
    @Test
    public void testEsperaExplicita(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));

        WebElement loginBtn = driver.findElement(By.xpath("//button[text() = ' Login ']"));

        Actions actions = new Actions(driver);
        actions.click(loginBtn).perform();

        WebElement RequiredMsg = driver.findElement(By.className("oxd-input-group__message"));
        Assert.assertEquals("Required", RequiredMsg.getText());
    }

    @Test
    public void testEsperaFluida(){

        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(20))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));

        WebElement loginBtn = driver.findElement(By.xpath("//button[text() = ' Login ']"));

        Actions actions = new Actions(driver);
        actions.click(loginBtn).perform();

        WebElement RequiredMsg = driver.findElement(By.className("oxd-input-group__message"));
        Assert.assertEquals("Required", RequiredMsg.getText());
    }

    @After
    public void afterTest(){
        //driver.close();
    }

    @AfterClass
    public static void afterClass(){
        System.out.println("After Class");
    }
}
