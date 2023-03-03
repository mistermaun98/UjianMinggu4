package com.juaracoding.ujian4.modules;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.support.PageFactory;

public class CatatanKeuangan {
    public AndroidDriver<MobileElement> driver;

    public CatatanKeuangan(AndroidDriver<MobileElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "com.chad.financialrecord:id/fabMenu")
    private MobileElement btnAddTransaction;

    @AndroidFindBy(id = "com.chad.financialrecord:id/btnIncome")
    private MobileElement btnIncome;

    @AndroidFindBy(id = "com.chad.financialrecord:id/btnExpense")
    private MobileElement btnExpense;

    @AndroidFindBy(id = "com.chad.financialrecord:id/btSave")
    private MobileElement btnSave;

    @AndroidFindBy(id = "com.chad.financialrecord:id/tvDate")
    private MobileElement date;

    @AndroidFindBy(id = "com.chad.financialrecord:id/spCategory")
    private MobileElement btnCategory;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='01 Maret 2023']")
    private MobileElement dateOneMarch;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[3]/android.widget.LinearLayout/android.widget.TextView")
    private MobileElement gajiIncome;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='03 Maret 2023']")
    private MobileElement dateThreeMarch;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[8]/android.widget.LinearLayout/android.widget.TextView")
    private MobileElement pulsaExpense;

    @AndroidFindBy(id = "android:id/button1")
    private MobileElement btnOkDate;

    @AndroidFindBy(id = "com.chad.financialrecord:id/etAmount")
    private MobileElement amount;

    @AndroidFindBy(id = "com.chad.financialrecord:id/etNote")
    private MobileElement note;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.view.ViewGroup[2]/android.widget.RelativeLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.TextView[1]")
    private MobileElement saldoIncome;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.view.ViewGroup[2]/android.widget.RelativeLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.TextView[2]")
    private MobileElement saldoExpense;

    @AndroidFindBy(id = "com.chad.financialrecord:id/tvBalance")
    private MobileElement balance;

    // Method add Income
    public void addIncome() {
        btnAddTransaction.click();
        btnIncome.click();
        date.click();
        dateOneMarch.click();
        btnOkDate.click();
        btnCategory.click();
        gajiIncome.click();
        amount.sendKeys("5000000");
        note.sendKeys("Gaji bulan maret");
        btnSave.click();
    }

    public void addExpense() {
        btnAddTransaction.click();
        date.click();
        dateThreeMarch.click();
        btnOkDate.click();
        btnCategory.click();
        pulsaExpense.click();
        amount.sendKeys("200000");
        note.sendKeys("Pulsa internet");
        btnSave.click();
    }

    public String fetchSaldoIncome() {
        return saldoIncome.getText();
    }
    public String fetchSaldoExpense() {
        return saldoExpense.getText();
    }
    public String fetchBalance() {
        return balance.getText();
    }
}
