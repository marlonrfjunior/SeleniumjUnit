package pages.github;


import attributes.github.HomeAttributesGithub;
import core.WebDriverManager;
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
