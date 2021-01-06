package testcases.frames;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import setup.BaseTest;
import setup.CommonMethods;

import java.time.Duration;

public class iFrames extends BaseTest {
    @Test
    public static void testIFrames() {
        CommonMethods.navigateToURL(prop.getProperty("iframe"));
        String actualMsg = driver.getTitle();
        asrt.assertEquals(actualMsg, "The Internet", "Title validation failed.");

        driver.findElement(By.xpath("//span[text()='File']//parent::button")).click();
        driver.findElement(By.xpath("//div[@title='New document']")).click();

        driver.switchTo().frame("mce_0_ifr");
        driver.findElement(By.id("tinymce")).sendKeys("The quick brown fox jumps over the lazy dog");
    }
}
