/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Testlogin {
    
    private WebDriver driver;
    /*
    @Before
    public void setUp() {
        // Configurar el path para el chromedriver
        System.setProperty("webdriver.chrome.driver", "C:/Users/123456789/Desktop/chromedriver-win64/chromedriver.exe");
        driver = new ChromeDriver(); // Inicializar el driver aquí
    }

    @Test
    public void testCamposVacios() {
        driver.get("http://localhost:8080/Panamericas_web/login.jsp");

        // Hacer clic en el botón de login sin llenar los campos
        driver.findElement(By.id("login")).click();
        
        // Verificar mensaje de error   
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit(); // Cerrar el navegador después de cada prueba
        }
    }
    
    */
    /*
    @Before
    public void setUp() {
        // Configurar el path para el chromedriver
        System.setProperty("webdriver.chrome.driver", "C:/Users/123456789/Desktop/chromedriver-win64/chromedriver.exe");
        driver = new ChromeDriver(); // Inicializar el driver aquí
    }

    @Test
    public void testCredenciales() {
        driver.get("http://localhost:8080/Panamericas_web/login.jsp");
        // Hacer clic en el botón de login  con credenciales incorrectas
        driver.findElement(By.id("usuario")).sendKeys("juan");
        driver.findElement(By.id("contrasenia")).sendKeys("halo2");
        driver.findElement(By.id("login")).click();    
    }
    @After
    public void tearDown() {
        if (driver != null) {
            
            try {
                driver.wait();// Cerrar el navegador después de cada prueba           
            } catch (InterruptedException ex) {
                Logger.getLogger(Testlogin.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    */
    
    
}


