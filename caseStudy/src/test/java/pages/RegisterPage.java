package pages;

import base.ChromeDriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RegisterPage extends ChromeDriverManager {
    @FindBy(id="name")
    public WebElement name;

    @FindBy(id="surname")
    public WebElement surname;

    @FindBy(id="email")
    public WebElement email;

    @FindBy(id="password")
    public WebElement password;

    @FindBy(id="mobile")
    public WebElement mobile;

    @FindBy(id="category")
    public WebElement category;

    @FindBy(id="city")
    public WebElement city;

    @FindBy(id="town")
    public WebElement town;

    @FindBy(id="quarter")
    public WebElement quarter;

    @FindBy(id="address")
    public WebElement address;

    @FindBy(id="taxOffice")
    public WebElement taxOffice;

    @FindBy(id="idNumber")
    public WebElement idNumber;

    @FindBy(id="phone")
    public WebElement phone;

    @FindBy(id="phone2")
    public WebElement phone2;

    @FindBy(css=".register-text > a")
    public WebElement registerButton;

    @FindBy(css = "[for=\"corporate\"]")
    public WebElement registrationType;

    @FindBy(id = "signUpButton")
    public WebElement submitButton;

    @FindBy(css = "dd > [for=\"captchaValue\"]")
    public WebElement captchaError;

    @FindBy(css = ".captchaInputinputText.error")
    public WebElement errorBox;

    public RegisterPage(){
        //Initialise Elements

        PageFactory.initElements(driver, this);
    }

    public void setName(String data) {
        name.clear();
        name.sendKeys(data);
    }

    public void setSurname(String data) {
        surname.clear();
        surname.sendKeys(data);
    }

    public void setEmail(String data) {

        email.sendKeys(data);
    }

    public void setPassword(String data) {
        password.sendKeys(data);
    }

    public void setMobile(String data) {
        mobile.sendKeys(data);
    }

    public void setAddress(String data) {
        address.sendKeys(data);
    }

    public void setIdNumber(String data) {
        idNumber.sendKeys(data);
    }

    public void setPhone(String data) {
        phone.sendKeys(data);
    }
    public void setPhone2(String data) {
        phone2.sendKeys(data);
    }

}
