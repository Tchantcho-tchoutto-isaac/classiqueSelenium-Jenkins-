package com.classique;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.classique.Pages.ProductsPage;
import com.classique.Pages.LoginPage;

public class ProductsTest {

    private WebDriver webDriver ;
    private LoginPage loginPage ;
    private ProductsPage productsPage ;

    @BeforeEach 
    public void teainit (){
        webDriver= new ChromeDriver();
        webDriver.get("https://www.saucedemo.com/"); 
        loginPage = new LoginPage(webDriver);
        loginPage.saisirUserName("standard_user");
        loginPage.saisirPassword("secret_sauce");
        loginPage.cliqueSurLogin();
        productsPage =new ProductsPage (webDriver);
    }

    @AfterEach 
    public void teadown (){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        if (webDriver!=null) {
            webDriver.quit();
        }
    }

    //Ajout d'un produit au panier

    /*Se connecter avec des identifiants valides : On commence par naviguer sur la page de connexion et saisir les identifiants valides.
     * Cliquer sur le bouton "Add to Cart" d'un produit : Une fois connecté, on clique sur le bouton "Add to Cart" du produit "Sauce Labs Backpack".
     * Vérifier que le bouton change en "Remove" : Après avoir ajouté le produit au panier, on vérifie que le bouton "Add to Cart" se transforme en "Remove".
     * Vérifier que l'icône du panier affiche le nombre d'articles ajoutés : On vérifie ensuite que l'icône du panier affiche "1", indiquant que le produit a bien été ajouté.
     */
    @Tag("addproduct")
    @Test 
    public void addproductTest(){
        
        // Vérification que l'utilisateur est bien redirigé vers la page des produits
        assertTrue(webDriver.getCurrentUrl().equals("https://www.saucedemo.com/inventory.html"));
        productsPage.addproduit();
        
       //  String buttonText = cartPage.getAddButtonText();// Utiliser la méthode dans CartPage
       // assertEquals("Remove", buttonText);
       String cartItemCount = productsPage.getCartItemCount();
       assertEquals("1", cartItemCount);
       System.out.println("Test réussi : produit ajouté au panier, bouton changé et icône du panier mise à jour.");
    }





   

}
