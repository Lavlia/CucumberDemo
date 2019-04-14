package stepDefinition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import pageObjects.SVHomePage;
import pageObjects.BaseUtil;

import static pageObjects.BasePage.accessingProperties;

public class SVLeftMainMenuSteps extends BaseUtil {

    SVHomePage homePage = new SVHomePage();

    @Given("^I navigate to Softvision Site$")
    public void iNavigateToSoftvisionSite() {
        getDriver().get(accessingProperties("baseUrl"));
    }

    @And("^I click on  every ([^\"]*) in Left Main Menu$")
    public void iClickOnEveryLinkButtonInLeftMainMenu(String linkButton) {
        homePage.clickOnLinkLeftMainMenu(linkButton);
    }

    @Then("^I verify if the link have the proper ([^\"]*)$")
    public void iVerifyIfTheLinkHaveTheProperElementTitle(String elementTitle) {
        homePage.verifyElementTitle(elementTitle);
    }
}
