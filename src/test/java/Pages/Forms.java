package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

public class Forms {

    WebDriver driver;
    WebDriverWait wdwait;

    public Forms(WebDriver driver, WebDriverWait wdwait) {
        this.driver = driver;
        this.wdwait = wdwait;
    }

    public String getUrl() {
        return driver.getCurrentUrl();
    }

    // Forms

    public void clickPracticeForm() throws InterruptedException {

        ArrayList<WebElement> bars = new ArrayList<WebElement>();
        WebElement element = null;
        bars = (ArrayList<WebElement>) driver.findElements(By.className("element-group"));
        // System.out.println("SIZE " + bars.size());
        //System.out.println("TEXT " + bars.get(1).getText());
        Thread.sleep(1000);
       /* WebElement element1 = bars.get(1);
        WebElement element  =         element1.findElement(By.cssSelector(".element-list.collapse.show"));*/


        for (int i = 0; i < bars.size(); i ++) {
            if (bars.get(i).findElement(By.className("header-text")).getText().equals("Forms")) {
                 element = bars.get(i).findElement(By.cssSelector(".element-list.collapse.show"));
            }
        }

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);

        element.click();

    }

}