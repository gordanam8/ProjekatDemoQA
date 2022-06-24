package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ToolTipsPage {

    WebDriver driver;
    WebDriverWait wdwait;

    WebElement hoverButtoon;
    WebElement hoverTextField;

    WebElement contraryText;

    WebElement sectionNumberText;
    public ToolTipsPage(WebDriver driver, WebDriverWait wdwait) {
        this.driver = driver;
        this.wdwait = wdwait;
    }

    public WebElement getHoverButtoon() {
        return hoverButtoon = driver.findElement(By.id("toolTipButton"));
    }

    public WebElement getHoverTextField() {
        return hoverTextField = driver.findElement(By.id("toolTipTextField"));
    }

    public WebElement getContraryText() {
        return contraryText = driver.findElement(By.linkText("Contrary"));
    }

    public WebElement getSectionNumberText() {
        return sectionNumberText = driver.findElement(By.linkText("1.10.32"));
    }
}
