package fr.afpa.login.selenium;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import org.springframework.boot.test.context.SpringBootTest;

import fr.afpa.login.selenium.pages.LoginPage;

/**
 * Classe d'automatisation des tests basés sur Selenium.
 * JUnit permet d'implémenter le lancement des tests.
 * 
 * Attention : BIEN PENSER A LANCER L'APPLICATION AVANT DE LANCER LES TESTS
 */
@SpringBootTest
class LoginSeleniumTests {

    private static SeleniumConfig seleniumConfig;
    private static LoginPage loginPage;

    /**
     * Méthode qui s'effectue avant tout autre test.
     * Permet d'initialiser les variables nécessaires à l'interaction avec la page de login
     */
    @BeforeAll
    static void initLoginPage() {
        // intanciation du paramétrage Selenium (WebDriver est en donnée membre de SeleniumConfig)
        seleniumConfig = new SeleniumConfig();
        // chargement de "LoginPage"
        loginPage = new LoginPage(seleniumConfig);
    }

    /**
     * Assure la simulation de la saisie utilisateur dans les "inputs"
     * @param username Le nom de l'utilisateur
     * @param password Le mot de passe de l'utilisateur
     */
    static void sendKeysToInputs(String username, String password) {
        // récupération de l'input "username"
        WebElement nameInput = loginPage.getNameInput();
        // TODO mise à jour du texte de l'input "username"
        // Documentation : https://www.selenium.dev/documentation/webdriver/elements/interactions/


        // TODO mise à jour du texte de l'input "password"

    }

    /**
     * Permet de fermer la fenêtre de test à la fin de tous les tests
     */
    @AfterAll
    static void afterAllTestsCloseWindow() {
        // TODO fermer la fenêtre en utilisant WebDriver
        // Documentation : 

    }

    /**
     * Test la connexion avec un utilisateur autorisé.
     */
    @Test
    void connectionWithAuthorizedUser() {
        // on force la navigation sur la page de login, quoiqu'il arrive
        seleniumConfig.getWebDriver().navigate().to(loginPage.getUrl());

        // saisie du texte dans les inputs
        sendKeysToInputs("ada_lovelace", "supersecured");

        // TODO effectuer le click sur l'input "submit"


        // TODO vérification de la bonne redirection
        // Question à se poser : quels sont les critères qui peuvent attester de la bonne redirection ?
        // Documentation intéressante :
        // - https://www.selenium.dev/documentation/webdriver/interactions/#get-current-url
        // - https://www.selenium.dev/documentation/webdriver/interactions/#get-title

    }

    /**
     * Test de la connexion avec un utilisateur non autorisé
     */
    @Test
    void connectionWithUnauthorizedUser() {
        // TODO saisie du texte dans les inputs
        

        // TODO effectuer le click sur l'input "submit"


        // TODO vérification de la NON redirection et du message d'erreur
        // Documentation utile :
        // https://www.selenium.dev/documentation/webdriver/interactions/#get-current-url
        // https://www.selenium.dev/selenium/docs/api/java/org/openqa/selenium/WebElement.html#getText()
  
    }

    /**
     * Test de la connexion avec un utilisateur autorisé suivi de la redirection vers une page non existante
     */
    @Test
    void connexionWithAuthorizedUserAndIncorrectNavigation() {
        // saisie du texte dans les inputs
        sendKeysToInputs("ada_lovelace", "supersecured");
        // click sur le bouton submit
        WebElement inputSubmit = loginPage.getSubmitInput();
        inputSubmit.click();

        // TODO effectuer la navigation vers une page non existante 
        // Documentation : https://www.selenium.dev/documentation/webdriver/interactions/navigation/
        
        
        // TODO vérification d'une caractéristique de la page d'erreur

    }
}
