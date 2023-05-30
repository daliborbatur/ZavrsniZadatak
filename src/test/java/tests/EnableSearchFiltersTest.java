package tests;

import helpers.BaseHelper;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.BlackewellsHomePage;
import pages.BlackwellsSearchResults;

public class EnableSearchFiltersTest extends BaseHelper {


    @Test
    public void EnableSearchFilters() throws InterruptedException {

        String url = "https://blackwells.co.uk/bookshop/home";
        String searchTerm = "Vonnegut";
        String fromYear ="2000";
        String toYear="2010";
        String formatName="Hardback";

        BlackewellsHomePage homePage = new BlackewellsHomePage(driver);
        homePage.Search(url, searchTerm);

        BlackwellsSearchResults searchResults = new BlackwellsSearchResults(driver);
        searchResults.enableSearchFilters(fromYear, toYear, formatName);

        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.className("search-result__list")));
        WebElement searchFilterResults = driver.findElement(By.className("search-result__list"));
        Assert.assertTrue(searchFilterResults.getText().contains(formatName));
        driver.quit();
    }
}