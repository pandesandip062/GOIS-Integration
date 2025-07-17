/*
 * Copyright (c) 2025. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.Pages;

import com.base.BasePage;
import com.driver.DriverFactory;
import net.bytebuddy.implementation.bind.annotation.Super;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TransferQueue;

public class salesOrder extends BasePage {


    @FindBy(xpath = "//a[text()='Quick Sales Order']")
    WebElement quickSalesOrder;


    @FindBy(xpath = "//a[text()='Sales Order']")
    WebElement Sales_Order;

    @FindBy(partialLinkText = "Manage Orders")
    WebElement Manage_Sales_Order;


    @FindBy(xpath = "//div[text()='More Info']")
    WebElement moreInfo;

    @FindBy(id = "SelectedOrg")
    WebElement Orgnization;

    @FindBy(xpath = "//span[text()='Sales']")
    WebElement Sales;

    @FindBy(id = "CustName")
    WebElement salectCustomer;


    @FindBy(xpath = "//strong[text()='praksah pande']")
    WebElement selectCustomer;

    @FindBy(xpath = "//button[text()='Proceed']")
    WebElement proceedCTA;

    @FindBy(id = "selectpe")
    WebElement salesPerson;

    @FindBy(id = "txtProduct1")
    WebElement addItem;

    @FindBy(xpath = "(//strong[text()='Samsung Ultra Pro'])[1]")
    WebElement selectIteam;
    @FindBy(id = "SaveandContinue")
    WebElement saveAndContinue;

    @FindBy(id = "btnDepositYes")
    WebElement YesCTA;

    @FindBy(id = "dispatchOrder")
    WebElement dispatchCTA;

    @FindBy(xpath = "(//a[@class='anchor_color'])[1]")
    WebElement salesName;

    @FindBy(xpath = "(//a[contains(@title,'Order Number')])[1]")
    WebElement SalesOrderNum;
    @FindBy(id = "imgRedirectToEdit")
    WebElement Edit_Sales_Order;

    @FindBy(xpath = "//span[text()='Edit here']")
    WebElement editHere;

    @FindBy(id = "btnSaveAndBack")
    WebElement save_BackBtn;

    @FindBy(id = "divError")
    WebElement errorMessage;

    @FindBy(id = "imgDeleteOrder")
    WebElement delete_order;

    String SO_Num;


    public salesOrder() {
        PageFactory.initElements(DriverFactory.getInstance().getDriver(), this);
    }


    public void createSalesOrder() throws InterruptedException {
        Actions act = new Actions(DriverFactory.getInstance().getDriver());
        act.moveToElement(Sales).perform();
        super.click(quickSalesOrder, "create quick sales order");
        super.click(moreInfo, "more information");
        Select select1 = new Select(Orgnization);
        select1.selectByVisibleText("Sandip_org");
        super.click(moreInfo, "more information");
        super.sendKeys(salectCustomer, "select customer", "praksah pande");
        Thread.sleep(2000);
        salectCustomer.sendKeys(Keys.BACK_SPACE);
        Thread.sleep(2000);
        super.click(selectCustomer, "select customer");
        super.click(proceedCTA, "Proceed Button");
        Select select2 = new Select(salesPerson);
        select2.selectByVisibleText("Neha");
        super.sendKeys(addItem, "add Iteam", "Samsung Ultra Pro");
        addItem.sendKeys(Keys.BACK_SPACE);
        Thread.sleep(2000);
        addItem.sendKeys(Keys.BACK_SPACE);
        Thread.sleep(2000);
        super.click(selectIteam, "selected item");
        super.click(saveAndContinue, "Save and Continue button");
        super.click(YesCTA, "yes CTA");

        Thread.sleep(4000);
        JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);", dispatchCTA);
        super.click(dispatchCTA, "Dispatch Button");
        super.click(YesCTA, "yes button");
        Thread.sleep(2000);
        DriverFactory.getInstance().getDriver().switchTo().alert().accept();

        String salesNamesValue = salesName.getText();


        // System.out.println("Sales order Number"+SO_Num);
        Assert.assertEquals(salesNamesValue, "praksah pande");

    }

    public void edit_Sales_Order() throws InterruptedException {
        Actions act = new Actions(DriverFactory.getInstance().getDriver());
        act.moveToElement(Sales).perform();
        super.click(Sales_Order, "clicked on sales order");
        super.click(Manage_Sales_Order, "clicked on manage sales order");
        super.click(SalesOrderNum, "Sales Order");
        super.click(Edit_Sales_Order, "Edit Sales Order");
        super.click(editHere, "Edit Here");
        List<String> listofPages = new ArrayList<String>(DriverFactory.getInstance().getDriver().getWindowHandles());
        DriverFactory.getInstance().getDriver().switchTo().window(listofPages.get(0));
        super.click(save_BackBtn, "Save and Back button");
        Thread.sleep(2000);
        DriverFactory.getInstance().getDriver().switchTo().alert().accept();

    }

    public void delete_Sales_Order() {
        Actions act = new Actions(DriverFactory.getInstance().getDriver());
        act.moveToElement(Sales).perform();
        super.click(Sales_Order, "clicked on sales order");
        super.click(Manage_Sales_Order, "clicked on manage sales order");
        super.click(delete_order,"Delete sales order");
        DriverFactory.getInstance().getDriver().switchTo().alert().accept();

        String Message = errorMessage.getText();

        System.out.println(Message);

    }
}
