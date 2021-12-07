package pages.github;


import attributes.github.SearchAttributesGithub;
import core.WebDriverManager;
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
