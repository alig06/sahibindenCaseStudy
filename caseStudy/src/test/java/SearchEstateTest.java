import base.AbstractActions;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import dataRepository.dataManage;
import org.junit.experimental.categories.Category;
import org.openqa.selenium.JavascriptExecutor;
import pages.SearchEstatePage;

public class SearchEstateTest extends AbstractActions {
    private SearchEstatePage searchEstatePage = new SearchEstatePage();

    @BeforeClass
    public static void setUp() {

    }

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
     * Showing searched results
     */
    @Test
    public void testSearch() throws InterruptedException {
        // Choose category
        searchEstatePage.housing.click();
        waitForElement(searchEstatePage.homeIcon);

        // Choose for sales
        searchEstatePage.forSale.click();
        waitUrlContains(dataManage.urls.FOR_SALE_URL);

        // Choose housing type
        searchEstatePage.apartment.click();
        waitUrlContains(dataManage.urls.FOR_SALE_APARTMENT_URL);

        // Choose city
        searchEstatePage.city.click();
        waitForElement(searchEstatePage.activeInput);
        searchEstatePage.setActiveInput(dataManage.identity.SEARCH_CITY);
        searchEstatePage.activeItem.click();
        scrollToElement(searchEstatePage.searchSubmit);
    }

    /**
     * Go viewAll popUp
     *
     * @throws InterruptedException
     */
    @Test
    public void testViewAll() throws InterruptedException {
        // Go viewAll popUp
        waitForClickable(searchEstatePage.viewAll);
        searchEstatePage.viewAll.click();

        // Submit popUp
        waitForClickable(searchEstatePage.submitPopupButton);
        waitForElement(searchEstatePage.popUp);

        // Scroll to shipping option
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        driver.executeScript("arguments[0].scrollIntoView(true);", searchEstatePage.shipping);
        driver.executeScript("arguments[0].scrollIntoView(false);", searchEstatePage.shipping);
        searchEstatePage.shipping.click();

    }

    /**
     * Check reach option equality
     *
     * @throws InterruptedException
     */
    @Test
    public void testExpectedValueEquality() throws InterruptedException {
        // Wait and click "Avrasya Tuneli" checkbox
        waitForElement(searchEstatePage.avrasyaTuneli);
        searchEstatePage.avrasyaTuneli.click();

        // Submit popUp form
        searchEstatePage.submitPopupButton.click();
        waitInvisibilityOfElement(searchEstatePage.opening);
        waitForClickable(searchEstatePage.lastSearchedElement);

        // Go any results
        searchEstatePage.lastSearchedElement.click();
        waitForElement(searchEstatePage.content);
        scrollToElement(searchEstatePage.reach);
        waitForElement(searchEstatePage.selectedElement);

        //Check equality
        Assert.assertEquals(searchEstatePage.selectedElement.getAttribute("class"), dataManage.identity.SELECTED_CLASS);
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }
}
