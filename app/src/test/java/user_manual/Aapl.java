package user_manual;

import org.testng.annotations.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

public class Aapl extends BaseTest{
    @Test(enabled = false)
    public void stocks() throws InterruptedException {
        driver.get("https://finance.yahoo.com/quote/AAPL/history?p=AAPL");
        try {
            driver.findElement(By.xpath("//button[@aria-label='Close']")).click();
        } catch (Exception e) {
            System.out.println("Pop up already closed");
        }
        JavascriptExecutor js = (JavascriptExecutor) driver;

        while (true) {
            Long initialHeight = (Long) js.executeScript("return document.body.scrollHeight");
            js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
            Thread.sleep(3000);
            Long newHeight = (Long) js.executeScript("return document.body.scrollHeight");
            if (newHeight.equals(initialHeight)) {
                break;
            }
        }

    }
}
