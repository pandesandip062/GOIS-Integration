/*
 * Copyright (c) 2025. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.javascript;



import com.driver.DriverFactory;
import com.report.ExtentFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class JavaScriptActions {

    private Logger logger = LogManager.getLogger(JavaScriptActions.class);

    public void click(WebElement element){
        try{
            JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
            js.executeScript("arguments[0].click()",element);
            logger.info("Element is clicked");
            ExtentFactory.getInstance().passTest("Element is clicked using JavaScript");
        }catch (Exception e){
            logger.error("Exception occured while clicking on element using js "+element);
            ExtentFactory.getInstance().failTest("Exception occured while clicking on element using js ");
        }
    }

    public void sendKeys(WebElement element,String value){
        try{
            JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
            js.executeScript("arguments[0].value= "+" "+value+" ",element);
            logger.info(value+" is entered");
            ExtentFactory.getInstance().passTest(value+" is entered");
        }catch (Exception e){
            logger.error("Exception occured while entering value using js"+e.getMessage());
            ExtentFactory.getInstance().failTest("Exception occured while entering value using js");
        }
    }

    public void scrollPageToViewElement(WebElement element){
        try{
            JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
            js.executeScript("arguments[0].scrollIntoView(true)",element);
            logger.info("Element is visible on Screen");
            ExtentFactory.getInstance().passTest("Element is visible on Screen");
        }catch (Exception e){
            logger.error("Exception occured while scrolling the page"+e.getMessage());
            ExtentFactory.getInstance().failTest("Exception occured while scrolling the page");
        }
    }

    public void scrollTillEndOfPage(){
        try{
            JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
            js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
            logger.info("Page is csrolled till end");
            ExtentFactory.getInstance().passTest("Page is csrolled till end");
        }catch (Exception e){
            logger.error("Exception occured while scrolling the end of page"+e.getMessage());
            ExtentFactory.getInstance().failTest("Exception occured while scrolling the end of page");
        }
    }

}
