package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BrowserWindowsPage {

    WebDriver driver;
    WebDriverWait wdwait;

    WebElement tabButton;
    WebElement windowButton;

    WebElement messageWindowButton;

    public BrowserWindowsPage(WebDriver driver, WebDriverWait wdwait) {
        this.driver = driver;
        this.wdwait = wdwait;
    }

    public WebElement getTabButton() {
        return tabButton = driver.findElement(By.id("tabButton"));
    }

    public WebElement getMessageWindowButton() {
        return messageWindowButton = driver.findElement(By.id("messageWindowButton"));
    }

    public WebElement getWindowButton() {
        return windowButton = driver.findElement(By.id("windowButton"));
    }
    //methods

    public void clickOnTabButton() {
        this.getTabButton().click();
    }

    public void clickOnWindowButton() {
        this.getWindowButton().click();
    }

    public void clickOnMessageWindowButton() {
        this.getMessageWindowButton().click();
    }

}
