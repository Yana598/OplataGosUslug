package pageObj;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertTrue;

public class Payment {
    WebDriver driver;
    private  By selectWithTelephone = By.xpath("//div[@class='collapse collapse-form in']/descendant::li[2]/a");
    private  By getDocPayment = By.xpath("//div[@class='collapse collapse-form in']/descendant::label[contains(@class,'checkbox')][2]");

    private  By sumPay = By.xpath("//div[@class='panel-heading']/descendant::span");
    private  By sumFine = By.xpath("//article[contains(@class, 'discount')]//p[@class='pm-summ__value']");
    private  By searchDocForPay = By.xpath("//div[@id='content-zone']/p");
    private  By selectWithBankCard = By.xpath("//div[@class='collapse collapse-form in']/descendant::li[1]/a");
    private  By selectWithYandexPay = By.xpath("//div[@class='collapse collapse-form in']/descendant::li[3]/a");

    private By numberSR=By.xpath("//div[@id='panel-b1']/descendant::pre[2]");
    private By commisBank=By.xpath("//article[contains(@class, 'discount')]//div[@class='commission commission--card']/p[@class='commission__sum']/span");

    private By commisTel=By.xpath("//div[@class='panel-summ summ summ--no-accent']/span");
    private By fieldTelefon=By.xpath("//div[@class='controls mobile-pay__controls']/div/input");

    public Payment(WebDriver driver) {
        this.driver = driver;
    }


    @Step("Проверка отображения поля телефон ")
    public void checkFieldTelPayisDisplayed() {
        assertTrue("не отобразилась оплата через телефон" ,driver.findElement(fieldTelefon).isDisplayed());
    }
    @Step("Проверка номера свидетельства о регистрации" )
    public void checkNumberSR(String expected) {
        String actual=driver.findElement(numberSR).getText().substring(16);
        Assert.assertEquals(Integer.parseInt(expected.substring(0,1)),Integer.parseInt(actual.substring(0,1)));
        Assert.assertEquals(Integer.parseInt(expected.substring(7)),Integer.parseInt(actual.substring(7)));
    }
    @Step("Найдено начислений" )
    public void checkSearchDocForPay() {
        String actual=driver.findElement(searchDocForPay).getText();
        Assert.assertTrue(actual.contains("Найдено начислений"));
    }
    @Step("Проверка на отображение оплаты через телефон ")
    public void checkFormTelPayisDisplayed() {
        assertTrue("не отобразилась оплата через телефон" ,driver.findElement(selectWithTelephone).isDisplayed());
    }
    @Step("Проверка на отображение оплаты через банковскую карту " )
    public void checkFormBankPayisDisplayed() {
        assertTrue("не отобразилась оплата через банк карту ",driver.findElement(selectWithBankCard).isDisplayed());
    }
    @Step("Проверка на отображение оплаты через YandexPay " )
    public void checkFormYandexPayisDisplayed() {
        assertTrue("не отобразилась оплата через YandexPay ",driver.findElement(selectWithYandexPay).isDisplayed());
    }
    @Step("Оплата через телефон" )
    public void selWithTelephone() {driver.findElement(selectWithTelephone).click();
    }
    @Step("Квитанция на почту" )
    public void selGetDocPayment() {driver.findElement(getDocPayment).click();
    }
    @Step("Проверка сумм к оплате и штрафа при оплате с телефона с комиссией" )
    public void summCheckTelWithDoc() {
        String sFine=driver.findElement(sumFine).getText().replace(" руб.","");
        String sPay = (driver.findElement(sumPay).getText()).substring(9).replace(" руб.","");
        String komiss= (driver.findElement(commisTel).getText()).substring(1).replace(" руб.","");
        if (sFine.contains(",")){
            sFine=sFine.replace(",",".");}
        if  (sPay.contains(",")){
            sPay=sPay.replace(",",".");}
        if  (komiss.contains(",")){
            komiss=komiss.replace(",",".");}
        Assert.assertEquals("суммы не равны",Double.parseDouble(sFine), Double.parseDouble(sPay)+Double.parseDouble(komiss), 0.01);
    }

        @Step("Проверка сумм к оплате штрафа c комиссией банка" )
        public void summWithKomCheck() {
            String sFine=driver.findElement(sumFine).getText().replace(" руб.","");
            String sPay = (driver.findElement(sumPay).getText()).substring(9).replace(" руб.","");
            String komiss= (driver.findElement(commisBank).getText());
            if (sFine.contains(",")){
                    sFine=sFine.replace(",",".");}
            if  (sPay.contains(",")){
                    sPay=sPay.replace(",",".");}
            if  (komiss.contains(",")){
                    komiss=komiss.replace(",",".");}
            Assert.assertEquals("суммы не равны",Double.parseDouble(sFine), Double.parseDouble(sPay)+Double.parseDouble(komiss), 0.01);
}}