package CW_31_05_2024;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class DucksPageTest extends BaseTest {
    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.get("https://litecart.stqa.ru/en/");
    }

    @Test
    public void checkAllPopularDucksTest() {
        List<WebElement> listOfDucks = driver.findElements(By.cssSelector("#box-most-popular div:first-child"));

        Assertions.assertEquals(5, listOfDucks.size());
    }

    @Test
    public void getAllDucksOnMainPageTest() {
        // List<WebElement> listOfAllDucks = driver.findElements(By.xpath("//*[@class='product column shadow hover-light']")) ;
        ArrayList<WebElement> images = (ArrayList<WebElement>) driver.findElements(By.className("image-wrapper"));

         Assertions.assertEquals(11,images.size());
    }
}

