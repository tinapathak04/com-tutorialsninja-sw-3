package laptopsandnotebooks;

import Utilities.Utility;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LaptopsAndNotebooks extends Utility {

    String baseUrl = "http://tutorialsninja.com/demo/index.php?";

    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }
    public void selectMyAccountOption(String option){
        List<WebElement> options = driver.findElements(By.linkText(option));
        for(WebElement element:options){
            element.click();
        }

    }
    @Test
    public void verifyProductsPriceDisplayHighToLowSuccessfully() {

        //1.1 Mouse hover on Laptops & Notebooks Tab.and click
        mouseHover(By.xpath("//a[text()='Laptops & Notebooks']"), By.xpath("//a[text()='Laptops & Notebooks']"));

        //1.2 Click on “Show All Laptops & Notebooks”
        clickOnElement(By.xpath("//a[contains(text(),'Show AllLaptops & Notebooks')]"));
        //1.3 Select Sort By "Price (High > Low)"
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='input-sort']"), "Price (High > Low)");
        //1.4 Verify the Product price will arrange in High to Low order.
        String expectedText = "Price (High > Low)";
        String actualText = getTextFromElement(By.xpath("//select[@id='input-sort']"));
        Assert.assertEquals("Message not found", expectedText, actualText);
    }
    @Test
    public void verifyThatUserPlaceOrderSuccessfully() {

        //2.1 Mouse hover on Laptops & Notebooks Tab and click
        mouseHover(By.xpath("//a[text()='Laptops & Notebooks']"), By.xpath("//a[text()='Laptops & Notebooks']"));
        //2.2 Click on “Show All Laptops & Notebooks”
        clickOnElement(By.xpath("//a[contains(text(),'Show AllLaptops & Notebooks')]"));
        //2.3 Select Sort By "Price (High > Low)"
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='input-sort']"), "Price (High > Low)");
        //2.4 Select Product “MacBook”
        clickOnElement(By.xpath("//a[text()='MacBook']"));
        //2.5 Verify the text “MacBook”
        String expectedText = "MacBook";
        String actualText = getTextFromElement(By.xpath("//h1[contains(text(),'MacBook')]"));
        Assert.assertEquals("Message not found", expectedText, actualText);

        //2.6 Click on ‘Add To Cart’ button
        clickOnElement(By.xpath("//button[@id='button-cart']"));

        // 2.7 Verify the message “Success: You have added MacBook to your shopping cart!”
