package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SignupTests extends BasicTest {

    @Test(priority = 10)
    public void VisitsTheSignupPage() {
        signupPage.getSignUpButtonFromNavigation().click();
        Assert.assertTrue(
                driver.getCurrentUrl().contains("/signup"),
                "[ERROR] Signup page url should contain '/signup'.");
    }

    @Test(priority = 20)
    public void ChecksInputTypes() {
        signupPage.getSignUpButtonFromNavigation().click();
        Assert.assertEquals(
                signupPage.getEmailSignup().getAttribute("type"),
                "email",
                "Email signup field does not have valid type.");
        Assert.assertEquals(
                signupPage.getPasswordSignup().getAttribute("type"),
                "password",
                "Password signup field does not have valid type.");
        Assert.assertEquals(
                signupPage.getConfirmPasswordSignup().getAttribute("type"),
                "password",
                "Confirm password signup field does not have valid type.");
    }

    @Test(priority = 30)
    public void DisplaysErrorsWhenUserAlreadyExists() throws InterruptedException {
        String name1 = "Another User";
        String email1 = "admin@admin.com";
        String password1 = "12345";
        String confirmPassword1 = "12345";
        signupPage.getSignUpButtonFromNavigation().click();
        Assert.assertTrue(
                driver.getCurrentUrl().contains("/signup"),
                "[ERROR] Signup page url should contain '/signup'.");
        signupPage.getNameSignup().sendKeys(name1);
        signupPage.getEmailSignup().sendKeys(email1);
        signupPage.getPasswordSignup().sendKeys(password1);
        signupPage.getConfirmPasswordSignup().sendKeys(confirmPassword1);
        signupPage.getSignMeUpButton().click();
        messagePopupPage.waitForPopupDialogToBeVisible();
        Assert.assertEquals(
                messagePopupPage.getElementsWithTextOfPopupMessage().getText(),
                "E-mail already exists",
                "[ERROR] Pop up message should contain 'E-mail already exists'.");
        Assert.assertTrue(
                driver.getCurrentUrl().contains("/signup"),
                "[ERROR] Signup page url should contain '/signup'.");
    }

    @Test(priority = 40)
    public void Signup () {
        String name2 = "Marija Prokić";
        String email2 = "marija.prokic@itbootcamp.rs";
        String password2 = "12345";
        String confirmPassword2 = "12345";
        signupPage.getSignUpButtonFromNavigation().click();
        signupPage.getNameSignup().sendKeys(name2);
        signupPage.getEmailSignup().sendKeys(email2);
        signupPage.getPasswordSignup().sendKeys(password2);
        signupPage.getConfirmPasswordSignup().sendKeys(confirmPassword2);
        signupPage.getSignMeUpButton().click();
        navPage.getHomeLink();
        Assert.assertEquals(
                messagePopupPage.getHeaderFromVerifyYourAccountPopupDialog().getText(),
                "IMPORTANT: Verify your account",
                "[ERROR] Pop up message should contain 'IMPORTANT: Verify your account'.");
    }
}
