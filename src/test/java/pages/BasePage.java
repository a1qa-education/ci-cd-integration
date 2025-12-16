package pages;

import org.openqa.selenium.By;
import utils.WaitUtils;

public class BasePage {
    private final By uniqueElementLocator;

    public BasePage(By uniqueElementLocator) {
        this.uniqueElementLocator = uniqueElementLocator;
    }

    public boolean waitForPageToOpen(){
        return WaitUtils.waitForElementDisplayed(uniqueElementLocator).isDisplayed();
    }
}