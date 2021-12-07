package steps;


import static core.WebDriverManager.*;

public class LoadStepSystems {

    public  void loadLinkedin() {
        openBrowser();
        navigateToURLProperty("linkedin");
    }

    public  void loadGitHub() {
        openBrowser();
        navigateToURLProperty("github");
    }
}
