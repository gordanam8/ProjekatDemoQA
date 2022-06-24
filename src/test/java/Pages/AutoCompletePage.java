package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;


public class AutoCompletePage {

    WebDriver driver;
    WebDriverWait wdwait;

    WebElement multipleContainer;
    WebElement singleContainer;

    public AutoCompletePage(WebDriver driver, WebDriverWait wdwait) {
        this.driver = driver;
        this.wdwait = wdwait;
    }

    public WebElement getMultipleContainer() {
        return multipleContainer = driver.findElement(By.cssSelector("auto-complete__input"));
    }

    public WebElement getSingleContainer() {
        return singleContainer = driver.findElement(By.id("autoCompleteSingleContainer"));
    }

    //methods

    public void sendColorToMultipleContainer(String color) {
        this.getMultipleContainer().sendKeys();
    }

    public void sendColorToSingleContainer(String color) {
        this.getMultipleContainer().sendKeys();
    }
}
