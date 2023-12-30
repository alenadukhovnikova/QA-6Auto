package Homework4;

import DriverSetUp.DriverSetUp;
import Homework3.ActionsClass;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class Task5 {

    static WebDriver driver;
    static ActionsClass actionsClass;

    @BeforeClass
    public void precondition() {
        driver = DriverSetUp.setUpDriver();
        actionsClass = new ActionsClass(driver);
    }

    @AfterClass
    public void postConditions() {
        driver.quit();

    }


    @Test
    @Parameters("search")
    public void SearchTest(String search) throws InterruptedException {
        driver.get("https://www.foxtrot.com.ua/");
        Thread.sleep(3000);
        actionsClass.sendKeys(By.cssSelector(".header-search__field.evinent-search-input.evinent-active"), search);
        actionsClass.sendKeys(By.cssSelector(".header-search__field.evinent-search-input.evinent-active"), Keys.ENTER);
        Thread.sleep(1500);

        driver.findElement(By.xpath("//h1[cotains(text(),'найдено по запросу']"));

        if (true) {

            Assert.assertTrue(driver.findElement(By.xpath("//h1[cotains(text())]")).getText().contains(search));
            System.out.println("содержит искомое слово");
        } else if (true) {
            Assert.assertTrue(driver.findElement(By.xpath("//div[@class ='search-page__box']")).getText().contains(search));
            System.out.println("содержит искомое слово");
        } else {
            System.out.println("не содержит искомое слово");
        }

    }

}
