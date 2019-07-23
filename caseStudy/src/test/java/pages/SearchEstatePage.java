package pages;

import base.AbstractActions;
import base.ChromeDriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchEstatePage extends ChromeDriverManager {
    @FindBy(css = "[href=\"/kategori/emlak-konut\"]")
    public WebElement housing;

    @FindBy(css = "[data-tab=\"home\"]")
    public WebElement homeIcon;

    @FindBy(css = "[href=\"/satilik\"]")
    public WebElement forSale;

    @FindBy(css = "[href=\"/satilik-daire\"]")
    public WebElement apartment;

    @FindBy(css = "li[data-address=\"city\"] > a.faceted-select")
    public WebElement city;

    @FindBy(css = "div.address-pane.active > div.address-filter > input.js-address-filter")
    public WebElement activeInput;

    @FindBy(css = "[data-id=\"10002\"]")
    public WebElement activeItem;

    @FindBy(css = "#moreSelectionLink > a.viewAllLightbox")
    public WebElement viewAll;

    @FindBy(css = ".pageNavigator")
    public WebElement searchSubmit;

    @FindBy(id = "faceted-left-menu-Ulaşım")
    public WebElement shipping;

    @FindBy(id = "cboxContent")
    public WebElement popUp;

    @FindBy(id = "faceted-true-a106958")
    public WebElement avrasyaTuneli;

    @FindBy(id = "doDetailedSearchButton")
    public WebElement submitPopupButton;

    @FindBy(css = ".searchResultsItem:nth-child(1)")
    public WebElement lastSearchedElement;

    @FindBy(css = ".classifiedDetailContent")
    public WebElement content;

    @FindBy(css = "#classifiedProperties > ul:nth-child(12) > li:nth-child(2)")
    public WebElement selectedElement;

    @FindBy(css = "h3:nth-child(13)")
    public WebElement reach;

    @FindBy(css = ".opening")
    public WebElement opening;

    @FindBy(xpath = "//*[@id=\"facetedSearchListContainer\"]/div")
    public WebElement reachList;

    public SearchEstatePage(){
        //Initialise Elements
        this.driver=driver;

        PageFactory.initElements(driver, this);
    }

    public void setActiveInput(String data) {
        activeInput.sendKeys(data);
    }


}
