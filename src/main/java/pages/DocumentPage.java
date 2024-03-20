package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DocumentPage {

    //wait until page is second loaded
    public void WaitUntilSecondPageLoads(WebDriver driver){
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
            String XpathOfitem="//*[@class='left' and contains(text(),'Send a Warning')]";
            By LocatorofItem=By.xpath(XpathOfitem);
            wait.until(ExpectedConditions.visibilityOfElementLocated(LocatorofItem));
        }
        catch (TimeoutException e) {
            System.out.println("Second page is not loaded");
        };
    }
    //find element of text and price
    public String findText(WebDriver driver) {
        String ItemUnderTest = null;
        try {
            ItemUnderTest = driver.findElement(By.xpath("//div[@class='left' and contains(text(),'Release a Lien')]")).getText();
        } catch (NoSuchElementException e) {
            // Handle the exception (e.g., log it, print a message)
            System.out.println("Element 'Release a Lien' not found: " );
        }
    return ItemUnderTest;
    }
    public String findPrice(WebDriver driver) {
        String PriceUnderTest = null;
        try {
            PriceUnderTest = driver.findElement(By.xpath("//span[@class='price-amount' and contains(text(), '$149')]")).getText();
        } catch (NoSuchElementException e) {
            // Handle the exception (e.g., log it, print a message)
            System.out.println("Element with price '$149' not found: " );
        }
        return PriceUnderTest;
    }


}
