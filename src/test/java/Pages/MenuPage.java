package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MenuPage {

    WebDriver driver;
    WebDriverWait wdwait;

    WebElement mainItem1;
    WebElement mainItem2;
    WebElement mainItem3;
    WebElement subItem1;
    WebElement subItem2;
    WebElement subSubList;

    WebElement subSubListItem1;
    WebElement subSubListItem2;

    public MenuPage(WebDriver driver, WebDriverWait wdwait) {
        this.driver = driver;
        this.wdwait = wdwait;
    }

    public WebElement getMainItem1() {
        return mainItem1 = driver.findElement(By.linkText("Main Item 1"));
    }

    public WebElement getMainItem2() {
        return mainItem2 =driver.findElement(By.linkText("Main Item 2"));
    }

    public WebElement getMainItem3() {
        return mainItem3 = driver.findElement(By.linkText("Main Item 3"));
    }

    public WebElement getSubItem1() {
        return subItem1 = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/ul/li[2]/ul/li[1]/a"));
    }

    public WebElement getSubItem2() {
        return subItem2 = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/ul/li[2]/ul/li[2]/a"));
    }

    public WebElement getSubSubList() {
        return subSubList = driver.findElement(By.linkText("SUB SUB LIST »"));
    }

    public WebElement getSubSubListItem1() {
        return subSubListItem1 = driver.findElement(By.linkText("Sub Sub Item 1"));
    }

    public WebElement getSubSubListItem2() {
        return subSubListItem2 = driver.findElement(By.linkText("Sub Sub Item 2"));
    }
}
