package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SliderPage {

    WebDriver driver;
    WebDriverWait wdwait;
    WebElement slider;

    WebElement sliderRange;



    public SliderPage(WebDriver driver, WebDriverWait wdwait) {
        this.driver = driver;
        this.wdwait = wdwait;
    }

    public WebElement getSlider() {
        return slider = driver.findElement(By.cssSelector(".range-slider.range-slider--primary"));
    }

    public WebElement getSliderRange() {
        return sliderRange = driver.findElement(By.cssSelector(".range-slider.range-slider--primary"));
    }
}