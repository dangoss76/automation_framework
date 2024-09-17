package testcases.app;

import io.appium.java_client.touch.offset.PointOption;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.testng.annotations.*;
import pageobject.app.DashboardPO;
import pageobject.app.HomeScreenPO;
import pageobject.app.SignupPO;
import pageobject.app.common.ButtonPO;
import testcases.BaseTest;
import utils.JavaFaker;
import io.appium.java_client.TouchAction;
import org.testng.annotations.Test;
@Epic("Regression Tests")
@Feature("Sign Up")

public class SignupWithAccessCode extends BaseTest {

    @Parameters({"platform"})
    @Test(description = "Patient can signup with an access code")
    @DisplayName("Sign up with an access code")
    public void test(String platform) throws InterruptedException {

        HomeScreenPO homeScreenPO = new HomeScreenPO(driver);
        SignupPO signupPO = new SignupPO(driver);
        ButtonPO buttonPO = new ButtonPO(driver);
        DashboardPO dashboardPO = new DashboardPO(driver);
        TouchAction touchAction = new TouchAction(driver);

        JavaFaker jf = new JavaFaker();
        String email = jf.getEmail();
        String firstname = jf.getFirstName();
        String lastname = jf.getLastName();
        String phone = jf.getPhone();
        String password = "xxxxxx";
        String accessCode = "demo";

        /*Tap on SIgn Up Button on the dahboard screen*/
        homeScreenPO.tapOnSignupHomeScreenButton();

        /*Enter patient email - Confirm email - enter password - enter access code - Tap sign up button*/
        signupPO.enterNewEmailPatient("demo_automation@yopmail.com").confirmNewEmailPatient("demo_automation@yopmail.com");
        touchAction.tap(PointOption.point(100, 100)).perform(); //Close keyboard
        signupPO.enterNewPasswordPatient(password);
        touchAction.tap(PointOption.point(100, 100)).perform(); //Close keyboard
        signupPO.enterAccessCode(accessCode);
        touchAction.tap(PointOption.point(100, 100)).perform(); //Close keyboard
        signupPO.tapSignupButton();

        /* STEP 1 - Tap on Start button*/
        buttonPO.tapOnStartButton();

        /* STEP 2 - Enter patient Firstname and Lastname*/
        signupPO.enterFirstNameFieldOnborading(firstname).enterLastNameFieldOnborading(lastname);
        touchAction.tap(PointOption.point(100, 100)).perform(); //Close keyboard
        if(platform.equalsIgnoreCase("Android")) {
            signupPO.nextButton.get(0).click();
        }
        else if(platform.equalsIgnoreCase("iOS")) {
            signupPO.tapNextButton();
        }


        /* STEP 3 - Choose Gender*/
        signupPO.tapSexMale();

        /* STEP 4 - Enter Date  of Birth*/
        if(platform.equalsIgnoreCase("Android")) {
            signupPO.taplogBirthdayOnboardingQuestionnaire();
            signupPO.tapOkButtonBirthdayOnboardingQuestionnaire();
            signupPO.nextButton.get(1).click();
        }
        else if(platform.equalsIgnoreCase("iOS")) {
            signupPO.tapOkButtonBirthdayOnboardingQuestionnaire();
            signupPO.tapNextButton();
        }



        /* STEP 5 - Enter Phone  NUmber*/
        signupPO.tapEnterPhoneNumberKey();
        touchAction.tap(PointOption.point(100, 100)).perform(); //Close keyboard
        if(platform.equalsIgnoreCase("Android")) {
            signupPO.nextButton.get(1).click();
        }
        else if(platform.equalsIgnoreCase("iOS")) {
            signupPO.tapNextButton();
        }

        /* STEP 6 - Choose Ethnicity*/
        signupPO.tapEthnicityOther();//.tapNextButton();
       /* if(PLATFORM.equals("Android")) {
            signupPO.nextButton.get(0).click();
        }
        else if(PLATFORM.equals("iOS")) {
            signupPO.tapNextButton();
        }*/

        /* STEP 7 - SMOKER */
        signupPO.tapNoAnswer();//.tapNextButton();

        /* STEP 8 - Enter height and weight */
        if(platform.equalsIgnoreCase("Android")) {
            signupPO.tapValueSurveyKey_height().enterHeightFeetField().enterHeightInchField();
            buttonPO.tapSaveButton();
            signupPO.tapValueSurveyKey_weight().enterWeightField();
            buttonPO.tapSaveButton();
            signupPO.nextButton.get(1).click();
        }
        else if(platform.equalsIgnoreCase("iOS")) {
            signupPO.tapValueSurveyKey_height().tapOK();
            signupPO.tapValueSurveyKey_weight().tapOK();//.tapNextButton();
            signupPO.tapNextButton();
        }


        /* STEP 9 - Health Conditions */
        //signupPO.tapDiabetesKey();
        if(platform.equalsIgnoreCase("Android")) {
            signupPO.nextButton.get(1).click();
        }
        else if(platform.equalsIgnoreCase("iOS")) {
            signupPO.tapNextButton();
        }

        /* STEP 10 - Diabetes Type */
       // signupPO.tapType2Key();//.tapNextButton();

        /* STEP 11 - Insulin */
        //signupPO.tapNoAnswer();//.tapNextButton();

        /* STEP 15 - Family History */
        //signupPO.tapDiabetesKey();

        /* Submit questionnaire and finish */
       Thread.sleep(3000);
        buttonPO.tapOnSubmitButton();
        buttonPO.tapOnFinishButton();

        Thread.sleep(3000);


        //Assert.assertEquals(dashboardPO.welcomeMessage, "Welcome to CareSimple! You will be receiving personalized tips & reminders daily to assist you through your patient journey.");
        //waitUtils.waitForElementToBeClickable(homeScreenPO.homeScreenSignupButton, driver);
        //Assert.assertTrue(dashboardPO.getTaskTitle(), "Conversation screen didn't appear!");
    }

    private void perform() {
    }

    @BeforeTest
    @Override
    public void setUpPage() {

    }

}
