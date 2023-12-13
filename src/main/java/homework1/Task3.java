package homework1;

import DriverSetUp.DriverSetUp;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Task3 {
    //Написать метод который выводит сообщение об айди элемента,
    //значении тэга элемента , значении класса элемента,
    //значении атрибута name элемента, текста данного элемента,
    //а также о координатах центра контейнера данного элемента.

    public static void GetInfo(WebElement webElement) {
        System.out.println("Id of the elements is : " + webElement.getAttribute("id"));
        System.out.println("Tag name of the elements is : " + webElement.getTagName());
        System.out.println("Class of the elements is : " + webElement.getAttribute("class"));
        System.out.println("Name of the elements is : " + webElement.getAttribute("name"));
        System.out.println("Text of the elements is : " + webElement.getText());
    }

    public static void GetCoordinatesX (WebElement webElement) {
    int x = webElement.getLocation().x + webElement.getSize().width/2;
        System.out.println("coordinates of the center of container: " + x);

    }
    public static void GetCoordinatesY (WebElement webElement) {
        int y = webElement.getLocation().y + webElement.getSize().height/2;
        System.out.println("coordinates of the center of container: " + y);

    }



    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = DriverSetUp.setUpDriver();
        driver.get("https://www.guinnessworldrecords.com/search");

        WebElement webElement = driver.findElement(By.id("search-button"));
        GetInfo(webElement);
        Thread.sleep(2000);
        GetCoordinatesX(webElement);

        GetCoordinatesY(webElement);
    }
}