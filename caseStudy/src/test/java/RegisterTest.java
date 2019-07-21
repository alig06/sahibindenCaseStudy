import base.AbstractActions;
import dataRepository.dataManage;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import pages.RegisterPage;


public class RegisterTest extends AbstractActions {
    private RegisterPage registerPage = new RegisterPage();

    @BeforeClass
    public static void setUp(){
    }
    /**
     * Check the expected url equality
     */
    @Test
    public void testUrl() {
        goUrl(dataManage.urls.BASE_URL);
        waitForPageLoad();
        Assert.assertEquals(driver.getCurrentUrl(), dataManage.urls.BASE_URL.concat("/"));
    }

    /**
     * Check the Register button workable
     */
    @Test
    public void testRegisterButton() {
        registerButton.click();
        waitForPageLoad();
        Assert.assertEquals(driver.getCurrentUrl(),dataManage.urls.REGISTER_PAGE_URL);
    }

    /**
     * Fill form fields
     *
     * @throws InterruptedException
     */
    @Test
    public void testRegisterForm() throws InterruptedException {
        registirationType.click();

        registerPage.setName(dataManage.identity.REGISTER_NAME);
        registerPage.setSurname(dataManage.identity.REGISTER_SURNAME);
        registerPage.setEmail(dataManage.identity.REGISTER_MAIL);
        registerPage.setPassword(dataManage.identity.REGISTER_PASSWORD);

        registerPage.setMobile(dataManage.identity.REGISTER_MOBILE);

        selectDropdownItem(category,dataManage.identity.CHOSEN_CATEGORY);
        selectDropdownItem(city,dataManage.identity.CHOSEN_CITY);
        selectDropdownItem(town,dataManage.identity.CHOSEN_TOWN);
        selectDropdownItem(quarter,dataManage.identity.CHOSEN_QUARTER);



    }

    @AfterClass
    public static void tearDown(){
        driver.quit();
    }
}
