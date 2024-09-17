package testcases.app;

import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.offset.PointOption;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.testng.ITestContext;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageobject.app.DashboardPO;
import pageobject.app.HomeScreenPO;
import pageobject.app.LoginPO;
import pageobject.app.SettingsPO;
import pageobject.app.common.ButtonPO;
import pageobject.web.WebLoginPO;
import testcases.BaseTest;
import utils.PropertyUtils;
import io.appium.java_client.TouchAction;


@Epic("Regression Tests")
@Feature("Login")

public class AppLogin extends BaseTest {

    public final static String EMAIL = PropertyUtils.getProperty("email");
    public final static String PASSWORD = PropertyUtils.getProperty("password");

    public final static String DREMAIL = PropertyUtils.getProperty("clinicianEmail");
    public final static String DRPASSWORD = PropertyUtils.getProperty("clinicianPassword");


    @Parameters("platform")
    @TmsLink("10062")
    @DisplayName("Sign up with an access code")
    @Link(name = "namelink", type = "task")
    @Test(description = "Patient can login")

    public void test(String platform, ITestContext ctx)  throws InterruptedException {
        ctx.getCurrentXmlTest().addParameter("caseId","10064");
        HomeScreenPO homeScreenPO = new HomeScreenPO(driver);
        LoginPO loginPO = new LoginPO(driver);
        DashboardPO dashboardPO = new DashboardPO(driver);
        ButtonPO buttonPO = new ButtonPO(driver);
        SettingsPO settingsPO = new SettingsPO(driver);
        TouchAction touchAction = new TouchAction(driver);
        //WebLoginPO webLoginPO = new WebLoginPO(webDriver);

        //webLoginPO.enterEmailPatient(DREMAIL);
        //webLoginPO.enterPassword(DRPASSWORD);
        //webLoginPO.clickLoginButton();

        /* TAP ON LOGIN - FILL USERNAME AND PASSWORD - SUBMIT */
        //homeScreenPO.tapOnLoginHomeScreenButton();
        waitUtils.staticWait(20000);
        loginPO.enterEmailPatient(EMAIL);
        //driver.pressKey(new KeyEvent().withKey(AndroidKey.ENTER));
        touchAction.tap(PointOption.point(100, 100)).perform(); //Close keyboard
        //driver.hideKeyboard();
        loginPO.enterPasswordPatient(PASSWORD);
        touchAction.tap(PointOption.point(100, 100)).perform(); //Close keyboard
        //driver.hideKeyboard();
        loginPO.tapOnLoginButton();
        waitUtils.staticWait(20000);
        //waitUtils.waitForElementToBePresent(By.tagName("dashboardPO.taskButton"), driver);
        //dashboardPO.tapOnPlusButton();
        //waitUtils.waitForElementToBePresent(By.tagName("dashboardPO.taskButton"), driver);

        //Assert.assertEquals(dashboardPO.elText, "TASKS");
        //Assert.assertTrue(dashboardPO.getTaskTitle(), "Page did not appear");

        //Assert.assertEquals(dashboardPO.getTasksTitle,"TASKS");
        /* OPEN A TASK - CANCEL - CONFIRM */
        dashboardPO.tapGlucoseSurveyTask();
        if(platform.equalsIgnoreCase("Android")) {
            buttonPO.tapOnBackButton().tapOnYesButton();
        }
        else if(platform.equalsIgnoreCase("iOS")) {
            buttonPO.tapOnCancelButton().tapOnYesButton();
        }

        /* OPEN CAREPLAN*/
        //dashboardPO.tapOnCarePlanButton();
        //buttonPO.tapOnBackButton();

        /* OPEN SETTINGS AND LOGOUT*/
        dashboardPO.tapOnSettingsButton();

        settingsPO.tapOnLogout();
        buttonPO.tapOnLogoutButton();



    }


    @BeforeTest
    @Override
    public void setUpPage() {

    }
}
