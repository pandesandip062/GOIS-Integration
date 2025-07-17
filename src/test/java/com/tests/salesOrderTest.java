/*
 * Copyright (c) 2025. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.tests;

import com.Pages.LoginPage;
import com.Pages.salesOrder;
import com.base.BaseTest;
import com.driver.DriverFactory;
import com.properties.TestDataLoader;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class salesOrderTest extends BaseTest {

    @Test
    public void quickSalesOrder() throws InterruptedException {
        DriverFactory.getInstance().getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        LoginPage loginPage = new LoginPage();
        loginPage.loginApplication(TestDataLoader.getInstance().getUsername(), TestDataLoader.getInstance().getPassword());

        salesOrder sales = new salesOrder();
        sales.createSalesOrder();

    }
    @Test
    public void editSalesOrder() throws InterruptedException {
        DriverFactory.getInstance().getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        LoginPage loginPage = new LoginPage();
        loginPage.loginApplication(TestDataLoader.getInstance().getUsername(), TestDataLoader.getInstance().getPassword());

        salesOrder sales = new salesOrder();
        sales.edit_Sales_Order();
    }

    @Test
    public void delete_sales_order(){
        DriverFactory.getInstance().getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        LoginPage loginPage = new LoginPage();
        loginPage.loginApplication(TestDataLoader.getInstance().getUsername(), TestDataLoader.getInstance().getPassword());

        salesOrder sales = new salesOrder();
        sales.delete_Sales_Order();
    }
}
