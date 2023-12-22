package Homework2;

import DriverSetUp.DriverSetUp;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class Task2 {
   // 2) http://www.ashortjourney.com/
   // Написать программу, которая будет автоматизировать сценарий показанный на видео "Сценарий для автоматизии.mp4".
   public static void dragNdrop(int x, int y, WebDriver driver){
       Actions actions = new Actions(driver);
       actions.moveToElement(driver.findElement(By.cssSelector("[r='40']")))
               .clickAndHold().moveToElement(driver.findElement(By.cssSelector("[r='8']")), x, y).release().build().perform();

   }
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = DriverSetUp.setUpDriver();
        driver.get("http://www.ashortjourney.com/");
        Thread.sleep(10000);
        dragNdrop(0, 30, driver);
        Thread.sleep(10000);
        dragNdrop(0, -30, driver);
        Thread.sleep(7000);
        dragNdrop(30, 0, driver);
        Thread.sleep(7000);
        dragNdrop(-30, 0, driver);
        Thread.sleep(7000);
        dragNdrop(-40, 0, driver);
        Thread.sleep(7000);
        dragNdrop(30, 0, driver);
        Thread.sleep(7000);
        dragNdrop(0, -10, driver);
        Thread.sleep(7000);
        driver.findElement(By.tagName("textarea")).sendKeys("Задание выполнено!");
        Thread.sleep(3000);
driver.quit();
    }
}
