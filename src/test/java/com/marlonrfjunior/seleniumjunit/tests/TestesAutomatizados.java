package com.marlonrfjunior.seleniumjunit.tests;


import com.marlonrfjunior.seleniumjunit.core.BaseTest;
import com.marlonrfjunior.seleniumjunit.steps.LoadStepSystems;
import com.marlonrfjunior.seleniumjunit.steps.github.HomeStepsGithub;
import com.marlonrfjunior.seleniumjunit.steps.github.ProfileStepsGithub;
import com.marlonrfjunior.seleniumjunit.steps.linkedin.HomeStepsLinkedin;
import com.marlonrfjunior.seleniumjunit.steps.linkedin.ResumeStepsLinkedin;
import com.marlonrfjunior.seleniumjunit.steps.linkedin.SearchStepsLinkedin;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static com.marlonrfjunior.seleniumjunit.core.WebDriverManager.closeAllBrowser;


public class TestesAutomatizados extends BaseTest {



	@Before
	public void initialize(){

	}

	@After
	public void finaliza(){
        closeAllBrowser();
	}
	
	@Test
	public void SearchMarlonLinkedinProfile(){
        new LoadStepSystems().loadLinkedin();
		new HomeStepsLinkedin().searchPeople();
        new SearchStepsLinkedin().searchPerfil("Marlon", "Junior");
        new ResumeStepsLinkedin().resumeValidation();
	}
    @Test
	public void SearchMarlonGithubProfile(){
        new LoadStepSystems().loadGitHub();
		new HomeStepsGithub().searchOnGit("Users","marlonrfjunior");
        new ProfileStepsGithub().verifyProfile();
	}
	

}
