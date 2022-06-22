package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AuthRoutesTests extends BasicTest {

    @Test(priority = 10)
    public void ForbidsVisitsToHomeUrlIfNotAuthenticated() {
        driver.get(baseUrl + "/home");
        Assert.assertTrue(
                driver.getCurrentUrl().contains("/login"),
                "[ERROR] Home page url should not contain '/login'.");
    }

    @Test(priority = 20)
    public void ForbidsVisitsToProfileUrlIfNotAuthenticated() {
        driver.get(baseUrl + "/profile");
        Assert.assertTrue(
                driver.getCurrentUrl().contains("/login"),
                "[ERROR] Profile page url should contain '/login'.");
    }

    @Test(priority = 30)
    public void ForbidsVisitsToAdminCitiesUrlIfNotAuthenticated() {
        driver.get(baseUrl + "/admin/cities");
        Assert.assertTrue(
                driver.getCurrentUrl().contains("/login"),
                "[ERROR] Admin/Cities page url should contain '/login'.");
    }

    @Test(priority = 40)
    public void ForbidsVisitsToAdminUsersUrlIfNotAuthenticated() {
        driver.get(baseUrl + "/admin/users");
        Assert.assertTrue(
                driver.getCurrentUrl().contains("/login"),
                "[ERROR] Admin/Users page url should contain '/login'.");
    }
}
