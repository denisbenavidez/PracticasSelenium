import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Practica1 {
    @Test
    public void test(){
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.google.com/?hl=es");

        WebElement search = driver.findElement(By.name("q"));

        search.sendKeys("selenium");
        search.submit();

    }
}
