package runner;


import cucumber.api.cli.Main;
import org.testng.annotations.Test;


public class Runner {
    @Test
    public void testRunner() {
        Main.main(new String[]{"--threads", "3",
                "-p", "html:target/reports",
                "-p", "json:target/reports/cucumber.json",
                "-p", "rerun:rerun.txt",
                "-g", "stepDefinition", "src/test/java/features"});
    }
}
