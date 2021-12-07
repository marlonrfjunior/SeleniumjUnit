package attributes.github;

import core.DSL;
import org.openqa.selenium.WebElement;


public class SearchAttributesGithub extends DSL {

    protected WebElement selectTypeResult(String option) {
        return findElementByXpath("//nav/a[contains(text(),'"+option+"')]");}

    protected WebElement selectProfileResult(String value) {
        return findElementByXpath("//div/a[@href='/" + value + "']");}

}
