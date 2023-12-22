package homework1;

import DriverSetUp.DriverSetUp;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.util.Set;

public class Task1 {
    //Написать программу, которая будет открывать пять различных страниц в новых окнах:
    //https://uhomki.com.ua/ru/koshki/1074/
   // https://zoo.kiev.ua/
   // https://www.w3schools.com/
   // https://taxi838.ua/ru/dnepr/
   // https://klopotenko.com/

   // Прописать цикл, который будет переключаться поочередно через все страницы,
    //для каждой страницы выводить в консоль название и ссылку на эту страницу.
   // И будет закрывать ту страницу в названии которой есть слово зоопарк.

    public static void openLinkInANewTab (WebDriver driver, String url) {
        Set<String> set1 = driver.getWindowHandles();
        ((JavascriptExecutor)driver).executeScript("window.open()");
        Set<String> set2 = driver.getWindowHandles();
        set2.removeAll(set1);
        String newDescriptor = set2.iterator().next();
        driver.switchTo().window(newDescriptor);
        driver.get(url);
    }

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = DriverSetUp.setUpDriver();
        driver.get("https://uhomki.com.ua/ru/koshki/1074/");
        System.out.println(driver.getTitle());
        openLinkInANewTab(driver, "http://zoo.kiev.ua/");
        System.out.println(driver.getTitle());
        openLinkInANewTab(driver,"https://www.w3schools.com/");
        System.out.println(driver.getTitle());
        openLinkInANewTab(driver,"https://taxi838.ua/ru/dnepr/");
        System.out.println(driver.getTitle());
        openLinkInANewTab(driver,"https://klopotenko.com/");
        System.out.println(driver.getTitle());
        Thread.sleep(2000);
        Set<String> handlers = driver.getWindowHandles();


        for (String handler: handlers){
            driver.switchTo().window(handler);
               if (driver.getTitle().contains("Зоопарк")){
                   System.out.println(" название страницы : " + driver.getTitle() + " ссылка на страницу : " + driver.getCurrentUrl());
                    handlers.remove(driver.getWindowHandles());}
                else{
                    System.out.println(" название страницы : " + driver.getTitle() + " ссылка на страницу : " + driver.getCurrentUrl());

    }
        }
        Thread.sleep(2000);
       driver.quit();
    }

    }

