package homework1;

import DriverSetUp.DriverSetUp;
import org.openqa.selenium.*;

import java.util.List;

public class Task2 {
    //Написать метод в параметры которого принимаются два ВебЭлемента.
    //метод выводит в консоль информацию какой из двух элементов располагается  выше на странице,
    //какой из элементов располагается левее на странице,
    //а также какой из элементов занимает большую площадь.
    //Параметры метода могут также включать в себя другие аргументы, если это необходимо.

    public static void whatIsHighest(WebElement webElement, WebElement webElement2, WebDriver driver) {
        if (webElement.getSize().height > webElement2.getSize().height) {
            System.out.println("выше на странице элемент : " + webElement);
        } else {
            System.out.println("выше на странице элемент : " + webElement2);
        }
    }

    public static void whatIsLefter(WebElement webElement, WebElement webElement2, WebDriver driver) {
        if (webElement.getSize().width > webElement2.getSize().width) {
            System.out.println("левее на странице элемент : " + webElement);
        } else {
            System.out.println("левее на странице элемент : " + webElement2);
        }
    }

    public static void whatIsBiggest(WebElement webElement, WebElement webElement2, WebDriver driver) {
        int square = webElement.getSize().height * webElement.getSize().height;
        int square2 = webElement2.getSize().height * webElement2.getSize().height;

        if (square > square2) {
            System.out.println("больше площадь у веб элемента : " + webElement);
        } else {
            System.out.println("больше площадь у веб элемента : " + webElement2);
        }
    }




    public static void main(String[] args) {

        WebDriver driver = DriverSetUp.setUpDriver();
        driver.get("https://www.guinnessworldrecords.com/search");

        WebElement webElement = driver.findElement(By.id("search-button"));
        WebElement webElement2 = driver.findElement(By.cssSelector(".icon.icon-search"));

    whatIsHighest(webElement,webElement2, driver);
    whatIsBiggest(webElement, webElement2, driver);
    whatIsLefter(webElement, webElement2, driver);


    }


    }

