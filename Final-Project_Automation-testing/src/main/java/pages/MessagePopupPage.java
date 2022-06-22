package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MessagePopupPage {
    private WebDriver driver;

    public MessagePopupPage(WebDriver driver) {
        this.driver = driver;
    }

    public void waitForPopupDialogToBeVisible() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'v-snack__content')]")));
    }

    public WebElement getElementsWithTextOfPopupMessage (){
        return driver.findElement(By.xpath("//div[@class='v-snack__content']/ul/li"));
    }

    public WebElement getDeleteButtonInPopupMessage (){
        return driver.findElement(By.xpath("//div[contains(@class, 'v-card__actions')]/button[2]"));
    }

    public WebElement getVerifyYourAccountPopupDialog (){
        return driver.findElement(By.xpath("//div[@class='v-card v-sheet theme--light']"));
    }

    public WebElement getHeaderFromVerifyYourAccountPopupDialog (){
        return driver.findElement(By.xpath("//div[contains(@class,'dlgVerifyAccount')]"));
    }

    public WebElement getCloseButtonFromVerifyYourAccountPopupDialog (){
        return driver.findElement(By.xpath("//button[contains(@class, 'btnClose')]"));
    }

}
