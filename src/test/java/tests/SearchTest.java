package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.BlackwellsHomePage;

public class SearchTest extends BaseTest {

    @Test
    public void SearchBook() throws InterruptedException {
        String url = "https://blackwells.co.uk/bookshop/home";
        String searchTerm = "Vonnegut";

        BlackwellsHomePage homePage = new BlackwellsHomePage(driver);
        homePage.Search(url, searchTerm);

        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.className("search-result__list")));
        WebElement searchResults = driver.findElement(By.className("search-result__list"));
        Assert.assertTrue(searchResults.getText().contains(searchTerm));
        driver.quit();
    }
}