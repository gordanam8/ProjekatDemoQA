package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

public class Elements {

    WebDriver driver;
    WebDriverWait wdwait;

    public Elements(WebDriver driver, WebDriverWait wdwait) {

        this.driver = driver;
        this.wdwait = wdwait;
    }

    public String getUrl() {
        return driver.getCurrentUrl();
    }


    // Side Bar
    public WebElement getBar(String barText) {
        ArrayList<WebElement> bars = new ArrayList<WebElement>();
        bars = (ArrayList<WebElement>) driver.findElements(By.className("element-group"));

        for (int i = 0; i < bars.size(); i++) {
            if (barText.equals(bars.get(i).findElement(By.className("header-text")).getText())) return bars.get(i);
        }

        return bars.get(0);
    }

    public void clickSideBarElements() {
        WebElement element;

        element = getBar("Elements");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);

        element.click();
    }

    public void clickSideBarForms() {
        WebElement element;

        element = getBar("Forms");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);

        element.click();
    }

    public void clickSideBarAlerts() {
        WebElement element;

        element = getBar("Alerts, Frame & Windows");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);

        element.click();
    }

    public void clickSideBarWidgets() {
        WebElement element;

        element = getBar("Widgets");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);

        element.click();
    }

    public void clickSideBarInteractions() {
        WebElement element;

        element = getBar("Interactions");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);

        element.click();
    }

    public void clickSideBarBookStoreApplication() {
        WebElement element;

        element = getBar("Book Store Application");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);

        element.click();
    }

    public void zoomOut() {
      /*  WebElement html = driver.findElement(By.tagName("html"));
        html.sendKeys(Keys.chord(Keys.CONTROL, Keys.ADD));*/

        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("document.body.style.zoom = '0.5'");

        driver = (WebDriver) driver;
    }

    public void zoomIn() {
       /* WebElement html = driver.findElement(By.tagName("html"));
        html.sendKeys(Keys.chord(Keys.CONTROL, "0"));*/
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("document.body.style.zoom = '1'");

        driver = (WebDriver) driver;
    }

    public WebElement getElementsTab(String tabName) {

        ArrayList<WebElement> tabs = new ArrayList<WebElement>();
        ArrayList<WebElement> elementsBars = new ArrayList<WebElement>();
       // tabs = (ArrayList<WebElement>) driver.findElements(By.cssSelector(".element-list.collapse.show"));
        tabs = (ArrayList<WebElement>) driver.findElements(By.className("element-group"));
        for (int i = 0; i < tabs.size(); i ++) {
            if (tabs.get(i).findElement(By.className("header-text")).getText().equals("Elements")) {
                elementsBars = (ArrayList<WebElement>) tabs.get(i).findElements(By.tagName("li"));
                for (int j = 0; j < elementsBars.size(); j++) {
                    if (tabName.equals(elementsBars.get(j).getText())) return elementsBars.get(j);
                }
            }
        }

        return null;

    }

    // Elements
    public void clickTextBox() {
        WebElement element = getElementsTab("Text Box");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);

        element.click();

    }

    public void clickCheckBox() {
        WebElement element = getElementsTab("Check Box");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);

        element.click();

    }

    public void clickRadioButton() {
        WebElement element = getElementsTab("Radio Button");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);

        element.click();

    }

    public void clickWebTables() {
        WebElement element = getElementsTab("Web Tables");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);

        element.click();

    }

    public void clickButtons() {
        WebElement element = getElementsTab("Buttons");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);

        element.click();

    }

    public void clickLinks() {
        WebElement element = getElementsTab("Links");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);

        element.click();

    }

    public void clickBrokenLinks() {
        WebElement element = getElementsTab("Broken Links - Images");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);

        element.click();

    }

    public void clickUploadAndDownload() {
        WebElement element = getElementsTab("Upload and Download");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);

        element.click();

    }

    public void clickDynamicProperties() {
        WebElement element = getElementsTab("Dynamic Properties");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);

        element.click();

    }









}
