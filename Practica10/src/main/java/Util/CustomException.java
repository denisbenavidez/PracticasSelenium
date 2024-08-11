package Util;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

import java.io.File;

public class CustomException extends WebDriverException {

    public CustomException(String classNme, String errorMessage, WebDriver driver) { //constructor
        super(errorMessage); //parametro errorMessage
        takeScreenshot(driver);
        System.out.println(classNme + " " + errorMessage);
        System.out.println(this.getMessage()); //FUNCION PROPIA DE WEBDRIVER QUE TRAE EL ERROR QUE FUE CAPTURADO
    }

    //Lo dejamos static porque debe ser poder acedido desde otras clases
    public static void takeScreenshot(WebDriver driver) {
        if (driver instanceof TakesScreenshot) { //TakesScreenshot es una clase de selenium

            File screenshot = ((TakesScreenshot) driver).getScreenshotAs((OutputType.FILE));
            new File("./target/screenshots").mkdirs(); //Enviamos el archivo a esta ruta //mkdirs() crea la carpeta en caso no exista
            try { //El try nos permite que en caso de falta de permisos para crear la carpeta haya una excepcion el flujo no se interrumpa y por lo tanto no se detenga el case
                FileUtils.copyToDirectory(screenshot, new File("./target/screenshots")); //FILEUTILS ES DE UNA LIBRERIA DE APACHE DEBEMOS IMPLEMENTAR LA DEPENDENCIA DE MAVEN apache commons io  // //funcion para copiar el archivo a la carpeta
            } catch (Exception e) {
                e.printStackTrace(); //capturamos el error en dado se realize una exception
            }
        }
    }
}