package CW_31_05_2024;


import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class LocatorsTest  extends BaseTest {

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
    }


    @Test
    public void cssTest() throws InterruptedException {

        Thread.sleep(2000);
        WebElement userName = driver.findElement(By.cssSelector("#user-name"));
        WebElement pass = driver.findElement(By.cssSelector("#password"));


        userName.sendKeys("standard_user");
        pass.sendKeys("secret_sauce");
        Thread.sleep(1000);

        WebElement loginBtn = driver.findElement(By.id("login-button"));
        loginBtn.click();
        Thread.sleep(1000);

        WebElement title = driver.findElement(By.cssSelector(".title"));
        String stringTitle = title.getText();

        Assertions.assertEquals("Products", stringTitle);

    }

    @Test
    public void xPathTest() throws InterruptedException {
        driver.get("https://www.saucedemo.com/");
        Thread.sleep(2000);
        WebElement userName = driver.findElement(By.xpath("//*[@id=\"user-name\"]"));
        WebElement pass = driver.findElement(By.xpath("//*[@id=\"password\"]"));


        userName.sendKeys("standard_user");
        pass.sendKeys("secret_sauce");
        Thread.sleep(1000);

        WebElement loginBtn = driver.findElement(By.xpath("//*[@id=\"login-button\"]"));
        loginBtn.click();
        Thread.sleep(1000);

        WebElement title = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span"));
        String stringTitle = title.getText();

        Assertions.assertEquals("Products", stringTitle);

    }

}
