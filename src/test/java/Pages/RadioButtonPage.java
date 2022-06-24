package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class RadioButtonPage {

    WebDriver driver;
    WebDriverWait wdwait;

    WebElement yesButton;
    WebElement impressiveButton;
    WebElement noButton;

    WebElement yesMessage;

    //constructor
    public RadioButtonPage(WebDriver driver, WebDriverWait wdwait) {
        this.driver = driver;
        this.wdwait = wdwait;
    }
    //getter

    public WebElement getYesButton() {
        return yesButton = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/div[2]/label"));
    }

    public WebElement getImpressiveButton() {
        return impressiveButton = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/div[3]/label"));
    }

    public WebElement getNoButton() {
        return noButton = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/div[4]/label"));
    }

    public WebElement getYesMessage() {
        return yesMessage = driver.findElement(By.className("text-success"));
    }

    //methods
    public void clickOnYesButton() {
        this.getYesButton().click();
    }

    public void clickOnImpressiveButton() {
        this.getImpressiveButton().click();
    }

    public void clickOnNoButton() {
        this.getNoButton().click();
    }


}
