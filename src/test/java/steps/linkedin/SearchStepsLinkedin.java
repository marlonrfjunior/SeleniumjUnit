package steps.linkedin;

import pages.linkedin.SearchPageLinkedin;

public class SearchStepsLinkedin {

    public void searchPerfil(String name, String lastName) {
        new SearchPageLinkedin().searchPerfil(name, lastName);
    }

    public void selectPerfil(String title, String name) {
        new SearchPageLinkedin().selectPerfil(title, name);
    }
}
