package practices.actions;

public class ActionsClass {

    /*
                Actions Class

    Bu clas  mause ve klavye ile yapabildiğimiz aksiyonları
    otomasyon testimize de aktarma imkanı sağlıyor.
        - sürükleyip bırakma
        - sağ tık
        - üzerine gelip bekleme
        - klavyedeki shift vs tuşları


    Adımlar:
    1-) Actions clasından obje oluşturulur ve içine driver atanır
    2-) web elementin locetoru alınır ve bir variable atanır.
    3-) action objesi üzerinden methotlar kullanılır ve methoda vebelementin variablesi atanır.
    4-) her komut perform() methodu ile bitirilir.


    Methotlar:
    A-) Mouse Base Actions
        .doubleClick();
        .clickAndHold(); --> Üzerine tıklar ve komut bekler
        .drogAndDrop(); --> bir noktadan diğerine sürükler ve bırakır
        .moveToElement(); --> mouse istediğimiz webelementinin üzerinde tutar
        .contextClick(); sağ tık yapar


    B-) Keyboard Base Actions
        .sendKeys(...); -->ögeye bir anahtar / karakter girer
        .keyDown(); -->bellirtiklen tula basar
        .keyUp(); -->basılı olan tuşu kaldırır


        *bir diğer yol:
        locatorVariable.sendKeys( Keys.SHIFT, "muhammet",
                                  Keys.SHIFT, "cakmak",
                                  Keys.ENTER)
     */


}
