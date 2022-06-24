package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

public class BookStoreApplication {

    WebDriver driver;
    WebDriverWait wdwait;

    public BookStoreApplication(WebDriver driver, WebDriverWait wdwait) {
        this.driver = driver;
        this.wdwait = wdwait;
    }

    public String getUrl() {
        return driver.getCurrentUrl();
    }


    // Alerts
    public WebElement getBookStoreApplicationTab(String tabName) {
        ArrayList<WebElement> bars = new ArrayList<WebElement>();
        ArrayList<WebElement> alarmBars = new ArrayList<WebElement>();
        bars = (ArrayList<WebElement>) driver.findElements(By.className("element-group"));

        for (int i = 0; i < bars.size(); i ++) {

            if (bars.get(i).findElement(By.className("header-text")).getText().equals("Book Store Application")) {

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

    // Click on Login
    public void clickLogin() {



        //js.executeScript("document.body.style.zoom = '0.5'");
        WebElement element = getBookStoreApplicationTab("Login");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);

        //element.click();
        js.executeScript("arguments[0].click();", element);
        //js.executeScript("document.body.style.zoom = '0.1'");

    }

    // Click on Book Store
    public void clickBookStore() {
        WebElement element = getBookStoreApplicationTab("Book Store");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);

       // element.click();
        js.executeScript("arguments[0].click();", element);

    }

    // Click on Profile
    public void clickProfile() {
        WebElement element = getBookStoreApplicationTab("Profile");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);

        //element.click();
        js.executeScript("arguments[0].click();", element);

    }

    // Click on Book Store API
    public void clickBookStoreApi() {
        WebElement element = getBookStoreApplicationTab("Book Store API");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);

        //element.click();
        js.executeScript("arguments[0].click();", element);

    }

}