package com.classique.Pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {

    private WebDriver driver;

    @FindBy(id = "remove-sauce-labs-backpack")
    private WebElement removeButton;
    
    @FindBy(className = "shopping_cart_badge")
    private WebElement cartBadge;
    @FindBy(id = "checkout")
    private WebElement checkoutbutonelement ;
    @FindBy(className = "inventory_details_price")
    private List<WebElement> listPriceElements;

    public CartPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void removeProductFromCart() {
        removeButton.click();
    }

    public boolean isCartEmpty() {
        try {
           // return cartBadge.isDisplayed();

           if (listPriceElements.size() > 0){
            return false;
           }
           else{
            return true;
           }
        } catch (Exception e) {
            return false; 
        }
    }

    public void clickcheckoutbuton(){
        checkoutbutonelement.click();
    }
}
