package base;

import dataRepository.dataManage;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class AbstractActions extends createWebDriver{
    protected dataManage data = new dataManage();
    private Logger logger = Logger.getLogger(String.valueOf(AbstractActions.class));

    protected WebDriverWait wait = new WebDriverWait(driver,20);

    public void goUrl(String url){
        logger.log(Level.INFO,"Going to url");
        driver.get(url);
        logger.log(Level.INFO,"Reached website");
    }
    public void clickCssSelector(String cssSelector){
        logger.log(Level.INFO,"Click expected element");
        driver.findElement(By.cssSelector(cssSelector)).click();
        logger.log(Level.INFO,"Clicked element");
    }

    public void waitForPageLoad(){
        logger.log(Level.INFO,"Waiting for page items");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".copyright")));
        logger.log(Level.INFO,"Page load succesfully");
    }
    public void waitForElement(String cssSelector){
        logger.log(Level.INFO,"Waiting for identified element");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(cssSelector)));
        logger.log(Level.INFO,"Element is ready");
    }
    public void writeToInput(String cssSelector, String data){
        logger.log(Level.INFO,"Waiting for identified element");
        waitForElement(cssSelector);
        driver.findElement(By.cssSelector(cssSelector)).sendKeys(data);
    }
    public void selectDropdownItem(String cssSelector, String selectValue) throws InterruptedException {
        Select dropdown = new Select(driver.findElement(By.cssSelector(cssSelector)));
        dropdown.selectByValue(selectValue);
        Thread.sleep(1000);
    }

}