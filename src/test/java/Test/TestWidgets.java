package Test;

import Base.BaseTest;
import org.apache.poi.ss.usermodel.DateUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.List;

public class TestWidgets extends BaseTest {

    @BeforeMethod
    public void pageSetUp() {
        driver.manage().window().maximize();
        //driver.navigate().to("https://demoqa.com");
        driver.get(homePageURL);
    }


    @Test
    public void testingAccordionCollapse() throws InterruptedException {

        // Go to page
        homePage.clickWidgets();

        // Select Accordion
        widgets.clickAccordian();

        //section1

        accordionPage.clickOnSection1();
        //fetch question of the section1
        String firstQuestion = accordionPage.getSection1().getText();
        System.out.println("First Question : " + firstQuestion);
        //wait for the content to be visible
        visibilityWait(accordionPage.getSection1Content());
        //fetch answer for section1 question
        String firstAnswer = accordionPage.getSection1Content().getText();
        System.out.println("First Answer : " + firstAnswer);

        //section2

        accordionPage.clickOnSection2();
        //fetch question of the section2
        String secondQuestion = accordionPage.getSection2().getText();
        System.out.println("Second Question : " + secondQuestion);
        //wait for the content to be visible
        visibilityWait(accordionPage.getSection2Content());
        //fetch answer for section2 question
        String secondAnswer = accordionPage.getSection2Content().getText();
        System.out.println("Second Answer : " + secondAnswer);

        //section3

        accordionPage.clickOnSection3();
        //fetch question of the section3
        String thirdQuestion = accordionPage.getSection3().getText();
        System.out.println("Third Question : " + secondQuestion);
        //wait for the content to be visible
        visibilityWait(accordionPage.getSection3Content());
        //fetch answer for section2 question
        String thirdAnswer = accordionPage.getSection3Content().getText();
        System.out.println("Third Answer : " + secondAnswer);

        accordionPage.clickOnSection3();

    }


    @Test
    public void testingSlider() throws InterruptedException {

        // Go to page
        homePage.clickWidgets();

        // Select Accordion
        widgets.clickSlider();

        Thread.sleep(2000);

        Actions actions = new Actions(driver);

        //Move mouse to x offset 50 i.e. in horizontal direction
        actions.moveToElement(sliderPage.getSlider(),50,0).perform();
        sliderPage.getSlider().click();
        System.out.println("Moved slider in horizontal directions");

        //print that value is now 50
        System.out.println(sliderPage.getSliderRange().getAttribute("value"));

    }

    @Test
    public void testingProgressBar() throws InterruptedException {

        // Go to page
        homePage.clickWidgets();

        // Select Progress Bar
        widgets.clickProgressBar();

        progressBarPage.clickOnStartStopButton();

        //visibilityWait(progressBarPage.getProgressBar());

        boolean progressStatus = wdwait.until(ExpectedConditions.attributeToBe(progressBarPage.getProgressBar(),"aria-valuenow", "100"));
        if (progressStatus==true){
            visibilityWait(progressBarPage.getResetButton());
            progressBarPage.clickOnResetButton();
        }

    }

    @Test
    public void testingMenu() {

        // Go to page
        homePage.clickWidgets();

        // Select Menu
        widgets.clickMenu();

        //Instantiate Action Class
        Actions actions = new Actions(driver);

        //Mouse hover menuOption MainItem1
        actions.moveToElement(menuPage.getMainItem1()).perform();
        System.out.println("Done mouse hover on MainItem1");

        //Mouse hover menuOption MainItem2
        actions.moveToElement(menuPage.getMainItem2()).perform();
        System.out.println("Done mouse hover on MainItem2");

        //Mouse hover menuOption MainItem3
        actions.moveToElement(menuPage.getMainItem3()).perform();
        System.out.println("Done mouse hover on MainItem3");

        //Switch to MainItem2
        actions.moveToElement(menuPage.getMainItem2()).perform();

        //Mouse hover subItem1
        actions.moveToElement(menuPage.getSubItem1()).perform();
        System.out.println("Done mouse hover on subItem1 from MainItem2");

        //Mouse hover subItem2
        actions.moveToElement(menuPage.getSubItem2()).perform();
        System.out.println("Done mouse hover on subItem2 from MainItem2");

        //Mouse hover subItem3 - subSubList
        actions.moveToElement(menuPage.getSubSubList()).perform();
        System.out.println("Done mouse hover on subSubList from MainItem2");

        //Mouse hover subSubListItem1
        actions.moveToElement(menuPage.getSubSubListItem1()).perform();
        System.out.println("Done mouse hover on subSubListItem1 from MainItem2");
        actions.moveToElement(menuPage.getSubSubListItem2()).perform();
        System.out.println("Done mouse hover on subSubListItem2 from MainItem2");

    }

