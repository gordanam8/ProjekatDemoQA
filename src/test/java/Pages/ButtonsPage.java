package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ButtonsPage {

    WebDriver driver;
    WebDriverWait wdwait;

    WebElement doubleClickButton;
    WebElement rightClickButtton;

    WebElement clickMeButton;

    WebElement messageDoubleClick;
    WebElement messageRightClick;
    WebElement messageDynamicClick;

    public ButtonsPage(WebDriver driver, WebDriverWait wdwait) {
        this.driver = driver;
        this.wdwait = wdwait;
    }


    public WebElement getDoubleClickButton() {
        return doubleClickButton = driver.findElement(By.id("doubleClickBtn"));
    }

    public WebElement getRightClickButtton() {
        return rightClickButtton = driver.findElement(By.id("rightClickBtn"));
    }

    public WebElement getClickMeButton() {
        List<WebElement> buttonsList = driver.findElements(By.cssSelector(".btn.btn-primary"));
        for (int i=0; i < buttonsList.size(); i++){
            if(buttonsList.get(i).getText().equals("Click Me")){
                return buttonsList.get(i);
            }
        }
        return null;
    }

    public WebElement getMessageDoubleClick() {
        return messageDoubleClick = driver.findElement(By.id("doubleClickMessage"));
    }

    public WebElement getMessageRightClick() {
        return messageRightClick = driver.findElement(By.id("rightClickMessage"));
    }

    public WebElement getMessageDynamicClick() {
        return messageDynamicClick = driver.findElement(By.id("dynamicClickMessage"));
    }

    //methods
    public void clickOnDoubleClickButton() {
        Actions actions = new Actions(driver);
        actions.doubleClick(this.getDoubleClickButton()).perform();
    }

    public void clickOnRightClickButton() {
        Actions actions = new Actions(driver);
        actions.moveToElement(this.getRightClickButtton());
        actions.contextClick(this.getRightClickButtton()).perform();
    }

    public void clickOnClickMeButton() {
        this.getClickMeButton().click();
    }

}
