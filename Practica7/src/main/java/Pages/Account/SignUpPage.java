package Pages.Account;

import Pages.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SignUpPage extends Page {


    public SignUpPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy (xpath = "//input[@id='id_gender1']")
    private WebElement signUpRadioTittle;

    @FindBy (xpath = "//input[@id='password']")
    private WebElement signUpPassword;


    @FindBy(xpath = "//select[@id='days']")
    private WebElement signUpDay; //

    @FindBy(xpath = "//select[@id='months']")
    private WebElement signUpMonth;

    @FindBy(xpath = "//select[@id='years']")
    private WebElement signUpYear;


    @FindBy (xpath = "//input[@id='newsletter']")
    private WebElement signUpCheckBoxNews;

    @FindBy (xpath = "//input[@id='optin']")
    private WebElement signUpCheckBoxOffers;

    @FindBy (xpath = "//input[@id='first_name']")
    private WebElement signUpFirtName;

    @FindBy (xpath = "//input[@id='last_name']")
    private WebElement signUpLastName;

    @FindBy (xpath = "//input[@id='company']")
    private WebElement signUpCompany;

    @FindBy (xpath = "//input[@id='address1']")
    private WebElement signUpAddress;

    @FindBy (xpath = "//input[@id='address2']")
    private WebElement signUpAddress2;

    @FindBy (xpath = "//select[@id='country']")
    private WebElement signUpCountry;

    @FindBy (xpath = "//input[@id='state']")
    private WebElement signUpState;

    @FindBy (xpath = "//input[@id='city']")
    private WebElement signUpCity;

    @FindBy (xpath = "//input[@id='zipcode']")
    private WebElement signUpZipCode;

    @FindBy (xpath = "//input[@id='mobile_number']")
    private WebElement signUpNumber;

    @FindBy (xpath = "//button[normalize-space()='Create Account']")
    private WebElement signUpBtnCreateAccount;


    public WebElement getSignUpRadioTittle(){
        return this.fiendElement(signUpRadioTittle);
    }

    public WebElement getSignUpPassword() {
        return this.fiendElement(signUpPassword);
    }


    // Método para seleccionar un día, mes, año específico
    public void setSignUpDay(String day) {
        Select select = new Select(signUpDay);
        select.selectByVisibleText(day);
    }

    public void setSignUpMonth(String month) {
        Select select = new Select(signUpMonth);
        select.selectByVisibleText(month);
    }

    public void setSignUpYear(String year) {
        Select select = new Select(signUpYear);
        select.selectByVisibleText(year);
    }


    public WebElement getSignUpCheckBoxNews() {
        return this.fiendElement(signUpCheckBoxNews);
    }

    public WebElement getSignUpCheckBoxOffers() {
        return this.fiendElement(signUpCheckBoxOffers);
    }

    public WebElement getSignUpFirtName() {
        return this.fiendElement(signUpFirtName);
    }

    public WebElement getSignUpLastName() {
        return this.fiendElement(signUpLastName);
    }

    public WebElement getSignUpCompany() {
        return this.fiendElement(signUpCompany);
    }

    public WebElement getSignUpAddress() {
        return this.fiendElement(signUpAddress);
    }

    public WebElement getSignUpAddress2() {
        return  this.fiendElement(signUpAddress2);
    }

    public void setSignUpCountry(String country) {
        Select select = new Select(signUpCountry);
        select.selectByVisibleText(country);
    }

    public WebElement getSignUpState() {
        return this.fiendElement(signUpState);
    }

    public WebElement getSignUpCity() {
        return this.fiendElement(signUpCity);
    }

    public WebElement getSignUpZipCode() {
        return this.fiendElement(signUpZipCode);
    }

    public WebElement getSignUpNumber() {
        return this.fiendElement(signUpNumber);
    }

    public WebElement getSignUpBtnCreateAccount() {
        return this.fiendElement(signUpBtnCreateAccount);
    }


}


