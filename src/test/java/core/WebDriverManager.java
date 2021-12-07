package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

import static utils.Utils.getTestProperty;


public class WebDriverManager {

    public static WebDriver driver;

    /**
     * Seleciona o tipo de browser que será inicializado para o teste de acordo com a testsettings.properties.
     *
     */
    public static void openBrowser() {
        switch (getTestProperty("browserType").toLowerCase()) {
            case "chrome":
                openApplicationChrome();
                break;
            case "ie":
                openApplicationIE();
                break;
            case "firefox":
                openApplicationFirefox();
                break;
            case "edge":
                openApplicationEdge();
                break;
            case "safari":
                openApplicationSafari();
                break;
            default:
                System.err.print("Browser não mapeado, ecolha outro browser");
                break;
        }
        driver.manage().deleteAllCookies();
        System.out.println("\nStatus: Em execucão no browser " + getTestProperty("browserType") + "...\n");

    }


    /**
     * Inicialização do browser Firefox com auxilio da libary webdrivermanager
     */
    private static void openApplicationFirefox() {
        io.github.bonigarcia.wdm.WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
    }

    /**
     * Inicialização do browser Chrome com auxilio da libary webdrivermanager
     */
    private static void openApplicationChrome() {
        io.github.bonigarcia.wdm.WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    /**
     * Inicialização do browser Edge com auxilio da libary webdrivermanager
     */
    private static void openApplicationEdge() {
        io.github.bonigarcia.wdm.WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.manage().window().maximize();
    }

    /**
     * Inicialização do browser Safari com auxilio da libary webdrivermanager
     */
    private static void openApplicationSafari() {
        driver = new SafariDriver();
        driver.manage().window().maximize();
    }

    /**
     * Inicialização do browser Internet Explorer com auxilio da libary webdrivermanager
     */
    private static void openApplicationIE() {
        io.github.bonigarcia.wdm.WebDriverManager.iedriver().setup();
        driver = new InternetExplorerDriver();
        driver.manage().window().maximize();
    }

    /**
     * Retorna o browser inicialzado
     *
     * @return
     */
    public static WebDriver getDriver() {
        return driver;
    }

    /**
     * Navegar de acordo com o sistema mapeado pelo propreties
     *
     * @param sistemEveriment
     */
    public static void navigateToURLProperty(String sistemEveriment) {
        driver.navigate().to(getTestProperty(sistemEveriment));
    }

    /**
     * Navegar direto pela URL parametrizada
     *
     * @param url
     */
    public static void navigateTo(String url) {
        driver.navigate().to(url);
    }

    /**
     * Fecha todos os browsers aberto e retorna a variavel driver para null
     */
    public static void closeAllBrowser(){
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
