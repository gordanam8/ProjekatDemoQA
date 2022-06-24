package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

public class Interactions {

    WebDriver driver;
    WebDriverWait wdwait;

    public Interactions(WebDriver driver, WebDriverWait wdwait) {
        this.driver = driver;
        this.wdwait = wdwait;
    }

    public String getUrl() {
        return driver.getCurrentUrl();
    }

    // Interactions
    public WebElement getInteractionsTab(String tabName) {
        ArrayList<WebElement> bars = new ArrayList<WebElement>();
        ArrayList<WebElement> alarmBars = new ArrayList<WebElement>();
        bars = (ArrayList<WebElement>) driver.findElements(By.className("element-group"));

        for (int i = 0; i < bars.size(); i ++) {

            if (bars.get(i).findElement(By.className("header-text")).getText().equals("Interactions")) {

                alarmBars = (ArrayList<WebElement>) bars.get(i).findElements(By.tagName("li"));

                for (int j = 0; j < alarmBars.size(); j++) {

                    if (tabName.equals(alarmBars.get(j).getText())) {

                        return alarmBars.get(j);
                    }
                }
            }
        }

        return null;
    }

    // Click on Sortable
    public void clickSortable() {
        WebElement element = getInteractionsTab("Sortable");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);

        element.click();

    }

    // Click on Selectable
    public void clickSelectable() {
        WebElement element = getInteractionsTab("Selectable");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);

        element.click();

    }

    // Click on Resizable
    public void clickResizable() {
        WebElement element = getInteractionsTab("Resizable");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);

        element.click();

    }

    // Click on Droppable
    public void clickDroppable() {
        WebElement element = getInteractionsTab("Droppable");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);

        element.click();

    }

    // Click on Dragabble
    public void clickDragabble() {
        WebElement element = getInteractionsTab("Dragabble");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);

        element.click();

    }

}