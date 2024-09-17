package pageobject.app;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import java.util.List;


import pageobject.BasePO;


public class SignupPO extends BasePO {

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
    public SignupPO(AppiumDriver driver) {super(driver); }


    @FindBy(id = "EmailField_Signup")
    private MobileElement signupEmailField;

    @Step("Patient enter email")
    public  SignupPO enterNewEmailPatient(String email){
        signupEmailField.sendKeys(email);
        return this;
    }


    @FindBy(id = "ConfirmEmailField")
    private  MobileElement confirmSignupEmailField;

    @Step("Patient confirm email")
    public  SignupPO confirmNewEmailPatient(String email){
        confirmSignupEmailField.sendKeys(email);
        return this;
    }


    @FindBy(id = "PasswordField_Signup")
    private  MobileElement signupPasswordField;

    @Step("Patient enter password")
    public SignupPO enterNewPasswordPatient(String password){
        signupPasswordField.sendKeys(password);
        return this;
    }


    @FindBy(id = "GroupTokenField")
    private  MobileElement signupAccessCodeField;

    @Step("Patient enter access code")
    public SignupPO enterAccessCode(String accessCode){
        signupAccessCodeField.sendKeys(accessCode);
        return this;
    }

    @FindBy(id = "SignupButton_Signup")
    private  MobileElement signupButton;

    @Step("Patient click signup button")
    public SignupPO tapSignupButton(){
        signupButton.click();
        return this;
    }


    /***** START QUESTIONNAIRE*****/
    //@AndroidFindBy(xpath = "//android.widget.TextView[@text='WELCOME!']")

    @FindBy(id = "StartButton")
    private  MobileElement startOnboradingQuestionnaire;

    public SignupPO clickStartOnboradingQuestionnaire(){
        startOnboradingQuestionnaire.click();
        return  this;
    }

    /* ANSWER YES AND NO FOR ALL QUESTIONS*/

    @FindBy(id = "surveyQuestion_yesKey")
    @AndroidFindBy(tagName = "surveyQuestion_yesKey")
    private MobileElement yesAnswer;

    public SignupPO tapYesAnswer(){
        yesAnswer.click();
        return  this;
    }

    @iOSXCUITFindBy(id = "surveyQuestion_noKey")
    @AndroidFindBy(tagName = "surveyQuestion_noKey")
    private MobileElement noAnswer;

    public SignupPO tapNoAnswer(){
        noAnswer.click();
        return  this;
    }

    @FindBy(id = "OK")
    private MobileElement ok;

    public SignupPO tapOK(){
        ok.click();
        return  this;
    }

    /***** QUESTION 1 - FIRST & LAST NAME*****/

    @FindBy(id = "surveyQuestion_firstName")
    @AndroidFindBy(tagName = "surveyQuestion_firstName")
    private MobileElement FirstNameFieldOnboarding;

    public SignupPO enterFirstNameFieldOnborading(String firstname){
        FirstNameFieldOnboarding.sendKeys(firstname);
        return  this;
    }


    @FindBy(id = "surveyQuestion_lastNameEditField")
    @AndroidFindBy(tagName = "surveyQuestion_lastNameEditField")
    private MobileElement LastNameFieldOnboarding;

    public SignupPO enterLastNameFieldOnborading(String lastname){
        LastNameFieldOnboarding.sendKeys(lastname);
        return  this;
    }



    /***** QUESTION 2 GENDER *****/

    @FindBy(id = "surveyQuestion_female")
    @AndroidFindBy(tagName = "surveyQuestion_female")
    private MobileElement sexFemale;

    public SignupPO tapSexFemale(){
        sexFemale.click();
        return  this;
    }

    @FindBy(id = "surveyQuestion_male")
    @AndroidFindBy(tagName = "surveyQuestion_male")
    private MobileElement sexMale;

    public SignupPO tapSexMale(){
        sexMale.click();
        return  this;
    }


    /***** QUESTION 3 DATE OF BIRTH *****/

    @FindBy(id = "surveyQuestion_dateButton")
    @AndroidFindBy(tagName = "surveyQuestion_dateButton")
    private MobileElement logBirthdayOnboardingQuestionnaire;

    public SignupPO taplogBirthdayOnboardingQuestionnaire(){
        logBirthdayOnboardingQuestionnaire.click();
        return  this;
    }

    @FindBy(id = "Save")
    @AndroidFindBy(id = "android:id/button1")

    private MobileElement okButtonBirthdayOnboardingQuestionnaire;
    public SignupPO tapOkButtonBirthdayOnboardingQuestionnaire(){
        okButtonBirthdayOnboardingQuestionnaire.click();
        return  this;
    }


    /***** QUESTION 4 PHONE NUMBER *****/

