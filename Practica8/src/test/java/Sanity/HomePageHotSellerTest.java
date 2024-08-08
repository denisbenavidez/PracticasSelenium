package Sanity;

import Pages.Home.HomePage;
import TestCaseImplements.TestCase;
import Util.Products;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class HomePageHotSellerTest extends TestCase {

    @Test
    public void test(){
        HomePage home = new HomePage(driver);
        Actions actions = new Actions(driver);

        Products item = home.getProductByName("Hero Hoodie");
        actions.moveToElement(item.getProductWebElement()).click().perform();
    }
}
