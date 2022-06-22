package pages;
//Login Page
//        ●	Polje za unos email-a
//        ●	Polje za unos lozinke
//        ●	Dugme za login.

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getLoginButtonFromNavigation (){
        return driver.findElement(By.xpath("//a[contains (@class, 'btnLogin')]"));
    }

    public WebElement getEmailInput (){
        return driver.findElement(By.id("email"));
    }

    public WebElement getPasswordInput(){
        return driver.findElement(By.id("password"));
    }

    public WebElement getLoginButton (){
        return driver.findElements(By.xpath("//span[contains (text(), 'Login')]")).get(1);
    }



}
