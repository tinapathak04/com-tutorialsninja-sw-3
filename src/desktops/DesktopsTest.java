package desktops;

import Utilities.Utility;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class DesktopsTest extends Utility {

    String baseUrl = "http://tutorialsninja.com/demo/index.php?";

    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }
    @Test
    public void verifyProductArrangeInAlphaBaticalOrder() {

        //1.1 Mouse hover on Desktops Tab.and click
        mouseHover(By.xpath("//a[text()='Desktops']"), By.xpath("//a[text()='Desktops']"));
        //1.2 Click on “Show All Desktops”
        clickOnElement(By.xpath("//a[contains(text(),'Show AllDesktops')]"));
        //1.3 Select Sort By position "Name: Z to A"
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='input-sort']"), "Name (Z - A)");
        //1.4 Verify the Product will arrange in Descending order.
//        String expectedText = "Name (Z - A)";
//        String actualText = getTextFromElement(By.xpath("//select[@id='input-sort']"));
//        Assert.assertEquals("Message not found", expectedText, actualText);

        List<WebElement> products = driver.findElements(By.xpath("//div[@class='caption']"));
        System.out.println("Products list in decending order :");
        for (WebElement productsName : products) {
            System.out.println(productsName.getText());
        }
    }
    @Test
    public void verifyProductAddedToShoppingCartSuccessFully(){

        //2.1 Mouse hover on Desktops Tab. and click
        mouseHover(By.xpath("//a[text()='Desktops']"), By.xpath("//a[text()='Desktops']"));
        //2.2 Click on “Show All Desktops”
        clickOnElement(By.xpath("//a[contains(text(),'Show AllDesktops')]"));
        //2.3 Select Sort By position "Name: A to Z"
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='input-sort']"),"Name (A - Z)");
        //2.4 Select product “HP LP3065”
        clickOnElement(By.xpath("//a[contains(text(),'HP LP3065')]"));
        //2.5 Verify the Text "HP LP3065"
        String expectedText = "HP LP3065";
        String actualText = getTextFromElement(By.xpath("//h1[contains(text(),'HP LP3065')]"));
        Assert.assertEquals("Message not found", expectedText, actualText);
        //2.6 Select Delivery Date "2022-11-30"
        String year = "2022";
        String month = "November";
        String date = "30";
        clickOnElement(By.xpath("//i[@class='fa fa-calendar']"));

        //2.7.Enter Qty "1” using Select class.
        sendTextToElement(By.xpath("//input[@id='input-quantity']"),"1");
        //2.8 Click on “Add to Cart” button
        clickOnElement(By.xpath("//button[@id='button-cart']"));
        //2.9 Verify the Message “Success: You have added HP LP3065 to your shopping cart!”
//        String expectedText1 = "Success: You have added HP LP3065 to your shopping cart!";
//        String actualText1 = getTextFromElement(By.xpath("//div[@class='alert alert-success alert-dismissible']"));
//        Assert.assertEquals("Message not found", expectedText1, actualText1);

        //2.10 Click on link “shopping cart” display into success message
        clickOnElement(By.xpath("//span[contains(text(),'Shopping Cart')]"));
        //2.11 Verify the text "Shopping Cart"
        String expectedText2 = "Shopping Cart";
        String actualText2 = getTextFromElement(By.partialLinkText("Shopping "));
        Assert.assertEquals("Message not found", expectedText2, actualText2);

        //2.12 Verify the Product name "HP LP3065"
        String expectedText3 = "HP LP3065";
        String actualText3 = getTextFromElement(By.partialLinkText("HP "));
        Assert.assertEquals("Message not found", expectedText3, actualText3);

        //2.13 Verify the Delivery Date "2022-11-30"
//        String expectedText4 = "Delivery Date:2022-11-30";
//        String actualText4 = getTextFromElement(By.xpath("//small[text()='Delivery Date:2022-11-30']"));
//        Assert.assertEquals("Message not found", expectedText4, actualText4);


        //2.14 Verify the Model "Product21"
        String expectedText5 = "Product 21";
        String actualText5 = getTextFromElement(By.xpath("//td[contains(text(),'Product 21')]"));
        Assert.assertEquals("Message not found", expectedText5, actualText5);

        //2.15 Verify the Total "$122.00"
        String expectedText6 = "$122.00";
        String actualText6 = getTextFromElement(By.xpath("//div[@class='col-sm-4 col-sm-offset-8']//td[text()='$122.00']"));
        Assert.assertEquals("Message not found", expectedText6, actualText6);

    }
    @After
    public void tearDown(){
        driver.quit();
    }

}
