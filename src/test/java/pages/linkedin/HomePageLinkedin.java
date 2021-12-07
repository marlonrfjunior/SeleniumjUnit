package pages.linkedin;


import attributes.linkedin.HomeAttributesLinkedin;
import core.WebDriverManager;
import org.openqa.selenium.support.PageFactory;

public class HomePageLinkedin extends HomeAttributesLinkedin {
    public HomePageLinkedin() {
        PageFactory.initElements(WebDriverManager.getDriver(), this);
    }

    public void searchPeople() {
        click(btnSearchPeople);
    }

}
