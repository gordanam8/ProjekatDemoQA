package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class LinksPage {

    WebDriver driver;
    WebDriverWait webDriverWait;

    WebElement simpleLink;
    WebElement dynamicLink;

    WebElement created;
    WebElement noContent;
    WebElement moved;
    WebElement badRequest;
    WebElement unauthorized;
    WebElement forbidden;
    WebElement notFound;

    WebElement expMessage;
    public LinksPage(WebDriver driver, WebDriverWait webDriverWait) {
        this.driver = driver;
        this.webDriverWait = webDriverWait;
    }

    public WebElement getSimpleLink() {
        return simpleLink = driver.findElement(By.id("simpleLink"));
    }

    public WebElement getDynamicLink() {
        return dynamicLink = driver.findElement(By.id("dynamicLink"));
    }

    public WebElement getCreated() {
        return created = driver.findElement(By.id("created"));
    }

    public WebElement getNoContent() {
        return noContent = driver.findElement(By.id("no-content"));
    }

    public WebElement getMoved() {
        return moved = driver.findElement(By.id("moved"));
    }

    public WebElement getBadRequest() {
        return badRequest = driver.findElement(By.id("bad-request"));
    }

    public WebElement getUnauthorized() {
        return unauthorized = driver.findElement(By.id("unauthorized"));
    }

    public WebElement getForbidden() {
        return forbidden = driver.findElement(By.id("forbidden"));
    }

    public WebElement getNotFound() {
        return notFound = driver.findElement(By.id("invalid-url"));
    }

    public WebElement getExpMessage() {
        return expMessage = driver.findElement(By.id("linkResponse"));
        //return expMessage = driver.findElement(By.id("linkWrapper")).findElement(By.id("linkResponse"));

    }

    //methods

    public void clickOnSimpleLink() {
        this.getSimpleLink().click();
    }

    public void clickOnDynamicLink() {
        this.getDynamicLink().click();
    }

    public void clickOnCreatedLink() {
        this.getCreated().click();
    }

    public void clickOnNoContentLink() {
        this.getNoContent().click();
    }

    public void clickOnMovedLink() {
        this.getMoved().click();
    }

    public void clickOnBadRequestLink() {
        this.getBadRequest().click();
    }

    public void clickOnUnauthorizedLink() {
        this.getUnauthorized().click();
    }

    public void clickOnForbiddenLink() {
        this.getForbidden().click();
    }

    public void clickOnNotFoundLink() {
        this.getNotFound().click();
    }
}
