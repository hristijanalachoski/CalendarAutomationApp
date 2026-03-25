package pages;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import util.GlobalVariables;

import io.qameta.allure.Step;

public class NewEventScreen {

    protected IOSDriver driver;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeNavigationBar[`name == \"New\"`]")
    private RemoteWebElement newEventScreenTitle;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField[`name == \"Title\"`]")
    private RemoteWebElement titleTextField;

    public NewEventScreen(IOSDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @Step("New event screen is loaded")
    public boolean newEventScreenLoaded() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(newEventScreenTitle)).isDisplayed();
    }

    @Step("Entering event title: {0}")
    public void enterEventTitle(String eventTitle) {
        titleTextField.clear();
        titleTextField.sendKeys(eventTitle);
    }
}
