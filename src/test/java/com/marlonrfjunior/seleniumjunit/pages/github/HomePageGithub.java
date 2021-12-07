package com.marlonrfjunior.seleniumjunit.pages.github;


import com.marlonrfjunior.seleniumjunit.attributes.github.HomeAttributesGithub;
import com.marlonrfjunior.seleniumjunit.core.WebDriverManager;
import org.openqa.selenium.support.PageFactory;

public class HomePageGithub extends HomeAttributesGithub {
    public HomePageGithub() {
        PageFactory.initElements(WebDriverManager.getDriver(), this);
    }

    public void searchOnGithub( String  value) {
        setText(inputSearch,value);
        click(btnSearch(value));
    }

}
