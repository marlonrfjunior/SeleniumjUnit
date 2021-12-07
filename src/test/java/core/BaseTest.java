package core;


import org.junit.BeforeClass;
import utils.Utils;
import org.junit.Rule;
import org.junit.rules.TestName;

import java.io.File;


public class BaseTest {


    @Rule
	public TestName testName = new TestName();

    @BeforeClass
    public static void beforeScenario() {
        Utils.setEnvironment();
        new File("target/report").mkdir();
        new File("target/report/Screenshoots").mkdir();
        Utils.deleteAllFilesInFolder("target/report/Screenshoots");
    }

}