//        String expectedText1 = "Success: You have added MacBook to your shopping cart!";
//        String actualText1 = getTextFromElement(By.xpath("//div[@class='alert alert-success alert-dismissible']"));
//        Assert.assertEquals("Message not found", expectedText1, actualText1);

        //2.8 Click on link “shopping cart” display into success message
        clickOnElement(By.xpath("//span[contains(text(),'Shopping Cart')]"));
        // 2.9 Verify the text "Shopping Cart"
        String expectedText2 = "Shopping Cart";
        String actualText2 = getTextFromElement(By.partialLinkText("Shopping "));
        Assert.assertEquals("Message not found", expectedText2, actualText2);

        //2.10 Verify the Product name "MacBook"
        String expectedText3 = "MacBook";
        String actualText3 = getTextFromElement(By.partialLinkText("MacBook"));
        Assert.assertEquals("Message not found", expectedText3, actualText3);

        //2.11 Change Quantity "2"
        driver.findElement(By.xpath("//input[@name='quantity[32350]']")).clear();
        sendTextToElement(By.xpath("//input[@name='quantity[32350]']"), "2");

        //2.12 Click on “Update”Tab
        clickOnElement(By.xpath("//i[@class='fa fa-refresh']"));

        //2.13 Verify the message “Success: You have modified your shopping cart!”
        String expectedText4 = "Success: You have modified your shopping cart!";
        String actualText4 = getTextFromElement(By.xpath("//body/div[@id='checkout-cart']/div[1]"));
        Assert.assertEquals("Message not found", expectedText4, actualText4);

        //2.14 Verify the Total $1,204.00
        String expectedText5 = "$1,204.00";
        String actualText5 = getTextFromElement(By.xpath("//div[@class='col-sm-4 col-sm-offset-8']//td[text()='$1,204.00']"));
        Assert.assertEquals("Message not found", expectedText5, actualText5);

        //2.15 Click on “Checkout” button
        clickOnElement(By.xpath("//a[contains(text(),'Checkout')]"));
        //2.16 Verify the text “Checkout”
        String expectedText6 = "Checkout";
        String actualText6 = getTextFromElement(By.xpath("//h1[contains(text(),'Checkout')]"));
        Assert.assertEquals("Message not found", expectedText6, actualText6);

        // 2.17 Verify the Text “New Customer”
        String expectedText7 = "New Customer";
        String actualText7 = getTextFromElement(By.xpath("//h2[contains(text(),'New Customer')]"));
        Assert.assertEquals("Message not found", expectedText7, actualText7);


        //2.18 Click on “Guest Checkout” radio button
        clickOnElement(By.xpath("//input[@value='guest']"));


        //2.19 Click on “Continue” tab
        clickOnElement(By.xpath("//input[@id='button-account']"));

        // 2.20 Fill the mandatory fields
        sendTextToElement(By.xpath("//input[@id='button-account']"), "Tina");
        sendTextToElement(By.xpath("//input[@id='button-account']"), "Pathak");
        sendTextToElement(By.xpath("//input[@id='input-payment-email']"), "tinaP@yahoo.com");
        sendTextToElement(By.xpath("//input[@id='input-payment-telephone']"), "07867854422");
        sendTextToElement(By.xpath("//input[@id='input-payment-address-1']"), "Flat 4");
        sendTextToElement(By.xpath("//input[@id='input-payment-address-2']"), "Christchurch avenue");
        sendTextToElement(By.xpath("//input[@id='input-payment-city']"), "London");
        sendTextToElement(By.xpath("//input[@id='input-payment-postcode']"), "HA0 1TR");
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='input-payment-country']"), "United Kingdom");
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='input-payment-zone']"), "Greater London");

        //2.21 Click on “Continue” Button
        clickOnElement(By.xpath("//input[@id='button-guest']"));

        //2.22 Add Comments About your order into text area
        sendTextToElement(By.xpath("//textarea[@name='comment']"), "If no one open the door,please drop at Flat no 5.Thank you!");
        //2.23 Check the Terms & Conditions check box
        clickOnElement(By.xpath("//input[@type='checkbox']"));

        //2.24 Click on “Continue” button
        clickOnElement(By.xpath("//input[@id='button-payment-method']"));


        //2.25 Verify the message “Warning: Payment method required!”
        String expectedText8 = "Warning: Payment method required!";
        String actualText8 = getTextFromElement(By.xpath("//div[text()='Warning: Payment method required!']"));
        Assert.assertEquals("Message not found", expectedText8, actualText8);
    }

    @Test
    public void verifyThatUserRegisterAccountSuccessfully(){
       // 3.1 Clickr on My Account Link.
        clickOnElement(By.xpath("//span[contains(text(),'My Account')]"));

       // 3.2 Call the method “selectMyAccountOptions” method and pass the parameter “Register”
        selectMyAccountOption("Register");//a[contains(text(),'Register')]
       // 3.3 Enter First Name
        sendTextToElement(By.xpath("//input[@id='button-account']"), "Tina");
       // 3.4 Enter Last Name
        sendTextToElement(By.xpath("//input[@id='button-account']"), "Pathak");
       // 3.5 Enter Email
        sendTextToElement(By.xpath("//input[@id='input-payment-email']"), "tinaP@yahoo.com");
        //3.6 Enter Telephone
        sendTextToElement(By.xpath("//input[@id='input-payment-telephone']"), "07867854422");
        //3.7 Enter Password
        sendTextToElement(By.xpath("//input[@id='input-password']"),"tina123");
        //3.8 Enter Password Confirm
        sendTextToElement(By.xpath("//input[@id='input-confirm']"),"tina123");
        //3.9 Select Subscribe Yes radio button
        clickOnElement(By.id("name"));


        //3.10 Click on Privacy Policy check box
        clickOnElement(By.xpath("//input[@name='agree']"));

        //3.11 Click on Continue button
        clickOnElement(By.xpath("//input[@value='Continue']"));

        //3.12 Verify the message “Your Account Has Been Created!”
        String expectedText = "Your Account Has Been Created!";
        String actualText = getTextFromElement(By.xpath("//h1[contains(text(),'Your Account Has Been Created!')]"));
        Assert.assertEquals("Message not found", expectedText, actualText);

        //3.13 Click on Continue button
        clickOnElement(By.xpath("//a[contains(text(),'Continue')]"));

        //3.14 Click on My Account Link.
        clickOnElement(By.xpath("//div[@class='list-group']//a[text()='My Account']"));

        //3.15 Call the method “selectMyAccountOptions” method and pass the parameter “Logout”
        selectMyAccountOption("Logout");
        //3.16 Verify the text “Account Logout”
        String expectedText1 = "Account Logout";
        String actualText1 = getTextFromElement(By.xpath("//h1[contains(text(),'Account Logout')]"));
        Assert.assertEquals("Message not found", expectedText1, actualText1);


        //3.17 Click on Continue button
        clickOnElement(By.xpath("//a[contains(text(),'Continue')]"));

    }

    @Test
    public void verifyThatUserShouldLoginAndLogoutSuccessfully(){
        //4.1 Clickr on My Account Link.
        clickOnElement(By.xpath("//span[contains(text(),'My Account')]"));
        //4.2 Call the method “selectMyAccountOptions” method and pass the parameter “Login”
        selectMyAccountOption("Login");
        //4.3 Enter Email address
        sendTextToElement(By.xpath("//input[@id='input-payment-email']"), "tinaP@yahoo.com");

        //4.4 Enter Last Name
        sendTextToElement(By.xpath("//input[@id='button-account']"), "Pathak");
        //4.5 Enter Password
        sendTextToElement(By.xpath("//input[@id='input-password']"),"tina123");
        //4.6 Click on Login button
         clickOnElement(By.xpath("//input[@value='Login']"));
        //4.7 Verify text “My Account”
        String expectedText = "My Account";
        String actualText = getTextFromElement(By.xpath("//h2[contains(text(),'My Account')]"));
        Assert.assertEquals("Message not found", expectedText, actualText);
        //4.8 Clickr on My Account Link.
        clickOnElement(By.xpath("//span[contains(text(),'My Account')]"));

        //4.9 Call the method “selectMyAccountOptions” method and pass the parameter “Logout”
         selectMyAccountOption("Logout");
        //4.10 Verify the text “Account Logout”
        String expectedText1 = "Account Logout";
        String actualText1 = getTextFromElement(By.xpath("//h1[contains(text(),'Account Logout')]"));
        Assert.assertEquals("Message not found", expectedText1, actualText1);

        //4.11 Click on Continue button
        clickOnElement(By.xpath("//a[contains(text(),'Continue')]"));


    }



    @After
    public void tearDown(){
        driver.quit();
    }


}
