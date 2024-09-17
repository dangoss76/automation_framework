package pageobject.app;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import pageobject.BasePO;


public class LoginPO  extends BasePO {

    public LoginPO(AppiumDriver driver) {
        super(driver);
    }

    By loginEmailField = By.id("EmailField_Login");
    @Step("Patient enter email")
    public void enterEmailPatient(String email){
        driver.findElement(loginEmailField).sendKeys(email);
    }


   /* @FindBy(id = "EmailField_Login")
    private MobileElement loginEmailField;
    public LoginPO enterEmailPatient(String email){
        loginEmailField.sendKeys(email);
        return this;
    }*/

    @FindBy(id = "PasswordField_Login")
    private MobileElement loginPasswordField;

    @Step("Patient enter password")
    public LoginPO enterPasswordPatient(String password){
        loginPasswordField.sendKeys(password);
        return this;
    }

    @FindBy(id = "ConnectButton")
    private MobileElement loginButton;

    @Step("Patient click on submit")
    public LoginPO tapOnLoginButton(){
        loginButton.click();
        return this;
    }

    @iOSXCUITFindBy(accessibility = "Care Plan")
    private MobileElement dashboardPage;
    public boolean isDashboardPageDisplayed() {
        return dashboardPage.isDisplayed();
    }
}
