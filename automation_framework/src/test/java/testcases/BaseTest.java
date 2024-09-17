package testcases;

import client.APIClient;
import client.APIException;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.json.simple.JSONObject;
import org.openqa.selenium.WebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utils.PropertyUtils;
//import utils.ScreenshotUtility;
import utils.TestRails;
import utils.WaitUtils;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

//@Listeners({ScreenshotUtility.class})
public abstract class BaseTest {

    String PROJECT_ID = "17"; //ID of the Testrail Project
    APIClient client = null;

    public static AppiumDriver driver = null;
    public static WebDriver webDriver = null;

    public final static String APPIUM_SERVER_URL = PropertyUtils.getProperty("appium.server.url", "http://127.0.0.1:4723/wd/hub");
    public final static int IMPLICIT_WAIT = PropertyUtils.getIntegerProperty("implicitWait", 30);
    public static WaitUtils waitUtils = new WaitUtils();
    public final static String URLTOTEST = PropertyUtils.getProperty("urlToTest");

   @Parameters({"browserName"})
    @BeforeClass
    public void createSuite(ITestContext ctx,@Optional("Chrome") String browserName) throws Exception {
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
        Date date = new Date(System.currentTimeMillis());
        client = new APIClient("https://tactio.testrail.io/");
        client.setUser("dgosselin@tactiohealth.com");
        client.setPassword("30go52XX");
        Map data = new HashMap();
        data.put("include_all",true);
        data.put("description","here's my custom description");
        data.put("name","Test Run "+browserName+" "+formatter.format(date));
        JSONObject c = null;
        c = (JSONObject)client.sendPost("add_run/"+PROJECT_ID,data);
        Long suite_id = (Long)c.get("id");
        ctx.setAttribute("suiteId",suite_id);
    }

    @BeforeMethod
    @Parameters({"browserName","platformVersion", "wda", "platform", "udid", "deviceName", "port"})
    public void setUp(@Optional("Chrome") String browserName, @Optional("iOS") String platformVersion, @Optional("8500") long wda, @Optional("13.6") String platform, @Optional String udid, @Optional("device") String deviceName, @Optional("8500") String port) throws MalformedURLException {
        if (browserName != null) {
            if (browserName.equalsIgnoreCase("Firefox")) {
                WebDriverManager.firefoxdriver().setup();
                webDriver = new FirefoxDriver();
                webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                webDriver.get(URLTOTEST);
            } else if (browserName.equalsIgnoreCase("Chrome")) {
                WebDriverManager.chromedriver().setup();
                webDriver = new ChromeDriver();
                webDriver.get(URLTOTEST);
            } else if (browserName.equalsIgnoreCase("Edge")) {
                WebDriverManager.edgedriver().setup();
                webDriver = new EdgeDriver();
                webDriver.get(URLTOTEST);
            } else if (browserName.equalsIgnoreCase("Safari")) {
                webDriver = new SafariDriver();
                webDriver.get(URLTOTEST);
            }
        }

        if (platform != null) {

            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
            capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, platform);
            capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, platformVersion);

            if (platform.equalsIgnoreCase("Android")) {
                capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Espresso");
                capabilities.setCapability("appPackage", "com.tactiohealth.rpm2000.tactiopatient");
                capabilities.setCapability("appWaitActivity", "com.tactio.tactioActivities.TactioWelcomePage");
                capabilities.setCapability(MobileCapabilityType.APP, "/Users/danielgosselin/Downloads/RPM2000-debug.apk");
                capabilities.setCapability("allowTestPackages", true);
                capabilities.setCapability("ignoreHiddenApiPolicyError", true);
                capabilities.setCapability("noSign", true);
                driver = new AndroidDriver(new URL(APPIUM_SERVER_URL), capabilities);
            } else if (platform.equalsIgnoreCase("iOS")) {
                capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
                capabilities.setCapability(MobileCapabilityType.UDID, udid);
                capabilities.setCapability("xcodeOrgId", "88JYMJ55KX");
                capabilities.setCapability("xcodeSigningId", "iPhone Developer");
                capabilities.setCapability(IOSMobileCapabilityType.WDA_LOCAL_PORT, wda);
                capabilities.setCapability(IOSMobileCapabilityType.AUTO_ACCEPT_ALERTS, true);
                capabilities.setCapability(MobileCapabilityType.APP, "/Users/danielgosselin/Downloads/RPM2000.app");
                driver = new IOSDriver(new URL(APPIUM_SERVER_URL), capabilities);
            }
        }
        
    }

    public void beforeTest(ITestContext ctx, Method method) throws NoSuchMethodException {
        Method m = BaseTest.class.getMethod(method.getName());
        if (m.isAnnotationPresent(TestRails.class)) {
            TestRails ta = m.getAnnotation(TestRails.class);
            ctx.setAttribute("caseId",ta.id());
        }
    }

    /**
     * This method will be called everytime before your test runs
     */
    @BeforeTest
    public abstract void setUpPage();


    /**
     * This method will always execute after each test case, This will quit the WebDriver instance called at the last
     */
    @AfterMethod(alwaysRun = true)
    public void afterTest(ITestResult result, ITestContext ctx) throws Exception {
        Map data = new HashMap();
        if(result.isSuccess()) {
            data.put("status_id",1);
        }

        else{
            data.put("status_id",5);
            data.put("comment", result.getThrowable().toString());
        }
        String caseId = ctx.getCurrentXmlTest().getParameter("caseId");
        //String caseId = (String)ctx.getAttribute("caseId");
        Long suiteId = (Long)ctx.getAttribute("suiteId");
        client.sendPost("add_result_for_case/"+suiteId+"/"+caseId,data);
    }

    /**
     * This method will be called after class finishes the execution of all tests
     */
    @AfterClass
    public void afterClass() {
        quitDriver();
        System.out.println("After Suite");
    }

    /**
     * At the end of the Test Suite(At last) this method would be called
     */
    @AfterSuite
    public void tearDown() {

    }


/*
    public static WebDriver getScreenshotableWebDriver() {
        final WebDriver augmentedDriver = new Augmenter().augment(driver);
        return augmentedDriver;
    }
*/
    /**
     * This will set implicit wait
     *
     * @param driver
     */
    private static void setTimeOuts(AppiumDriver driver) {
        //Use a higher value if your mobile elements take time to show up
        driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT, TimeUnit.SECONDS);
    }

    private static String getAbsolutePath(String appRelativePath) {
        File file = new File(appRelativePath);
        return file.getAbsolutePath();
    }

    /**
     * This will quite the driver instance
     */
    private void quitDriver() {
        try {
            if(driver != null) {
                driver.quit();
            }

            if(webDriver != null) {
                webDriver.quit();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}