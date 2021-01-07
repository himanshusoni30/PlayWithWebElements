package testcases.frames;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import setup.BaseTest;
import setup.CommonMethods;

public class NestedFrames extends BaseTest {
    @Test
    public static void testNestedFrames() {
        CommonMethods.navigateToURL(prop.getProperty("nested_frames"));
//        String mainPage = driver.getWindowHandle();

        driver.switchTo().frame("frame-top");

        driver.switchTo().frame("frame-left");
        String leftFrame = driver.findElement(By.xpath("/html/body")).getText();
        System.out.println("Left Frame: "+leftFrame);
        asrt.assertEquals(driver.findElement(By.xpath("/html/body")).getText(), "LEFT", "Text validation failed.");

        driver.switchTo().parentFrame();
//        driver.switchTo().defaultContent();

        driver.switchTo().frame("frame-middle");
        String midFrame = driver.findElement(By.xpath("//div[@id='content']")).getText();
        System.out.println("Mid Frame: "+midFrame);
        asrt.assertEquals(midFrame, "MIDDLE", "Text validation failed.");

        driver.switchTo().parentFrame();
//        driver.switchTo().defaultContent();

        driver.switchTo().frame("frame-right");
        String rightFrame = driver.findElement(By.xpath("/html/body")).getText();
        System.out.println("Right Frame: "+rightFrame);
        asrt.assertEquals(rightFrame, "RIGHT", "Text validation failed.");

//        driver.switchTo().parentFrame();
//        driver.switchTo().parentFrame();
        driver.switchTo().defaultContent();
//        driver.switchTo().window(mainPage);

        driver.switchTo().frame("frame-bottom");
        String bottomFrame = driver.findElement(By.xpath("/html/body")).getText();
        System.out.println("Bottom Frame: "+bottomFrame);
        asrt.assertEquals(bottomFrame, "BOTTOM", "Text validation failed.");
    }
}
