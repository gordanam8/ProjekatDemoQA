package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UploadAndDownloadPage {

    WebDriver driver;
    WebDriverWait wdwait;
    WebElement downloadButton;

    WebElement chooseFile;

    WebElement uploadedFilePath;

    public UploadAndDownloadPage(WebDriver driver, WebDriverWait wdwait) {
        this.driver = driver;
        this.wdwait = wdwait;
    }

    public WebElement getDownloadButton() {
        return downloadButton = driver.findElement(By.id("downloadButton"));
    }

    //methods

    public void clickOnDownloadButton() {
        this.getDownloadButton().click();
    }

    public WebElement getChooseFile() {
        return chooseFile = driver.findElement(By.id("uploadFile"));
    }

    public WebElement getUploadedFilePath() {
        return uploadedFilePath = driver.findElement(By.id("uploadedFilePath"));
    }


}
