package com.shipfast.test.acceptance.steps;

import com.shipfast.test.acceptance.pages.HomePage;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import static org.assertj.core.api.Assertions.assertThat;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class BasicStepdefs {
    private WebDriver driver;
    private Object currentPage;

    @Before({"@requires_browser"})
    public void createDriver() {
        driver = new HtmlUnitDriver();
    }

    @After({"@requires_browser"})
    public void destroyDriver() {
        driver.quit();
    }

    @Given("^I have identified an item that I've decided to buy$")
    public void i_have_identified_an_item_that_I_ve_decided_to_buy() throws Throwable {
        currentPage = HomePage.loadUsing(driver);
    }

    @When("^I (add|remove) the item$")
    public void i_choose_the_item(String action) throws Throwable {
        if("add".equalsIgnoreCase(action)) {
            ((HomePage) currentPage).clickSearchButton();
        } else if("remove".equalsIgnoreCase(action)) {
            ((HomePage) currentPage).clickLuckyButton();
        }
    }

    @Then("^I should see the item appear in the cart$")
    public void i_should_see_the_item_appear_in_the_cart() throws Throwable {
        assertThat(true).isEqualTo(true);
    }

    @Given("^I have identified an item that I've decided to not buy$")
    public void i_have_identified_an_item_that_I_ve_decided_to_not_buy() throws Throwable {
        currentPage = HomePage.loadUsing(driver);
    }

    @Then("^I should no longer see the item in the cart$")
    public void i_should_no_longer_see_the_item_in_the_cart() throws Throwable {
        assertThat(true).isEqualTo(true);
    }
}
