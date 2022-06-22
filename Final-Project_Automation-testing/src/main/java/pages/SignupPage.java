package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignupPage {

    private WebDriver driver;

    public SignupPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getNameSignup() {
        return driver.findElement(By.name("name"));
    }

    public WebElement getEmailSignup() {
        return driver.findElement(By.name("email"));
    }

    public WebElement getPasswordSignup() {
        return driver.findElement(By.name("password"));
    }

    public WebElement getConfirmPasswordSignup() {
        return driver.findElement(By.name("confirmPassword"));
    }

    public WebElement getSignUpButtonFromNavigation(){
        return driver.findElement(By.xpath("//a[@href='/signup']"));
    }
    public WebElement getSignMeUpButton(){
        return driver.findElement(By.xpath("//span[contains (text(), 'Sign me up')]"));
    }

}
