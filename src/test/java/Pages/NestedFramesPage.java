package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NestedFramesPage {

    WebDriver driver;
    WebDriverWait wdwait;

    WebElement frame1;
    WebElement frame1InsideElement;
    public NestedFramesPage(WebDriver driver, WebDriverWait wdwait) {
        this.driver = driver;
        this.wdwait = wdwait;
    }

    public WebElement getFrame1() {
        return frame1 =driver.findElement(By.id("frame1"));
    }

    public WebElement getFrame1InsideElement() {
        return frame1InsideElement = driver.findElement(By.tagName("body"));
    }
}
