package CucumberProject.StepDefinitions;

import CucumberProject.Pages.HomePage;
import CucumberProject.Pages.PaymentPage;
import CucumberProject.Utils.Common;
import CucumberProject.Utils.ConfigurationReader;
import CucumberProject.Utils.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.junit.Assert;

import java.util.Map;

public class Step_Definitions {
    HomePage home = new HomePage();
    PaymentPage payment= new PaymentPage();

    private static final Logger logger= Logger.getLogger(Step_Definitions.class);



    @Given("The user wants to go to the Guru99 payment Gateway Page")
    public void the_user_wants_to_go_to_the_guru99_payment_gateway_page() {
        logger.info("<<<<<<<<<< This is home page  >>>>>>>>>>");

    }


    @When("The user wants to verify  header as {string}")
    public void the_user_wants_to_verify_header_as(String pageHeader) {
        Assert.assertEquals(home.getHeader().getText(),pageHeader);

        Common.hardWait(3000);

        logger.info("<<<<<<<<<< Verify Header  >>>>>>>>>>");
    }


    @When("The user wants to verify that the toy price is {string}")
    public void the_user_wants_to_verify_that_the_toy_price_is(String toyPrice) {

        Assert.assertTrue(home.getToyPrice().getText().contains(toyPrice));

        logger.info("<<<<<<<<<< Toy price  >>>>>>>>>>");
    }


    @When("The user wants to verify that URL contains {string}")
    public void the_user_wants_to_verify_that_url_contains(String url) {
        Assert.assertTrue((Driver.Driver().getCurrentUrl()).contains(url) );
        Common.hardWait(5000);

        logger.info("<<<<<<<<<< Verify URL  >>>>>>>>>>");
    }






    @When("The user wants to choose quantity of the product as {string}")
    public void the_user_wants_to_choose_quantity_of_the_product_as(String quantity) {
     home.setQuantity(quantity);

        Common.hardWait(2000);

        logger.info("<<<<<<<<<< Quantity of toy  >>>>>>>>>>");
    }

    @When("The user wants to click Buy Now Button")
    public void the_user_wants_to_click_buy_now_button() {
   home.clickBuyNow();

   Common.hardWait(5000);

        logger.info("<<<<<<<<<< buy now   >>>>>>>>>>");

    }

    @When("The user wants to enter card information as")
    public void the_user_wants_to_enter_card_information_as(Map<String,String> dataTable) {
        payment.getCardNumber().sendKeys(dataTable.get("Card"));
        payment.getExpMonth().sendKeys(dataTable.get("expireMonth"));
        payment.getExpYear().sendKeys(dataTable.get("expireYear"));
        payment.getCvvCode().sendKeys(dataTable.get("CVVCode"));

        Common.hardWait(3000);

        logger.info("<<<<<<<<<< visa card information  >>>>>>>>>>");
    }

    @When("The user wants to click pay button")
    public void the_user_wants_to_click_pay_button() {
    payment.setPayButton();

        logger.info("<<<<<<<<<< pay and buy  >>>>>>>>>>");
    }

    @Then("The user should be able to see {string}  text")
    public void the_user_should_be_able_to_see_text(String successful) {
        Assert.assertEquals(payment.getPaymentSuccessfull().getText(),successful);

        logger.info("<<<<<<<<<< verify of payment  >>>>>>>>>>");
    }

}