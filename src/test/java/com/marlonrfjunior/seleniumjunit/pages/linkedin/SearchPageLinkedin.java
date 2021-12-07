package com.marlonrfjunior.seleniumjunit.pages.linkedin;

import com.marlonrfjunior.seleniumjunit.attributes.linkedin.SearchAttributesLinkedin;
import com.marlonrfjunior.seleniumjunit.core.WebDriverManager;
import org.openqa.selenium.support.PageFactory;

public class SearchPageLinkedin extends SearchAttributesLinkedin {
    public SearchPageLinkedin() {
        PageFactory.initElements(WebDriverManager.getDriver() , this);
    }


    public void searchPerfil(String name, String lastName) {
        fixedWait(3);
        setText(labelName, name);
        setText(labelLastName, lastName);
        click(btnSearchPerfil);
    }

    public  void selectPerfil(String title, String name){
        fixedWait(3);
        click(cardPefil(title,name));
    }
}
