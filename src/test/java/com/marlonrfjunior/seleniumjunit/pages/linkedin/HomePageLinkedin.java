package com.marlonrfjunior.seleniumjunit.pages.linkedin;


import com.marlonrfjunior.seleniumjunit.attributes.linkedin.HomeAttributesLinkedin;
import com.marlonrfjunior.seleniumjunit.core.WebDriverManager;
import org.openqa.selenium.support.PageFactory;

public class HomePageLinkedin extends HomeAttributesLinkedin {
    public HomePageLinkedin() {
        PageFactory.initElements(WebDriverManager.getDriver(), this);
    }

    public void searchPeople() {
        click(btnSearchPeople);
    }

}
