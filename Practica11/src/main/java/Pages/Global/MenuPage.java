package Pages.Global;

import Interfaces.IMenu;
import Pages.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class MenuPage extends Page {
    public MenuPage(WebDriver driver) {
        super(driver);
    }

    public enum lvl0 implements IMenu{ //PERTENECE A LA PRIMERA FILA DE ELEMENTOS DEL MENU
        WHATSNEW("Whats news", By.xpath("//a[@id='ui-id-3']//span[1]")),
        WOMEN("Women", By.xpath("//span[normalize-space()='Women']"))
        ;

        private String name;
        private By locator;

        lvl0(String name, By locator){
            this.name = name;
            this.locator = locator;
        }

        @Override
        public By locator(){
            return this.locator;
        }
    }

    public enum lvl1 implements IMenu{ //PERTENECE A LA PRIMERA FILA DE ELEMENTOS DEL MENU
        TOPS("Tops", By.xpath("//a[@id='ui-id-9']//span[contains(text(),'Tops')]")),
        ;

        private String name;
        private By locator;

        lvl1(String name, By locator){
            this.name = name;
            this.locator = locator;
        }

        @Override
        public By locator(){
            return this.locator;
        }
    }

    public enum lvl2 implements IMenu{ //PERTENECE A LA PRIMERA FILA DE ELEMENTOS DEL MENU
        JACKETS("Jackets", By.xpath("//a[@id='ui-id-11']//span[contains(text(),'Jackets')]")),
        ;

        private String name;
        private By locator;

        lvl2(String name, By locator){
            this.name = name;
            this.locator = locator;
        }

        @Override
        public By locator(){
            return this.locator;
        }
    }

    public Actions goToMenu(IMenu menu){
        Actions actions = new Actions(driver); //INSTANCIAMOS NUESTRA CLASE ACTIONS CON EL DRIVER
        return actions.moveToElement(this.fiendElement(menu.locator()));
    }
}

