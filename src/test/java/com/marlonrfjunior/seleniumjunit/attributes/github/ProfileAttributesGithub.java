package com.marlonrfjunior.seleniumjunit.attributes.github;

import com.marlonrfjunior.seleniumjunit.core.DSL;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class ProfileAttributesGithub extends DSL {

    @FindBy(xpath = "//span[@itemprop=\"name\"]")
    protected WebElement  labelname;

    @FindBy(xpath = "//span[@itemprop=\"additionalName\"]")
    protected WebElement  labelAdditionalName;

    @FindBy(xpath = "//li[@itemprop=\"worksFor\"]")
    protected WebElement  labelWorks;

    @FindBy(xpath = "//li[@itemprop=\"homeLocation\"]")
    protected WebElement  labelLocation;



}

