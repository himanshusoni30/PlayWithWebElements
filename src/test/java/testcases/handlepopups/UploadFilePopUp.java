package testcases.handlepopups;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import setup.BaseTest;
import setup.CommonMethods;

import java.time.Duration;

public class UploadFilePopUp extends BaseTest {
    @Test
    public static void testConfirmationPopUpTextAndAccept() {
        CommonMethods.navigateToURL(prop.getProperty("file_upload_pop_up"));
        String actualMsg = driver.getTitle();
        asrt.assertEquals(actualMsg, "The Internet", "Title validation failed.");
        fileUpload("/fileToUpload.txt");
    }

    public static void fileUpload(String fileName){
        driver.findElement(By.xpath("//*[@id='file-upload']")).sendKeys(fileName);
        driver.findElement(By.id("file-submit")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='example']")));

        String actMsg = driver.findElement(By.xpath("//div[@class='example']//h3")).getText();
        asrt.assertEquals(actMsg, "File Uploaded!", "Uploaded file is not correct.");

        String actualFileName = driver.findElement(By.id("uploaded-files")).getText();
        asrt.assertEquals(actualFileName, "fileToUpload.txt", "Uploaded file is not correct.");
    }
}
