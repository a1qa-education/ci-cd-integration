package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.Browser;

public abstract class BaseTest {
    protected static final String URL = "https://this-website-is-fake-and-broken111.com/";

    @BeforeMethod
    public void setup() {
        Browser.getInstance().get(URL);
    }

    @AfterMethod
    public void teardown() {
        Browser.quitDriver();
    }
}