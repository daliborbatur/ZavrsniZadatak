package pages;

import helpers.BaseHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.List;

public class BlackwellsSearchResults extends BaseHelper {

    public BlackwellsSearchResults(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(name="pubDateFrom")
    WebElement fromYearField;
    @FindBy(name="pubDateTo")
    WebElement toYearField;
    @FindBy(xpath="//img[@alt='Hardback']")
    WebElement formats;
    @FindBy(xpath="//input[@value='Refine']")
    WebElement refineButton;
    @FindBy(className="btn-add")
    WebElement addToBasketButton;


    private void enterYearRange(String fromYear, String toYear) {
        wdWait.until(ExpectedConditions.visibilityOf(fromYearField));
        fromYearField.click();
        fromYearField.sendKeys(fromYear);

        wdWait.until(ExpectedConditions.visibilityOf(toYearField));
        toYearField.click();
        toYearField.sendKeys(toYear);
    }

    private void selectFormat(String formatName){

        formats.click();
        // Find all the format filter options and store them in a list
//        wdWait.until(ExpectedConditions.visibilityOf(formats));
//        wdWait.until(ExpectedConditions.presenceOfNestedElementLocatedBy(formats, By.tagName("ul")));
//        wdWait.until(ExpectedConditions.visibilityOfNestedElementsLocatedBy(formats, By.tagName("ul")));
//        WebElement formatList = formats.findElement(By.tagName("li"));
//        List<WebElement> selectFormatList = formatList.findElements(By.tagName("li"));
//        for (WebElement format : selectFormatList) {
//            if (format.getText().contains(formatName)) {
//                wdWait.until(ExpectedConditions.elementToBeClickable(format));
//                break;
//            }
//        }
        }

        private void clickRefineButton() {
            ((JavascriptExecutor)driver).executeScript("window.scrollTo(-20,"+refineButton.getLocation().x+")");
            refineButton.click();
        }

        public void enableSearchFilters(String fromYear, String toYear, String formatName){
            enterYearRange(fromYear, toYear);
            selectFormat(formatName);
            clickRefineButton();
    }

    private void selectBook(){
        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.className("search-result")));
        WebElement allBooks = driver.findElement(By.className("search-result"));
        List<WebElement> listOfBooks = allBooks.findElements(By.className("search-result__item"));
        listOfBooks.get(1).findElement(By.tagName("h4")).getText();
        listOfBooks.get(0).findElement(By.tagName("a")).click();
    }

    public void addToBasket (String fromYear, String toYear, String formatName) {
        enterYearRange(fromYear, toYear);
        selectFormat(formatName);
        clickRefineButton();
        selectBook();
        addToBasketButton.click();
    }

}
