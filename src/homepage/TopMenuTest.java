package homepage;

import Utilities.Utility;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class TopMenuTest extends Utility {

    String baseUrl =" http://tutorialsninja.com/demo/index.php?";

    public void selectMenu(String menu){

        clickOnElement(By.xpath(menu));

    }
    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }
    @Test
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully() {
        //1.1 Mouse hover on “Desktops” Tab and click
        mouseHover(By.xpath("//a[text()='Desktops']"), By.xpath("//a[text()='Desktops']"));
        //1.2 call selectMenu method and pass the menu = “Show All Desktops”
        selectMenu("//a[contains(text(),'Show AllDesktops')]");
        //1.3 Verify the text ‘Desktops’
        String expectedText = "Desktops";
        String actualText = getTextFromElement(By.xpath("//h2[contains(text(),'Desktops')]"));
        Assert.assertEquals("Message not found", expectedText, actualText);
    }

    @Test
    public void verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully(){

        //2.1 Mouse hover on “Laptops & Notebooks” Tab and click
         mouseHover(By.xpath("//a[text()='Laptops & Notebooks']"),By.xpath("//a[text()='Laptops & Notebooks']"));
        //2.2 call selectMenu method and pass the menu = “Show All Laptops & Notebooks”
         selectMenu("//a[contains(text(),'Show AllLaptops & Notebooks')]");
        //2.3 Verify the text ‘Laptops & Notebooks’
        String expectedText = "Laptops & Notebooks";
        String actualText = getTextFromElement(By.xpath("//h2[contains(text(),'Laptops & Notebooks')]"));
        Assert.assertEquals("Message not found", expectedText, actualText);
    }
    @Test
    public void verifyUserShouldNavigateToComponentsPageSuccessfully(){
        //3.1 Mouse hover on “Components” Tab and click
        mouseHover(By.xpath("//a[text()='Components']"),By.xpath("//a[text()='Components']"));
        //3.2 call selectMenu method and pass the menu = “Show All Components”
        selectMenu("//a[contains(text(),'Show AllComponents')]");
        //3.3 Verify the text ‘Components’
        String expectedText = "Components";
        String actualText = getTextFromElement(By.xpath("//h2[contains(text(),'Components')]"));
        Assert.assertEquals("Message not found", expectedText, actualText);
    }


    @After
     public  void tearDown(){
         driver.quit();
        }





}
