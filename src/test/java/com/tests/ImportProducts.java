

package com.tests;

import com.Pages.LoginPage;
import com.Pages.ProductPage;
import com.Pages.productsScreen;
import com.base.BaseTest;
import com.driver.DriverFactory;
import com.properties.TestDataLoader;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ImportProducts extends BaseTest {

@Test
    public void addProductViaExcel() throws InterruptedException {
    DriverFactory.getInstance().getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    LoginPage loginPage = new LoginPage();
    loginPage.loginApplication(TestDataLoader.getInstance().getUsername(), TestDataLoader.getInstance().getPassword());

    ProductPage productPage = new ProductPage();
    productPage.addProductViaExcel();
}
}
