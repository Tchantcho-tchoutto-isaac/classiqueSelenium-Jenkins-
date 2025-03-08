package com.classique;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.classique.Pages.CartPage;
import com.classique.Pages.LoginPage;
import com.classique.Pages.ProductsPage;
import com.classique.Pages.CheckoutOnetpage;
import com.classique.Pages.Checkouttwopage;

public class CheckoutTest {

    private WebDriver webDriver;
    private LoginPage loginPage;
    private ProductsPage productsPage;
    private CartPage cartPage;
    private CheckoutOnetpage checkoutOnetpage;
    private Checkouttwopage checkouttwopage ;

    @BeforeEach
    public void setUp() {
        
        webDriver = new ChromeDriver();
        webDriver.get("https://www.saucedemo.com/");

        
        loginPage = new LoginPage(webDriver);
        loginPage.saisirUserName("standard_user");
        loginPage.saisirPassword("secret_sauce");
        loginPage.cliqueSurLogin();
        productsPage = new ProductsPage(webDriver);
        cartPage = new CartPage(webDriver); 
        checkoutOnetpage = new CheckoutOnetpage(webDriver);
        checkouttwopage =new Checkouttwopage(webDriver);

        productsPage.addproduit();
        productsPage.checkpanier();

        cartPage.clickcheckoutbuton();
    }

    
    @AfterEach
    public void teadown (){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
           
            e.printStackTrace();
        }
        if (webDriver!=null) {
            webDriver.close();
            webDriver.quit();
        }

    } 

    @Tag("checkouttest")
    @Test
    public void checkoutOneTest() {
        // Remplir le formulaire de commande
        checkoutOnetpage.addfirstname("John");
        checkoutOnetpage.addlastname("Doe");
        checkoutOnetpage.addpostal("12345");

        checkoutOnetpage.clickcontinue();
        checkouttwopage.clickfinish();

        assertTrue(webDriver.getCurrentUrl().contains("checkout-complete.html"), 
            "L'URL après soumission du formulaire de checkout est incorrecte.");
        
        System.out.println("Test reussi : Formulaire de checkout rempli et redirige vers l'etape suivante.");
    }
}
