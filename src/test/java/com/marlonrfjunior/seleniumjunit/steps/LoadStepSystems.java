package com.marlonrfjunior.seleniumjunit.steps;


import static com.marlonrfjunior.seleniumjunit.core.WebDriverManager.*;

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
