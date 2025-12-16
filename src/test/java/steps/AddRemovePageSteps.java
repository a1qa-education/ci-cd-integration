package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.AddRemovePage;

public class AddRemovePageSteps {
    private final AddRemovePage addRemovePage = new AddRemovePage();

    @When("user click Add button")
    public void clickAddButton() {
        addRemovePage.clickAddElementBtn();
    }

    @Then("remove button is displayed")
    public void removeButtonDisplayed() {
        Assert.assertTrue(addRemovePage.isRemoveBtnDisplayed(), "remove button is not displayed");
    }
}
