package attributes.github;

import core.DSL;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class HomeAttributesGithub extends DSL {

    @FindBy(xpath = "//input[@placeholder='Search GitHub']")
    protected WebElement inputSearch;

    protected WebElement btnSearch(String option) {
        return findElementByXpath("//a[@href='https://github.com/search?q=" + option + "']");}

}
