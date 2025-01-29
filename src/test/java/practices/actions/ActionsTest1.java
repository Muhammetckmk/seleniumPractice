package practices.actions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ActionsTest1 extends TestBase {




    //Go to https://the-internet.herokuapp.com/context_menu
    //Right click on the box
    //Test that the text appearing in Alert is “You selected a context menu”
    //Close the alert by clicking OK

    @Test
    void sagTik() {

        //https://the-internet.herokuapp.com/context_menu sitesine gidin
        driver.get("https://the-internet.herokuapp.com/context_menu");

        //Kutuya sag tıklayın
        Actions actions= new Actions(driver);
        WebElement box= driver.findElement(By.id("hot-spot"));
        actions.contextClick(box).perform();


        //Alert’te cikan yazinin“You selected a context menu”oldugunu test edin
       Assertions.assertEquals("You selected a context menu",driver.switchTo().alert().getText());


        //Tamam diyerek alert’i kapatın
        driver.switchTo().alert().accept();

    }

    //Go to Amazon https://www.amazon.com/
    //Go to the "Account & Lists" menu in the upper right section and click on the "Account" option
    //Verify that the title of the opened page contains “Your Account”

    @Test
    void moveTo() {

        //Amazon a gidelim https://www.amazon.com/
        driver.get("https://www.amazon.com/");
        waitFor(3);

        //Sag ust bolumde bulunan “Account & Lists” menüsüne git ve bekle,  “Account” secenegine tikla
        Actions actions=new Actions(driver);
        WebElement accoundList = driver.findElement(By.id("nav-link-accountList"));
        actions.moveToElement(accoundList).perform();

         driver.findElement(By.xpath("(//a[@class='nav-link nav-item'])[3]")).click();
        //Acilan sayfanin Title in “Your Account” icerdigini dogrula
        Assertions.assertTrue(driver.getTitle().contains("Your Account"));

    }
}
