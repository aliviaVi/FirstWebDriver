package CW_31_05_2024;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;


public class SelectOneTests extends BaseTest {

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/select-menu");
    }

    @Test
    public void selectOneFromListTest() {
        WebElement selectOne = driver.findElement(By.cssSelector("#selectOne"));
        selectOne.click();
        List<WebElement> elementList = driver.findElements(By.cssSelector("#selectOne > div.css-26l3qy-menu > div > div > div:nth-child(2)>div"));

        for (int i = 0; i < elementList.size(); i++) {
            if (elementList.get(i).getText().equals("Ms.")) {
                elementList.get(i).click();
                break;
            }
        }
        WebElement selectedValue = driver.findElement(By.cssSelector(".css-1pahdxg-control"));
        Assertions.assertEquals("Ms.", selectedValue.getText());

    }

    @Test
    public void selectFromOldStyleMenuTest() {
        WebElement selector = driver.findElement(By.cssSelector("#oldSelectMenu"));
        selector.click();
        List<WebElement> listOfOldStyleElements = driver.findElements(By.cssSelector("#oldSelectMenu>option"));
        String nameSelectedElement = "";
        for (WebElement element : listOfOldStyleElements) {
            if (element.getText().equals("Voilet")) {
                nameSelectedElement = element.getAccessibleName();
                element.click();
                break;
            }
        }
        Assertions.assertEquals("Voilet", nameSelectedElement);
    }

    @Test
    public void multiselectDropDownTest() {
        WebElement multySelect = driver.findElement(By.xpath("//*[@id=\"selectMenuContainer\"]/div[7]/div/div"));
        multySelect.click();

        List<WebElement> elementList = driver.findElements(By.cssSelector("div[id^=react-select-4-option]"));
        for (int i = 0; i < elementList.size() - 2; i++) {
            elementList.get(i).click();

        }

        //css-12jo7m5
        List<WebElement> selectedElements = driver.findElements(By.cssSelector("div.css-12jo7m5"));

        Assertions.assertEquals("Green", selectedElements.get(0).getText());
        Assertions.assertEquals("Blue", selectedElements.get(1).getText());


    }

}
