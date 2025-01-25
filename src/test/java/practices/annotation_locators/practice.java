package practices.annotation_locators;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;



public class practice extends TestBase {
    // 1-) Senaryo: Google ana sayfasını açın, arama kutusunu locate edin ve görünür olduğunu doğrulayın.
    //Locator Yöntemi: name

    @Test
    void test01() {

        driver.get("https://google.com");

        WebElement aramakutusu = driver.findElement(By.name("q"));
        Assertions.assertTrue(aramakutusu.isDisplayed());

    }


    // 2-) Senaryo: Amazon ana sayfasını açın, "Ara" butonunu locate edin ve tıklanabilir olduğunu doğrulayın.
    //Locator Yöntemi: id
    //Locator Yöntemi2: id ve css

    @Test
    void test02() throws InterruptedException {
        driver.get("https://amazon.com");
        WebElement tikla = driver.findElement(By.cssSelector("input[type='text']"));
        Thread.sleep(3000);
        Assertions.assertTrue(tikla.isEnabled());


    }


    // 3-) Senaryo: Facebook giriş sayfasını açın, "Giriş Yap" butonunu locate edin ve metninin "Giriş Yap" olduğunu doğrulayın.
    //Locator Yöntemi: name

    @Test
    void test03() {
        driver.get("https://facebook.com");
        WebElement element = driver.findElement(By.xpath("//button[@name='login']"));
        Assertions.assertEquals("Log in",element.getText());
    }


    // 4-)Senaryo: Hepsiburada ana sayfasını açın, "Kategoriler" menüsünü locate edin ve görünür olduğunu doğrulayın.
    //Locator Yöntemi: cssSelector

    @Test
    void test04() {
        driver.get("https://Hepsiburada.com");
        WebElement elektrik = driver.findElement(By.xpath("//span[.='Elektronik']"));
        Assertions.assertTrue(elektrik.isDisplayed());
    }


    // 5-)Senaryo: Twitter giriş sayfasını açın, şifre alanını locate edin ve içeriğinin boş olduğunu doğrulayın.
    //Locator Yöntemi: xpath


    // 6-)Senaryo: YouTube ana sayfasını açın, arama kutusunu locate edin ve placeholder metninin "Search" olduğunu doğrulayın.
    //Locator Yöntemi: name

    // 7-)Senaryo: Trendyol ana sayfasını açın, "Sepetim" butonunu locate edin ve görünür olduğunu doğrulayın.
    //Locator Yöntemi: cssSelector

    // 8-)Senaryo: LinkedIn giriş sayfasını açın, şifre giriş alanını locate edin ve etkin olduğunu doğrulayın.
    //Locator Yöntemi: cssSelector

    // 9-)Senaryo: GitHub ana sayfasını açın, "Sign up for GitHub" linkini locate edin ve href özelliğinin "https://github.com/signup" olduğunu doğrulayın.
    //Locator Yöntemi: xpath

    // 10-) Senaryo: Instagram giriş sayfasını açın, kullanıcı adı giriş alanını locate edin ve görünür olduğunu doğrulayın.
    //Locator Yöntemi: cssSelector

}
