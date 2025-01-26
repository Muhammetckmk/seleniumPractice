package practices.annotation_locators;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C01_Iframe extends TestBase {

/*
            ==> Bir web elementi locate ettikten sonra NoSuchElementException aliyorsak oncelikle locate i kontrol ederiz
            buna ragmen ayni hatayi aliyorsak locate etmek istedigimiz webelement iframe icinde olabilir. Dolasiyla iframe
            icindeki bir webelement ile driver i etkilesime gecirebilmek icin driveri iframe e gecis yaptirmamiz gerekir
            1) driver.switchTo().iframe(iframe indexi -> index 0 dan baslar)
            2) driver.switchTo().iframe(<iframe id="abc", name="abc" > id / name attribute degeri)
            3) driver.switchTo().iframe(iframe i locate ederek webelement olarak)
            4) Eger ic ice nested iframelere gecis yaptiysak ve tekrar ana sayfaya gecis yapmak istersek driver.switchTo().default()
            5) bir ust frame gecis yapmak icinde driver.switchTo().parentFrame() methodunu kullanabiliriz

            */

    @Test
    void test01() {



        // https://testcenter.techproeducation.com/index.php?page=iframe

        driver.get("https://testcenter.techproeducation.com/index.php?page=iframe");

        // anasayfadaki 'An iframe with a thin black border:' metninde 'black border'
        // yazisinin oldugunu test edin

        WebElement text = driver.findElement(By.xpath("//p[text()='An iframe with a thin black border:']"));
        Assertions.assertTrue(text.getText().contains("black border"));


        // ayrica 'Applications lists' yazisinin sayfada oldugunu test edin

        driver.switchTo().frame(driver.findElement(By.xpath("//iframe")));
        WebElement baslik = driver.findElement(By.tagName("h1"));
        Assertions.assertEquals("Applications lists",baslik.getText());


        // sayfada iframe yazisinin oldugunu test edin

        driver.switchTo().defaultContent();
        WebElement Title = driver.findElement(By.xpath("//h3"));
        Assertions.assertEquals("iframe",Title.getText());




    }

//    @Test
//    void test02() {
//
//        // https://the-internet.herokuapp.com/iframe sayfasina gidin
//
//        driver.get("https://the-internet.herokuapp.com/iframe");
//
//        // Kalin yazini "Editor" kelimesini icerdigini dogrulayiniz
//
//        String actualText = driver.findElement(By.xpath("//h3")).getText();
//        Assertions.assertTrue(actualText.contains("Editor"));
//
//        // Textboxun icindeki metin 'Your content goes here' oldugunu test edin
//
//        driver.switchTo().frame("mce_0_ifr"); //-> id attribute value su ile gecis
//        String actualTextBox = driver.findElement(By.xpath("//p[.='Your content goes here.']")).getText();
//        String expectedtextBox = "Your content goes here.";
//        Assertions.assertEquals(expectedtextBox,actualTextBox);
//
//        // Sayfadaki "Elemental Selenium" yazisinin oldugunu test edin
//
//        driver.switchTo().defaultContent();
//        driver.navigate().refresh();//eger iframe icinde form vs doldurulmuyorsa kullanabilir
//        String actualElementSeleniumText = driver.findElement(By.partialLinkText("Elemental Selenium")).getText();
//        Assertions.assertEquals("Elemental Selenium",actualElementSeleniumText);
//
//    }



}
