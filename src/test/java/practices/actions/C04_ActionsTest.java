package practices.actions;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C04_ActionsTest extends TestBase {
    //Go to https://jqueryui.com/droppable/
    //Drag me to my target webelement onto the Drop here webelement

    @Test
    void test01() {
        //https://jqueryui.com/droppable/ adresine gidelim
        driver.get("https://jqueryui.com/droppable/");

        //Drag me to my target webelementini Drop here webelementi üzerine bıkalım
        driver.switchTo().frame(0);
        Actions actions = new Actions(driver);
        WebElement drag = driver.findElement(By.id("draggable"));
        WebElement drop = driver.findElement(By.id("droppable"));
        actions.dragAndDrop(drag,drop).perform();//drag webelementini alip drop webelementinin üzerine birakir
    }

    @Test
    void test02() {
        //https://jqueryui.com/droppable/ adresine gidelim
        driver.get("https://jqueryui.com/droppable/");

        //Drag me to my target webelementini Drop here webelementi üzerine bıkalım
        driver.switchTo().frame(0);
        Actions actions = new Actions(driver);
        WebElement drag = driver.findElement(By.id("draggable"));
        WebElement drop = driver.findElement(By.id("droppable"));
        actions.clickAndHold(drag)//drag webelementine tıklar ve basılı tutar
                .moveToElement(drop)//drag webelementi tutup drop webelementinin üzerine götürür
                .release()//basili tutulan webelemeti serbest birakir
                .perform();

    }

    @Test
    void test03() {
        //https://jqueryui.com/droppable/ adresine gidelim
        driver.get("https://jqueryui.com/droppable/");

        //Drag me to my target webelementini Drop here webelementi üzerine bıkalım
        driver.switchTo().frame(0);
        Actions actions = new Actions(driver);
        WebElement drag = driver.findElement(By.id("draggable"));
        WebElement drop = driver.findElement(By.id("droppable"));
        actions.clickAndHold(drag)
                .moveByOffset(139,49)
                .release()
                .perform();
    }
    /*
    homework
    Drag webelementinin drop webelementinin üzerine birakildigini test edin
     */

}
