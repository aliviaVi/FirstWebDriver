package CW_31_05_2024;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;




public class RadioButtonTest extends BaseTest{

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/radio-button");
    }



    @Test
    public void ClickRadioBtnYes(){
        WebElement radioBtnYes = driver.findElement(By.cssSelector("div.custom-radio"));
        WebElement yesRadio = radioBtnYes.findElement(By.id("yesRadio"));

        radioBtnYes.click();

        Assertions.assertTrue(yesRadio.isSelected());
    }

    @Test
    public void ClickRadioBtnImpressiveTest(){
        WebElement radioBtnImpressive = driver.findElement(By.cssSelector("div.custom-radio:nth-of-type(3) "));


        radioBtnImpressive.click();
        WebElement textImpressive = driver.findElement(By.cssSelector("p.mt-3"));
        String textImpressiveText = textImpressive.getText();

        Assertions.assertEquals("You have selected Impressive", textImpressiveText);
    }
}
