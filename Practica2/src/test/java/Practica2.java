import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Practica2 {
    @Test
    public void test() throws InterruptedException {
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com");

        WebElement userName = driver.findElement(By.id("user-name"));
        WebElement passWord = driver.findElement(By.id("password"));
        WebElement loginBtn = driver.findElement(By.id("login-button"));

        userName.sendKeys("standard_user");
        passWord.sendKeys("secret_sauce");
        Thread.sleep(3000);
        loginBtn.submit();

        WebElement swagLabs = driver.findElement(By.className("login_logo"));
        WebElement usernamesAre = driver.findElement(By.xpath("//h4[text()='Accepted usernames are:']"));
        WebElement passwordAll = driver.findElement(By.xpath("//h4[text()='Password for all users:']"));
        WebElement divAllData = driver.findElement(By.xpath("//div[@class='login_credentials']"));
        WebElement divUserCredential = driver.findElement(By.xpath("//div[@id='login_credentials']"));
        WebElement divPassCredential = driver.findElement(By.xpath("login_password"));
        WebElement divLoginWrpper = driver.findElement(By.xpath("//div[@class='login_wrapper-inner']"));
    }
}