    @Test
    public void testingOldStyleSelectMenu() {

        // Go to page
        homePage.clickWidgets();

        // Select Menu
        widgets.clickSelectMenu();

        //selecting the dropdown element
        Select select = new Select(selectMenuPage.getOldStyleSelectMenu());

        //get the list of options
        List<WebElement> listOptions = select.getOptions();

        //looping through the options and printing dropdown options
        System.out.println("The dropdown options are:");
        for(WebElement options: listOptions)
            System.out.println(options.getText());

        //selecting the option 'Purple' by index
        System.out.println("Select the Option by Index 4");
        select.selectByIndex(4);
        System.out.println("Select value is: " + select.getFirstSelectedOption().getText());
        String expColor = "Purple";
        Assert.assertTrue(expColor.equals(select.getFirstSelectedOption().getText()));

        //selecting the option 'Yellow' by visible text
        System.out.println("Select the Option by Text Magenta");
        select.selectByVisibleText("Yellow");
        System.out.println("Select value is: " + select.getFirstSelectedOption().getText());
        expColor = "Yellow";
        Assert.assertTrue(expColor.equals(select.getFirstSelectedOption().getText()));

        //selecting an option by its value
        System.out.println("Select the option by value 5");
        select.selectByValue("5");
        System.out.println("Select value is: " + select.getFirstSelectedOption().getText());
        expColor = "Black";
        Assert.assertTrue(expColor.equals(select.getFirstSelectedOption().getText()));

    }

    @Test
    public void testingStandardMultiSelect() {

        // Go to page
        homePage.clickWidgets();

        // Select Menu
        widgets.clickSelectMenu();

        //Selecting the multi-select element by locating its id
        Select select = new Select(selectMenuPage.getStandardMultiSelect());

        //get the list of options
        System.out.println("The dropdown options are: ");

        List<WebElement> listOptions = select.getOptions();

        //looping through the options and printing them
        for(WebElement options: listOptions)
            System.out.println(options.getText());

        //using isMultiple() method to verify if the element is multi-select, if yes go onto next steps else exit
        if(select.isMultiple()){

            //Selecting option 'Volvo' by index
            System.out.println("Select option Volvo by Index");
            select.selectByIndex(0);

            //selecting the option 'Opel' by value
            System.out.println("Select option Opel by Value");
            select.selectByValue("opel");


            //selecting the option 'Audi' by visible text
            System.out.println("Select option Audi by Text");
            select.selectByVisibleText("Audi");

            //Get the list of selected options
            System.out.println("The selected values in the dropdown options are: ");

            List<WebElement> selectedOptions = select.getAllSelectedOptions();

            for(WebElement selectedOption: selectedOptions)
                System.out.println(selectedOption.getText());

            //deselect the value 'Volvo' by Index
            System.out.println("Deselect option Volvo by Index");
            select.deselectByIndex(0);

            //deselect the value 'Audi' by visible text
            System.out.println("Select option Audi by Text");
            select.deselectByVisibleText("Audi");

            //validate that both the values are deselected
            System.out.println("The selected values after deselect in the dropdown options are: ");
            List<WebElement> selectedOptionsAfterDeselect = select.getAllSelectedOptions();

            for(WebElement selectedOptionAfterDeselect: selectedOptionsAfterDeselect)
                System.out.println(selectedOptionAfterDeselect.getText());
            String expOption = "Opel";
            Assert.assertTrue(expOption.equals(select.getFirstSelectedOption().getText()));
            //deselect all values
            select.deselectAll();
        }

    }


    @Test
    public void testingToolTips() {

        // Go to page
        homePage.clickWidgets();

        // Select Tool Tips
        widgets.clickToolTips();

        //instantiate Action Class
        Actions actions = new Actions(driver);

        //mouse hover on hoverButton
        actions.moveToElement(toolTipsPage.getHoverButtoon()).perform();

        //mouse hover on hoverButton
        actions.moveToElement(toolTipsPage.getHoverTextField()).perform();

        //mouse hover on hoverButton
        actions.moveToElement(toolTipsPage.getContraryText()).perform();

        //mouse hover on hoverButton
        actions.moveToElement(toolTipsPage.getSectionNumberText()).perform();


    }

}
