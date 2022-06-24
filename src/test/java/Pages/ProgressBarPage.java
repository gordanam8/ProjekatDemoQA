package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProgressBarPage {

    WebDriver driver;
    WebDriverWait wdwait;

    WebElement startStopButton;
    WebElement progressBar;

    WebElement resetButton;

    public ProgressBarPage(WebDriver driver, WebDriverWait wdwait) {
        this.driver = driver;
        this.wdwait = wdwait;
    }

    public WebElement getStartStopButton() {
        return startStopButton = driver.findElement(By.id("startStopButton"));
    }

    public WebElement getProgressBar() {
        return progressBar = driver.findElement(By.cssSelector(".progress-bar.bg-info"));
    }

    public WebElement getResetButton() {
        return resetButton = driver.findElement(By.xpath("//button[@id='resetButton']"));
    }

    //methods
    public void clickOnStartStopButton() {
        this.getStartStopButton().click();
    }

    public void clickOnResetButton() {
        this.getResetButton().click();
    }
}