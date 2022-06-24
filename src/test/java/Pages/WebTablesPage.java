package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebTablesPage {

    WebDriver driver;
    WebDriverWait wdwait;

    WebElement addNewRecordButton;
    WebElement firstNameField;
    WebElement lastNameField;
    WebElement emailField;
    WebElement ageField;
    WebElement salaryField;
    WebElement departmentField;
    WebElement submitButton;

    WebElement editIcon4;

    WebElement deleteIcon4;

    WebElement firstNameText;
    WebElement lastNameText;
    WebElement emailText;
    WebElement ageText;
    WebElement salaryText;
    WebElement departmentText;
    public WebTablesPage(WebDriver driver, WebDriverWait wdwait) {
        this.driver = driver;
        this.wdwait = wdwait;
    }

    public WebElement getAddNewRecordButton() {
        return addNewRecordButton = driver.findElement(By.id("addNewRecordButton"));
    }

    public WebElement getFirstNameField() {
        return firstNameField = driver.findElement(By.id("firstName"));
    }

    public WebElement getLastNameField() {
        return lastNameField = driver.findElement(By.id("lastName"));
    }

    public WebElement getEmailField() {
        return emailField = driver.findElement(By.id("userEmail"));
    }

    public WebElement getAgeField() {
        return ageField = driver.findElement(By.id("age"));
    }

    public WebElement getSalaryField() {
        return salaryField = driver.findElement(By.id("salary"));
    }

    public WebElement getDepartmentField() {
        return departmentField = driver.findElement(By.id("department"));
    }

    public WebElement getSubmitButton() {
        return submitButton = driver.findElement(By.id("submit"));
    }

    public WebElement getEditIcon4() {
        return editIcon4 = driver.findElement(By.id("edit-record-4"));
    }

    public WebElement getDeleteIcon4() {
        return deleteIcon4 = driver.findElement(By.id("delete-record-4"));
    }

    public WebElement getFirstNameText() {
        return firstNameText = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/div[3]/div[1]/div[2]/div[4]/div/div[1]"));
    }

    public WebElement getLastNameText() {
        return lastNameText = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/div[3]/div[1]/div[2]/div[4]/div/div[2]"));
    }

    public WebElement getEmailText() {
        return emailText = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/div[3]/div[1]/div[2]/div[4]/div/div[4]"));
    }

    public WebElement getAgeText() {
        return ageText = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/div[3]/div[1]/div[2]/div[4]/div/div[3]"));
    }

    public WebElement getSalaryText() {
        return salaryText = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/div[3]/div[1]/div[2]/div[4]/div/div[3]"));
    }

    public WebElement getDepartmentText() {
        return departmentText = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/div[3]/div[1]/div[2]/div[4]/div/div[6]"));
    }

    //methods
    public void clickOnAddNewRecordButton() {
        this.getAddNewRecordButton().click();
    }

    public void insertFirstName(String username) {
        this.getFirstNameField().clear();
        this.getFirstNameField().sendKeys(username);
    }

    public void insertLastName(String username) {
        this.getLastNameField().clear();
        this.getLastNameField().sendKeys(username);
    }

    public void insertEmail(String email) {
        this.getEmailField().clear();
        this.getEmailField().sendKeys(email);
    }

    public void insertAge(String age) {
        this.getAgeField().clear();
        this.getAgeField().sendKeys(age);
    }

    public void insertSalary(String salary) {
        this.getSalaryField().clear();
        this.getSalaryField().sendKeys(salary);
    }

    public void insertDepartment(String department) {
        this.getDepartmentField().clear();
        this.getDepartmentField().sendKeys(department);
    }

    public void clickOnSubmitButton() {
        this.getSubmitButton().click();
    }

    public void clickOnEditIcon4() {
        this.getEditIcon4().click();
    }

    public void clickOnDeleteIcon4() {
        this.getDeleteIcon4().click();
    }

}
