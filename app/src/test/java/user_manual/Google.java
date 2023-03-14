package user_manual;

import org.testng.annotations.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class Google  extends BaseTest{
    @Test(enabled = false)
    public void google_amazon() throws InterruptedException {
        driver.get("https://www.google.com");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@aria-label='Search']")).sendKeys("amazon", Keys.ENTER);
        System.out.println(driver.findElement(By.xpath("//a[contains(@href, 'amazon')]")) == null
                ? "Did not find AMAZON link: PASS"
                : "FOUND AMAZON LINK: PASS");
    }
}
