package Test;

import Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class TestElements extends BaseTest {

    @BeforeMethod
    public void pageSetUp() {
        driver.manage().window().maximize();
        //driver.navigate().to("https://demoqa.com");
        driver.get(homePageURL);
    }

    @Test(priority = 10)
    public void successfulSubmitDataIntoTextBox() {

        // Go to page
        homePage.clickElements();

        //Select Text Box
        elements.clickTextBox();

        String fullName = excelReader.getStringData("Elements", 1, 0);
        String email = excelReader.getStringData("Elements", 1, 1);
        String currentAddress = excelReader.getStringData("Elements", 1, 2);
        String permanentAddress = excelReader.getStringData("Elements", 1, 3);
        textBoxPage.insertFullName(fullName);
        textBoxPage.insertEmail(email);
        textBoxPage.insertCurrentAddress(currentAddress);
        textBoxPage.insertPermanentAddress(permanentAddress);
        scrollIntoView(textBoxPage.getSubmitButton());
        textBoxPage.clickOnSubmitButton();

        //check if we are on expected page
        String expUrl = "https://demoqa.com/text-box";
        Assert.assertTrue(expUrl.equals(textBoxPage.getUrlTextBoxPage()));

        //check that FullName is as expected
        String expFullName = "Name:Lucy Montgomery";
        Assert.assertTrue(expFullName.equals(textBoxPage.getNameText().getText()));
        System.out.println(textBoxPage.getNameText().getText());

        //check that Email is as expected
        String expEmail = "Email:lucymontgomery@hotmail.com";
        Assert.assertTrue(expEmail.equals(textBoxPage.getEmailText().getText()));
        System.out.println(textBoxPage.getEmailText().getText());

        //check that Current Address is as expected
        String expCurrentAddress = "Current Address :Green Gables 8";
        Assert.assertTrue(expCurrentAddress.equals(textBoxPage.getCurrentAddressText().getText()));
        System.out.println(textBoxPage.getCurrentAddressText().getText());

        //check that Permanent Address is as expected
        String expPermanentAddress = "Permananet Address :Montreal Avenue 8";
        Assert.assertTrue(expPermanentAddress.equals(textBoxPage.getPermanentAddressText().getText()));
        System.out.println(textBoxPage.getPermanentAddressText().getText());
    }


    @Test(priority = 20)
    public void validationOfTheRadioButtons() throws InterruptedException {

        // Go to page
        homePage.clickElements();

        // Select Radio Button
        elements.clickRadioButton();

        //Validate Yes Button isSelected and then click to select
        boolean selectYes = radioButtonPage.getYesButton().isSelected();
        System.out.println(selectYes);
        // performing click operation if element is not already selected
        if (selectYes == false) {
            radioButtonPage.clickOnYesButton();
        }
        String expMessage = "Yes";
        System.out.println(radioButtonPage.getYesMessage().getText());
        Assert.assertTrue(expMessage.equals(radioButtonPage.getYesMessage().getText()));

        //Validate Impressive Button isDisplayed and click to select
        boolean selectImpressive = radioButtonPage.getImpressiveButton().isDisplayed();

        // performing click operation if element is displayed
        if (selectImpressive == true) {
            radioButtonPage.clickOnImpressiveButton();
        }
        expMessage = "Impressive";
        System.out.println(radioButtonPage.getYesMessage().getText());
        Assert.assertTrue(expMessage.equals(radioButtonPage.getYesMessage().getText()));

        //Validate if No Button isEnabled and click to select
        boolean selectNo = radioButtonPage.getNoButton().isDisplayed();

        // performing click operation if element is enabled
        if (selectNo == true) {
            radioButtonPage.clickOnNoButton();
        }

    }

    @Test(priority = 30)
    public void addNewRecordWebTables() {

        // Go to page
        homePage.clickElements();

        // Select Web Tables
        elements.clickWebTables();

        webTablesPage.clickOnAddNewRecordButton();
        String firstName = excelReader.getStringData("Elements", 1, 4);
        String lastName = excelReader.getStringData("Elements", 1, 5);
        String email = excelReader.getStringData("Elements", 1, 1);
        String age = String.valueOf(excelReader.getIntegerData("Elements", 1, 6));
        String salary = String.valueOf(excelReader.getIntegerData("Elements", 1, 7));
        String department = excelReader.getStringData("Elements", 1, 8);
        webTablesPage.insertFirstName(firstName);
        webTablesPage.insertLastName(lastName);
        webTablesPage.insertEmail(email);
        webTablesPage.insertAge(age);
        webTablesPage.insertSalary(salary);
        webTablesPage.insertDepartment(department);
        webTablesPage.clickOnSubmitButton();

        String expFirstName = "Lucy";
        Assert.assertTrue(expFirstName.equals(webTablesPage.getFirstNameText().getText()));
        String expLastName = "Montgomery";
        Assert.assertTrue(expLastName.equals(webTablesPage.getLastNameText().getText()));
        String expEmail = "lucymontgomery@hotmail.com";
        Assert.assertTrue(expEmail.equals(webTablesPage.getEmailText().getText()));
        String expAge = "40";
        Assert.assertTrue(expAge.equals(webTablesPage.getAgeText().getText()));
        String expSalary = "3000";
        Assert.assertTrue(expAge.equals(webTablesPage.getSalaryText().getText()));
        String expDepartment = "Legal";
        Assert.assertTrue(expDepartment.equals(webTablesPage.getDepartmentText().getText()));


    }

    @Test(priority = 40)
    public void editRecordWebTables() {
        // Go to page
        homePage.clickElements();

        // Select Web Tables
        elements.clickWebTables();

        webTablesPage.clickOnAddNewRecordButton();
        String firstName = excelReader.getStringData("Elements", 1, 4);
        String lastName = excelReader.getStringData("Elements", 1, 5);
        String email = excelReader.getStringData("Elements", 1, 1);
        String age = String.valueOf(excelReader.getIntegerData("Elements", 1, 6));
        String salary = String.valueOf(excelReader.getIntegerData("Elements", 1, 7));
        String department = excelReader.getStringData("Elements", 1, 8);
        webTablesPage.insertFirstName(firstName);
        webTablesPage.insertLastName(lastName);
        webTablesPage.insertEmail(email);
        webTablesPage.insertAge(age);
        webTablesPage.insertSalary(salary);
        webTablesPage.insertDepartment(department);
        webTablesPage.clickOnSubmitButton();

        String expFirstName = "Lucy";
        Assert.assertTrue(expFirstName.equals(webTablesPage.getFirstNameText().getText()));
        String expLastName = "Montgomery";
        Assert.assertTrue(expLastName.equals(webTablesPage.getLastNameText().getText()));

        webTablesPage.clickOnEditIcon4();
        String newFirstName = excelReader.getStringData("Elements", 1, 9);
        String newLastName = excelReader.getStringData("Elements", 1, 10);
        webTablesPage.insertFirstName(newFirstName);
        webTablesPage.insertLastName(newLastName);
        webTablesPage.clickOnSubmitButton();

        String expNewFirstName = "Jane";
        Assert.assertTrue(expNewFirstName.equals(webTablesPage.getFirstNameText().getText()));
        String expNewLastName = "Austen";
        Assert.assertTrue(expNewLastName.equals(webTablesPage.getLastNameText().getText()));

    }

    @Test(priority = 50)
    public void deleteRecordWebTables() {
        // Go to page
        homePage.clickElements();

        // Select Web Tables
        elements.clickWebTables();

        webTablesPage.clickOnAddNewRecordButton();
        String firstName = excelReader.getStringData("Elements", 1, 4);
        String lastName = excelReader.getStringData("Elements", 1, 5);
        String email = excelReader.getStringData("Elements", 1, 1);
        String age = String.valueOf(excelReader.getIntegerData("Elements", 1, 6));
        String salary = String.valueOf(excelReader.getIntegerData("Elements", 1, 7));
        String department = excelReader.getStringData("Elements", 1, 8);
        webTablesPage.insertFirstName(firstName);
        webTablesPage.insertLastName(lastName);
        webTablesPage.insertEmail(email);
        webTablesPage.insertAge(age);
        webTablesPage.insertSalary(salary);
        webTablesPage.insertDepartment(department);
        webTablesPage.clickOnSubmitButton();

        String expFirstName = "Lucy";
        Assert.assertTrue(expFirstName.equals(webTablesPage.getFirstNameText().getText()));
        String expLastName = "Montgomery";
        Assert.assertTrue(expLastName.equals(webTablesPage.getLastNameText().getText()));
        String expEmail = "lucymontgomery@hotmail.com";
        Assert.assertTrue(expEmail.equals(webTablesPage.getEmailText().getText()));
        String expAge = "40";
        Assert.assertTrue(expAge.equals(webTablesPage.getAgeText().getText()));
        String expSalary = "3000";
        Assert.assertTrue(expAge.equals(webTablesPage.getSalaryText().getText()));
        String expDepartment = "Legal";
        Assert.assertTrue(expDepartment.equals(webTablesPage.getDepartmentText().getText()));

        webTablesPage.clickOnDeleteIcon4();

    }

    @Test(priority = 60)
    public void testButtons() throws InterruptedException {

        // Go to page
        homePage.clickElements();

        // Select Buttons
        elements.clickButtons();

        clickabilityWait(buttonsPage.getDoubleClickButton());
        buttonsPage.clickOnDoubleClickButton();
        String expMessage = "You have done a double click";
        Assert.assertTrue(expMessage.equals(buttonsPage.getMessageDoubleClick().getText()));
        Thread.sleep(2000);
        clickabilityWait(buttonsPage.getRightClickButtton());
        buttonsPage.clickOnRightClickButton();
        expMessage = "You have done a right click";
        Assert.assertTrue(expMessage.equals(buttonsPage.getMessageRightClick().getText()));
        Thread.sleep(2000);
        clickabilityWait(buttonsPage.getClickMeButton());
        buttonsPage.clickOnClickMeButton();
        expMessage = "You have done a dynamic click";
        Assert.assertTrue(expMessage.equals(buttonsPage.getMessageDynamicClick().getText()));
    }

    @Test(priority = 70)
    public void testingSimpleAndDynamicLinks() throws InterruptedException {

        // Go to page
        homePage.clickElements();

        // Select Links
        elements.clickLinks();

        //each click will open new tab
        linksPage.clickOnSimpleLink();
        Thread.sleep(3000);
        linksPage.clickOnDynamicLink();
        Thread.sleep(3000);

        String originalHandle = driver.getWindowHandle();
        //closing all tabs except original Handle
        for(String handle : driver.getWindowHandles()) {
            if (!handle.equals(originalHandle)) {
                driver.switchTo().window(handle);
                driver.close();
            }
        }
        //switch to original Handle
        driver.switchTo().window(originalHandle);

    }

    @Test(priority = 80)
    public void testingThatLinkWillSendAnApiCallAndVerifyTheHttpResponseCode() throws InterruptedException {
        // Go to page
        homePage.clickElements();

        // Select Links
        elements.clickLinks();

        //click on Created Link and assert that link responded with status code 201
        linksPage.clickOnCreatedLink();
        Thread.sleep(2000);
        scrollIntoView(linksPage.getExpMessage());
        Thread.sleep(2000);
        String expMsg = "Link has responded with staus 201 and status text Created";
        Assert.assertTrue(expMsg.equals(linksPage.getExpMessage().getText()));

        //click on NoContent Link and assert that link responded with status code 204
        linksPage.clickOnNoContentLink();
        Thread.sleep(2000);
        scrollIntoView(linksPage.getExpMessage());
        Thread.sleep(2000);
        expMsg = "Link has responded with staus 204 and status text No Content";
        Assert.assertTrue(expMsg.equals(linksPage.getExpMessage().getText()));

        //click on Moved Link and assert that link responded with status code 301
        linksPage.clickOnMovedLink();
        Thread.sleep(2000);
        scrollIntoView(linksPage.getExpMessage());
        Thread.sleep(2000);
        expMsg = "Link has responded with staus 301 and status text Moved Permanently";
        Assert.assertTrue(expMsg.equals(linksPage.getExpMessage().getText()));

        //click on BadRequest Link and assert that link responded with status code 400
        linksPage.clickOnBadRequestLink();
        Thread.sleep(2000);
        scrollIntoView(linksPage.getExpMessage());
        Thread.sleep(2000);
        expMsg = "Link has responded with staus 400 and status text Bad Request";
        Assert.assertTrue(expMsg.equals(linksPage.getExpMessage().getText()));

        //click on Unauthorized Link and assert that link responded with status code 401
        linksPage.clickOnUnauthorizedLink();
        Thread.sleep(2000);
        scrollIntoView(linksPage.getExpMessage());
        Thread.sleep(2000);
        expMsg = "Link has responded with staus 401 and status text Unauthorized";
        Assert.assertTrue(expMsg.equals(linksPage.getExpMessage().getText()));

        //click on Forbidden Link and assert that link responded with status code 403
        linksPage.clickOnForbiddenLink();
        Thread.sleep(2000);
        scrollIntoView(linksPage.getExpMessage());
        Thread.sleep(2000);
        expMsg = "Link has responded with staus 403 and status text Forbidden";
        Assert.assertTrue(expMsg.equals(linksPage.getExpMessage().getText()));

        //click on NotFound Link and assert that link responded with status code 404
        linksPage.clickOnNotFoundLink();
        Thread.sleep(2000);
        scrollIntoView(linksPage.getExpMessage());
        Thread.sleep(2000);
        expMsg = "Link has responded with staus 404 and status text Not Found";
        Assert.assertTrue(expMsg.equals(linksPage.getExpMessage().getText()));


    }

    @Test(priority = 90)
    public void testingDynamicProperties() {

        // Go to page
        homePage.clickElements();

        // Select Dynamic Properties
        elements.clickDynamicProperties();

        //assert that text color of ChangeColor button is rgba(255, 255, 255, 1)
        String color1 = dynamicPropertiesPage.getChangeColorButton().getCssValue("color");
        System.out.println(color1);

        //assert that VisibleAfter5Button is not displayed
        boolean check = true;
        try {
            check = dynamicPropertiesPage.getVisibleAfter5Button().isDisplayed();
        } catch (Exception e) {
            check = false;
        }
        Assert.assertFalse(check);

        //assert that EnableAfter5Button is not enabled
        check = true;
        try {
            check = dynamicPropertiesPage.getEnableAfter5Button().isEnabled();
        } catch (Exception e) {
            check = false;
        }
        Assert.assertFalse(check);

        //assert that EnableAfter5Button is enabled
        wdwait.until(ExpectedConditions.elementToBeClickable(dynamicPropertiesPage.getEnableAfter5Button()));
        dynamicPropertiesPage.clickOnEnableAfter5Button();
        Assert.assertTrue(dynamicPropertiesPage.getEnableAfter5Button().isEnabled());

        //assert that VisibleAfter5Button is displayed
        Assert.assertTrue(dynamicPropertiesPage.getVisibleAfter5Button().isDisplayed());

        //assert that text color of ChangeColor button is changed to rgba(220, 53, 69, 1)
        String color2 = dynamicPropertiesPage.getChangeColorButton().getCssValue("color");
        System.out.println(color2);

    }

    @Test(priority = 100)
    public void clickOnValidAndBrokenLink() throws InterruptedException {

        // Go to page
        homePage.clickElements();

        // Select BrokenLinks - Images
        elements.clickBrokenLinks();

        //javascript executor for opening more than one tab
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.open()");
        js.executeScript("window.open()");

        //create list of handles
        ArrayList<String> listaTabova = new ArrayList<String>(driver.getWindowHandles());

        //switch to first tab
        driver.switchTo().window(listaTabova.get(1));
        //Ovom komandom prelazimo na treci tab
        driver.navigate().to("https://demoqa.com/broken");
        brokenLinksPage.clickOnValidLink();
        String expUrl = excelReader.getStringData("URLs", 1, 0);
        Assert.assertTrue(expUrl.equals(driver.getCurrentUrl()));

        //switch to second tab
        driver.switchTo().window(listaTabova.get(2));
        driver.navigate().to("https://demoqa.com/broken");
        brokenLinksPage.clickOnBrokenLinkk();
        expUrl = "http://the-internet.herokuapp.com/status_codes/500";
        Assert.assertTrue(expUrl.equals(driver.getCurrentUrl()));
        driver.close();
        Thread.sleep(1000);

        driver.switchTo().window(listaTabova.get(1));
        driver.close();
        Thread.sleep(1000);

        driver.switchTo().window(listaTabova.get(0));

    }

    @Test(priority = 110)
    public void testingBrokenImage() {

        // Go to page
        homePage.clickElements();

        // Select BrokenLinks - Images
        elements.clickBrokenLinks();

        // Storing all elements with img tag in a list of WebElements
        List<WebElement> images = driver.findElements(By.tagName("img"));
        System.out.println("Total number of Images on the Page are " + images.size());


        //checking the links reached
        for(int i=0; i<images.size();i++)
        {
            WebElement image= images.get(i);
            String imageURL= image.getAttribute("src");
            System.out.println("URL of Image " + (i+1) + " is: " + imageURL);
            brokenLinksPage.verifyLinks(imageURL);

        //assert that image is displayed
            try {
                boolean imageDisplayed = (Boolean) ((JavascriptExecutor) driver).executeScript("return (typeof arguments[0].naturalWidth !=\"undefined\" && arguments[0].naturalWidth > 0);", image);
                if (imageDisplayed) {
                    System.out.println("Display - OK");
                }else {
                    System.out.println("Display- BROKEN");
                }
            }
            catch (Exception e) {
                System.out.println("Error Occured");
            }
        }

    }

    @Test(priority = 120)
    public void downloadFile() throws InterruptedException {
        File f = new File("C:\\Users\\neman\\Downloads\\sampleFile.jpeg");

        // Go to page
        homePage.clickElements();

        // Select Upload Download
        elements.clickUploadAndDownload();

        // Check if file exists and if does delete it
        if (f.exists()) f.delete();

        // Confirm that file does not exist
        Assert.assertFalse(f.exists());

        // Download file
        uploadAndDownloadPage.clickOnDownloadButton();

        // Check that file is downloaded
        Thread.sleep(1000);
        Assert.assertTrue(f.exists());

    }

    @Test(priority = 130)
    public void uploadFile() throws InterruptedException {

        // Go to page
        homePage.clickElements();

        //Select Upload and Download
        elements.clickUploadAndDownload();

        String pathForUpload = excelReader.getStringData("Elements", 1, 11);
        String fileForUpload = excelReader.getStringData("Elements", 1, 12);
        uploadAndDownloadPage.getChooseFile().sendKeys(pathForUpload + fileForUpload);

        String expUploadedFilePath = "C:\\fakepath\\" + fileForUpload;

        Assert.assertTrue(expUploadedFilePath.equals(uploadAndDownloadPage.getUploadedFilePath().getText()));

    }


    @Test(priority = 140)
    public void testingCheckBox() throws InterruptedException {

        // Go to page
        homePage.clickElements();

        //select Check Box
        elements.clickCheckBox();

        Thread.sleep(1000);
        //Assert that Home check box is displayed
        Assert.assertTrue(checkBoxPage.getHome().isDisplayed());

        //Assert that checkboxes inside Home are not displayed
        boolean check = true;
        try {
            check = checkBoxPage.getDesktop().isDisplayed();
        }
        catch (Exception e) {
            check = false;
        }
        Assert.assertFalse(check);

        check = true;
        try {
            check = checkBoxPage.getDocuments().isDisplayed();
        }
        catch (Exception e) {
            check = false;
        }
        Assert.assertFalse(check);

        check = true;
        try {
            check = checkBoxPage.getDownloads().isDisplayed();
        }
        catch (Exception e) {
            check = false;
        }
        Assert.assertFalse(check);

        //Click Arrow at Home Checkbox
        checkBoxPage.clickHomeArrow();

        //Assert that elements inside Home directories are displayed
        Assert.assertTrue(checkBoxPage.getDesktop().isDisplayed());
        Assert.assertTrue(checkBoxPage.getDocuments().isDisplayed());
        Assert.assertTrue(checkBoxPage.getDownloads().isDisplayed());

        // Click " - "
        checkBoxPage.clickMinus();

        //Assert that checkboxes inside Home are not displayed
        check = true;
        try {
            check = checkBoxPage.getDesktop().isDisplayed();
        }
        catch (Exception e) {
            check = false;
        }
        Assert.assertFalse(check);

        check = true;
        try {
            check = checkBoxPage.getDocuments().isDisplayed();
        }
        catch (Exception e) {
            check = false;
        }
        Assert.assertFalse(check);

        check = true;
        try {
            check = checkBoxPage.getDownloads().isDisplayed();
        }
        catch (Exception e) {
            check = false;
        }
        Assert.assertFalse(check);

        // Click " + "
        checkBoxPage.clickPlus();

        // Assert that following Checkboxes are displayed
        Assert.assertTrue(checkBoxPage.getDesktop().isDisplayed());
        Assert.assertTrue(checkBoxPage.getDocuments().isDisplayed());
        Assert.assertTrue(checkBoxPage.getDownloads().isDisplayed());

        // Click Home Checkbox
        checkBoxPage.clickHome();

        String expMsg = "You have selected :\n" + "home\n" + "desktop\n" + "notes\n" + "commands\n" + "documents\n" + "workspace\n" + "react\n" + "angular\n" + "veu\n" + "office\n" + "public\n" + "private\n" + "classified\n" + "general\n" + "downloads\n" + "wordFile\n" + "excelFile";

        // Assert that  result message is as expected
        Assert.assertTrue(expMsg.equals(checkBoxPage.getResultMsg().getText()));

        // Click Desktop Checkbox
        checkBoxPage.clickDesktop();

        // Assert that  result message is as expected
        expMsg = "You have selected :\n" + "documents\n" + "workspace\n" + "react\n" + "angular\n" + "veu\n" + "office\n" + "public\n" + "private\n" + "classified\n" + "general\n" + "downloads\n" + "wordFile\n" + "excelFile";
        Assert.assertTrue(expMsg.equals(checkBoxPage.getResultMsg().getText()));

        // Click Documents Checkbox
        checkBoxPage.clickDocuments();

        // Assert that  result message is as expected
        expMsg = "You have selected :\n" + "downloads\n" + "wordFile\n" + "excelFile";
        Assert.assertTrue(expMsg.equals(checkBoxPage.getResultMsg().getText()));

        //Click Downloads Checkbox
        checkBoxPage.clickDownloads();

        // Assert that result message is not present
        check = true;
        try {
            check = checkBoxPage.getResultMsg().isDisplayed();
        }
        catch (Exception e) {
            check = false;
        }
        Assert.assertFalse(check);

        // Click Notes Checkbox
        checkBoxPage.clickNotes();

        // Assert that  result message is as expected
        expMsg = "You have selected :\n" + "notes";
        Assert.assertTrue(expMsg.equals(checkBoxPage.getResultMsg().getText()));

        // Click Commands Checkbox
        checkBoxPage.clickCommands();

        // Assert that  result message is as expected
        expMsg = "You have selected :\n" + "desktop\n" + "notes\n" + "commands";
        Assert.assertTrue(expMsg.equals(checkBoxPage.getResultMsg().getText()));

        // Click WorkSpace Checkbox
        checkBoxPage.clickWorkSpace();

        // Assert that  result message is as expected
        expMsg = "You have selected :\n" + "desktop\n" + "notes\n" + "commands\n" + "workspace\n" + "react\n" + "angular\n" + "veu";
        Assert.assertTrue(expMsg.equals(checkBoxPage.getResultMsg().getText()));

        // Click Office Checkbox
        checkBoxPage.clickOffice();

        // Assert that  result message is as expected
        expMsg = "You have selected :\n" + "desktop\n" + "notes\n" + "commands\n" + "documents\n" + "workspace\n" + "react\n" + "angular\n" + "veu\n" + "office\n" + "public\n" + "private\n" + "classified\n" + "general";
        Assert.assertTrue(expMsg.equals(checkBoxPage.getResultMsg().getText()));

        // Click React Checkbox
        checkBoxPage.clickReact();

        // Assert that  result message is as expected
        expMsg = "You have selected :\n" + "desktop\n" + "notes\n" + "commands\n" + "angular\n" + "veu\n" + "office\n" + "public\n" + "private\n" + "classified\n" + "general";
        Assert.assertTrue(expMsg.equals(checkBoxPage.getResultMsg().getText()));

        // Click Angular Checkbox
        checkBoxPage.clickAngular();

        // Assert that  result message is as expected
        expMsg = "You have selected :\n" + "desktop\n" + "notes\n" + "commands\n" + "veu\n" + "office\n" + "public\n" + "private\n" + "classified\n" + "general";
        Assert.assertTrue(expMsg.equals(checkBoxPage.getResultMsg().getText()));

        // Click Veu Checkbox
        checkBoxPage.clickVeu();

        // Assert that  result message is as expected
        expMsg = "You have selected :\n" + "desktop\n" + "notes\n" + "commands\n" + "office\n" + "public\n" + "private\n" + "classified\n" + "general";
        Assert.assertTrue(expMsg.equals(checkBoxPage.getResultMsg().getText()));

        // Click Public
        checkBoxPage.clickPublic();

        // Assert that  result message is as expected
        expMsg = "You have selected :\n" + "desktop\n" + "notes\n" + "commands\n" + "private\n" + "classified\n" + "general";
        Assert.assertTrue(expMsg.equals(checkBoxPage.getResultMsg().getText()));

        // Click Private Checkbox
        checkBoxPage.clickPrivate();

        // Assert that  result message is as expected
        expMsg = "You have selected :\n" + "desktop\n" + "notes\n" + "commands\n" + "classified\n" + "general";
        Assert.assertTrue(expMsg.equals(checkBoxPage.getResultMsg().getText()));

        // Click Classified Checkbox
        checkBoxPage.clickClassified();

        // Assert that  result message is as expected
        expMsg = "You have selected :\n" + "desktop\n" + "notes\n" + "commands\n" + "general";
        Assert.assertTrue(expMsg.equals(checkBoxPage.getResultMsg().getText()));

        // Click General Chekbox
        checkBoxPage.clickGeneral();

        // Assert that  result message is as expected
        expMsg = "You have selected :\n" + "desktop\n" + "notes\n" + "commands";
        Assert.assertTrue(expMsg.equals(checkBoxPage.getResultMsg().getText()));

        // Click Word File Checkbox
        checkBoxPage.clickWordFile();

        // Assert that  result message is as expected
        expMsg = "You have selected :\n" + "desktop\n" + "notes\n" + "commands\n" + "wordFile";
        Assert.assertTrue(expMsg.equals(checkBoxPage.getResultMsg().getText()));

        // Click Excel File
        checkBoxPage.clickExcelFile();

        // Assert that  result message is as expected
        expMsg = "You have selected :\n" + "desktop\n" + "notes\n" + "commands\n" + "downloads\n" + "wordFile\n" + "excelFile";
        Assert.assertTrue(expMsg.equals(checkBoxPage.getResultMsg().getText()));

    }

}
