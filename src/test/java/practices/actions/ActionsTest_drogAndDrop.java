package practices.actions;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class ActionsTest_drogAndDrop extends TestBase {
    //Go to https://jqueryui.com/droppable/
    //Drag me to my target webelement onto the Drop here webelement

    @Test
    void drogAndDrop() {
        //https://jqueryui.com/droppable/ adresine gidelim
        driver.get("https://jqueryui.com/droppable/");

        //Drag me to my target webelementini Drop here webelementi üzerine bıkalım
        Actions actions=new Actions(driver);
        driver.switchTo().frame(0);
        WebElement box1 = driver.findElement(By.id("draggable"));
        WebElement box2 = driver.findElement(By.id("droppable"));
        actions.dragAndDrop(box1,box2).perform();
    waitFor(2);
    }

    @Test
    void drogAndDrop02() {
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
    void drogAndDrop03() {
        //https://jqueryui.com/droppable/ adresine gidelim
        driver.get("https://jqueryui.com/droppable/");

        //Drag me to my target webelementini Drop here webelementi üzerine bıkalım
        driver.switchTo().frame(0);
        Actions actions = new Actions(driver);
        WebElement drag = driver.findElement(By.id("draggable"));
        WebElement drop = driver.findElement(By.id("droppable"));
        actions.clickAndHold(drag)
                .moveByOffset(170,35)
                .release()
                .perform();
    }
    /*
    homework
    Drag webelementinin drop webelementinin üzerine birakildigini test edin
     */

}
