package user_manual;

import org.testng.annotations.Test;

public class Heroku extends BaseTest {
    @Test(enabled = true, groups = "Heroku", description = "practicing nested frames on irctc!")
    public void heroku_frames() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/nested_frames");
        Thread.sleep(1000);
        System.out.println("total number of iFrames" + Utility.countIframes(driver));
        System.out.println("\n\n");
        System.out.println("total number of Frames" + Utility.countFrames(driver));
    }
}
