package Base;

import Pages.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.time.Duration;

public class BaseTest {

    public WebDriver driver;
    public WebDriverWait wdwait;
    public HomePage homePage;

    public String homePageURL;

    public TextBoxPage textBoxPage;
    public CheckBoxPage checkBoxPage;
    public RadioButtonPage radioButtonPage;
    public WebTablesPage webTablesPage;

    public ButtonsPage buttonsPage;
    public LinksPage linksPage;

    public DynamicPropertiesPage dynamicPropertiesPage;
    public BrokenLinksPage brokenLinksPage;

    public UploadAndDownloadPage uploadAndDownloadPage;

    public BrowserWindowsPage browserWindowsPage;

    public AlertsPage alertsPage;
    public FramesPage framesPage;

    public NestedFramesPage nestedFramesPage;

    public ModalDialogsPage modalDialogsPage;

    public AccordionPage accordionPage;

    public AutoCompletePage autoCompletePage;

    public DroppablePage droppablePage;

    public SliderPage sliderPage;

    public ProgressBarPage progressBarPage;

    public MenuPage menuPage;

    public SelectMenuPage selectMenuPage;

    public ToolTipsPage toolTipsPage;

    public ExcelReader excelReader;

    public Elements elements;
    public Forms forms;
    public Alerts alerts;
    public Widgets widgets;
    public Interactions interactions;
    public BookStoreApplication bookStoreApplication;

    @BeforeClass
    public void setUp() throws IOException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wdwait = new WebDriverWait(driver, Duration.ofSeconds(10));
        homePage = new HomePage(driver, wdwait);
        textBoxPage = new TextBoxPage(driver, wdwait);
        radioButtonPage = new RadioButtonPage(driver, wdwait);
        webTablesPage = new WebTablesPage(driver, wdwait);
        buttonsPage = new ButtonsPage(driver, wdwait);
        linksPage = new LinksPage(driver, wdwait);
        dynamicPropertiesPage = new DynamicPropertiesPage(driver, wdwait);
        brokenLinksPage = new BrokenLinksPage(driver, wdwait);
        uploadAndDownloadPage = new UploadAndDownloadPage(driver, wdwait);
        checkBoxPage = new CheckBoxPage(driver, wdwait);
        alertsPage = new AlertsPage(driver, wdwait);
        framesPage = new FramesPage(driver, wdwait);
        nestedFramesPage = new NestedFramesPage(driver, wdwait);
        browserWindowsPage = new BrowserWindowsPage(driver, wdwait);
        modalDialogsPage = new ModalDialogsPage(driver, wdwait);
        accordionPage = new AccordionPage(driver, wdwait);
        autoCompletePage = new AutoCompletePage(driver, wdwait);
        droppablePage = new DroppablePage(driver, wdwait);
        sliderPage = new SliderPage(driver, wdwait);
        progressBarPage = new ProgressBarPage(driver, wdwait);
        menuPage = new MenuPage(driver, wdwait);
        selectMenuPage = new SelectMenuPage(driver, wdwait);
        toolTipsPage = new ToolTipsPage(driver, wdwait);
        excelReader = new ExcelReader("C:\\Users\\neman\\Desktop\\TestDemoQA.xlsx");
        homePageURL = excelReader.getStringData("URLs", 1, 0);
        elements = new Elements(driver, wdwait);
        forms = new Forms(driver, wdwait);
        alerts = new Alerts(driver, wdwait);
        widgets = new Widgets(driver, wdwait);
        interactions = new Interactions(driver, wdwait);
        bookStoreApplication = new BookStoreApplication(driver, wdwait);

    }

    public void visibilityWait(WebElement element) {

        wdwait.until(ExpectedConditions.visibilityOf(element));
    }

    public void clickabilityWait(WebElement element) {

        wdwait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void scrollIntoView(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public boolean elementVisibility(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    @AfterMethod
    public void removeCookies() {

        driver.manage().deleteAllCookies();
    }

    @AfterClass
    public void tearDown() {
        //driver.close();
        //driver.quit();
    }


}
