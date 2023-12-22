package Homework2;

import DriverSetUp.DriverSetUp;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.*;

public class Task1 {
    // 1) http://only-testing-blog.blogspot.com/2014/01/textbox.html?
    //Написать программу реализующую действие показанное на "видео1.mp4".
    //После выполнения программы на консоли должна выводится информация в следующем виде:
    //
    //Автомобили доступные для выбора:
    //Volvo, BMW, Opel, Audi, Toyota, Renault, Maruti Car.
    //Страны из первой таблицы:
    //USA, Russia, Japan, Mexico, India, Malaysia, Greece.
    //Страны из второй таблицы:
    //France, Germany, Italy, Spain.
    public static void fillMap(Map<Integer, String> map) {
        map.put(1, "Volvo");
        map.put(2, "BMV");
        map.put(3, "Opel");
        map.put(4, "Audi");
        map.put(5, "Toyota");
        map.put(6, "Renault");
        map.put(7, "Maruti Car");
    }

        public static void fillMap2 (Map<Integer, String> map) {
            map.put(10, "USA");
            map.put(11, "Russia");
            map.put(12, "Japan");
            map.put(13, "Mexico");
            map.put(14, "India");
            map.put(15, "Malaysia");
            map.put(16, "Greece");

    }

    public static void fillMap3 (Map<Integer, String> map) {
        map.put(17, "France");
        map.put(18, "Germany");
        map.put(19, "Italy");
        map.put(20, "Spain");

    }

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = DriverSetUp.setUpDriver();
        driver.get("http://only-testing-blog.blogspot.com/2014/01/textbox.html?");
        Thread.sleep(5000);
        Select car = new Select(driver.findElement(By.id("Carlist")));
        car.selectByVisibleText("Renault");
        Thread.sleep(5000);
        Select countries = new Select(driver.findElement(By.xpath("//select[@size='10'][1]")));
        countries.selectByVisibleText("France");
        countries.selectByVisibleText("India");
        countries.deselectByVisibleText("India");
        countries.selectByVisibleText("Germany");
        countries.selectByVisibleText("Italy");
        countries.selectByVisibleText("Malaysia");
        countries.deselectByVisibleText("Malaysia");
        countries.selectByVisibleText("Spain");

        driver.findElement(By.xpath("//input[@onclick='move(this.form.FromLB,this.form.ToLB)']")).click();

        Map<Integer, String> linkedHashMap = new LinkedHashMap<>();
        fillMap(linkedHashMap);
        System.out.println("Автомобили доступные для выбора:");
        for (Map.Entry<Integer, String> entry : linkedHashMap.entrySet()) {
            System.out.print(entry.getValue() + "," );
        }

        Map<Integer, String> linkedHashMap2 = new LinkedHashMap<>();
        fillMap2(linkedHashMap2);
        System.out.println("Страны из первой таблицы:");
        for (Map.Entry<Integer, String> entry : linkedHashMap2.entrySet()) {
            System.out.print(entry.getValue() + "," );
        }

        Map<Integer, String> linkedHashMap3 = new LinkedHashMap<>();
        fillMap3(linkedHashMap3);
        System.out.println("Страны из второй таблицы:" );
        for (Map.Entry<Integer, String> entry : linkedHashMap3.entrySet()) {
            System.out.print(entry.getValue() + "," );
        }
    }
        }
