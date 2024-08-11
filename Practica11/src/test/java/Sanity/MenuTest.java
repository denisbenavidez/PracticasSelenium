package Sanity;

import Pages.Global.MenuPage;
import TestCaseImplements.TestCase;
import org.testng.annotations.Test;

public class MenuTest extends TestCase {

    @Test
    public void test(){
        MenuPage menu = new MenuPage(driver); //INSTANCIAMOS LA CLASE

        menu.goToMenu(MenuPage.lvl0.WOMEN).perform();////objeto.clase.nivel NOS POSICIONAMOS EN WOMEN
        menu.goToMenu(MenuPage.lvl1.TOPS).perform();
        menu.goToMenu(MenuPage.lvl2.JACKETS).click().perform(); //AHORA SI USAMOS CLICK() YA QUE QUEREMOS ACCEDER A ESTE ELEMENTO
    }
}
