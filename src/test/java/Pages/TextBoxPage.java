package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TextBoxPage {

    WebDriver driver;
    WebDriverWait wdwait;
    String urlTextBoxPage;

    WebElement fullNameField;

    WebElement emailField;

    WebElement currentAddressField;

    WebElement permanentAddressField;

    WebElement submitButton;

    WebElement nameText;

    WebElement emailText;

    WebElement currentAddressText;

    WebElement permanentAddressText;



    public TextBoxPage(WebDriver driver, WebDriverWait wdwait) {
        this.driver = driver;
        this.wdwait = wdwait;
    }

    public String getUrlTextBoxPage() {
        return urlTextBoxPage = driver.getCurrentUrl();
    }

    public WebElement getFullNameField() {
        return fullNameField = driver.findElement(By.id("userName"));
    }

    public WebElement getEmailField() {
        return emailField = driver.findElement(By.id("userEmail"));
    }

    public WebElement getCurrentAddressField() {
        return currentAddressField = driver.findElement(By.id("currentAddress"));
    }

    public WebElement getPermanentAddressField() {
        return permanentAddressField = driver.findElement(By.id("permanentAddress"));
    }

    public WebElement getSubmitButton() {
        return submitButton = driver.findElement(By.id("submit"));
    }

    public WebElement getNameText() {
        return nameText = driver.findElement(By.id("name"));
    }

    public WebElement getEmailText() {
        return emailText = driver.findElement(By.id("email"));
    }

    public WebElement getCurrentAddressText() {
        return currentAddressText = driver.findElement(By.id("output")).findElement(By.id("currentAddress"));
    }

    public WebElement getPermanentAddressText() {
        return permanentAddressText = driver.findElement(By.id("output")).findElement(By.id("permanentAddress"));
    }

    //methods
    public void insertFullName(String username) {
        this.getFullNameField().clear();
        this.getFullNameField().sendKeys(username);
    }
    public void insertEmail(String email) {
        this.getEmailField().clear();
        this.getEmailField().sendKeys(email);
    }
    public void insertCurrentAddress(String currentAddress) {
        this.getCurrentAddressField().clear();
        this.getCurrentAddressField().sendKeys(currentAddress);
    }
    public void insertPermanentAddress(String permanentAddress) {
        this.getPermanentAddressField().clear();
        this.getPermanentAddressField().sendKeys(permanentAddress);
    }

    public void clickOnSubmitButton() {
        this.getSubmitButton().click();
    }


}
