package Homework3;

import DriverSetUp.DriverSetUp;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.Set;

public class Homework3 {

    @Test
     public void Homework3 () throws InterruptedException {
        WebDriver driver = DriverSetUp.setUpDriver();
        driver.get("https://www.google.com/search");
        ActionsClass actionsClass = new ActionsClass(driver);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");
        driver.findElement(By.xpath("//div[text()='Принять все']")).click();

        //открыть первую в новой вкладке
        actionsClass.sendKeys(By.cssSelector("[jsname='yZiJbe']"),("https://www.guinnessworldrecords.com/account/register?"));
        actionsClass.sendKeys(By.cssSelector("[jsname='yZiJbe']"), Keys.ENTER);

        String handle1 = driver.getWindowHandle(); // забирает дескриптор первого окна
        Set<String> windowHandles1 = driver.getWindowHandles();// получить декриптор нового окна до открытия
        actionsClass.clickAndOpenInNewWindow(By.xpath("//h3[text()='Create account']")); // открывает в новой вкладке, но не переключает
        Set<String> windowHandles2 = driver.getWindowHandles();// получить дескриптор второго окна после его открітия
         windowHandles2.removeAll(windowHandles1);
        String handle2 = windowHandles2.iterator().next();

// открыть вторую в новой
        actionsClass.sendKeys(By.cssSelector("[jsname='yZiJbe']"),("https://www.hyrtutorials.com/p/alertsdemo.html"));
        actionsClass.sendKeys(By.cssSelector("[jsname='yZiJbe']"), Keys.ENTER);
//забираем дескриптор 3 окна
        Set<String> windowHandles3 = driver.getWindowHandles();
        actionsClass.clickAndOpenInNewWindow(By.xpath("//h3[text()='AlertsDemo']"));
         //driver.findElement(By.xpath("//span[text()='Не входить']")).click();
        Set<String> windowHandles4 = driver.getWindowHandles();
        windowHandles4.removeAll(windowHandles3);
        String handle3 = windowHandles4.iterator().next();

        actionsClass.clearAndSendKeys((By.cssSelector("[jsname='yZiJbe']")),("https://www.w3schools.com/html/tryit.asp?filename=tryhtml_form_submit"));
        actionsClass.sendKeys(By.cssSelector("[jsname='yZiJbe']"), Keys.ENTER);
        actionsClass.click(By.xpath("//h3[text()='W3Schools Tryit Editor - HTML Forms']"));

       //driver.findElement(By.id("accept-choices")).click();
       actionsClass.click(By.id("accept-choices"));
       driver.switchTo().frame("iframeResult");
       //System.out.println(driver.findElement(By.id(")).getText());

        actionsClass.clearAndSendKeys(By.id("fname"),("Alona"));
        actionsClass.clearAndSendKeys(By.id("lname"),("Dukhovnikova"));
        actionsClass.click (By.xpath("//input[@type='submit']"));
       System.out.println(actionsClass.getTextFromElement(By.xpath("//*[contains(text(),' This tutorial will not teach you') ]")));

// Переключаемся на вторую вкладку
        driver.switchTo().window(handle2);
        Thread.sleep(5000);
        actionsClass.click(By.id ("ez-accept-all"));
        System.out.println(driver.getTitle());

        actionsClass.sendKeys(By.name("LastName"), "Dukhovnikova");
        actionsClass.sendKeys(By.name("FirstName"), "Alona");
        Thread.sleep(7000);
       actionsClass.sendKeys(By.id("DateOfBirthDay"), "19");
       actionsClass.sendKeys(By.id("DateOfBirthMonth"), "04");
       actionsClass.sendKeys(By.id("DateOfBirthYear"), "1990");

        Select country = new Select(driver.findElement(By.id ("Country")));
        country.selectByVisibleText("Ukraine");

        actionsClass.sendKeys(By.id("State"), "Odesa");
        actionsClass.sendKeys(By.name("EmailAddress"), "alena19apr@gmail.com");
        actionsClass.sendKeys(By.name("ConfirmEmailAddress"), "alena19apr@gmail.com");
        actionsClass.sendKeys(By.id("Password"), "1234567");
        actionsClass.sendKeys(By.id("ConfirmPassword"), "12345678");
        actionsClass.click(By.xpath("//button[@class='btn btn-primary blue']"));
        System.out.println(actionsClass.getTextFromElement(By.xpath("//span[@for='ConfirmPassword']")));

        Thread.sleep(1500);
        driver.switchTo().window(handle3);
        Thread.sleep(1500);
        actionsClass.click(By.xpath("//p[text()='Consent']"));

        actionsClass.click(By.id("alertBox"));
        Alert alert1=driver.switchTo().alert();
        alert1.accept();
        System.out.println(actionsClass.getTextFromElement(By.id("output")));

        actionsClass.click(By.id("confirmBox"));
        Alert alert2=driver.switchTo().alert();
        alert2.dismiss();
        System.out.println(actionsClass.getTextFromElement(By.id("output")));

        actionsClass.click(By.id("promptBox"));
        Alert alert3=driver.switchTo().alert();
        alert3.sendKeys("Final step of this task");
        alert3.accept();
        System.out.println(actionsClass.getTextFromElement(By.id("output")));

        //  System.out.println(driver.getTitle());
    }


}
