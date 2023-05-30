package pages;

import helpers.BaseHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BlackwellsHomePage extends BaseHelper {

@FindBy(name="keyword")
WebElement searchField;
@FindBy(xpath="//input[@type=\"submit\"]")
    WebElement searchButton;

    public BlackwellsHomePage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    private void navigateToHomepage(String url) {
        driver.manage().window().maximize();
        driver.get(url);
    }

    private void enterSearchTerm(String searchTerm)
    {
        wdWait.until(ExpectedConditions.visibilityOf(searchField));
        searchField.sendKeys(searchTerm);
    }

    private void clickSearchButton() {
        wdWait.until(ExpectedConditions.elementToBeClickable(searchButton));
        searchButton.click();
    }

    public void Search(String url, String searchTerm) throws InterruptedException {
        navigateToHomepage(url);
        enterSearchTerm(searchTerm);
        clickSearchButton();
    }
}
