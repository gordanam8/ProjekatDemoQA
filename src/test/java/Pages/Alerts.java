package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

public class Alerts {

    WebDriver driver;
    WebDriverWait wdwait;

    public Alerts(WebDriver driver, WebDriverWait wdwait) {
        this.driver = driver;
        this.wdwait = wdwait;
    }

    public String getUrl() {
        return driver.getCurrentUrl();
    }

    // Alerts
    public WebElement getAlertsTab(String tabName) {
        ArrayList<WebElement> bars = new ArrayList<WebElement>();
        ArrayList<WebElement> alarmBars = new ArrayList<WebElement>();
        bars = (ArrayList<WebElement>) driver.findElements(By.className("element-group"));

        for (int i = 0; i < bars.size(); i ++) {

            if (bars.get(i).findElement(By.className("header-text")).getText().equals("Alerts, Frame & Windows")) {

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

    // Click on Browser Windows
    public void clickBrowserWindows() {
        WebElement element = getAlertsTab("Browser Windows");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);

        element.click();

    }

    // Click on Alerts
    public void clickAlerts() {
        WebElement element = getAlertsTab("Alerts");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);

        element.click();

    }

    // Click on Frames
    public void clickFrames() {
        WebElement element = getAlertsTab("Frames");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);

        element.click();

    }

    // Click on Nested Frames
    public void clickNestedFrames() {
        WebElement element = getAlertsTab("Nested Frames");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);

        element.click();

    }

    // Click on Modal Dialogs
    public void clickModalDialogs() {
        WebElement element = getAlertsTab("Modal Dialogs");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);

        element.click();

    }

}