package setup;

public class CommonMethods extends BaseTest{
    public static void navigateToURL(String url){
        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
    }
}
