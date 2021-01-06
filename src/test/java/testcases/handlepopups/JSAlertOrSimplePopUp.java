package testcases.handlepopups;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import setup.BaseTest;
import setup.CommonMethods;

import java.time.Duration;

public class JSAlertOrSimplePopUp extends BaseTest {
    @Test
    public static void testPopUpTextAndClickOnOk() {
        CommonMethods.navigateToURL(prop.getProperty("js_alert"));
        String actualMsg = driver.getTitle();
        asrt.assertEquals(actualMsg, "The Internet", "Title validation failed.");

        driver.findElement(By.xpath("//button[contains(text(),'Click for JS Alert')]")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.alertIsPresent());

        Alert alrt = driver.switchTo().alert();
        String expText = alrt.getText();
        asrt.assertEquals(expText, "I am a JS Alert", "Pop up body text validation failed.");
        alrt.accept();

        asrt.assertEquals(driver.findElement(By.id("result")).getText(), "You successfuly clicked an alert", "Result validation failed.");
    }
}
