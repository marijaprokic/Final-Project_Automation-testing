package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LocaleTests extends BasicTest {


    @Test(priority = 10)
    public void setLocaleToES () {
        navPage.getLanguageButton().click();
        navPage.getESButton().click();
        Assert.assertTrue(
                navPage.getHeatherFromHomePage().getText().contains("Página de aterrizaje"),
                "[ERROR] Language is not set to Spanish.");
    }

    @Test(priority = 20)
    public void setLocaleToEN () {
        navPage.getLanguageButton().click();
        navPage.getENButton().click();
        Assert.assertTrue(
                navPage.getHeatherFromHomePage().getText().contains("Landing"),
                "[ERROR] Language is not set to English.");
    }

    @Test(priority = 30)
    public void setLocaleToCN () {
        navPage.getLanguageButton().click();
        navPage.getCNButton().click();
        Assert.assertTrue(
                navPage.getHeatherFromHomePage().getText().contains("首页"),
                "[ERROR] Language is not set to Chinese.");
    }

    @Test(priority = 40)
    public void setLocaleToFR () {
        navPage.getLanguageButton().click();
        navPage.getFRButton().click();
        Assert.assertTrue(
                navPage.getHeatherFromHomePage().getText().contains("Page d'atterrissage"),
                "[ERROR] Language is not set to French.");
    }

}
