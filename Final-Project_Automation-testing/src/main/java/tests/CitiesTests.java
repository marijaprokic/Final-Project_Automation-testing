package tests;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CitiesTests extends BasicTest {


    @Test(priority = 10)
    public void visitsTheAdminCitiesPageAndListCities() {
        String email1 = "admin@admin.com";
        String password1 = "12345";
        loginPage.getLoginButtonFromNavigation().click();
        loginPage.getEmailInput().sendKeys(email1);
        loginPage.getPasswordInput().sendKeys(password1);
        loginPage.getLoginButton().click();
        navPage.getAdminButton().click();
        navPage.getCitiesButton().click();
        Assert.assertTrue(
                driver.getCurrentUrl().contains("/admin/cities"),
                "[ERROR] Page url should contain '/admin/cities'.");
    }

    @Test(priority = 20)
    public void checksInputTypesForCreateEditNewCity() throws InterruptedException {
        navPage.getAdminButton().click();
        navPage.getCitiesButton().click();
        citiesPage.getNewItemButton().click();
        citiesPage.waitForEditCreateDialogToBeVisible();
        Assert.assertEquals(
                citiesPage.getNameFieldFromDialog().getAttribute("type"),
                "text",
                "[ERROR] Name field from New Item Cities dialog does not have valid type.");
    }

    @Test(priority = 30)
    public void createNewCity() throws InterruptedException {
        String cityName = "Roma";
        navPage.getAdminButton().click();
        navPage.getCitiesButton().click();
        citiesPage.getNewItemButton().click();
        citiesPage.waitForEditCreateDialogToBeVisible();
        citiesPage.getNameFieldFromDialog().sendKeys(cityName);
        citiesPage.getSaveButtonFromEditDialogue().click();
        messagePopupPage.waitForPopupDialogToBeVisible();
        Assert.assertEquals(
                messagePopupPage.getElementsWithTextOfPopupMessage().getText(),
                "Saved successfully",
                "[ERROR] Popup dialogue after creating new city should contain message 'Saved successfully'.");
    }

    @Test(priority = 40)
    public void editCity() {
        String oldCityName = "Roma";
        String newCityName = "Roma eternal city";
        navPage.getAdminButton().click();
        navPage.getCitiesButton().click();
        citiesPage.getSearchButton().click();
        citiesPage.getSearchButton().sendKeys(oldCityName);
        citiesPage.waitForNumberOfRowsToBe(1);
        citiesPage.getEditButtonByRowIndex(0).click();
        citiesPage.getEditNameFieldFromDialog().click();
        citiesPage.getEditNameFieldFromDialog().sendKeys(Keys.CONTROL, "a");
        citiesPage.getEditNameFieldFromDialog().sendKeys(newCityName);
        citiesPage.getSaveButtonFromEditDialogue().click();
        messagePopupPage.waitForPopupDialogToBeVisible();
        Assert.assertEquals(
                citiesPage.getMessageFromAddNewItemDialog().getText(),
                "Saved successfully",
                "[ERROR] Message after editing city should contain 'Saved successfully'.");
    }

    @Test(priority = 50)
    public void searchCity() {
        String newCityName = "Roma eternal city";
        navPage.getAdminButton().click();
        navPage.getCitiesButton().click();
        citiesPage.getSearchButton().sendKeys(newCityName);
        citiesPage.waitForNumberOfRowsToBe(1);
        Assert.assertTrue(
                citiesPage.getTableCell(1, 2).getText().contains(newCityName),
                "[ERROR] Name field should contain edited city name");
    }

    @Test(priority = 60)
    public void deleteCity() {
        String newCityName = "Roma eternal city";
        navPage.getAdminButton().click();
        navPage.getCitiesButton().click();
        citiesPage.getSearchButton().sendKeys(newCityName);
        citiesPage.waitForNumberOfRowsToBe(1);
        Assert.assertTrue(
                citiesPage.getTableCell(1, 2).getText().contains(newCityName),
                "[ERROR] Name field should contain edited city name");
        citiesPage.getDeleteButtonByRowIndex(0).click();
        citiesPage.waitForDeleteDialogToBeVisible();
        messagePopupPage.getDeleteButtonInPopupMessage().click();
        messagePopupPage.waitForPopupDialogToBeVisible();
        messagePopupPage.getDeleteButtonInPopupMessage().click();
        messagePopupPage.waitForPopupDialogToBeVisible();
        Assert.assertEquals(
                citiesPage.getMessageFromAddNewItemDialog().getText(),
                "Deleted successfully",
                "[ERROR] Message after deleting city should contain 'Deleted successfully'.");
    }
}
