package hw_25_05_2024;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class TestPage {

    public WebDriver webDriver;


    @BeforeEach
    public void beforeEachMethod() {
        webDriver = new ChromeDriver();
        webDriver.get("https://the-internet.herokuapp.com/");
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterEach
    public void tearDown() {
        webDriver.quit();
    }


    @Test
    public void openPage() {
        System.out.println("test passed");
    }
}
