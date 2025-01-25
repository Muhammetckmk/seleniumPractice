package practices.annotation_locators;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class locators {



    @Test
    void name() throws InterruptedException {
        WebDriver driver= new ChromeDriver();

        // https://www.amazon.com/ adresine git
        driver.get("https://www.amazon.com/");
        Thread.sleep(3000);



        //searcbox ı id ile locate et ve kalem ara
        //WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        //searchBox.sendKeys("kalem"+ Keys.ENTER);
        Thread.sleep(3000);
        //sepet i className ile locate et ve sepete git
        // driver.findElement(By.className("stylehome1 h0"));

        // today's Deal's ı linktext ile al ve eşit olduğunu doğrula
        //WebElement element = driver.findElement(By.linkText("Today's Deals"));
        // Assertions.assertEquals("Today's Deals",element.getText());
        // particalLinkTest ile al ve "Deal" içerdiğini doğrula
        WebElement deals = driver.findElement(By.partialLinkText("Deals"));
        Assertions.assertTrue(deals.getText().contains("Deal"));
        driver.close();



    }


}
