package com.marlonrfjunior.seleniumjunit.pages.linkedin;


import com.marlonrfjunior.seleniumjunit.attributes.linkedin.ResumeAttributesLinkedin;
import com.marlonrfjunior.seleniumjunit.core.WebDriverManager;
import org.openqa.selenium.support.PageFactory;

public class ResumePageLinkedin extends ResumeAttributesLinkedin {
    public ResumePageLinkedin() {
        PageFactory.initElements(WebDriverManager.getDriver() , this);
    }

    public void verification(){
        fixedWait(3);
        checkElement(labelAbout);
        checkElement(labelExperience);
        checkElement(labelAcademicEducation);
        checkElement(labelLanguages);
        checkElement(labelRecomendation);
    }


}
