import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

//con la anotacion CucumberOptions le digo donde estan los features y le indico que los pegue en donde tengo los steps
@CucumberOptions(features = "src/test/java/features/search.feature", glue = "steps", 
plugin = {"com.vimalselvam.cucumber.listener.ExtentCucumberFormatter:reporte/cucumber/report.html"})
public class RuncCukesTest extends AbstractTestNGCucumberTests {

}
