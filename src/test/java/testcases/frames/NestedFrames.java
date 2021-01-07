package testcases.frames;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import setup.BaseTest;
import setup.CommonMethods;

public class NestedFrames extends BaseTest {
    @Test
    public static void testNestedFrames() {
        CommonMethods.navigateToURL(prop.getProperty("nested_frames"));

        driver.switchTo().frame("frame-top");

        driver.switchTo().frame("frame-left");
        String leftFrame = driver.findElement(By.xpath("/html/body")).getText();
        System.out.println("Left Frame: "+leftFrame);
        asrt.assertEquals(driver.findElement(By.xpath("/html/body")).getText(), "LEFT", "Text validation failed.");

        /**
         * Change focus to the parent context.
         * If the current context is the top level browsing context, the context remains unchanged.
         */
        driver.switchTo().parentFrame();

        driver.switchTo().frame("frame-middle");
        String midFrame = driver.findElement(By.xpath("//div[@id='content']")).getText();
        System.out.println("Mid Frame: "+midFrame);
        asrt.assertEquals(midFrame, "MIDDLE", "Text validation failed.");

        driver.switchTo().parentFrame();

        driver.switchTo().frame("frame-right");
        String rightFrame = driver.findElement(By.xpath("/html/body")).getText();
        System.out.println("Right Frame: "+rightFrame);
        asrt.assertEquals(rightFrame, "RIGHT", "Text validation failed.");

        /**
         * Selects either the first frame on the page, or the main document when a page contains iframes.
         */
        driver.switchTo().defaultContent();

        driver.switchTo().frame("frame-bottom");
        String bottomFrame = driver.findElement(By.xpath("/html/body")).getText();
        System.out.println("Bottom Frame: "+bottomFrame);
        asrt.assertEquals(bottomFrame, "BOTTOM", "Text validation failed.");
    }
}