    @FindBy(id = "surveyQuestion_enterPhoneNumberKey")
    @AndroidFindBy(tagName = "surveyQuestion_enterPhoneNumberKey")
    private MobileElement enterPhoneNumberKey;

    public SignupPO tapEnterPhoneNumberKey(){
        enterPhoneNumberKey.sendKeys("5149990808");
        return  this;
    }


    /***** QUESTION 5 ETHNICITY *****/

    @FindBy(id = "surveyQuestion_caucasian")
    @AndroidFindBy(tagName = "surveyQuestion_caucasian")
    private MobileElement ethnicityCaucasian;

    public SignupPO tapEthnicityCaucasian(){
        ethnicityCaucasian.click();
        return  this;
    }

    @FindBy(id = "surveyQuestion_african")
    @AndroidFindBy(tagName = "surveyQuestion_african")
    private MobileElement ethnicityAfrican;

    public SignupPO tapEthnicityAfrican(){
        ethnicityAfrican.click();
        return  this;
    }

    @FindBy(id = "surveyQuestion_hispanic")
    @AndroidFindBy(tagName = "surveyQuestion_hispanic")
    private MobileElement ethnicityHispanic;

    public SignupPO tapEthnicityHispanic(){
        ethnicityHispanic.click();
        return  this;
    }

    @FindBy(id = "surveyQuestion_asian")
    @AndroidFindBy(tagName = "surveyQuestion_asian")
    private MobileElement ethnicityAsian;

    public SignupPO tapEthnicityAsian(){
        ethnicityAsian.click();
        return  this;
    }

    @FindBy(id = "surveyQuestion_other")
    @AndroidFindBy(tagName = "surveyQuestion_other")
    private MobileElement ethnicityOther;

    public SignupPO tapEthnicityOther(){
        ethnicityOther.click();
        return  this;
    }

    /***** QUESTION 6 SMOKER *****/
    /* USE THE GENERAL YES OR NO */



    /***** QUESTION 7 HEIGHT / WEIGHT *****/

    @FindBy(id = "surveyQuestion_valueSurveyKey_height")
    @AndroidFindBy(tagName = "surveyQuestion_valueSurveyKey_height")
    private MobileElement valueSurveyKey_height;

    public SignupPO tapValueSurveyKey_height(){
        valueSurveyKey_height.click();
        return  this;
    }


    @AndroidFindBy(tagName = "measurementEntry_height")
    //@iOSXCUITFindBy(accessibility = "Tap + to Log")

    private MobileElement heightFeetField;
    public SignupPO enterHeightFeetField(){
        heightFeetField.sendKeys("6");
        return  this;
    }

    @AndroidFindBy(tagName = "measurementEntry_extraValue_height")
    //@iOSXCUITFindBy(accessibility = "Tap + to Log")

    private MobileElement heightInchField;
    public SignupPO enterHeightInchField(){
        heightInchField.sendKeys("6");
        return  this;
    }


    @FindBy(id = "surveyQuestion_valueSurveyKey_weight")
    @AndroidFindBy(tagName = "surveyQuestion_valueSurveyKey_weight")
    private MobileElement valueSurveyKey_weight;

    public SignupPO tapValueSurveyKey_weight(){
        valueSurveyKey_weight.click();
        return  this;
    }


    @AndroidFindBy(tagName = "measurementEntry_weight")
    //@iOSXCUITFindBy(accessibility = "Tap + to Log")

    private MobileElement weightField;
    public SignupPO enterWeightField(){
        weightField.sendKeys("234");
        return  this;
    }

    /***** QUESTION 8 HEALTH CONDITIONS *****/

    @AndroidFindBy(tagName = "surveyQuestion_checkbox_diabetesKey")
    @FindBy(id = "surveyQuestion_diabetesKey")
    private MobileElement diabetesKey;

    public SignupPO tapDiabetesKey(){
        diabetesKey.click();
        return  this;
    }

    @AndroidFindBy(tagName = "surveyQuestion_checkbox_highBloodPressureKey")
    @FindBy(id = "surveyQuestion_highBloodPressureKey")
    private MobileElement highBloodPressureKey;

    public SignupPO tapHighBloodPressureKey(){
        highBloodPressureKey.click();
        return  this;
    }

    @AndroidFindBy(tagName = "surveyQuestion_checkbox_highCholesterolKey")
    @FindBy(id = "surveyQuestion_highCholesterolKey")
    private MobileElement highCholesterolKey;

    public SignupPO tapHighCholesterolKey(){
        highCholesterolKey.click();
        return  this;
    }

    @AndroidFindBy(tagName = "surveyQuestion_checkbox_CHFKey")
    @FindBy(id = "surveyQuestion_CHFKey")
    private MobileElement CHFKey;

