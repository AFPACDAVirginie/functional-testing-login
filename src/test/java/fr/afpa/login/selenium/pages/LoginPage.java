package fr.afpa.login.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import fr.afpa.login.selenium.SeleniumConfig;

/**
 * Classe représentant la page de login de l'application à tester.
 * 
 * Permet d'alléger la classe de test et de ne pas la modifier si
 * 
 * Responsabilité de la classe : manipule le DOM pour récupérer/modifier les
 * éléments de la page de Login
 */
public class LoginPage {

    /**
     * Référence vers la classe permettant d'accéder au WebDriver
     */
    private SeleniumConfig config;

    /**
     * Url de la page représentée
     */
    private String url = "";

    public LoginPage(SeleniumConfig seleniumConfig) {
        config = seleniumConfig;
        url = config.getServerUrl() + "/login";
        config.getWebDriver().get(url);
    }

    /**
     * @return Le titre de la page
     */
    public String getTitle() {
        return this.config.getWebDriver().getTitle();
    }

    /**
     * @return Input correspondant au nom de l'utilisateur.
     */
    public WebElement getNameInput() {
        // TODO retourner l'input "username"
        // Documentation :
        // https://www.selenium.dev/documentation/webdriver/elements/finders/
        return this.config.getWebDriver().findElement(By.name("username"));
    }

    /**
     * 
     * @return Input correspondant au mot de passe de l'utilisateur.
     */
    public WebElement getPasswordInput() {
        // TODO retourner l'input "password"
        // Documentation :
        // https://www.selenium.dev/documentation/webdriver/elements/finders/
        return this.config.getWebDriver().findElement(By.name("password"));
    }

    /**
     * @return Input correspondant au bouton "envoyer".
     */
    public WebElement getSubmitInput() {
        // TODO retourner l'input "submit"
        // Documentation :
        // https://www.selenium.dev/documentation/webdriver/elements/finders/
        return this.config.getWebDriver().findElement(By.cssSelector(".input-button"));
    }

    /**
     * @return Le "p" correspondant au message d'erreur lors d'une tentative
     *         infructueuse
     */
    public WebElement getErrorMessageParagraph() {
        // TODO retourner le paragraphe contenant le message d'erreur
        // Documentation :
        // https://www.selenium.dev/documentation/webdriver/elements/finders/

        return this.config.getWebDriver().findElement(By.tagName("p"));
    }

    /**
     * @return L'url de la page
     */
    public String getUrl() {
        return url;
    }
}
