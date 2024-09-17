package pageobject.app.common;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.support.FindBy;
import pageobject.BasePO;

public class ButtonPO extends BasePO {

    public ButtonPO(AppiumDriver driver) {
        super(driver);
    }


    @FindBy(id = "StartButton")
    private MobileElement startButton;

    public ButtonPO tapOnStartButton(){
        startButton.click();
        return this;
    }

    @FindBy(id = "SubmitButton")
    private MobileElement submitButton;

    public ButtonPO tapOnSubmitButton(){
        submitButton.click();
        return this;
    }

    @FindBy(id = "FinishButton")
    private MobileElement finishButton;

    public ButtonPO tapOnFinishButton(){
        finishButton.click();
        return this;
    }

    @FindBy(id = "Cancel")
    private MobileElement cancelButton;

    public ButtonPO tapOnCancelButton(){
        cancelButton.click();
        return this;
    }

    @FindBy(id = "SaveButton")
    private MobileElement saveButton;

    public ButtonPO tapSaveButton(){
        saveButton.click();
        return  this;
    }

    @FindBy(id = "Yes")
    @AndroidFindBy(id = "android:id/button1")
    private MobileElement yesButton;

    public ButtonPO tapOnYesButton(){
        yesButton.click();
        return this;
    }

    @FindBy(id = "No")
    @AndroidFindBy(id = "android:id/button2")
    private MobileElement noButton;

    public ButtonPO tapOnNoButton(){
        noButton.click();
        return this;
    }

    @FindBy(id = "BackButton")
    private MobileElement backButton;

    public  ButtonPO tapOnBackButton(){
        backButton.click();
        return this;
    }

    @FindBy(id = "LogoutButton")
    private MobileElement logoutButton;

    public  ButtonPO tapOnLogoutButton(){
        logoutButton.click();
        return this;
    }

}
