package practices.actions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C02_ActionsTest extends TestBase {
    //Go to Amazon https://www.amazon.com/
    //Go to the "Account & Lists" menu in the upper right section and click on the "Account" option
    //Verify that the title of the opened page contains “Your Account”

    @Test
    void test01() {

        //Amazon a gidelim https://www.amazon.com/
        driver.get("https://www.amazon.com/");
        waitFor(3);

        //Sag ust bolumde bulunan “Account & Lists” menüsüne git  “Account” secenegine tikla
        WebElement accountLists = driver.findElement(By.id("nav-link-accountList"));
        Actions actions = new Actions(driver);
        actions.moveToElement(accountLists).perform();//mouse u locate ettigimiz webelementin üzerine götürdük
        waitFor(2);

        driver.findElement(By.xpath("//span[.='Account']")).click();//acilan popup tan account linkine tikladik
        waitFor(2);

        //Acilan sayfanin Title in “Your Account” icerdigini dogrula
        Assertions.assertEquals("Your Account",driver.getTitle());

    }
}
