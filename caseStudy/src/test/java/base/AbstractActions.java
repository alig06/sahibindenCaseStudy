package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.RegisterPage;

import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class AbstractActions extends RegisterPage {
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
    public void waitForElement(WebElement element){
        logger.log(Level.INFO,"Waiting for identified element");
        wait.until(ExpectedConditions.visibilityOf(element));
        logger.log(Level.INFO,"Element is ready");
    }

    public void selectDropdownItem(WebElement element, String selectValue) throws InterruptedException {
        Select dropdown = new Select(wait.until(ExpectedConditions.visibilityOf(element)));
        dropdown.selectByValue(selectValue);
        Thread.sleep(1000);
    }

}