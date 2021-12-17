package CucumberProject.Pages;

import CucumberProject.Utils.Common;
import CucumberProject.Utils.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class HomePage  {

    public HomePage() {
        PageFactory.initElements(Driver.Driver(), this);}


    @FindBy(xpath =  "//h2[contains(text(),'Mother Elephant With Babies Soft Toy')]")
    private WebElement pageHeader;
    @FindBy(xpath = "//h3[.='Price: $20']")
    private WebElement toyPrice;
    @FindBy(xpath = "//select[@name='quantity']")
    private WebElement quantity;
    @FindBy(xpath = "//input[@type='submit']")
    private WebElement buyNow;




    public WebElement getHeader() {

        return pageHeader;
    }

    public WebElement getToyPrice() {

        return toyPrice;
    }


    public void setQuantity(String setQuantity){

        Select select=new Select(quantity);
        select.selectByValue(setQuantity); }



    public void clickBuyNow(){
        Common.clickWithWait(buyNow);
    }



}