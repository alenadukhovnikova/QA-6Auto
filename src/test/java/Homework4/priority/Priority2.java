package Homework4.priority;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
public class Priority2 {
    static WebDriver driver;
    @Test (dependsOnMethods = {"b"})
    public void a () {
        Assert.assertTrue(true);
    }
    @Test (dependsOnMethods = {"c"})
    public void b () {
        Assert.assertTrue(true);
    }
    @Test (dependsOnMethods = {"d"})
    public void c () {
        Assert.assertTrue(true);
    }
    @Test (dependsOnMethods = {"e"})
    public void d () {
        Assert.assertTrue(true);
    }
    @Test (dependsOnMethods = {"f"})
    public void e () {
        Assert.assertTrue(true);
    }
    @Test (dependsOnMethods = {"g"})
    public void f () {
        Assert.assertTrue(true);
    }
    @Test //(dependsOnMethods = {"a"})
    public void g () {
        Assert.assertTrue(true);
    }


}
