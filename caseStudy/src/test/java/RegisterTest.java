import base.AbstractActions;
import dataRepository.dataManage;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import pages.RegisterPage;

public class RegisterTest extends AbstractActions {
    private RegisterPage registerPage = new RegisterPage();

    /**
     * Check the expected url equality
     */
    @Test
    public void testUrl() {
        // Go base url and check equality
        goUrl(dataManage.urls.BASE_URL);
        waitForPageLoad();
        Assert.assertEquals(driver.getCurrentUrl(), dataManage.urls.BASE_URL.concat("/"));
    }

    /**
     * Check the Register button workable
     */
    @Test
    public void testRegisterButton() {
        // Click register button and url control
        registerPage.registerButton.click();
        waitForPageLoad();
        Assert.assertEquals(driver.getCurrentUrl(), dataManage.urls.REGISTER_PAGE_URL);
    }

    /**
     * Fill form fields
     *
     * @throws InterruptedException
     */
    @Test
    public void testRegisterForm() throws InterruptedException {
        // Choose registration type
        registerPage.registrationType.click();

        // Choose identity data
        registerPage.setName(dataManage.identity.REGISTER_NAME);
        registerPage.setSurname(dataManage.identity.REGISTER_SURNAME);
        registerPage.setEmail(dataManage.identity.REGISTER_MAIL);
        registerPage.setPassword(dataManage.identity.REGISTER_PASSWORD);
        registerPage.setMobile(dataManage.identity.REGISTER_MOBILE);

        // Choose address data
        selectDropdownItem(registerPage.category, dataManage.identity.CHOSEN_CATEGORY);
        selectDropdownItem(registerPage.city, dataManage.identity.CHOSEN_CITY);
        selectDropdownItem(registerPage.town, dataManage.identity.CHOSEN_TOWN);
        selectDropdownItem(registerPage.quarter, dataManage.identity.CHOSEN_QUARTER);
        registerPage.setAddress(dataManage.identity.CHOSEN_ADDRESS);
        selectDropdownItem(registerPage.taxOffice, dataManage.identity.CHOSEN_TAX_OFFICE);

        // Choose communication data and submit
        registerPage.setIdNumber(dataManage.identity.IDENTITY_NUMBER);
        registerPage.setPhone(dataManage.identity.PHONE_NUMBER);
        registerPage.setPhone2(dataManage.identity.PHONE_NUMBER_2);
        registerPage.submitButton.click();
    }

    /**
     * Check the captcha error text
     * @throws InterruptedException
     */
    @Test
    public void testEmptySecCode() throws InterruptedException {
        // Wait error elements and check error text
        waitForElement(registerPage.errorBox);
        waitForElement(registerPage.captchaError);
        Assert.assertEquals(
                takeTextToElement(registerPage.captchaError), dataManage.errorText.emptySecCodeError);

        // Finish (driver quit)
        tearDown();
    }
}