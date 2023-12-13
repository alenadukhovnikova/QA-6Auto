package homework1;

import DriverSetUp.DriverSetUp;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Task4 {

    public static void main(String[] args) throws InterruptedException {
        //Написать программу, которая повторит действия на видео
        // "HW_AUTOMATION_LESSON_3_UPDATE.mp4".
           //     http://www.automationpractice.pl/index.php

        WebDriver driver = DriverSetUp.setUpDriver();
        driver.get("http://www.automationpractice.pl/index.php");
        String inputForSearch = "Printed Chiffon Dress";
        driver.findElement(By.xpath("//input[@id='search_query_top']")).sendKeys(inputForSearch);
        Thread.sleep(2000);
        driver.findElement(By.cssSelector(".btn.btn-default.button-search")).click();
        driver.findElement(By.xpath("//a[@title='Printed Chiffon Dress']")).click();
        driver.findElement(By.xpath("//*[text()='Add to cart']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[@class='continue btn btn-default button exclusive-medium']")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector(".sf-with-ul")).click();
        Thread.sleep(2000);
        String inputForSearch2 = "Faded Short";
        driver.findElement(By.xpath("//input[@id='search_query_top']")).sendKeys(inputForSearch2);
        driver.findElement(By.cssSelector(".btn.btn-default.button-search")).click();
        driver.findElement(By.xpath("//a[@title='Faded Short Sleeve T-shirts'][1]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[text()='Add to cart']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[@class='continue btn btn-default button exclusive-medium']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[@title='View my shopping cart']")).click();
        Thread.sleep(2000);
driver.quit();
    }
}
