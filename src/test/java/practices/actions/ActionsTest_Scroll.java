package practices.actions;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class ActionsTest_Scroll extends TestBase {
      /*
    Eger bir webelement pencerede görünür değilse driver bu webelementi bulamayabilir,
    daha sağlikli bir test icin scroll yaparak
    bu webelementi görünür yapmamiz gerekir
     */

    @Test
    void scroll01() {

        //Techpro education sayfasina gidelim
        driver.get("https://techproeducation.com");


        //sayfayi istedigimiz kadar asagiya doğru scroll yapalim
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        waitFor(3);
        actions.sendKeys(Keys.PAGE_UP).perform();
        //sayfayi istedigimiz kadar yukariya doğru scroll yapalim

        for (int i = 0; i < 5; i++) {
            actions.sendKeys(Keys.PAGE_DOWN).perform();
            waitFor(1);
        }
        for (int i = 0; i < 5; i++) {
            actions.sendKeys(Keys.PAGE_UP).perform();
            waitFor(1);
        }
    }

    @Test
    void scroll02() {

        //Techproeducation sayfasına gidelim
        driver.get("https://amazon.com");

        Actions actions = new Actions(driver);

        //Sayfanın en altına scroll yapalım
        actions.sendKeys(Keys.END).perform();
        waitFor(2);

        //Sayfanın en üstüne scroll yapalım
        actions.sendKeys(Keys.HOME).perform();
    }

    @Test
    void scroll03() {
        //Techproeducation sayfasına gidelim
        driver.get("https://techproeducation.com");

        //Events yazısına kadar scroll yapalım
        Actions actions = new Actions(driver);
        WebElement eventsText = driver.findElement(By.xpath("//h2[.='Events']"));
        actions.scrollToElement(eventsText).perform();
    }

    @Test
    void scroll0() {

        //Techpro education sayfasina gidelim
        driver.get("https://amazon.com");


        //sayfayi istedigimiz kadar asagiya doğru scroll yapalim
        Actions actions=new Actions(driver);
       //actions.sendKeys(Keys.PAGE_DOWN).perform();
       //waitFor(2);
       //actions.sendKeys(Keys.PAGE_UP).perform();
       //waitFor(2);


        //sayfayi istedigimiz kadar yukariya doğru scroll yapalim
        for (int i = 0; i < 4; i++) {
            actions.sendKeys(Keys.PAGE_DOWN).perform();
            waitFor(2);
        }
        for (int i = 0; i < 2; i++) {
            actions.sendKeys(Keys.PAGE_UP).perform();
            waitFor(2);
        }

        }
    }

