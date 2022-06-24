package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

public class Widgets {

    WebDriver driver;
    WebDriverWait wdwait;

    WebElement progressBar;

    public Widgets(WebDriver driver, WebDriverWait wdwait) {
        this.driver = driver;
        this.wdwait = wdwait;
    }

    public String getUrl() {
        return driver.getCurrentUrl();
    }


    public WebElement getWidgetsTab(String tabName) {
        ArrayList<WebElement> bars = new ArrayList<WebElement>();
        ArrayList<WebElement> alarmBars = new ArrayList<WebElement>();
        bars = (ArrayList<WebElement>) driver.findElements(By.className("element-group"));

        for (int i = 0; i < bars.size(); i++) {

            if (bars.get(i).findElement(By.className("header-text")).getText().equals("Widgets")) {

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

    // Click on Accordian
    public void clickAccordian() {
        WebElement element = getWidgetsTab("Accordian");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);

        element.click();

    }

    // Click on Auto Complete
    public void clickAutoComplete() {
        WebElement element = getWidgetsTab("Auto Complete");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);

        element.click();


    }

    // Click on Date Picker
    public void clickDatePicker() {
        WebElement element = getWidgetsTab("Date Picker");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);

        element.click();


    }

    // Click on Slider
    public void clickSlider() {
        WebElement element = getWidgetsTab("Slider");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);

        element.click();


    }

    // Click on Progress Bar
    public void clickProgressBar() {
        WebElement element = getWidgetsTab("Progress Bar");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);

        element.click();


    }

    // Click on Tabs
    public void clickTabs() {
        WebElement element = getWidgetsTab("Tabs");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);

        element.click();


    }

    // Click on Tool Tips
    public void clickToolTips() {
        WebElement element = getWidgetsTab("Tool Tips");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);

        element.click();


    }

    // Click on Menu
    public void clickMenu() {
        WebElement element = getWidgetsTab("Menu");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);

        element.click();


    }

    // Click on Select Menu
    public void clickSelectMenu() {
        WebElement element = getWidgetsTab("Select Menu");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);

        element.click();


    }

    public WebElement getProgressBar() {
      //  return progressBar = driver.findElement(By.id("progressBarContainer")).findElement(By.id("progressBar"));
        return progressBar = driver.findElement(By.cssSelector(".progress-bar.bg-info"));


    }



}