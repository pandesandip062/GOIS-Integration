/*
 * Copyright (c) 2025. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.Pages;

import com.base.BasePage;
import com.base.BaseTest;
import com.driver.DriverFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class productsScreen extends BasePage {

    @FindBy(xpath = "//span[text()='Products']")
    WebElement product;
    @FindBy(id = "AddProduct")
    WebElement addProduct;

    @FindBy(id = "ddlOrg")
    WebElement orgnizationSelect;

    @FindBy(id = "btnSelect")
    WebElement selectButton;

    @FindBy(xpath = "//option[text()='Sandip_org']")
    WebElement sandipOrg;

    @FindBy(id = "txtProductName")
    WebElement productNameValue;

    @FindBy(id = "txtProductNumber")
    WebElement productNo;

    @FindBy(id = "txtUnitPurchasePrice")
    WebElement unitCost;
    @FindBy(id = "txtLastDirectCostPrice")
    WebElement lastDirectCost;
    @FindBy(id = "txtUnitSalePrice")
    WebElement unitPrice;
    @FindBy(xpath = "//span[text()='Settings']")
    WebElement settingTab;

    @FindBy(id = "ddlproductPostingDropdwn")
    WebElement productPostingGroup;
    @FindBy(id = "ddlinventoryPostingDropdwn")
    WebElement inventoryPostingGroup;

    @FindBy(id = "btnSave")
    WebElement saveButton;

    @FindBy(xpath = "//p[text()='Product']")
    WebElement productLinks;

    @FindBy(xpath = "(//div[@id='txtProductName'])[1]")
    WebElement getProductName;

    @FindBy(xpath = "(//img[@title='Click to edit this Product'])[1]")
    WebElement editProduct;

    @FindBy(id = "btnSaveAndBack")
    WebElement saveAndBack;

    public productsScreen() {
        PageFactory.initElements(DriverFactory.getInstance().getDriver(), this);
    }

    public void addProduct(String productName) throws InterruptedException {

        Actions select = new Actions(DriverFactory.getInstance().getDriver());
        select.click(product).perform();
        select.click(addProduct).perform();
        orgnizationSelect.click();
        JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);", sandipOrg);


        sandipOrg.click();
        this.click(selectButton, "clicked on selectButton");
        super.sendKeys(productNameValue, "product name", productName);
        super.sendKeys(productNo, "product Number ", productName + "123");
        super.sendKeys(unitCost, "unit cost", "1");
        super.sendKeys(lastDirectCost, "last direct cost", "1");
        super.sendKeys(unitPrice, "unit price", "1");
        super.click(settingTab, "setting button");

        Select select1 = new Select(productPostingGroup);
        select1.selectByVisibleText("GQB-SYNC ITEM");


        Select select2 = new Select(inventoryPostingGroup);
        select2.selectByVisibleText("Inventory Posting Global");

        super.click(saveButton, "save button");

        Thread.sleep(2000);
        super.click(productLinks, "product link");
        Thread.sleep(2000);
        String productNamevalues = getProductName.getText();


        Assert.assertEquals(productNamevalues, productName);


    }

    public void manageProduct() throws InterruptedException {
        super.click(editProduct, "edit product");
        Thread.sleep(3000);
        super.sendKeys(productNameValue, "product Name", "Iphone X1");
        super.click(saveAndBack, "Save and back");
        String productNamevalues = getProductName.getText();
        Assert.assertEquals("Iphone X11", productNamevalues);

    }
}
