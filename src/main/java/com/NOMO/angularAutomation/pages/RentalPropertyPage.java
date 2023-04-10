package com.NOMO.angularAutomation.pages;

import com.NOMO.angularAutomation.constants.GeneralConstants;
import com.NOMO.angularAutomation.dataModels.RentalPropertyPageDM;
import com.NOMO.angularAutomation.utils.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class RentalPropertyPage extends MainPage{
    public RentalPropertyPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath="//div[@class='mc-form_ValidationMsgError__JNryE']")
    WebElement validationErrorMsg;

    @FindBy(xpath="//input[@id='mui-1']")
    WebElement estimatedPropertyValue;

    @FindBy(id="mui-2")
    WebElement estimatedMonthlyRentalIncome;

    @FindBy(id="mui-3")
    WebElement downPayment;

    @FindBy(xpath="//div[@class='MuiSelect-select MuiSelect-outlined MuiOutlinedInput-input MuiInputBase-input css-qiwgdb']//div")
    WebElement lengthForFixedRatePeriod;

    @FindBy(xpath="//li[text()='5 year fixed rate']")
    WebElement fiveYearFixedOption;

    @FindBy(xpath="//li[text()='2 year fixed rate']")
    WebElement twoYearFixedOption;

    @FindBy(xpath="//h2[@class='mc-results_MCResultsValueOfFinance__CBt1j']")
    WebElement financeAmount;

    @FindBy(xpath="//h3[@class='mc-results_MCResultsMonthlyCosts__pRvOw']")
    WebElement monthlyCosts;

    @FindBy(xpath="//h2[text()='How much property finance could you get?']")
    WebElement howMuchStatment;

    @FindBy(xpath="//div[@class='MuiFormControl-root MuiTextField-root input_Input___bqLh css-i44wyl']")
    List<WebElement> first;

    @FindBy(xpath="//div[@class='MuiOutlinedInput-root MuiInputBase-root MuiInputBase-colorPrimary MuiInputBase-formControl css-1v4ccyo']")
    List<WebElement> second;


    public String setData(RentalPropertyPageDM RentalPropertyPageDM) {

        try {
            new WebDriverWait(driver, 20).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@class='mc-embedded_Iframe__27PR_']")));

            if(!RentalPropertyPageDM.getEstimatedPropertyValue().isEmpty()){
                WebDriverWait wait = new WebDriverWait(driver, 30);
                wait.until(ExpectedConditions.visibilityOf(estimatedPropertyValue));
                specialsetTextValue(estimatedPropertyValue, RentalPropertyPageDM.getEstimatedPropertyValue());

            }

            if(!RentalPropertyPageDM.getEstimatedMonthlyRentalIncome().isEmpty()){
                setTextValue(estimatedMonthlyRentalIncome,RentalPropertyPageDM.getEstimatedMonthlyRentalIncome());
            }

            if(!RentalPropertyPageDM.getDownPayment().isEmpty()){
                setTextValue(downPayment,RentalPropertyPageDM.getDownPayment());
            }

            if(!RentalPropertyPageDM.getTwoYearFixedOption().isEmpty()){
                lengthForFixedRatePeriod.click();
                Thread.sleep(1000);
                scrollIntoView(downPayment);
                twoYearFixedOption.click();

            }

            if(!RentalPropertyPageDM.getFiveYearFixedOption().isEmpty()){
                lengthForFixedRatePeriod.click();
                Thread.sleep(1000);
                scrollIntoView(downPayment);
                fiveYearFixedOption.click();

            }

            // this is for showing all the data inserted to the user
            scrollIntoView(howMuchStatment);
            Log.info("data inserted successfully in estimated property value with "+ estimatedPropertyValue.getAttribute("value"));
            Log.info("data inserted successfully in estimated Monthly Rental Income with "+estimatedMonthlyRentalIncome.getAttribute("value"));
            Log.info("data inserted successfully in DownPayment with "+ downPayment.getAttribute("value"));

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

    public String getFinanceAmountTextFromWeb(RentalPropertyPageDM RentalPropertyPageDM) {
        String financeAmountText = null;
        try {
            if(!RentalPropertyPageDM.getFinanceAmount().isEmpty()){
                // this scroll for showing data to the user
                scrollIntoView(howMuchStatment);
                financeAmountText=  financeAmount.getText();
            }
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
        return financeAmountText;

    }
    public String getMonthlyCostsTextFromWeb(RentalPropertyPageDM RentalPropertyPageDM) {
        String monthlyCostsText = null;
        try {
            if(!RentalPropertyPageDM.getMonthlyCosts().isEmpty()){
                // this scroll for showing data to the user
                scrollIntoView(howMuchStatment);
                monthlyCostsText=  monthlyCosts.getText();
            }
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
        return monthlyCostsText;

    }
    public String getErrorMsgTextFromWeb(RentalPropertyPageDM RentalPropertyPageDM) {
        String errorMsgText = null;
        try {
            if(!RentalPropertyPageDM.getexpectedErrMsg().isEmpty()){
                // this scroll for showing data to the user
                scrollIntoView(howMuchStatment);
                Thread.sleep(2000);
                errorMsgText=  validationErrorMsg.getText();
            }
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
        return errorMsgText;

    }

}
