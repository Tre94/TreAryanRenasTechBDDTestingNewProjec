package CucumberProject.Pages;

import CucumberProject.Utils.Common;
import CucumberProject.Utils.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentPage {
    public PaymentPage() {
        PageFactory.initElements(Driver.Driver(), this);}


    @FindBy(xpath = "//input[@id='card_nmuber']")
    private WebElement cardNumber;
    @FindBy(id = "month")
    private WebElement expMonth;
    @FindBy(id = "year")
    private WebElement expYear;
    @FindBy(id = "cvv_code")
    private WebElement cvvCode;
    @FindBy(xpath = "//input[@name='submit']")
    private WebElement payButton;

    public WebElement getCardNumber() {
        return cardNumber;
    }

    public WebElement getExpMonth() {
        return expMonth;
    }

    public WebElement getExpYear() {
        return expYear;
    }

    public WebElement getCvvCode() {
        return cvvCode;
    }

    public void setPayButton(){
        Common.clickWithWait(payButton);
    }
    @FindBy(xpath = "//h2[.='Payment successfull!']")
    private WebElement paymentSuccessfull;

    public WebElement getPaymentSuccessfull() {
        return paymentSuccessfull;
    }

}
