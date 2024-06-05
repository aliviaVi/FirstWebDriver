package CW_31_05_2024;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static java.lang.Integer.parseInt;

public class ElementCollectionTests extends BaseTest {

    private static final Log log = LogFactory.getLog(ElementCollectionTests.class);

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
    }
    public void login() throws InterruptedException {
        WebElement userName = driver.findElement(By.cssSelector("#user-name"));
        WebElement pass = driver.findElement(By.cssSelector("#password"));


        userName.sendKeys("standard_user");
        pass.sendKeys("secret_sauce");
        Thread.sleep(1000);

        WebElement loginBtn = driver.findElement(By.id("login-button"));
        loginBtn.click();
    }


    @Test
    public void countElementInCartWithPriceEstimation() throws InterruptedException {
        login();
        List<WebElement> inventoryList = driver.findElements(By.cssSelector("div.inventory_item"));
        for (WebElement inventoryItem : inventoryList) {
            String[] inventoryItemPrices = inventoryItem.findElement(By.className("inventory_item_price")).getText().split("\\.");
            int inventoryPriceInt = Integer.parseInt(inventoryItemPrices[0].substring(1));
            if (inventoryPriceInt >= 10) {
                WebElement inventoryItemElement = inventoryItem.findElement(By.cssSelector("button.btn_inventory"));
                inventoryItemElement.click();
                Thread.sleep(1000);
            }
        }

        Thread.sleep(1000);
        WebElement shoppingCart = driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a/span"));

        Assertions.assertEquals(4, parseInt(shoppingCart.getText()));
    }

    @Test
    public void countElementInCart() throws InterruptedException {
        login();

        List<WebElement> addBtn = driver.findElements(By.cssSelector("button.btn_inventory"));

        for (WebElement addItem : addBtn) {
            addItem.click();
            Thread.sleep(1000);
        }
        WebElement shoppingCart = driver.findElement(By.cssSelector("#shopping_cart_container > a > span"));

        Assertions.assertEquals(parseInt(shoppingCart.getText()), addBtn.size());

    }

    @Test
    public void checkAllAcceptedUserNames() throws InterruptedException {
        List<WebElement> allUserNames = driver.findElements(By.xpath("//div/br"));

        Assertions.assertEquals(6, allUserNames.size());
    }

    @Test
    public void sortItemsTest() throws InterruptedException {
       login();

        WebElement sortContainerLastElement = driver.findElement(By.cssSelector("select option:last-child"));
        sortContainerLastElement.click();
        List<WebElement> inventoryList = driver.findElements(By.cssSelector("div.inventory_item"));

        WebElement inventoryItemPrice = inventoryList.get(0).findElement(By.className("inventory_item_price"));

        Assertions.assertEquals("$49.99", inventoryItemPrice.getText());

    }


}
