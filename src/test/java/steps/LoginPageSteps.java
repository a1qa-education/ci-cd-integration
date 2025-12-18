package steps;

import enums.LoginStatus;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.LoginPage;

import java.util.List;
import java.util.Map;

public class LoginPageSteps {
    private final LoginPage loginPage = new LoginPage();

    @When("user inputs login {string}")
    public void enterLogin(String login) {
        loginPage.sendTextToUsernameInput(login);
    }

    @When("user inputs password {string}")
    public void enterPassword(String password) {
        loginPage.sendTextToPasswordInput(password);
    }

    @When("user click Login button2")
    public void clickLoginButton() {
        loginPage.clickLoginButton();
    }

    @Then("message about {status} login is displayed")
    public void verifyLoginStatus(LoginStatus status) {
        switch (status) {
            case SUCCESS:
                Assert.assertTrue(loginPage.isSuccessMessageDisplayed(), "Message about a successful login is not displayed");
                break;
            case FAILURE:
                Assert.assertFalse(loginPage.isFailureMessageDisplayed(), "Message about an unsuccessful login is not displayed");
                break;
        }
    }

    @When("user inputs credentials")
    public void userInputsCredentials(DataTable dataTable) {
        List<Map<String, String>> rows = dataTable.asMaps(String.class, String.class);
        if (rows.isEmpty()) {
            throw new IllegalArgumentException("No credentials provided");
        }
        Map<String, String> credentials = rows.get(0);
        loginPage.sendTextToUsernameInput(credentials.get("login"));
        loginPage.sendTextToPasswordInput(credentials.get("password"));
    }
}