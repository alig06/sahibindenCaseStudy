package base;

import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDriverManager {
    protected static ChromeDriver driver = new ChromeDriver();

    public static ChromeDriver getDriver() {
        return driver;
    }
}