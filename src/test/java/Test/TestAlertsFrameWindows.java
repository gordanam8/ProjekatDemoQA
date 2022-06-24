package Test;

import Base.BaseTest;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.Set;

public class TestAlertsFrameWindows extends BaseTest {

    @BeforeMethod
    public void pageSetUp() {
        driver.manage().window().maximize();
        //driver.navigate().to("https://demoqa.com");
        driver.get(homePageURL);
    }

    @Test
    public void openingNewTabAndFetchNewTabHeading()  {

        // Go to page
        homePage.clickAlerts();

        // Click on Browser Windows
        alerts.clickBrowserWindows();

        //this will open new tab
        browserWindowsPage.clickOnTabButton();

        //get handles of the windows
        String originalHandle = driver.getWindowHandle();
        Set<String> allWindowHandles = driver.getWindowHandles();
        Iterator<String> iterator = allWindowHandles.iterator();

        //switch to new tab and get the text from new tab heading
        while (iterator.hasNext()) {
            String newTab = iterator.next();
            if (!originalHandle.equalsIgnoreCase(newTab)) {
                driver.switchTo().window(newTab);
                WebElement textOnNewTab = driver.findElement(By.id("sampleHeading"));
                System.out.println("Heading of new tab is " + textOnNewTab.getText());

                //assert url for new tab
                String expectedUrl = "https://demoqa.com/sample";
                wdwait.until(ExpectedConditions.urlToBe(expectedUrl));
                Assert.assertEquals(driver.getCurrentUrl(), expectedUrl);

            }
        }
        //closing all tabs except original Handle
        for (String handle : driver.getWindowHandles()) {
            if (!handle.equals(originalHandle)) {
                driver.switchTo().window(handle);
                driver.close();
            }
        }
        //switch to original Handle
        driver.switchTo().window(originalHandle);

    }

    @Test
    public void testingNewWindowAndNewWindowMessage() throws InterruptedException {

        // Go to page
        homePage.clickAlerts();

        // Click on Browser Windows
        alerts.clickBrowserWindows();

        //opening child window
        browserWindowsPage.clickOnWindowButton();
        //opening child message window
        browserWindowsPage.clickOnMessageWindowButton();

        String originalHandle = driver.getWindowHandle();
        System.out.println("Main window handle is " + originalHandle);

        //handle all new opened windows
        Set<String> allWindowHandles = driver.getWindowHandles();
        System.out.println("Child window handle is" + allWindowHandles);
        Iterator<String> iterator = allWindowHandles.iterator();

        //closing child window and child message window
        Thread.sleep(2000);
        while (iterator.hasNext()) {
            String childWindow = iterator.next();
            if (!originalHandle.equalsIgnoreCase(childWindow)) {
                driver.switchTo().window(childWindow);
                driver.close();
                System.out.println("Child window closed");
            }
        }
        //switch to original Handle
        driver.switchTo().window(originalHandle);
    }

    @Test
    public void acceptSimpleAlerts() throws InterruptedException {
        // Go to page
        homePage.clickAlerts();

        // Select Alerts
        alerts.clickAlerts();

        clickabilityWait(alertsPage.getAlertButton());
        alertsPage.clickOnAlertButton();
        //switch to alert and accept it
        Alert simpleAlert = driver.switchTo().alert();
        simpleAlert.accept();
    }

    @Test
    public void acceptTimerAlerts() throws InterruptedException {

        // Go to page
        homePage.clickAlerts();

        // Select Alerts
        alerts.clickAlerts();

        //check for the alert
        try {
            alertsPage.clickOnTimerAlertButton();
            wdwait.until(ExpectedConditions.alertIsPresent());
            //alert is present, accept it
            Alert timerAlert = driver.switchTo().alert();
            timerAlert.accept();
            System.out.println("Unexpected alert accepted");
        } catch (Exception e) {
            //else, alert is not present
            System.out.println("Unexpected alert not present");
        }
    }

    @Test
    public void confirmAlertMessageBox() throws InterruptedException {

        // Go to page
        homePage.clickAlerts();

        // Select Alerts
        alerts.clickAlerts();

        //alert appears on screen
        alertsPage.clickOnConfirmButton();
        Thread.sleep(2000);
        //switch to alert
        Alert confirmationAlert = driver.switchTo().alert();
        String alertText = confirmationAlert.getText();
        System.out.println("Alert text is " + alertText);
        confirmationAlert.accept();
    }

    @Test
    public void dismissAlertMessageBox() throws InterruptedException {

        // Go to page
        homePage.clickAlerts();

        // Select Alerts
        alerts.clickAlerts();

        //alert appears on screen
        alertsPage.clickOnConfirmButton();
        Thread.sleep(2000);
        //switch to alert
        Alert confirmationAlert = driver.switchTo().alert();
        String alertText = confirmationAlert.getText();
        System.out.println("Alert text is " + alertText);
        confirmationAlert.dismiss();
    }

