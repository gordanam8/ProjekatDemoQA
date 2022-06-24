package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FramesPage {

    WebDriver driver;
    WebDriverWait wdwait;

    WebElement frame1;
    WebElement frame1Heading;

    WebElement frame2;

    WebElement frame2Heading;

    public FramesPage(WebDriver driver, WebDriverWait wdwait) {
        this.driver = driver;
        this.wdwait = wdwait;
    }

    public WebElement getFrame1() {
        return frame1 = driver.findElement(By.id("frame1"));
    }

    public WebElement getFrame1Heading() {
        return frame1Heading = driver.findElement(By.id("sampleHeading"));
    }

    public WebElement getFrame2() {
        return frame2 = driver.findElement(By.xpath("/html/body/h1"));
        //return frame2 = driver.findElement(By.id("frame2"));
    }

    public WebElement getFrame2Heading() {
        return frame2Heading = driver.findElement(By.id("sampleHeading"));
    }
}
