package Test;

import Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestInteractions extends BaseTest {

    @BeforeMethod
    public void pageSetUp() {
        driver.manage().window().maximize();
        //driver.navigate().to("https://demoqa.com");
        driver.get(homePageURL);
    }

    @Test(priority = 10)
    public void testingSimpleDragAndDrop() {

        // Go to page
        homePage.clickInteractions();

        //select Check Box
        interactions.clickDroppable();

        //Actions class method to drag and drop
        droppablePage.dragAndDrop();

        //verify text changed in to 'Drop here' box
        String textTo = droppablePage.getTarget().getText();

        if(textTo.equals("Dropped!")) {
            System.out.println("Source is dropped to target as expected");
        }else {
            System.out.println("Source couldn't be dropped to target as expected");
        }

    }

}
