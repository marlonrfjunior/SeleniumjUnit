package pages.github;


import attributes.github.ProfileAttributesGithub;
import core.WebDriverManager;
import org.openqa.selenium.support.PageFactory;

public class ProfilePageGithub extends ProfileAttributesGithub {
    public ProfilePageGithub() {
        PageFactory.initElements(WebDriverManager.getDriver() , this);
    }

    public void verification(){
        fixedWait(3);
        checkElement(labelname);
        checkElement(labelAdditionalName);
        checkElement(labelWorks);
        checkElement(labelLocation);
    }


}
