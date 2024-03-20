package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class LevelSetHomePage {
//determine elements in homepage


    public WebElement GetPaidbutton(WebDriver driver) {
        By GetPaidXButtonpath = By.xpath("//a[@class='btn btn-info btn-outline mob-dropdown-btn']");
        WebElement GetPaidbutton = driver.findElement(GetPaidXButtonpath);
        return GetPaidbutton;
    }

    public By GetStartedbuttonXpath() {
        By GetStartedBtnXpath = By.xpath("//button[@type='submit' and contains(text(),'Get started')]");
        return GetStartedBtnXpath;
    }

    //preconditons
    //check if page fully loaded  using get started button
    public void HomeLoadedSuccessfully(WebDriver driver) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            By GetStartedXpath = GetStartedbuttonXpath();
            wait.until(ExpectedConditions.visibilityOfElementLocated(GetStartedXpath));
        } catch (
                TimeoutException e) {
            System.out.println("page is not loaded");
        }
    }

    //check if button already appears in page
    public void AlreadyExistsGetPaidButton(WebDriver driver) {
        Boolean DisplayedButton = GetPaidbutton(driver).isDisplayed();
        if (!DisplayedButton) {
            System.out.println("get button is not displayed");
        }
    }

    //check if clickable button
    public void IsGetPaidClickableButton(WebDriver driver) {
        Boolean clickableButton = GetPaidbutton(driver).isEnabled();
        if (!clickableButton) {
            System.out.println("button is not clickable");
        }
    }

    // Wait for the "Get Paid" button to be clickable
    public void WaitGetPaidToBeClickable(WebDriver driver)
    { WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    try

    {
        wait.until(ExpectedConditions.elementToBeClickable(GetPaidbutton(driver)));
    }catch(
    TimeoutException e)

    {
        System.out.println("get paid button not clickable");
    }
   }

    //click on get paid button
    public void ClickOnGetPaidBtn(WebDriver driver){
        Actions actions = new Actions(driver);
        actions.moveToElement(GetPaidbutton(driver)).click().build().perform();
    }
    public void CheckIfSecondPageAppearsSuccessfully(WebDriver driver){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //after clicking button check if the next page appears correctly
        try {
            String XpathOfitem="//*[@class='left' and contains(text(),'Send a Warning')]";
            By LocatorofItem=By.xpath(XpathOfitem);
            wait.until(ExpectedConditions.visibilityOfElementLocated(LocatorofItem));
        }
        catch (TimeoutException e) {
            System.out.println("Send Warning button is not visible");
        };
    }

}