    public SignupPO tapCHFKey(){
        CHFKey.click();
        return  this;
    }

    @AndroidFindBy(tagName = "surveyQuestion_checkbox_COPDKey")
    @FindBy(id = "surveyQuestion_COPDKey")
    private MobileElement COPDKey;

    public SignupPO tapCOPDKey(){
        COPDKey.click();
        return  this;
    }

    @AndroidFindBy(tagName = "surveyQuestion_checkbox_asthmaKey")
    @FindBy(id = "surveyQuestion_asthmaKey")
    private MobileElement asthmaKey;

    public SignupPO tapAsthmaKey(){
        asthmaKey.click();
        return  this;
    }

    @AndroidFindBy(tagName = "surveyQuestion_checkbox_majorIllnessKey")
    @FindBy(id = "surveyQuestion_majorIllnessKey")
    private MobileElement majorIllnessKey;

    public SignupPO tapMajorIllnessKey(){
        majorIllnessKey.click();
        return  this;
    }


    /***** QUESTION 9 DIABETES TYPE *****/

    @AndroidFindBy(tagName = "surveyQuestion_type1Key")
    @FindBy(id = "surveyQuestion_type1Key")
    private MobileElement type1Key;

    public SignupPO tapType1Key(){
        type1Key.click();
        return  this;
    }

    @AndroidFindBy(tagName = "surveyQuestion_type2Key")
    @FindBy(id = "surveyQuestion_type2Key")
    private MobileElement type2Key;

    public SignupPO tapType2Key(){
        type2Key.click();
        return  this;
    }

    /***** QUESTION 10 INSULIN *****/
    /* USE THE GENERAL YES OR NO */

    /***** QUESTION 11 CHF *****/

    @FindBy(id = "surveyQuestion_undeterminedKey")
    private MobileElement undeterminedKey;

    public SignupPO tapUndeterminedKey(){
        undeterminedKey.click();
        return  this;
    }

    @FindBy(id = "surveyQuestion_preservedKey")
    private MobileElement preservedKey;

    public SignupPO tapPreservedKey(){
        preservedKey.click();
        return  this;
    }

    @FindBy(id = "surveyQuestion_reducedKey")
    private MobileElement reducedKey;

    public SignupPO tapReducedKey(){
        reducedKey.click();
        return  this;
    }

    @FindBy(id = "surveyQuestion_iDontKnowKey")
    private MobileElement iDontKnowKey;

    public SignupPO tapIDontKnowKey(){
        iDontKnowKey.click();
        return  this;
    }


    /***** QUESTION 12 FLUID RESTRICTIONS *****/
    /* USE THE GENERAL YES OR NO */

    /***** QUESTION 13 PHYSICAL ACTIVITIES *****/
    /* USE THE GENERAL YES OR NO */

    /***** QUESTION 14 FAMILY HISTORY *****/
/*
    @FindBy(id = "surveyQuestion_diabetesKey")
    private MobileElement diabetesKey;

    public SignupPO tapDiabetesKey(){
        diabetesKey.click();
        return  this;
    }
*/
    @FindBy(id = "surveyQuestion_prematureCHDKey")
    private MobileElement prematureCHDKey;

    public SignupPO tapPrematureCHDKey(){
        prematureCHDKey.click();
        return  this;
    }


    @iOSXCUITFindBy(accessibility = "Save")
    @AndroidFindBy(xpath = "//android.widget.Button[@text='Save']")

    private MobileElement saveButton;
    public SignupPO tapSaveButton(){
        saveButton.click();
        return  this;
    }


    @FindBy(id = "NextButton_Questionnaire")
    private MobileElement iOSnextButton;
    public SignupPO tapNextButton(){
        iOSnextButton.click();
        return  this;
    }

    @AndroidFindBy(id = "NextButton_Questionnaire")
    //private MobileElement nextButton;
    public List<MobileElement> nextButton;



/*

    @AndroidFindBy(xpath = "//android.widget.Button[@text='Next']")
    @FindBy(id = "NextButton_Questionnaire")
    private MobileElement nextButton;

    public SignupPO tapNextButton(){
        nextButton.click();
        return  this;
    }

    //@FindBy(id = "NextButton_Questionnaire")
    //private MobileElement nextButton;
    //public List<MobileElement> nextButton;
signupPO.nextButton.get(0).click();

 = (List<MobileElement>) driver.findElement(By.id("NextButton_Questionnaire"));
    public SignupPO tapNextButton(){
        
        //List<MobileElement> nextButton2 = driver.findElements(By.id(“your_id”)).get(index);
        nextButton2.click();
        return  this;
    }
*/

//android.widget.TextView[@index='0']
}