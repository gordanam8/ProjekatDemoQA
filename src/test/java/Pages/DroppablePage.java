package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DroppablePage {

    WebDriver driver;
    WebDriverWait wdwait;

    WebElement source;
    WebElement target;

    public DroppablePage(WebDriver driver, WebDriverWait wdwait) {
        this.driver = driver;
        this.wdwait = wdwait;
    }

    public WebElement getSource() {

        return source = driver.findElement(By.id("draggable"));
    }

    public WebElement getTarget() {

        return target = driver.findElement(By.id("droppable"));
    }

    // methods

    public void dragAndDrop() {
        Actions actions = new Actions(driver);
        actions.dragAndDrop(this.getSource(), this.getTarget()).perform();
    }

}
