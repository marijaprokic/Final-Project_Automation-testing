package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NavPage {
    private WebDriver driver;

    public NavPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getHomeLink() {
        String homeLink = "https://vue-demo.daniel-avellaneda.com/";
        return homeLink;
    }

    public String getAboutLink() {
        String aboutLink = "https://vue-demo.daniel-avellaneda.com/about";
        return aboutLink;
    }

    public String getMyProfileLink() {
        String myProfileLink = "https://vue-demo.daniel-avellaneda.com/profile";
        return myProfileLink;
    }

    public WebElement getAdminButton() {
        return driver.findElement(By.xpath("//button[contains (@class, 'btnAdmin')]"));
    }

    public String getCitiesLink() {
        String citiesLink = "https://vue-demo.daniel-avellaneda.com/admin/cities";
        return citiesLink;
    }

    public String getUsersLink() {
        String usersLink = "https://vue-demo.daniel-avellaneda.com/admin/users";
        return usersLink;
    }

    public WebElement getLogoutButton() {
        return driver.findElement(By.xpath("//button[contains (@class, 'btnLogout')]"));
    }

    public WebElement getLanguageButton() {
        return driver.findElement(By.xpath("//button[contains (@class, 'btnLocaleActivation')]"));
    }

    public WebElement getENButton() {
        return driver.findElement(By.xpath("//div[contains (@class, 'btnEN')]"));
    }

    public WebElement getESButton() {
        return driver.findElement(By.xpath("//div[contains (@class, 'btnES')]"));
    }

    public WebElement getFRButton() {
        return driver.findElement(By.xpath("//div[contains (@class, 'btnFR')]"));
    }

    public WebElement getCNButton() {
        return driver.findElement(By.xpath("//div[contains (@class, 'btnCN')]"));
    }

    public WebElement getHeatherFromHomePage() {
      return driver.findElement(By.xpath("//h1[@class = 'display-2 font-weight-bold']"));
    }

    public WebElement getCitiesButton () {
        return driver.findElement(By.xpath("//div[contains (text(), 'Cities')]"));
    }
}
