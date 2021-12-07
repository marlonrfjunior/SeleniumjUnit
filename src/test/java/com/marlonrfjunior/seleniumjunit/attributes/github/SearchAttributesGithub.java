package com.marlonrfjunior.seleniumjunit.attributes.github;

import com.marlonrfjunior.seleniumjunit.core.DSL;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class SearchAttributesGithub extends DSL {

    protected WebElement selectTypeResult(String option) {
        return findElementByXpath("//nav/a[contains(text(),'"+option+"')]");}

    protected WebElement selectProfileResult(String value) {
        return findElementByXpath("//div/a[@href='/" + value + "']");}

}
