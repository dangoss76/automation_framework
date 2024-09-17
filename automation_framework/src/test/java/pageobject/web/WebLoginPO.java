package pageobject.web;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import pageobject.BaseWebPO;

public class WebLoginPO extends BaseWebPO {

   public WebLoginPO(WebDriver webDriver) {
       super(webDriver);
    }

    @FindBy(id = "email")
    @CacheLookup
    private WebElement emailLogin;
    @Step("Clinician enter email")
    public WebLoginPO enterEmailPatient(String email) {
        emailLogin.sendKeys(email);
        return this;
    }

    @FindBy(id = "password")
    @CacheLookup
    private WebElement passwordlogin;
    @Step("Clinician enter password")
    public WebLoginPO enterPassword(String password) {
        passwordlogin.clear();
        passwordlogin.sendKeys(password);
        return this;
    }

    @FindBy(id = "log_in_button")
    @CacheLookup
    private WebElement loginButton;
    @Step("Clinician click login")
    public WebLoginPO clickLoginButton() {
        loginButton.click();
        return this;
    }

    @FindBy(className = "username")
    private WebElement dashboardScreen;
    @Step("Dashboard is displayed")
    public String dashboardLoaded(){
        return dashboardScreen.getText();
    }


   /*
    @FindBy(className= "username")
    private WebElement clinicianUsername;
    @Step("Clinican username is displayed")
    public WebLoginPO clinicianUsernameDisplay() {
        String text = clinicianUsername.getText();
        return this;
    }

 //@FindBy(id = "dashboardKey")
    By userName = By.className("username");
    public String getUsername(String userName){
        return webDriver.findElement(this.userName).getText();
    }




    @FindBy(css = ".username")
    private WebElement clinicianUsername;
    public WebLoginPO assertClinicianName() {
        String text = clinicianUsername.getText();
        return this;
    }

*/
    //@FindBy(css = ".ng-scope admin")
    //public WebElement pageIsLoaded;


}


