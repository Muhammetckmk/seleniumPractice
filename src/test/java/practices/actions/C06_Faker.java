package practices.actions;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;

import java.util.Locale;

public class C06_Faker {
    @Test
    void test01() {

        Faker faker = new Faker();

        //faker objesi ile fake bir isim yazdırınız
        System.out.println(faker.name().firstName());

        //faker objesi ile fake bir soyisim yazdırınız
        System.out.println(faker.name().lastName());

        //faker objesi ile fake bir adress yazdırınız
        System.out.println(faker.address().fullAddress());

        //faker objesi ile fake bir telefon No yazdırınız
        System.out.println(faker.phoneNumber().phoneNumber());

        //faker objesi ile fake bir email yazdırınız
        System.out.println(faker.internet().emailAddress());

        //faker objesi ile fake bir rastgele 15 haneli bir sayi yazdırınız
        System.out.println(faker.number().digits(15));

        //faker objesi ile fake bir isimsoyisim yazdırınız
        System.out.println(faker.name().fullName());

    }

    @Test
    void test02() {
        Faker faker = new Faker( new Locale("tr"));
        System.out.println(faker.name().fullName());

    }


}
