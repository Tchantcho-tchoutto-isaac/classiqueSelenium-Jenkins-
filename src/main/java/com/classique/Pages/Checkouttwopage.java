package com.classique.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Checkouttwopage {
@FindBy (id = "finish")
private WebElement finishbutonelement ;

public Checkouttwopage (WebDriver webDriver){
     PageFactory.initElements(webDriver, this);

}

public void clickfinish(){
    finishbutonelement.click();
}
    
}
