package user_manual;

import org.testng.annotations.*;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Imdb extends BaseTest {
    @Test(enabled = false)
    public void imdb() throws InterruptedException {
        driver.get("https://www.imdb.com/chart/top");
        System.out.println(
                "Highest rated movie is " + driver.findElement(By.xpath("//td[@class='titleColumn']")).getText());
        List<WebElement> movies = driver.findElements(By.xpath("//tbody[@class='lister-list']/tr"));
        System.out.println("Total movies on list " + movies.size());
        Select select = new Select(driver.findElement(By.xpath("//select[@id='lister-sort-by-options']")));
        select.selectByVisibleText("Release Date");
        try {
            Thread.sleep(1000);
            driver.findElement(By.xpath("//span[@class='global-sprite lister-sort-reverse ascending']")).click();
        } catch (Exception e) {
            System.out.println("Maybe already in Descending order?-->" + e);
        }
        Thread.sleep(1000);

        System.out.println(
                "Oldest Movie is " + driver.findElement(By.xpath("//tbody[@class='lister-list']/tr")).getText());
        try {
            driver.findElement(By.xpath("//span[@class='global-sprite lister-sort-reverse descending']")).click();
        } catch (Exception e) {
            System.out.println("Maybe already in Ascending order?-->" + e);
        }
        Thread.sleep(1000);

        System.out.println(
                "Newest Movie is " + driver.findElement(By.xpath("//tbody[@class='lister-list']/tr")).getText());

        select = new Select(driver.findElement(By.xpath("//select[@id='lister-sort-by-options']")));
        select.selectByVisibleText("Your Rating");
        Thread.sleep(1000);

        System.out.println(
                "Popular Movie is " + driver.findElement(By.xpath("//tbody[@class='lister-list']/tr")).getText());

    }
}
