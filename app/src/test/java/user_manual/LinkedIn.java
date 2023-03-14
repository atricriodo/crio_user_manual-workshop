package user_manual;

import org.testng.annotations.*;
import org.openqa.selenium.By;

public class LinkedIn extends BaseTest{


    @Test(enabled = true, groups = "Linkedin", description = "posting some image on linkedin!")
    @Parameters("media_path")
    public void linkedin_media(String media_path) throws InterruptedException {
        driver.get("https://www.linkedin.com/home");
        driver.findElement(By.xpath(
                "//button[@class='artdeco-button artdeco-button--muted artdeco-button--4 artdeco-button--tertiary ember-view share-box-feed-entry__trigger']"))
                .click();
        driver.findElement(By.xpath(
                "//button[@class='artdeco-button artdeco-button--circle artdeco-button--muted artdeco-button--2 artdeco-button--tertiary ember-view']"))
                .click();
        driver.findElement(By.xpath("//input[@id='image-sharing-detour-container__file-input']")).sendKeys(media_path);
        driver.findElement(By.xpath(
                "//button[@class='share-box-footer__primary-btn artdeco-button artdeco-button--2 artdeco-button--primary ember-view']"))
                .click();
        driver.findElement(By.xpath(
                "//button[@class='share-actions__primary-action artdeco-button artdeco-button--2 artdeco-button--primary ember-view']"))
                .click();
        Thread.sleep(5000);
    }

    @Test(enabled = true, groups = "Linkedin", description = "posting a phrase on linkedin!")
    @Parameters("content")
    public void linkedin_post(String content) throws InterruptedException {
        driver.get("https://www.linkedin.com/home");
        driver.findElement(By.xpath(
                "//button[@class='artdeco-button artdeco-button--muted artdeco-button--4 artdeco-button--tertiary ember-view share-box-feed-entry__trigger']"))
                .click();
        driver.findElement(By.xpath("//div[@aria-placeholder='What do you want to talk about?']")).sendKeys(content);
        driver.findElement(By.xpath(
                "//button[@class='share-actions__primary-action artdeco-button artdeco-button--2 artdeco-button--primary ember-view']"))
                .click();
        Thread.sleep(5000);
    }

}
