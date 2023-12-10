package pageObj;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertTrue;


public class ToolBar {
    WebDriver driver;
    private  By selectService = By.xpath("//i[@class='header-nav__icon icon-dropdown']");
    private  By listServices=By.xpath("//li[contains(@class,'dropdown open')]/div/ul");
    private  By fineGibdd=By.xpath("//li[contains(@class,'dropdown open')]/div/ul/li/a/span[text()='Штрафы ГИБДД']");

    public ToolBar(WebDriver driver) {
        this.driver = driver;
    }

   @Step("Проверка на отображение списка услуг" )
    public void checkServicesIsDisplayed() {
        assertTrue("Не отобразился спиcок услуг ",driver.findElement(listServices).isDisplayed());
    }
    @Step("Проверка на отображение пункта 'Штрафы ГИБДД'" )
    public void checkFinesGibddIsDisplayed() {
        assertTrue("Не отобразился спиcок услуг ",driver.findElement(fineGibdd).isDisplayed());
    }
    @Step("Клик по кнопке выбрать услугу" )
    public void clickServiceBtn() {
        driver.findElement(selectService).click();
    }
    @Step("Переход на вкладку штрафы ГИБДД" )
    public void clickGibddBtn() {driver.findElement(fineGibdd).click();
    }

    }




