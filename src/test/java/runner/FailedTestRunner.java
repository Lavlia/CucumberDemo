package runner;

import cucumber.api.cli.Main;
import org.testng.annotations.Test;

public class FailedTestRunner {
    @Test
    public void failedTestRunner() {
        Main.main(new String[]{"--threads", "3",
                "-p", "html:target/reports",
                "-p", "json:target/reports/cucumber.json",
                "-g", "stepDefinition", "@rerun.txt"});
    }
}
