package com.classique;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.classique.Pages.CartPage;
import com.classique.Pages.LoginPage;
import com.classique.Pages.ProductsPage;

public class CartTest {

    private WebDriver webDriver ;
    private LoginPage loginPage ;
    private ProductsPage productsPage ;
    private CartPage cartPage ;

    @BeforeEach
    public void setUp() {
        webDriver  = new ChromeDriver();
        webDriver.get("https://www.saucedemo.com/");

       
        loginPage = new LoginPage(webDriver);
        productsPage = new ProductsPage(webDriver);
        cartPage = new CartPage(webDriver);
        loginPage.saisirUserName("standard_user");
        loginPage.saisirPassword("secret_sauce");
        loginPage.cliqueSurLogin();
    }


    @Tag("removeProduct")
    @Test
    public void removeProductFromCartTest() {
        productsPage.addproduit();

        productsPage.checkpanier();

        cartPage.removeProductFromCart();

        assertTrue(cartPage.isCartEmpty(), "Le panier devrait être vide après avoir supprimé le produit.");

        System.out.println("Test réussi : produit supprimé du panier.");
    }

}
