package annotation_locator;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class annotations {
static  WebDriver driver;
    @BeforeEach
    void each(){
        //Assertion clasını kullanarak örnekleri test et

        WebDriver driver=new ChromeDriver();

        // https://www.google.com/ sayfasına gidin
        driver.get("https://www.google.com/");
        //sayfayı büyütün
        driver.manage().window().maximize();
    }

    @AfterEach
    void after(){
        //sayfayı kapatın
        driver.quit();
    }

    @Test
    void test1() {

        //sayfanın URL sinin  "https://www.google.com/" olduğunu dğrulayın
        Assertions.assertEquals("https://www.google.com/",driver.getCurrentUrl());

    }


    @Test
    void name1() {

        //sayfanın title ı "google" içerdiğini doğrulayın
        Assertions.assertTrue(driver.getTitle().contains("Google"));//fail

    }
    @Test
    void name2() {

        //sayfanın title ı "com" içermediğini doğrulayın
        Assertions.assertFalse(driver.getTitle().contains("com"));

    }
    @Test
    void name3() {

        //sayfanın title ını bir string e alın
        // stringin boş olduğunu doğrulayın
        String title=driver.getTitle();
        Assertions.assertNull(title);//fail

    }
}
