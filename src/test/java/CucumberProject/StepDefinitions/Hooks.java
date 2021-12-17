package CucumberProject.StepDefinitions;

import CucumberProject.Utils.ConfigurationReader;
import CucumberProject.Utils.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.util.concurrent.TimeUnit;

public class Hooks {
    private static final Logger logger= Logger.getLogger(Hooks.class);
    @Before
    public void setup(){
        logger.info(" (^_^) START OF TEST EXECUTION (*_*)");
        Driver.Driver().get(ConfigurationReader.getProperty("Url"));
        Driver.Driver().manage().window().maximize();
        Driver.Driver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

    }

    @After
    public void tearDown(Scenario scenario){
        if (scenario.isFailed()){
            byte[] data = ((TakesScreenshot) Driver.Driver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(data, "image/png", scenario.getName());
            logger.info(" (^_^) END OF TEST EXECUTION (*_*)");
        }
       Driver.closeDriver();
    }
}
