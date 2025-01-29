package practices.actions;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C07_FakerTest extends TestBase {
    //Go to https://www.globalsqa.com/samplepagetest/
    //Fill textboxes with fake data


    @Test
    void test01() {

        //https://www.globalsqa.com/samplepagetest/ sitesine gidin
        driver.get("https://www.globalsqa.com/samplepagetest/");

        //Textbox lari fake datalar ile doldurun
        Faker faker = new Faker();
        WebElement nameTextBox = driver.findElement(By.id("g2599-name"));
        nameTextBox.sendKeys(
                faker.name().firstName(), Keys.TAB,
                faker.internet().emailAddress(),Keys.TAB,
                faker.internet().domainName()
        );

        WebElement commentTextBox = driver.findElement(By.id("contact-form-comment-g2599-comment"));
        commentTextBox.sendKeys(faker.lorem().paragraph());
    }

    /*
//1. "https://facebook.com" Adresine gidin
//2. “create new account” butonuna basin
//3. “firstName” giris kutusuna bir isim yazin
//4. “surname” giris kutusuna bir soyisim yazin
//5. “email” giris kutusuna bir email yazin
//6. “email” onay kutusuna emaili tekrar yazin
//7. Bir sifre girin
//8. Tarih icin gun secin
//9. Tarih icin ay secin
//10. Tarih icin yil secin
//11. Cinsiyeti secin
//12. Isaretlediginiz cinsiyetin secili, diger cinsiyet kutusunun secili olmadigini test edin.
//13. Sayfayi kapatin

     */
}
