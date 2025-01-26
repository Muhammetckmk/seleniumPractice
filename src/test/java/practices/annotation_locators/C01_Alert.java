package practices.annotation_locators;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C01_Alert extends TestBase {

    /*
    *Eger bir sayfadaki bir butona tikladigimizda bir uyari penceresi cikiyorsaa ve bu cikan pencereye
    inspect locate alamiyorsak bu bir JS Alert tur
    ==> JS Alert u handle edebilmek icin driver imizi  pencereye gecirmemiz gerekir
    ==> Bunun icin driver objemizi uzerinden switchTo().alert() diyerek gecis yapabiliriz
    ==> accept() -> onaylar
    ==> dismiss() -> cancel a basar (iptal eder) */

    // https://testcenter.techproeducation.com/index.php?page=javascript-alerts adresine gidin

    @Test
    void acceptAlert() throws InterruptedException {

//        // 1-) bir method olusturun : acceptAlert
//        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
//
//
//        // birinci butona tiklayin
//
//        Thread.sleep(2000);
//        driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();
//
//
//
//        // uyaridaki ok butonuna tiklayin
//
//        Thread.sleep(2000);
//        driver.switchTo().alert().accept();
//
//
//        // result mesajinin "You successfully clicked an alert" oldugunu test edin
//
//        WebElement yazi = driver.findElement(By.id("result"));
//        Assertions.assertEquals("You successfully clicked an alert",yazi.getText());




    }

    @Test
    void dismissAlert() throws InterruptedException {

//        // 2-) bir method olusturun : dismissAlert
//
//        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
//
//        // ikinci butona tiklayin
//
//
//
//        Thread.sleep(2000);
//        driver.findElement(By.cssSelector("button[onclick='jsConfirm()']")).click();
//
//
//
//        // uyaridaki cancel butonuna tiklayin
//
//        Thread.sleep(2000);
//        driver.switchTo().alert().dismiss();
//
//
//        // result mesajinin "successfully" oldugunu test edin
//
//       WebElement cancel = driver.findElement(By.id("result"));
//       Assertions.assertEquals("successfully",cancel.getText());





    }

    @Test
    void sendKeysAlert() throws InterruptedException {

        // 3-) bir method olusturun : sendKeysAlert

        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");

        //driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");


        // ucuncu butona tiklayin


        Thread.sleep(2000);
        driver.findElement(By.cssSelector("button[onclick='jsPrompt()']")).click();

        // uyaridaki metin kutusuna isminizi yazin

        Thread.sleep(2000);
        driver.switchTo().alert().sendKeys("Arkadaslar Tekrar Yapin!!!");


        // ok butonuna tiklayin


        Thread.sleep(2000);
        driver.switchTo().alert().accept();

        // result mesajinda isminizin goruntulendigini dogrulayin

        WebElement Arkadaslar = driver.findElement(By.id("result"));
        Assertions.assertEquals("You entered: Arkadaslar Tekrar Yapin!!!",Arkadaslar.getText());



    }
}
