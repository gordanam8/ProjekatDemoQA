package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SelectMenuPage {

    WebDriver driver;
    WebDriverWait wdwait;
    WebElement oldStyleSelectMenu;

    WebElement standardMultiSelect;
    public SelectMenuPage(WebDriver driver, WebDriverWait wdwait) {
        this.driver = driver;
        this.wdwait = wdwait;
    }

    public WebElement getOldStyleSelectMenu() {
        return oldStyleSelectMenu = driver.findElement(By.id("oldSelectMenu"));
    }

    public WebElement getStandardMultiSelect() {
        return standardMultiSelect = driver.findElement(By.id("cars"));
    }

}
