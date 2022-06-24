package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.HttpURLConnection;
import java.net.URL;

public class BrokenLinksPage {

    WebDriver driver;
    WebDriverWait wdwait;

    WebElement validLink;
    WebElement brokenLink;

    public BrokenLinksPage(WebDriver driver, WebDriverWait wdwait) {
        this.driver = driver;
        this.wdwait = wdwait;
    }

    public WebElement getValidLink() {
        return validLink = driver.findElement(By.linkText("Click Here for Valid Link"));
    }

    public WebElement getBrokenLink() {
        return brokenLink = driver.findElement(By.linkText("Click Here for Broken Link"));
    }

    //methods

    public void clickOnValidLink() {
        this.getValidLink().click();
    }

    public void clickOnBrokenLinkk() {
        this.getBrokenLink().click();
    }

    public static void verifyLinks(String linkUrl) {
        try {
            URL url = new URL(linkUrl);

            //creating url connection and getting the response code
            HttpURLConnection httpURLConnect = (HttpURLConnection) url.openConnection();
            httpURLConnect.setConnectTimeout(5000);
            httpURLConnect.connect();
            if (httpURLConnect.getResponseCode() >= 400) {
                System.out.println("HTTP STATUS - " + httpURLConnect.getResponseMessage() + "is a broken link");
            }

            //reaching and printing the response code
            else {
                System.out.println("HTTP STATUS - " + httpURLConnect.getResponseMessage());
            }
        } catch (Exception e) {

        }
    }
}
