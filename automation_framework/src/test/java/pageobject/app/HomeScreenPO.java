package pageobject.app;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import pageobject.BasePO;


public class HomeScreenPO extends BasePO {
    /**
     * A base constructor that sets the page's driver
     * <p>
     * The page structure is being used within this test in order to separate the
     * page actions from the tests.
     * <p>
     * Please use the AppiumFieldDecorator class within the page factory. This way annotations
     * like @AndroidFindBy within the page objects.
     *
     * @param driver the appium driver created in the beforesuite method.
     */
    public HomeScreenPO(AppiumDriver driver) {
        super(driver);
    }

    //@iOSXCUITFindBy(accessibility = "Log In")
    @FindBy(id = "LoginButton")
    private MobileElement homeScreenLoginButton;
    @Step("Patient click login button")
    public HomeScreenPO tapOnLoginHomeScreenButton(){
        homeScreenLoginButton.click();
        return this;
    }

    @FindBy(id = "SignupButton_Welcome")
    @iOSXCUITFindBy(accessibility = "Sign Up")
    //@AndroidFindBy(xpath = "//android.widget.Button[@text='Sign Up']")
    private MobileElement homeScreenSignupButton;
    @Step("Patient click signup button")
    public HomeScreenPO tapOnSignupHomeScreenButton(){
        homeScreenSignupButton.click();
        return this;
    }

}