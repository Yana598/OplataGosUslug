package pageObj;


import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertTrue;

public class FinesGIBDD {
    WebDriver driver;
    private By searchDocuments = By.xpath("//div[@id='content-zone']/descendant::span[contains(text(),'док')]");
    private  By numberRegistration=By.xpath("//div[@class='tab-content']/descendant::input[1]");
    private  By numberDriverLicense=By.xpath("//div[@class='tab-content']/descendant::input[2]");
    private  By buttonSearch=By.xpath("//*[text()='Найти штрафы']");

    public FinesGIBDD(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Проверка на отображение инпута свид-во о регистрации " )
    public void checkNumberRegistrationIsDisplayed() {
        assertTrue("не отобразилось св-во о регистрации ",driver.findElement(numberRegistration).isDisplayed());
    }
    @Step("Проверка на отображение списка услуг" )
    public void checkDriverLicenseIsDisplayed() {
        assertTrue("не отобразился спиcок услуг ",driver.findElement(numberDriverLicense).isDisplayed());
    }
    @Step("Выбор вкладки поиск по документам" )
    public void clickSearchDocuments() {
        driver.findElement(searchDocuments).click();
    }

    @Step("Ввод номера свидетельства о регистрации" )
    public void setNumberRegistration(String number) {
        driver.findElement(numberRegistration).sendKeys(number);
    }

    @Step("Клик по кнопке поиска" )
    public void clickButtonSearch() {
        driver.findElement(buttonSearch).click();
    }

    @Step("Проверка URL" )
    public void checkURL() {
        Assert.assertEquals("Адрес неверный","https://oplatagosuslug.ru/shtrafy_gibdd/",driver.getCurrentUrl());
    }

}
