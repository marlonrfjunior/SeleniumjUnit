package tests;


import core.BaseTest;
import steps.LoadStepSystems;
import steps.github.HomeStepsGithub;
import steps.github.ProfileStepsGithub;
import steps.linkedin.HomeStepsLinkedin;
import steps.linkedin.ResumeStepsLinkedin;
import steps.linkedin.SearchStepsLinkedin;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static core.WebDriverManager.closeAllBrowser;


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
