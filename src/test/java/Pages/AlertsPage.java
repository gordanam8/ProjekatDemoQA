package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AlertsPage {

    WebDriver driver;
    WebDriverWait wdwait;

    WebElement alertButton;
    WebElement timerAlertButton;

    WebElement confirmButton;

    WebElement promptButton;

    public AlertsPage(WebDriver driver, WebDriverWait wdwait) {
        this.driver = driver;
        this.wdwait = wdwait;
    }

    public WebElement getAlertButton() {
        return alertButton = driver.findElement(By.id("alertButton"));
    }

    public WebElement getTimerAlertButton() {
        return timerAlertButton = driver.findElement(By.id("timerAlertButton"));
    }

    public WebElement getConfirmButton() {
        return confirmButton = driver.findElement(By.id("confirmButton"));
    }

    public WebElement getPromptButton() {
        return promptButton = driver.findElement(By.id("promtButton"));
    }
    //methods

    public void clickOnAlertButton() {
        this.getAlertButton().click();
    }

    public void clickOnTimerAlertButton() {
        this.getTimerAlertButton().click();
    }

    public void clickOnConfirmButton() {
        this.getConfirmButton().click();
    }

    public void clickOnPromptButton() {
        this.getPromptButton().click();
    }

}
