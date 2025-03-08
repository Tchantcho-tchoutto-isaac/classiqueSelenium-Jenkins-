package com.classique;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.classique.Pages.LoginPage;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

public class LoginTest {

    private WebDriver webDriver;
    private LoginPage loginPage;

    @BeforeEach
    public void teainit() {
        
        webDriver = new ChromeDriver();
        webDriver.get("https://www.saucedemo.com/");
        loginPage = new LoginPage(webDriver);
    }

    @AfterEach
    public void teadown() {
        try {
            Thread.sleep(5000); 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (webDriver != null) {
            webDriver.close();
            webDriver.quit();
        }
    }

    @Tag("login")
    @Test
    public void loginTest() {
        loginPage.saisirUserName("standard_user");
        loginPage.saisirPassword("secret_sauce");
        loginPage.cliqueSurLogin();
        assertTrue(webDriver.getCurrentUrl().equals("https://www.saucedemo.com/inventory.html"));
        System.out.println("Test de connexion validé avec succès.");
    }


}
