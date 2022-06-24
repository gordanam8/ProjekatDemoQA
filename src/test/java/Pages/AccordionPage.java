package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccordionPage {

    WebDriver driver;
    WebDriverWait wdwait;

    WebElement section1;

    WebElement section2;
    WebElement section3;

    WebElement section1Content;
    WebElement section2Content;
    WebElement section3Content;
    public AccordionPage(WebDriver driver, WebDriverWait wdwait) {
        this.driver = driver;
        this.wdwait = wdwait;
    }

    public WebElement getSection1() {
        return section1 = driver.findElement(By.id("section1Heading"));
    }

    public WebElement getSection2() {
        return section2 = driver.findElement(By.id("section2Heading"));
    }

    public WebElement getSection3() {
        return section3 = driver.findElement(By.id("section3Heading"));
    }

    public WebElement getSection1Content() {
        return section1Content = driver.findElement(By.id("section1Content"));
    }

    public WebElement getSection2Content() {
        return section2Content = driver.findElement(By.id("section2Content"));
    }

    public WebElement getSection3Content() {
        return section3Content = driver.findElement(By.id("section3Content"));
    }

    //methods

    public void clickOnSection1() {
        this.getSection1().click();
    }

    public void clickOnSection2() {
        this.getSection2().click();
    }

    public void clickOnSection3() {
        this.getSection3().click();
    }


}
