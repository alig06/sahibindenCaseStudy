package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.RegisterPage;

import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class AbstractActions extends ChromeDriverManager{
    private Logger logger = Logger.getLogger(String.valueOf(AbstractActions.class));

    protected WebDriverWait wait = new WebDriverWait(driver,20);

    public void goUrl(String url){
        logger.log(Level.INFO,"Going to url");
        driver.get(url);
        logger.log(Level.INFO,"Reached website");
    }

    public void waitForPageLoad(){
        logger.log(Level.INFO,"Waiting for page items");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".copyright")));
        logger.log(Level.INFO,"Page load succesfully");
    }
    public void waitForElement(WebElement element) throws InterruptedException {
        logger.log(Level.INFO,"Waiting for identified element");
        wait.until(ExpectedConditions.visibilityOf(element));
        Thread.sleep(1000);
        logger.log(Level.INFO,"Element is ready");
    }

    public void waitForClickable(WebElement element) throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        Thread.sleep(1000);
    }

    public void selectDropdownItem(WebElement element, String selectValue) throws InterruptedException {
        logger.log(Level.INFO,"Selecting item");
        Select dropdown = new Select(wait.until(ExpectedConditions.visibilityOf(element)));
        dropdown.selectByValue(selectValue);
        Thread.sleep(1000);
        logger.log(Level.INFO,"Item is selected");
    }

    public String takeTextToElement(WebElement element){
        logger.log(Level.INFO,"Taking the element text");
        return wait.until(ExpectedConditions.visibilityOf(element)).getText();
    }
    public void waitUrlContains(String url){
        logger.log(Level.INFO,"Checking Url");
        wait.until(ExpectedConditions.urlContains(url));
        logger.log(Level.INFO,"Url contains given text");
    }
    public void scrollToElement(WebElement element){
        WebElement el = wait.until(ExpectedConditions.visibilityOf(element));
        Actions actions = new Actions(driver);
        actions.moveToElement(el);
        actions.perform();
    }

    public void waitInvisibilityOfElement(WebElement element){
        wait.until(ExpectedConditions.invisibilityOf(element));
    }
}