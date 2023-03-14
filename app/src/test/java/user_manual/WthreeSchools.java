package user_manual;

import org.testng.annotations.*;
import org.openqa.selenium.By;

public class WthreeSchools extends BaseTest{
    @Test(enabled = true)
    @Parameters("name")
    public void w_three_schools_alerts(String name) throws InterruptedException {

        driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_prompt");
        driver.switchTo().frame("iframeResult");
        driver.findElement(By.xpath("//button[text()='Try it']")).click();
        driver.switchTo().alert().sendKeys(name);
        driver.switchTo().alert().accept();
        try{
            System.out.println(driver.findElement(By.xpath("//p[@id='demo']")).getText());
            System.out.println(driver.findElement(By.xpath("//p[@id='demo']")).getText().contains(name)?"PASSED":"Failed");
        }
        catch(Exception e){
            System.out.println("FAILED"+e);
        }

    }

    @Test(enabled = false)
    public void w_three_schools_widnows(){
        
        driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_win_open");
        String originalWindowHandle = driver.getWindowHandle();
        driver.switchTo().frame("iframeResult");
        driver.findElement(By.xpath("//button[text()='Try it']")).click();

        for (String windowHandle : driver.getWindowHandles()) {
            if (!originalWindowHandle.equals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                System.out.println(driver.getCurrentUrl());
                Utility.takeScreenshot(driver);
                driver.close();
            }
        }
        driver.switchTo().window(originalWindowHandle);
    }
}
