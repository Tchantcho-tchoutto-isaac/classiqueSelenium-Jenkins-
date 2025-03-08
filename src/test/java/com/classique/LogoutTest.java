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

public class LogoutTest {

    private WebDriver webDriver ;
    private LoginPage loginPage ;
    private ProductsPage productsPage ;
   

    @BeforeEach
    public void setUp() {
        webDriver  = new ChromeDriver();
        webDriver.get("https://www.saucedemo.com/");

       
        loginPage = new LoginPage(webDriver);
        productsPage = new ProductsPage(webDriver);
        loginPage.saisirUserName("standard_user");
        loginPage.saisirPassword("secret_sauce");
        loginPage.cliqueSurLogin();
    }


    @Tag("logoutTest")
    @Test
    public void LogoutTest() {
        productsPage.menuburgerclick();
        productsPage.logout();
        assertTrue(webDriver.getCurrentUrl().equals("https://www.saucedemo.com/"), "L'utilisateur n'a pas été redirigé vers la page de connexion.");
        
        System.out.println("Test reussi : L'utilisateur a ete deconnect et redirigé vers la page de connexion.");
        
   }
}
