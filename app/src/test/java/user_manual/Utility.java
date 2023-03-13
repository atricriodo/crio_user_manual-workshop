package user_manual;

import org.testng.annotations.*;
import static org.testng.Assert.*;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
public class Utility {
    
    public static int countIframes(WebDriver driver) {
        int count = 0;
        List<WebElement> iframes = driver.findElements(By.tagName("iframe"));
        System.out.println("This iframe has "+iframes.size()+" iframes within it");
        count += iframes.size();
        for (WebElement iframe : iframes) {
            try{
                System.out.println("The id of this iFrame is "+iframe.getAttribute("id"));
            }
            catch(Exception e){
                System.out.println("OOPS! this iframe doesn't have an id");
            }
            driver.switchTo().frame(iframe);
            System.out.println("Hey! Im in an iFrame!");
            count += countIframes(driver);
            driver.switchTo().parentFrame();
        }
        return count;
    }
    public static int countFrames(WebDriver driver) {
        int count = 0;
        List<WebElement> frames = driver.findElements(By.tagName("frame"));
        System.out.println("This iframe has "+frames.size()+" iframes within it");
        count += frames.size();
        for (WebElement frame : frames) {
            System.out.println("The id of this Frame is "+frame.getAttribute("id")+" And name is "+frame.getAttribute("name"));
            driver.switchTo().frame(frame);
            System.out.println("Hey! Im in a Frame!");
            count += countFrames(driver);
            driver.switchTo().parentFrame();
        }
        return count;
    }
}
