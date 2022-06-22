package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CitiesPage {
    private WebDriver driver;

    public CitiesPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getNewItemButton() {
        return driver.findElement(By.xpath("//button[contains(@class,'btnNewItem ')]"));
    }

    public WebElement getNameFieldFromDialog() {
        return driver.findElement(By.xpath("//input[contains(@id,'name')]"));
    }

    public WebElement getEditNameFieldFromDialog() {
        return driver.findElement(By.xpath("//input[contains(@id,'name')]"));
    }
    public WebElement getSearchButton() {
        return driver.findElement(By.xpath("//input[@id='search']"));
    }

    public void waitForEditCreateDialogToBeVisible() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'dlgNewEditItem')]")));
    }

    public void waitForDeleteDialogToBeVisible() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//header[contains(@class, 'warning')]")));
    }

    public WebElement getSaveButtonFromEditDialogue() {
        return driver.findElement(By.xpath("//button[contains(@class,'btnSave')]"));
    }

    public WebElement getMessageFromAddNewItemDialog () {
        return driver.findElement(By.xpath("//div[contains(text(), ' Saved successfully ')]"));
    }

    public WebElement getDeleteButtonFromDeleteDialogue() {
        return driver.findElement(By.xpath("//span[contains(text(), ' Delete ']"));
    }

    public void waitForNumberOfRowsToBe(int numberOfRows) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath("//table/tbody/tr"), numberOfRows));
    }

    public WebElement getTableCell(int rowIndex, int columnIndex) {
        return driver.findElement(By.xpath("//table/tbody/tr["+rowIndex +"]/td["+ columnIndex +"]"));
    }

    public WebElement getEditButtonByRowIndex(int rowIndex) {
        return driver.findElements(By.xpath("//button[@id= 'edit']")).get(rowIndex);
    }

    public WebElement getDeleteButtonByRowIndex(int rowIndex) {
        return driver.findElements(By.xpath("//button[@id= 'delete']")).get(rowIndex);
    }

}
