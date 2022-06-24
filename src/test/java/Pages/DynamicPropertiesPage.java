package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class DynamicPropertiesPage {

    WebDriver driver;
    WebDriverWait wdwait;
    WebElement enableAfter5Button;

    WebElement changeColorButton;
    WebElement visibleAfter5Button;

    public DynamicPropertiesPage(WebDriver driver, WebDriverWait wdwait) {
        this.driver = driver;
        this.wdwait = wdwait;
    }

    public WebElement getEnableAfter5Button() {
        return enableAfter5Button = driver.findElement(By.id("enableAfter"));
    }

    public WebElement getChangeColorButton() {
        return changeColorButton = driver.findElement(By.id("colorChange"));
    }

    public WebElement getVisibleAfter5Button() {
        return visibleAfter5Button = driver.findElement(By.id("visibleAfter"));
    }

    //methods

    public void clickOnEnableAfter5Button() {
        this.getEnableAfter5Button().click();
    }

}