    @Test
    public void promptAlertBoxSendTextAndAccept() throws InterruptedException {

        // Go to page
        homePage.clickAlerts();

        // Select Alerts
        alerts.clickAlerts();

        //alert appears on screen
        alertsPage.clickOnPromptButton();
        Thread.sleep(2000);
        //switch to alert
        Alert promptAlert = driver.switchTo().alert();
        String alertText = promptAlert.getText();
        System.out.println("Alert text is " + alertText);
        //send text to the alert
        promptAlert.sendKeys(excelReader.getStringData("Elements", 1, 0));
        promptAlert.accept();
    }

    @Test
    public void switchingBetweenFrames() throws InterruptedException {

        // Go to page
        homePage.clickAlerts();

        // Select Frames
        alerts.clickFrames();

        //switching to frame1
        driver.switchTo().frame(framesPage.getFrame1());

        //text of the frame1 heading
        String frame1Text = framesPage.getFrame1Heading().getText();
        System.out.println("Text of the frame1 heading is:" + frame1Text);

        scrollIntoView(framesPage.getFrame2());

        //text of the frame2 heading
        String frame2Text = framesPage.getFrame2Heading().getText();
        System.out.println("Text of the frame1 heading is:" + frame2Text);

    }

    @Test
    public void numberOfFrames() {

        // Go to page
        homePage.clickAlerts();

        // Select Frames
        alerts.clickFrames();

        //find the number of iframes on the page
        int numberOfIFramesOnPage = driver.findElements(By.xpath("//iframe[contains(@id,'frame')] ")).size();

        //Print the total iframes on page
        System.out.println("Total iframes on Page:" + numberOfIFramesOnPage);

        //switch to first frame
        driver.switchTo().frame(0);
    }

    @Test
    public void testingNestedFramesAndSwitchToChildFrame() {

        // Go to page
        homePage.clickAlerts();

        // Select Nested Frames
        alerts.clickNestedFrames();

        driver.switchTo().frame(nestedFramesPage.getFrame1());
        //text in frame1 element
        String frame1Text = nestedFramesPage.getFrame1InsideElement().getText();
        System.out.println("Frame1 is :" + frame1Text);

        //number of frames in frame1
        int numberOfIframesInFrame1 = driver.findElements(By.tagName("iframe")).size();
        System.out.println("Number of iFrames inside the Frame1:" + numberOfIframesInFrame1);

        //switch to child frame
        driver.switchTo().frame(0);

        //number of Iframes in frame 2
        int numberOfIframesInFrame2 = driver.findElements(By.tagName("iframe")).size();
        System.out.println("Number of iFrames inside the Frame2:" + numberOfIframesInFrame2);

    }

    @Test
    public void switchingBetweenNestedFramesParentAndChild() {

        // Go to page
        homePage.clickAlerts();

        // Select Nested Frames
        alerts.clickNestedFrames();

        //number of frames on a page
        int numberOfIframesInPage = driver.findElements(By.tagName("iframe")).size();
        System.out.println("Number of Frames on a Page:" + numberOfIframesInPage);

        //switch to frame1
        driver.switchTo().frame(nestedFramesPage.getFrame1());

        //number of frames in frame1
        int numberOfIframesInFrame1 = driver.findElements(By.tagName("iframe")).size();
        System.out.println("Number of Frames inside the Frame1:" + numberOfIframesInFrame1);

        //switch to child frame
        driver.switchTo().frame(0);
        int numberOfIframesInFrame2 = driver.findElements(By.tagName("iframe")).size();
        System.out.println("Number of Frames inside the Frame2:" + numberOfIframesInFrame2);

        //switch to parent iframe
        driver.switchTo().parentFrame();

        //get the text for frame1InsideElement
        String frame1Text = nestedFramesPage.getFrame1InsideElement().getText();

        //print the text inside parent frame
        System.out.println("Frame1 is :" + frame1Text);
    }

    @Test
    public void testingSmallModalDialogBox() {

        // Go to page
        homePage.clickAlerts();

        // Select Model Dialogs
        alerts.clickModalDialogs();

        modalDialogsPage.clickOnSmallModalButton();

        //wait for the modal box to be visible
        visibilityWait(modalDialogsPage.getModalContainer());

        //fetch content of modal body and asserting it
        System.out.println(modalDialogsPage.getModalContentBody().getText());
        Assert.assertEquals(modalDialogsPage.getModalContentBody().getText(), "This is a small modal. It has very less content");

        //close small modal dialog
        modalDialogsPage.clickOnCloseSmallModal();
    }

    @Test
    public void testingLargeModalDialogBox() {

        // Go to page
        homePage.clickAlerts();

        // Select Accordion
        widgets.clickAccordian();

        // Select Model Dialogs
        alerts.clickModalDialogs();

        modalDialogsPage.clickOnLargeModalButton();

        //wait for the modal box to be visible
        visibilityWait(modalDialogsPage.getModalContainer());

        //fetch content of modal body and asserting it
        System.out.println(modalDialogsPage.getModalContentBody().getText());
        Assert.assertEquals(modalDialogsPage.getModalContentBody().getText(),"Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.");

        //close large modal dialog
        modalDialogsPage.clickOnCloseLargeModal();
    }


}