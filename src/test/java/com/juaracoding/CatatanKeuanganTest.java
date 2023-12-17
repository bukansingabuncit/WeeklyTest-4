package com.juaracoding;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class CatatanKeuanganTest {
    private AndroidDriver driver;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability("deviceName", "Pixel 2 API 30");
        dc.setCapability("udid", "emulator-5554");
        dc.setCapability("platformName", "android");
        dc.setCapability("platformVersion", "11");
        dc.setCapability("appPackage", "com.chad.financialrecord");
        dc.setCapability("appActivity", "com.rookie.catatankeuangan.feature.splash.SplashActivity");
        dc.setCapability("noReset", true);
        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        AndroidDriver driver = new AndroidDriver(url, dc);
    }

    @AfterClass
    public void finish() {
        driver.quit();
    }

    @Test
    public void testIncome() {
        MobileElement btnFabMenu = (MobileElement) driver.findElementById("com.chad.financialrecord:id/fabMenu");
        MobileElement income = (MobileElement) driver.findElementById("com.chad.financialrecord:id/btnIncome");
        MobileElement date = (MobileElement) driver.findElementById("com.chad.financialrecord:id/tvDate");
        MobileElement category = (MobileElement) driver.findElementById("com.chad.financialrecord:id/spCategory");
        MobileElement calculator = (MobileElement) driver.findElementById("com.chad.financialrecord:id/ibCalc");
        MobileElement amount = (MobileElement) driver.findElementById("com.chad.financialrecord:id/etAmount").sendKeys("500000");
        MobileElement notes = (MobileElement) driver.findElementById("com.chad.financialrecord:id/etNote");
        MobileElement btnSave = (MobileElement) driver.findElementById("com.chad.financialrecord:id/btSave");

        btnFabMenu.click();
        income.click();
        date.click();
        category.click();
        calculator.click();
        amount.click();
        notes.click();
        btnSave.click();

        MobileElement resultIncome = (MobileElement) driver.findElementById("com.chad.financialrecord:id/elTransaction");
        System.out.println(resultIncome.getText());
        Assert.assertEquals(resultIncome.getText(),"500000");
    }

    @Test
    public void testExpense() {
        MobileElement btnFabMenuEx = (MobileElement) driver.findElementById("com.chad.financialrecord:id/fabMenu");
        MobileElement expenseEx = (MobileElement) driver.findElementById("com.chad.financialrecord:id/btnExpense");
        MobileElement dateEx = (MobileElement) driver.findElementById("com.chad.financialrecord:id/tvDate");
        MobileElement categoryEx = (MobileElement) driver.findElementById("com.chad.financialrecord:id/spCategory");
        MobileElement calculatorEx = (MobileElement) driver.findElementById("com.chad.financialrecord:id/ibCalc");
        MobileElement amountEx = (MobileElement) driver.findElementById("com.chad.financialrecord:id/etAmount").sendKeys("200000");
        MobileElement notesEx = (MobileElement) driver.findElementById("com.chad.financialrecord:id/etNote");
        MobileElement btnSaveEx = (MobileElement) driver.findElementById("com.chad.financialrecord:id/btSave");

        btnFabMenuEx.click();
        expenseEx.click();
        dateEx.click();
        categoryEx.click();
        calculatorEx.click();
        amountEx.click();
        notesEx.click();
        btnSaveEx.click();

        MobileElement resultexpense = (MobileElement) driver.findElementById("com.chad.financialrecord:id/elTransaction");
        System.out.println(resultexpense.getText());
        Assert.assertEquals(resultexpense.getText(),"200000");
    }

}
