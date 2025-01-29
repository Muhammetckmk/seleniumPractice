package practices.actions;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class C01_ActionsTest extends TestBase {
    //Go to https://the-internet.herokuapp.com/context_menu
    //Right click on the box
    //Test that the text appearing in Alert is “You selected a context menu”
    //Close the alert by clicking OK

    @Test
    void test01() {

        //https://the-internet.herokuapp.com/context_menu sitesine gidin
        driver.get("https://the-internet.herokuapp.com/context_menu");

        //Kutuya sag tıklayın
        WebElement box = driver.findElement(By.id("hot-spot"));
        Actions actions = new Actions(driver);
        actions.contextClick(box).perform();
        /*
        kullandigimiz actions methodlarini isleme almasi icin perform() methodunu kullanmaliyiz
         */

        //Alert’te cikan yazinin“You selected a context menu”oldugunu test edin
        String expectedData ="ou selected a context menu";
        String actualData = driver.switchTo().alert().getText();
        assertEquals(expectedData,actualData,"ActualData ile Expected Data uyumlu degil");

        //Tamam diyerek alert’i kapatın
        driver.switchTo().alert().accept();

    }
}
