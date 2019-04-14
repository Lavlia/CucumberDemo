package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class SVHomePage extends BasePage {

    public SVHomePage() {
        super();
        PageFactory.initElements(getDriver(), this);
    }

    WebElement element;

    @FindBy(xpath = "//ul[@class ='pagination dark']/li")
    private WebElement leftMainMenuContainer;

    public WebElement getLeftMainMenuContainer() {
        return leftMainMenuContainer;
    }

    public void clickOnLinkLeftMainMenu(String linkButton) {
        element = getDriver().findElement(By.xpath("//ul[@class ='pagination dark']/li/a/span[contains(text(),'" + linkButton + "')]"));
        element.click();
    }

    public void verifyElementTitle(String elementTitle) {
        Assert.assertTrue(element.getAttribute("textContent").equals(elementTitle));
    }

}
