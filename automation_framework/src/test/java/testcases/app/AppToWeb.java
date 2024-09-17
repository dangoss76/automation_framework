package testcases.app;

import org.junit.jupiter.api.Test;
import org.testng.annotations.BeforeTest;
import pageobject.app.HomeScreenPO;
import pageobject.web.WebLoginPO;
import testcases.BaseTest;
import utils.PropertyUtils;

public class AppToWeb extends BaseTest {

    public final static String EMAIL = PropertyUtils.getProperty("clinicianEmail");
    public final static String PASSWORD = PropertyUtils.getProperty("clinicianPassword");
    public final static String URLTOTEST = PropertyUtils.getProperty("urlToTest");

    @Test
    public void test() {

        WebLoginPO webLoginPO = new WebLoginPO(webDriver);
       HomeScreenPO homeScreenPO = new HomeScreenPO(driver);

        homeScreenPO.tapOnLoginHomeScreenButton();

        webLoginPO.enterEmailPatient(EMAIL);
        webLoginPO.enterPassword(PASSWORD);
        webLoginPO.clickLoginButton();
    }

    @BeforeTest
    @Override
    public void setUpPage() {

    }
}
