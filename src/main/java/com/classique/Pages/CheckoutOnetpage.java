package com.classique.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutOnetpage {
@FindBy(id="first-name")
private WebElement firstnameeElement;

@FindBy(id="last-name")
private WebElement lastnameelElement;

@FindBy(id="postal-code")
private WebElement postalcodeElement;
@FindBy(id = "continue")
private WebElement continuButoElement ;

public CheckoutOnetpage (WebDriver webDriver){
     PageFactory.initElements(webDriver, this);
}

public void addfirstname ( String firstname){
    firstnameeElement.sendKeys(firstname);
}

public void addlastname ( String lastname){
    lastnameelElement.sendKeys(lastname);
}

public void addpostal ( String postal){
    postalcodeElement.sendKeys(postal);
}

public void clickcontinue(){
    continuButoElement.click();
}

}
