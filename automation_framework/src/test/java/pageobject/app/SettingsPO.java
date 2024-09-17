package pageobject.app;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.support.FindBy;
import pageobject.BasePO;

public class SettingsPO extends BasePO {

    public SettingsPO(AppiumDriver driver) {
        super(driver);
    }

    @AndroidFindBy(id = "SettingButton_Account")
    @FindBy(id = "Account / Logout")
    private MobileElement logout;

    public SettingsPO tapOnLogout(){
        logout.click();
        return this;
    }
}
