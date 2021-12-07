package com.marlonrfjunior.seleniumjunit.steps.github;

import com.marlonrfjunior.seleniumjunit.pages.github.ProfilePageGithub;


public class ProfileStepsGithub {


    public void verifyProfile() {
        new ProfilePageGithub().verification();
    }

}


