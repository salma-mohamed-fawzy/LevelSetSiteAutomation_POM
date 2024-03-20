import org.openqa.selenium.interactions.Actions;
import pages.DocumentPage;
import pages.LevelSetHomePage;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class LevelSet {

    WebDriver ChromeDriver = new ChromeDriver();
    SoftAssert MySoftAssert=new SoftAssert();
    LevelSetHomePage HomePage=new LevelSetHomePage();
    DocumentPage DocumtPge=new DocumentPage();


    @BeforeTest
        public void SetupAndOpeningSite() {
        // 1-go to site
        ChromeDriver.get("https://www.levelset.com/?_ga=2.133352584.742123980.1710677443-314824061.1710677442");
        ChromeDriver.manage().window().maximize();
    };
    @Test
    public void testsOfFirstPage() {
        HomePage.HomeLoadedSuccessfully(ChromeDriver);
        HomePage.AlreadyExistsGetPaidButton(ChromeDriver);
        HomePage.IsGetPaidClickableButton(ChromeDriver);
        HomePage.WaitGetPaidToBeClickable(ChromeDriver);
        HomePage.ClickOnGetPaidBtn(ChromeDriver);
        HomePage.CheckIfSecondPageAppearsSuccessfully(ChromeDriver);

    };
    @Test
    public void testsOfSecondPage () {
        DocumtPge.WaitUntilSecondPageLoads(ChromeDriver);
        String ItemName = DocumtPge.findText(ChromeDriver);
        String ItemPrice =DocumtPge.findPrice(ChromeDriver);
        MySoftAssert.assertEquals(ItemName, "Release a Lien", "Item is not a found correctly");
        MySoftAssert.assertEquals(ItemPrice, "$149", "Price is not correct");
        MySoftAssert.assertAll();
        System.out.println("the elements matched correctly");


    };
    @AfterTest
        public void CloseDriver () {
            ChromeDriver.close();
    };
}



