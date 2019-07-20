import base.AbstractActions;
import dataRepository.dataManage;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;


public class RegisterTest extends AbstractActions {
    @BeforeClass
    public static void setUp(){
    }
    /**
     * Check the expected url equality
     */
    @Test
    public void testUrl() {
        goUrl(data.BASE_URL);
        waitForPageLoad();
        Assert.assertEquals(driver.getCurrentUrl(), data.BASE_URL.concat("/"));
    }

    /**
     * Check the Register button workable
     */
    @Test
    public void testRegisterButton() {
        clickCssSelector(".register-text > a");
        waitForPageLoad();
        Assert.assertEquals(driver.getCurrentUrl(),data.REGISTER_PAGE_URL);
    }

    /**
     * Fill form fields
     *
     * @throws InterruptedException
     */
    @Test
    public void testRegisterForm() throws InterruptedException {
        clickCssSelector("[for=\"corporate\"]");

        writeToInput("#name", data.REGISTER_NAME);
        writeToInput("#surname", data.REGISTER_SURNAME);
        writeToInput("#email", data.REGISTER_MAIL);
        writeToInput("#password", data.REGISTER_PASSWORD);
        writeToInput("#mobile", data.REGISTER_MOBILE);

        selectDropdownItem("#category", data.CHOSEN_CATEGORY);
        selectDropdownItem("#city", data.CHOSEN_CITY);
        selectDropdownItem("#town", data.CHOSEN_TOWN);
        selectDropdownItem("#quarter", data.CHOSEN_QUARTER);

        writeToInput("#address", data.CHOSEN_ADDRESS);

        selectDropdownItem("#taxOffice", data.CHOSEN_TAX_OFFICE);

        writeToInput("#idNumber", data.IDENTITY_NUMBER);
        writeToInput("#phone", data.PHONE_NUMBER);

    }

    @AfterClass
    public static void tearDown(){
        driver.quit();
    }
}
