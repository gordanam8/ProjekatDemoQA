package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class CheckBoxPage {

    WebDriver driver;
    WebDriverWait wdwait;

    WebElement checkBoxes;

    WebElement plus;

    WebElement minus;

    WebElement homeArrow;

    WebElement home;

    WebElement desktop;

    WebElement documents;

    WebElement downloads;

    WebElement notes;
    WebElement commands;

    WebElement workSpace;
    WebElement office;

    WebElement react;
    WebElement angular;
    WebElement veu;

    WebElement publicElement;
    WebElement privateElement;
    WebElement classified;
    WebElement general;

    WebElement wordFile;
    WebElement excelFile;

    WebElement resultMsg;

    public CheckBoxPage(WebDriver driver, WebDriverWait wdwait) {
        this.driver = driver;
        this.wdwait = wdwait;
    }

    public WebElement getCheckBoxes() {
        List<WebElement> checkBoxes = driver.findElements(By.cssSelector(".rct-icon.rct-icon-expand-close"));
        for (int i = 0; i < checkBoxes.size(); i++) {
            if (checkBoxes.get(i).getText().equals("Home")) {
                return checkBoxes.get(i);
            }
        }
        return null;
    }

    //methods
    public WebElement getHomeArrow () {
        return homeArrow = driver.findElement(By.cssSelector(".rct-icon.rct-icon-expand-close"));
    }

    public void clickHomeArrow() {
        getHomeArrow ().click();
    }

    public WebElement getPlus() {
        return plus = driver.findElement(By.cssSelector(".rct-icon.rct-icon-expand-all"));
    }

    public void clickPlus() {
        getPlus ().click();
    }

    public WebElement getMinus() {
        return minus = driver.findElement(By.cssSelector(".rct-icon.rct-icon-collapse-all"));
    }

    public void clickMinus() {
        getMinus().click();
    }

    public WebElement getHomeSubElement(String elementName) {
        ArrayList<WebElement> homeElements = new ArrayList<>();
        homeElements = (ArrayList<WebElement>) driver.findElements(By.className("rct-title"));

        for (int i = 0; i < homeElements.size(); i++) {
            if(elementName.equals(homeElements.get(i).getText())) {
                return homeElements.get(i);
            }
        }

        return null;
    }

    public WebElement getHome() {
        //return home = driver.findElement(By.cssSelector(".rct-icon.rct-icon-parent-open"));
        return home = getHomeSubElement("Home");
    }

    public void clickHome() {
        getHome().click();
    }

    public WebElement getDesktop () {
        return desktop = getHomeSubElement("Desktop");
    }

    public void clickDesktop() {
        getDesktop().click();
    }

    public WebElement getDocuments() {
        return documents = getHomeSubElement("Documents");
    }

    public void clickDocuments() {
        getDocuments().click();
    }

    public WebElement getDownloads() {
        return downloads = getHomeSubElement("Downloads");
    }

    public void clickDownloads() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", getDownloads());
        getDownloads().click();
    }

    public WebElement getNotes() {
        return notes = getHomeSubElement("Notes");
    }

    public void clickNotes() {
        getNotes().click();
    }

    public WebElement getCommands() {
        return commands = getHomeSubElement("Commands");
    }

    public void clickCommands() {
        getCommands().click();
    }

    public WebElement getWorkSpace() {
        return workSpace = getHomeSubElement("WorkSpace");
    }

    public void clickWorkSpace() {
        getWorkSpace().click();
    }


    public WebElement getOffice() {
        return office = getHomeSubElement("Office");
    }

    public void clickOffice() {
        getOffice().click();
    }

    public WebElement getReact() {
        return react = getHomeSubElement("React");
    }

    public void clickReact() {
        getReact().click();
    }

    public WebElement getAngular() {
        return angular = getHomeSubElement("Angular");
    }

    public void clickAngular() {
        getAngular().click();
    }

    public WebElement getVeu() {
        return veu = getHomeSubElement("Veu");
    }

    public void clickVeu() {
        getVeu().click();
    }

    public WebElement getPublicElement() {
        return publicElement = getHomeSubElement("Public");
    }

    public void clickPublic() {
        getPublicElement().click();
    }

    public WebElement getPrivateElement() {
        return privateElement = getHomeSubElement("Private");
    }

    public void clickPrivate() {
        getPrivateElement().click();
    }

    public WebElement getClassified() {
        return classified = getHomeSubElement("Classified");
    }

    public void clickClassified() {
        getClassified().click();
    }

    public WebElement getGeneral() {
        return general = getHomeSubElement("General");
    }

    public void clickGeneral() {
        getGeneral().click();
    }

    public WebElement getWordFile() {
        return wordFile = getHomeSubElement("Word File.doc");
    }

    public void clickWordFile() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", getWordFile());
        getWordFile().click();
    }

    public WebElement getExcelFile() {
        return excelFile = getHomeSubElement("Excel File.doc");
    }

    public void clickExcelFile() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", getExcelFile());
        getExcelFile().click();
    }

    public WebElement getResultMsg() {
        return resultMsg = driver.findElement(By.id("result"));
    }



}
