package user_manual;

import org.testng.annotations.*;
import org.openqa.selenium.By;

public class LinkedIn extends BaseTest{
    @Test(enabled = false)
    @Parameters({ "email", "pwd", "media_path" })
    public void linkedin_media(String email1, String pwd, String media_path) throws InterruptedException {
        driver.get("https://www.linkedin.com/home");
        driver.findElement(By.xpath("//input[@name='session_key']")).sendKeys(email1);
        driver.findElement(By.xpath("//input[@name='session_password']")).sendKeys(pwd);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
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
        driver.findElement(By.xpath(
                "//button[@class='global-nav__primary-link global-nav__primary-link-me-menu-trigger artdeco-dropdown__trigger artdeco-dropdown__trigger--placement-bottom ember-view']"))
                .click();
        driver.findElement(By.xpath("//*[text()='Sign Out']")).click();
        Thread.sleep(500);
        try {
            driver.findElement(By.xpath(
                    "//button[@class='full-width mt4 artdeco-button artdeco-button--muted artdeco-button--2 artdeco-button--secondary ember-view']"))
                    .click();
            Thread.sleep(5000);
        } catch (Exception e) {
            System.out.println("No need for extra steps to log out!");
        }
    }

    @Test(enabled = false)
    @Parameters({ "email", "pwd", "content" })
    public void linkedin_post(String email2, String pwd, String content) throws InterruptedException {
        driver.get("https://www.linkedin.com/home");
        driver.findElement(By.xpath("//input[@name='session_key']")).sendKeys(email2);
        driver.findElement(By.xpath("//input[@name='session_password']")).sendKeys(pwd);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        driver.findElement(By.xpath(
                "//button[@class='artdeco-button artdeco-button--muted artdeco-button--4 artdeco-button--tertiary ember-view share-box-feed-entry__trigger']"))
                .click();
        driver.findElement(By.xpath("//div[@aria-placeholder='What do you want to talk about?']")).sendKeys(content);
        driver.findElement(By.xpath(
                "//button[@class='share-actions__primary-action artdeco-button artdeco-button--2 artdeco-button--primary ember-view']"))
                .click();
        Thread.sleep(5000);
        driver.findElement(By.xpath(
                "//button[@class='global-nav__primary-link global-nav__primary-link-me-menu-trigger artdeco-dropdown__trigger artdeco-dropdown__trigger--placement-bottom ember-view']"))
                .click();
        driver.findElement(By.xpath("//*[text()='Sign Out']")).click();
        Thread.sleep(500);
        try {
            driver.findElement(By.xpath(
                    "//button[@class='full-width mt4 artdeco-button artdeco-button--muted artdeco-button--2 artdeco-button--secondary ember-view']"))
                    .click();
            Thread.sleep(5000);
        } catch (Exception e) {
            System.out.println("No need for extra steps to log out!");
        }
    }
}
