package tests;

import helpers.BaseHelper;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.BlackewellsHomePage;
import pages.BlackwellsSearchResults;

public class ShoppingBasketTest extends BaseHelper {

    @Test
    public void addToShoppingBasket () throws InterruptedException {
        String url = "https://blackwells.co.uk/bookshop/home";
        String searchTerm = "Vonnegut";
        String fromYear = "2000";
        String toYear = "2010";
        String formatName = "Hardback";
        String buttonAdded = "Added to basket";

        BlackewellsHomePage homePage = new BlackewellsHomePage(driver);
        homePage.Search(url, searchTerm);

        BlackwellsSearchResults searchResults = new BlackwellsSearchResults(driver);
        searchResults.addToBasket(fromYear, toYear, formatName);

        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.className("btn-add")));
        WebElement buttonAddedToBasket = driver.findElement(By.className("btn-add"));
        Assert.assertTrue(buttonAddedToBasket.getText().contains(buttonAdded));
        driver.quit();
    }
}