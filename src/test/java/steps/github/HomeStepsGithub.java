package steps.github;

import pages.github.HomePageGithub;
import pages.github.SearchPageGithub;


public class HomeStepsGithub {



    public void searchOnGit(String optionSearch, String valueSearch) {
        new HomePageGithub().searchOnGithub(valueSearch);
        new SearchPageGithub().searchOnGithub(optionSearch,valueSearch);
    }

}


