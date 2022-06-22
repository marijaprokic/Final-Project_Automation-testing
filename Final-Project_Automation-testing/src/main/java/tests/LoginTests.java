package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BasicTest {

    @Test(priority = 10)
    public void visitsLoginPage() throws InterruptedException {
        navPage.getLanguageButton().click();
        navPage.getENButton().click();
        loginPage.getLoginButtonFromNavigation().click();
        Assert.assertTrue(
                driver.getCurrentUrl().contains("/login"),
                "[ERROR] Login page url should contain '/login'.");
    }

    @Test(priority = 20)
    public void checksInputTypes() {
        loginPage.getLoginButtonFromNavigation().click();
        Assert.assertEquals(
                loginPage.getEmailInput().getAttribute("type"),
                "email",
                "Email input field does not have valid type.");
        Assert.assertEquals(
                loginPage.getPasswordInput().getAttribute("type"),
                "password",
                "Password input does not have valid type.");
    }


    @Test(priority = 30)
    public void displaysErrorsWhenUserDoesNotExist() {
        String email1 = "non-existing-user@gmal.com";
        String password1 = "pasword123";
        loginPage.getLoginButtonFromNavigation().click();
        loginPage.getEmailInput().sendKeys(email1);
        loginPage.getPasswordInput().sendKeys(password1);
        loginPage.getLoginButton().click();
        messagePopupPage.waitForPopupDialogToBeVisible();
        Assert.assertEquals(
                messagePopupPage.getElementsWithTextOfPopupMessage().getText(),
                "User does not exists",
                "[ERROR] Pop up message should contain 'User does not exist'.");
        Assert.assertTrue(
                driver.getCurrentUrl().contains("/login"),
                "[ERROR] Login page url should contain '/login'.");
    }

    @Test(priority = 40)
    public void displaysErrorsWhenPasswordIsWrong() {
        String email2 = "admin@admin.com";
        String password2 = "pasword123";
        loginPage.getLoginButtonFromNavigation().click();
        loginPage.getEmailInput().sendKeys(email2);
        loginPage.getPasswordInput().sendKeys(password2);
        loginPage.getLoginButton().click();
        messagePopupPage.waitForPopupDialogToBeVisible();
        Assert.assertEquals(
                messagePopupPage.getElementsWithTextOfPopupMessage().getText(),
                "Wrong password",
                "[ERROR] Pop up message should contain 'Wrong password'.");
        Assert.assertTrue(
                driver.getCurrentUrl().contains("/login"),
                "[ERROR] Login page url should contain '/login'.");
    }

    @Test(priority = 50)
    public void login() throws InterruptedException {
        String email3 = "admin@admin.com";
        String password3 = "12345";
        loginPage.getLoginButtonFromNavigation().click();
        loginPage.getEmailInput().sendKeys(email3);
        loginPage.getPasswordInput().sendKeys(password3);
        loginPage.getLoginButton().click();
        Thread.sleep(1000);
        Assert.assertTrue(
                driver.getCurrentUrl().contains("/home"),
                "[ERROR] Login page url should contain '/home'.");
    }

    @Test(priority = 60)
    public void logout() {
        Assert.assertTrue(navPage.getLogoutButton().isDisplayed());
        navPage.getLogoutButton().click();
    }
}

