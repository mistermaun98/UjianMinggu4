package com.juaracoding.ujian4.testmodules;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.juaracoding.ujian4.modules.CatatanKeuangan;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class CatatanKeuanganTest {
    private static AndroidDriver<MobileElement> driver;
    private CatatanKeuangan ck;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("appium:deviceName", "SM_A530F");
        capabilities.setCapability("appium:udid", "5200ee25c080c49f");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("appium:platformVersion", "11.0");
        capabilities.setCapability("appium:appPackage", "com.chad.financialrecord");
        capabilities.setCapability("appium:appActivity", "com.rookie.catatankeuangan.feature.splash.SplashActivity");
        capabilities.setCapability("appium:ensureWebviewsHavePages", true);
        capabilities.setCapability("appium:nativeWebScreenshot", true);
        capabilities.setCapability("appium:newCommandTimeout", 3600);
        capabilities.setCapability("appium:connectHardwareKeyboard", true);

        driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }

    @BeforeMethod
    public void pageObject() {
        ck = new CatatanKeuangan(driver);
    }

    @Test(priority = 1)
    public void testIncome() {
        delay(5);
        ck.addIncome();
        System.out.println("Saldo pemasukan : "+ck.fetchSaldoIncome());
        Assert.assertEquals(ck.fetchSaldoIncome(),"5.000.000");
    }

    @Test(priority = 2)
    public void testExpenseAndBalance() {
        delay(3);
        ck.addExpense();
        System.out.println("Saldo Pengeluaran : "+ck.fetchSaldoExpense());
        System.out.println("Sisa Saldo : "+ck.fetchBalance());
        Assert.assertEquals(ck.fetchSaldoExpense(),"200.000");
        Assert.assertEquals(ck.fetchBalance(),"4.800.000");
    }

    @AfterClass
    public void closeApp() {
        driver.quit();
    }

    static void delay(long detik){
        try {
            Thread.sleep(detik*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
