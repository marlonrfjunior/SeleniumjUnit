package com.marlonrfjunior.seleniumjunit.steps.github;

import com.marlonrfjunior.seleniumjunit.pages.github.HomePageGithub;
import com.marlonrfjunior.seleniumjunit.pages.github.SearchPageGithub;


public class HomeStepsGithub {



    public void searchOnGit(String optionSearch, String valueSearch) {
        new HomePageGithub().searchOnGithub(valueSearch);
        new SearchPageGithub().searchOnGithub(optionSearch,valueSearch);
    }

}


