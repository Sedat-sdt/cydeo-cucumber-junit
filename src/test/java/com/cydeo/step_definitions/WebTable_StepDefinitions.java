package com.cydeo.step_definitions;

import com.cydeo.pages.WebTableLoginPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.Map;

public class WebTable_StepDefinitions {

    WebTableLoginPage webTableLoginPage= new WebTableLoginPage();

    @Given("user is on the login page of web table app")
    public void user_is_on_the_login_page_of_web_table_app() {

        String url=ConfigurationReader.getProperty("web.table.url");
        Driver.getDriver().get(url);
        //Driver.getDriver().get(ConfigurationReader.getProperty("web.table.url"));


    }

    @When("user enters username {string}")
    public void userEntersUsername(String string) {

        webTableLoginPage.inputUserName.sendKeys(string);

    }

    @And("user enters password {string}")
    public void userEntersPassword(String string) {

       webTableLoginPage.inputPassword.sendKeys(string);
    }
    @When("user clicks to login button")
    public void user_clicks_to_login_button() {

        webTableLoginPage.loginBtn.click();

    }
    @Then("user should see url contains orders")
    public void user_should_see_url_contains_orders() {

        //Assert.assertTrue(Driver.getDriver().getCurrentUrl().endsWith("orders"));
        //Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("orders"));
        BrowserUtils.verifyUrlContains("orders");

    }


    @When("user enters username {string} password {string} and logins")
    public void userEntersUsernamePasswordAndLogins(String userName, String password) {

       /* webTableLoginPage.inputUserName.sendKeys(userName);
        webTableLoginPage.inputPassword.sendKeys(password);
        webTableLoginPage.loginBtn.click();*/

        webTableLoginPage.login(userName,password);

    }

    @When("user enters below credentials")
    public void user_enters_below_credentials(Map<String, String> credentials) {

        /*System.out.println("credentials.get(\"username\") = " + credentials.get("username"));
        System.out.println("credentials.get(\"password\") = " + credentials.get("password"));*/

        /*webTableLoginPage.inputUserName.sendKeys(credentials.get("username"));
        webTableLoginPage.inputPassword.sendKeys(credentials.get("password"));
        webTableLoginPage.loginBtn.click();*/

        webTableLoginPage.login(credentials.get("username"),credentials.get("password"));





    }




}
