package user_manual;

import org.testng.annotations.*;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Irctc extends BaseTest{
    
    @Test(enabled = true, groups = "IRCTC", description = "going and searching a station in irctc!")
    @Parameters("irctc_first_letters")
    public void irctc_from_station(String param) throws InterruptedException {
        driver.get("https://www.irctc.co.in/nget/train-search");
        WebElement from_station = driver.findElement(By.xpath(
                "//input[@class='ng-tns-c57-8 ui-inputtext ui-widget ui-state-default ui-corner-all ui-autocomplete-input ng-star-inserted']"));
        from_station.clear();
        from_station.sendKeys(param);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
                "//div[@class='ng-trigger ng-trigger-overlayAnimation ng-tns-c57-8 ui-autocomplete-panel ui-widget ui-widget-content ui-corner-all ui-shadow ng-star-inserted']")));
        Thread.sleep(500);
        WebElement first_auto = driver.findElement(By.xpath(
                "//div[@class='ng-trigger ng-trigger-overlayAnimation ng-tns-c57-8 ui-autocomplete-panel ui-widget ui-widget-content ui-corner-all ui-shadow ng-star-inserted']"));
        first_auto.click();
    }


}
