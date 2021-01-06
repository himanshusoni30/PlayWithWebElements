package testcases.handlepopups;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import setup.BaseTest;
import setup.CommonMethods;

import java.time.Duration;

public class JSConfirmOrConfirmationPopUp extends BaseTest {
    private static Alert alrt;

    @Test
    public static void testConfirmationPopUpTextAndAccept() {
        CommonMethods.navigateToURL(prop.getProperty("js_alert"));
        String actualMsg = driver.getTitle();
        asrt.assertEquals(actualMsg, "The Internet", "Title validation failed.");

        confirmationPopUp("accept");
        confirmationPopUp("dismiss");
    }

    public static void confirmationPopUp(String acceptOrdismiss){
        driver.findElement(By.xpath("//button[contains(text(),'Click for JS Confirm')]")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.alertIsPresent());

        alrt = driver.switchTo().alert();
        String expText = alrt.getText();
        asrt.assertEquals(expText, "I am a JS Confirm", "Pop up body text validation failed.");

        if(acceptOrdismiss.equals("accept")){
            alrt.accept();
            asrt.assertEquals(driver.findElement(By.id("result")).getText(), "You clicked: Ok", "Result validation failed.");
        }else if(acceptOrdismiss.equals("dismiss")){
            alrt.dismiss();
            asrt.assertEquals(driver.findElement(By.id("result")).getText(), "You clicked: Cancel", "Result validation failed.");
        }
    }
}
