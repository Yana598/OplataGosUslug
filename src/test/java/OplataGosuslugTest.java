import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObj.FinesGIBDD;
import pageObj.Payment;
import pageObj.ToolBar;

import java.util.concurrent.TimeUnit;

public class OplataGosuslugTest {

    WebDriver driver;
    public String numberSR="7813690343";

    @Before
    public void initTest(){
        WebDriverManager.firefoxdriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://oplatagosuslug.ru/");}
    @After
    public void teardown() {
        // Закрываем браузер
        driver.quit();
    }

    @Test
    @DisplayName("Успешный поиск штрафа ГИБДД ")
    public void succesSearchFine() {

        ToolBar toolBar = new ToolBar(driver);
        toolBar.checkLogoIsDisplayed();
        toolBar.clickServiceBtn();
        toolBar.checkServicesIsDisplayed();
        toolBar.checkFinesGibddIsDisplayed();
        toolBar.clickGibddBtn();

        FinesGIBDD finesGIBDD = new FinesGIBDD(driver);
        finesGIBDD.checkURL();
        finesGIBDD.clickSearchDocuments();
        finesGIBDD.checkDriverLicenseIsDisplayed();
        finesGIBDD.checkNumberRegistrationIsDisplayed();
        finesGIBDD.setNumberRegistration(numberSR);
        finesGIBDD.clickButtonSearch();

        Payment payment = new Payment(driver);
        payment.checkSearchDocForPay();
        payment.checkFormBankPayisDisplayed();
        payment.checkFormTelPayisDisplayed();
        payment.checkFormYandexPayisDisplayed();
        payment.checkNumberSR(numberSR);
        payment.summWithKomCheck();
    }

    @Test
    @DisplayName("Добавление квитанции при оплате с телефона ")
    public void succesSearchFineWithPayTelDoc() {

        ToolBar toolBar = new ToolBar(driver);
        toolBar.checkLogoIsDisplayed();
        toolBar.clickServiceBtn();
        toolBar.checkServicesIsDisplayed();
        toolBar.checkFinesGibddIsDisplayed();
        toolBar.clickGibddBtn();

        FinesGIBDD finesGIBDD = new FinesGIBDD(driver);
        finesGIBDD.checkURL();
        finesGIBDD.clickSearchDocuments();
        finesGIBDD.checkDriverLicenseIsDisplayed();
        finesGIBDD.checkNumberRegistrationIsDisplayed();
        finesGIBDD.setNumberRegistration(numberSR);
        finesGIBDD.clickButtonSearch();

        Payment payment = new Payment(driver);
        payment.checkSearchDocForPay();
        payment.checkFormBankPayisDisplayed();
        payment.checkFormTelPayisDisplayed();
        payment.checkFormYandexPayisDisplayed();
        payment.checkNumberSR(numberSR);
        payment.selWithTelephone();
        payment.checkFieldTelPayisDisplayed();
        payment.selGetDocPayment();
        payment.summCheckTelWithDoc();
    }

}
