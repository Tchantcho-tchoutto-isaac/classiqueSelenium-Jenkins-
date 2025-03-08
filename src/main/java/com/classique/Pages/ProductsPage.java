package com.classique.Pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductsPage {
    private WebDriver webDriver;
 
   @FindBy(id = "add-to-cart-sauce-labs-backpack")  
   private WebElement addButtonElement;
   @FindBy(className = "shopping_cart_badge")  
   private WebElement cartBadgeElement;
   @FindBy(className = ".btn.btn_secondary.btn_small.cart_button")
   private WebElement removeButtonElement;
   @FindBy(id = "react-burger-menu-btn")
   private WebElement menuburgerelement ;
   @FindBy (id = "logout_sidebar_link")
   private WebElement logoutbuttoElement ;
 
  

   
   public ProductsPage(WebDriver webDriver){
       PageFactory.initElements(webDriver, this);
   }


    public void addproduit(){
        addButtonElement.click();
    }
   
      public String getAddButtonText() {
        return addButtonElement.getText();
    }
    public void checkpanier(){
        cartBadgeElement.click();
    }

  
    public String getCartItemCount() {
        return cartBadgeElement.getText();
    }
    public void removeButtonElement (){
        removeButtonElement.click();
    }

    public void menuburgerclick(){
        menuburgerelement.click();
    }


    public void logout() {
       
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        WebElement logoutBtn = wait.until(ExpectedConditions.elementToBeClickable(logoutbuttoElement));
        logoutBtn.click();
    }
    

}
