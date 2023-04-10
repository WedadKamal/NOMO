package com.NOMO.angularAutomation.pages;

import com.NOMO.angularAutomation.constants.GeneralConstants;
import com.NOMO.angularAutomation.utils.Log;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class NomoHomePage extends MainPage{
    public NomoHomePage(WebDriver driver) {
        super(driver);
    }
    // Initialize page's web elements
    @FindBy(xpath="//div[text()='Property Finance']")
    WebElement propertyFinanceBtn;

    @FindBy(xpath="//div[@class='MuiGrid-root MuiGrid-container MuiGrid-direction-xs-column']//a[text()='Rental Property']")
    WebElement rentalPropertyBtn;

    @FindBy(xpath="//span[text()='Accept Cookies']")
    WebElement acceptCookies;


    public String navigateTorentalPropertyFinance() {
        try {
            Log.info("navigate to Rental Property Finance ");
            scrollIntoView(propertyFinanceBtn);
            new Actions(driver).moveToElement(propertyFinanceBtn)
                    .perform();
            Thread.sleep(1000);
            rentalPropertyBtn.click();
            Thread.sleep(7000);
        } catch (Exception e) {
            Log.error("Error occurred in " + new Object() {
            }
                    .getClass().getName() + "." + new Object() {
            }
                    .getClass()
                    .getEnclosingMethod()
                    .getName(), e);
            return GeneralConstants.FAILED;
        }
        return GeneralConstants.SUCCESS;
    }
    public String acceptCookies() {
        try {
            Log.info("accept cookies ");
            acceptCookies.click();
        } catch (Exception e) {
            Log.error("Error occurred in " + new Object() {
            }
                    .getClass().getName() + "." + new Object() {
            }
                    .getClass()
                    .getEnclosingMethod()
                    .getName(), e);
            return GeneralConstants.FAILED;
        }
        return GeneralConstants.SUCCESS;
    }
    public String refreshCurrentSite() {
        try {
            Log.info("refreshing site ");
            driver.navigate().refresh();
            Thread.sleep(5000);
        } catch (Exception e) {
            Log.error("Error occurred in " + new Object() {
            }
                    .getClass().getName() + "." + new Object() {
            }
                    .getClass()
                    .getEnclosingMethod()
                    .getName(), e);
            return GeneralConstants.FAILED;
        }
        return GeneralConstants.SUCCESS;
    }


}
