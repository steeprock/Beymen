package org.example.page;

import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.apache.commons.logging.Log;
import static org.example.utils.Driver.webDriver;
import static org.junit.Assert.assertEquals;


public class Search {


    public String productprice1;
    public String productprice2;
    public String productprice3;
    private static final Log log = LogFactory.getLog(Search.class);



    public void kelimeAra(String term) {
        log.info("====Arama yapılıyor====");
        webDriver.findElement(By.xpath("//div[@class='input-wrapper']")).click();
        WebElement searchEt = webDriver.findElement(By.xpath("//input[@class='default-input o-header__search--input']"));
        searchEt.sendKeys(term);
        WebElement aramaIcon = webDriver.findElement(By.xpath("//*[@class='icon icon-search']"));
        aramaIcon.click();
    }


    public void productTik(Integer productNo) throws InterruptedException {
        log.info(productNo + ". product is selecting");
        WebElement productTikla = webDriver.findElement(By.xpath("(//div[@class='m-productCard__photo'])["+productNo+"]"));
        WebElement TL = webDriver.findElement(By.xpath("((//*[@class='m-productCard__newPrice'])["+productNo+"]"));
        productprice1 = (TL.getText() + " TL");
        System.out.println("Ürün fiyatı:"+productprice1);
        productTikla.click();
        Thread.sleep(5000);
    }



    public void addToCart()throws InterruptedException{
        log.info("====Secilen urun sepete ekleniyor====");
       WebElement beden = webDriver.findElement(By.xpath("(//span[@class='m-variation__item'])[1]"));
        beden.click();
        WebElement TL = webDriver.findElement(By.id("priceNew"));
        productprice2 = (TL.getText() + " TL");
        System.out.println("Ürün fiyatı:"+productprice2);
        webDriver.findElement(By.id("addBasket")).click();
        WebElement sepeteGit = webDriver.findElement(By.xpath("//a[@title='Sepetim']"));
        sepeteGit.click();
        Thread.sleep(5000);
        WebElement checkUrun2 = webDriver.findElement(By.xpath("//span[@class='m-productPrice__salePrice']"));
        System.out.println("Ürün fiyatı:"+checkUrun2.getText());
        productprice3 = checkUrun2.getText();

        log.info("====Price kontrolü yapılıyor====");
        assertEquals(productprice1,productprice2,productprice3);
    }




}