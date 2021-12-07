package com.marlonrfjunior.seleniumjunit.pages.github;


import com.marlonrfjunior.seleniumjunit.attributes.github.SearchAttributesGithub;
import com.marlonrfjunior.seleniumjunit.core.WebDriverManager;
import org.openqa.selenium.support.PageFactory;

public class SearchPageGithub extends SearchAttributesGithub {
    public SearchPageGithub() {
        PageFactory.initElements(WebDriverManager.getDriver(), this);
    }

    public void searchOnGithub(String optionSearch, String  value) {
        click(selectTypeResult(optionSearch));
        click(selectProfileResult(value));
    }

}
