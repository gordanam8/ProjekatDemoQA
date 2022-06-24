package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ModalDialogsPage {

    WebDriver driver;
    WebDriverWait wdwait;

    WebElement smallModalButton;
    WebElement largeModalButton;

    WebElement closeSmallModal;

    WebElement closeLargeModal;

    WebElement modalContainer;
    WebElement modalContentBody;

    public ModalDialogsPage(WebDriver driver, WebDriverWait wdwait) {
        this.driver = driver;
        this.wdwait = wdwait;
    }

    public WebElement getSmallModalButton() {
        return smallModalButton = driver.findElement(By.id("showSmallModal"));
    }

    public WebElement getLargeModalButton() {
        return largeModalButton = driver.findElement(By.id("showLargeModal"));
    }

    public WebElement getCloseSmallModal() {
        return closeSmallModal = driver.findElement(By.id("closeSmallModal"));
    }

    public WebElement getCloseLargeModal() {
        return closeLargeModal = driver.findElement(By.id("closeLargeModal"));
    }

    public WebElement getModalContainer() {
        return modalContainer = driver.findElement(By.className("modal-content"));
    }

    public WebElement getModalContentBody() {
        return modalContentBody = driver.findElement(By.className("modal-body"));
    }

    //methods

    public void clickOnSmallModalButton() {
        this.getSmallModalButton().click();
    }

    public void clickOnLargeModalButton() {
        this.getLargeModalButton().click();
    }

    public void clickOnCloseSmallModal() {
        this.getCloseSmallModal().click();
    }

    public void clickOnCloseLargeModal () {
        this.getCloseLargeModal().click();
    }

}
