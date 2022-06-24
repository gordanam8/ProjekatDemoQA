package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

public class HomePage {

    WebDriver driver;
    WebDriverWait wdwait;

    WebElement elements;

    WebElement alertFraneWindow;

    WebElement widgets;

    WebElement interactions;

    WebElement bookStoreApplication;


    public HomePage(WebDriver driver, WebDriverWait wdwait) {
        this.driver = driver;
        this.wdwait = wdwait;
    }

    public void cardElementsClicik() throws InterruptedException {
        ArrayList<WebElement> cards = new ArrayList<WebElement>();


        cards = (ArrayList<WebElement>) driver.findElements(By.cssSelector(".card.mt-4.top-card"));
        System.out.println("SIZE " + cards.size());
        System.out.println("SIZE " + cards.get(0).getText());

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", cards.get(0));

        Thread.sleep(1000);


        cards.get(0).click();
    }

    public void cardFormsClicik() {
        ArrayList<WebElement> cards = new ArrayList<WebElement>();
        cards = (ArrayList<WebElement>) driver.findElements(By.cssSelector(".card.mt-4.top-card"));
        System.out.println("SIZE " + cards.size());
        System.out.println("SIZE " + cards.get(0).getText());
        cards.get(1).findElement(By.className("card-body")).click();

    }

    public void clickSidebarElementsCheckBox() {
        ArrayList<WebElement> sideBar = new ArrayList<WebElement>();
        sideBar =  (ArrayList<WebElement>) driver.findElements(By.className("left-pannel"));

        System.out.println("SIZE SLIDE " + sideBar);

        sideBar.get(0).findElement(By.id("item-2")).click();

    }

    public WebElement getCard(String cardText) {
        ArrayList<WebElement> cards = new ArrayList<WebElement>();
        cards = (ArrayList<WebElement>) driver.findElements(By.cssSelector(".card.mt-4.top-card"));

        for (int i = 0; i < cards.size(); i++) {
            if (cardText.equals(cards.get(i).getText())) return cards.get(i);
        }

        return cards.get(0);
    }

    public void clickElements() {
        WebElement element;

        element = getCard("Elements");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);

        element.click();
    }

    public void clickForms() {
        WebElement element;

        element = getCard("Forms");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);

        element.click();
    }

    public void clickAlerts() {
        WebElement element;

        element = getCard("Alerts, Frame & Windows");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);

        element.click();
    }

    public void clickWidgets() {
        WebElement element;

        element = getCard("Widgets");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);

        element.click();
    }

    public void clickInteractions() {
        WebElement element;

        element = getCard("Interactions");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);

        element.click();
    }

    public void clickBookStoreApplication() {
        WebElement element;

        element = getCard("Book Store Application");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);

        element.click();
    }

}
