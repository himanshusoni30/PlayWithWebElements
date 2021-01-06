package setup;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;

import java.io.*;
import java.util.Properties;

public class BaseTest {
    public static WebDriver driver = null;
    public static WebElement element = null;
    public static SoftAssert asrt = null;
    protected static Properties prop;

    @BeforeSuite
    public static void fetchProperty(){
        prop = System.getProperties();
        try{
            prop.load(new FileInputStream(new File("selenium.properties")));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @BeforeTest
    public static void setup(){
        WebDriverManager.firefoxdriver().setup();
        asrt = new SoftAssert();
        driver = new FirefoxDriver();
    }

    @AfterTest
    public static void tearDown(){
        driver.close();
    }

    @AfterSuite
    public static void afterSuite(){
        asrt.assertAll();
//        driver.quit();
    }
}