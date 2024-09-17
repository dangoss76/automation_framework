package pageobject.app;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.support.FindBy;
import pageobject.BasePO;

public class DashboardPO extends BasePO {

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
    public DashboardPO(AppiumDriver driver) {
        super(driver);
    }
    //String taskButton = driver.findElement(By.tagName("tasks_514ecb4f-07bc-4717-e003-8d97acab68e7")).getText();
    //public String taskTitle = driver.findElement(By.id("TasksDashboardHeading")).getText();



    /* TASK TITLE
    @FindBy(id = "TasksDashboardHeading")
    @AndroidFindBy(id = "app:id/TasksDashboardHeading")
    private MobileElement taskTitle;
*/
    //MobileElement taskTitle = (MobileElement) driver.findElementById("TasksDashboardHeading");
    //public String elText = taskTitle.getText();

    /*
        public DashboardPO getTaskTitle(){
            String thetasktitle = taskTitle.getText();
            return this;
        }

        //public String thetasktitle = taskTitle.getText();
    /*
        public DashboardPO getTaskTitle(){
            String thetasktitle = taskTitle.getText();
            return this;
        }
    */
    /* CLICK ON A TASK*/
    @FindBy(id = "tasks_glucoseSurveyTaskTitle")
    @AndroidFindBy(tagName = "tasks_glucoseSurveyTaskTitle")
    private MobileElement glucoseSurveyTask;

    public DashboardPO tapGlucoseSurveyTask(){
        glucoseSurveyTask.click();
        return this;
    }

    /* CLICK TO OPEN CAREPLAN*/
    @FindBy(id = "CarePlanButton")
    private MobileElement carePlanButton;

    public DashboardPO tapOnCarePlanButton(){
        carePlanButton.click();
        return this;
    }

    /* CLICK ON PLUS TO ADD A MEASUREMENT*/
    @FindBy(id = "PlusButton")
    private MobileElement plusButton;

    public DashboardPO tapOnPlusButton(){
        plusButton.click();
        return this;
    }

    /* CLICK ON SETTINGS*/
    //@iOSXCUITFindBy(id = "SettingsButtton")
    //@AndroidFindBy(id = "SettingsButton")
    @FindBy(id = "SettingsButton")

    private MobileElement settingsButton;

    public DashboardPO tapOnSettingsButton(){
        settingsButton.click();
        return this;
    }

    //@FindBy(id = "TASKS")
    //private MobileElement tasksTitle;
    //public String getTasksTitle = tasksTitle.getText();

}



