package com.NOMO.angularAutomation.tests;

import com.NOMO.angularAutomation.pages.RentalPropertyPage;
import com.NOMO.angularAutomation.constants.GeneralConstants;
import com.NOMO.angularAutomation.constants.excelIndices.RentalPropertyExcellndices;
import com.NOMO.angularAutomation.dataModels.RentalPropertyPageDM;
import com.NOMO.angularAutomation.utils.Log;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class PropertyFinanceFunctionalityTest extends BaseTest{


    ArrayList rentalPropertyFinanceTestData = new ArrayList();
    String actualResults;
    @BeforeClass(alwaysRun = true)
    public void navigateToRentalPropertyFinancePage(){
        actualResults = NomoHomePage.acceptCookies();
        Assert.assertEquals(actualResults, GeneralConstants.SUCCESS, "Could not accpet the cookies");

        String navigatedToPageSuccessfully = NomoHomePage.navigateTorentalPropertyFinance();
        Assert.assertEquals(navigatedToPageSuccessfully, GeneralConstants.SUCCESS, "Could not navigate to Rental property Finance Page successfully");
    }

    @BeforeMethod( alwaysRun = true)
    public void refreshCurrentPage() {
        NomoHomePage.refreshCurrentSite();
    }

    @Test(description = "Validate rentalPropertyFinance functionalities",priority = 0  ,dataProvider = "rentalPropertyFinanceDP" ,enabled = true)
    public void verifyRentalPropertyFinanceFunctionality(RentalPropertyPageDM RentalPropertyPageDM) {
        //Create extent test to be logged in report using test case title
        test = extent.createTest(RentalPropertyPageDM.getTestCaseId() + " --- " + RentalPropertyPageDM.getTestCaseTitle());
        Log.test = test;
        Log.startTestCase(RentalPropertyPageDM.getTestCaseId() + " --- " + RentalPropertyPageDM.getTestCaseTitle());

        RentalPropertyPage RentalPropertyPage = new RentalPropertyPage(driver);
        actualResults = RentalPropertyPage.setData(RentalPropertyPageDM);
        Assert.assertEquals(actualResults, GeneralConstants.SUCCESS, "Could not set data Successfully");
        assertMonthlyAmountAndFinanceCost(RentalPropertyPageDM,RentalPropertyPage);
        assertExpectedErrorMsg(RentalPropertyPageDM,RentalPropertyPage);

    }

    // assertion monthly amount to be 92,915 GBP and finance costs to be 458 GBP
    void assertMonthlyAmountAndFinanceCost(RentalPropertyPageDM RentalPropertyPageDM, RentalPropertyPage RentalPropertyPage)
    {
        String expectedResults = null;
        if(!RentalPropertyPageDM.getFinanceAmount().isEmpty()){
            actualResults= RentalPropertyPage.getFinanceAmountTextFromWeb(RentalPropertyPageDM);
            expectedResults = RentalPropertyPageDM.getFinanceAmount();
            Assert.assertEquals(actualResults,expectedResults,"assertion failed for Finance Amount Value ");
            Log.info("Finance Amount Value assertion passed successfully which is "+ actualResults);
        }

        if(!RentalPropertyPageDM.getMonthlyCosts().isEmpty()){
            actualResults= RentalPropertyPage.getMonthlyCostsTextFromWeb(RentalPropertyPageDM);
            expectedResults = RentalPropertyPageDM.getMonthlyCosts();
            Assert.assertEquals(actualResults,expectedResults,"assertion failed for Monthly Costs Value ");
            Log.info("Monthly Costs Value assertion passed successfully which is "+ actualResults);
        }

    }

    // assertion for the error msg in unhappy scenarios
    void assertExpectedErrorMsg(RentalPropertyPageDM RentalPropertyPageDM, RentalPropertyPage RentalPropertyPage)
    {
        String expectedResults = null;
        if(!RentalPropertyPageDM.getexpectedErrMsg().isEmpty()){
            actualResults= RentalPropertyPage.getErrorMsgTextFromWeb(RentalPropertyPageDM);
            expectedResults = RentalPropertyPageDM.getexpectedErrMsg();
            Assert.assertEquals(actualResults,expectedResults,"assertion failed for Error Msg Value ");
            Log.info("Error Msg Value assertion passed successfully which is "+ actualResults);
        }
    }

    // this function for reading data from excel file
    @DataProvider(name = "rentalPropertyFinanceDP")
    public Object[][] providerentalPropertyFinanceTD() {
        Object[][] rentalPropertyFinanceDP = new Object[rentalPropertyFinanceTestData.size()][1];
        for (int i = 0; i < rentalPropertyFinanceTestData.size(); i++)
            rentalPropertyFinanceDP[i][0] = rentalPropertyFinanceTestData.get(i);

        return rentalPropertyFinanceDP;
    }

    // this function for reading data from excel file
    @BeforeClass
    public void rentalPropertyFinanceTD() {

        ArrayList<ArrayList<Object>> resultArray = provideTestData("rentalPropertyFinanceTestData");

        for (ArrayList<Object> objects : resultArray) {
            RentalPropertyPageDM RentalPropertyPageDM = new RentalPropertyPageDM();
            RentalPropertyPageDM.setTestCaseId(objects.get(RentalPropertyExcellndices.TEST_CASE_ID_INDEX).toString());
            RentalPropertyPageDM.setTestCaseTitle(objects.get(RentalPropertyExcellndices.TEST_CASE_TITLE_INDEX).toString());
            RentalPropertyPageDM.setTestScope(objects.get(RentalPropertyExcellndices.TEST_SCOPE_INDEX).toString());
            RentalPropertyPageDM.setEstimatedPropertyValue(objects.get(RentalPropertyExcellndices.ESTIMATED_PROPERTY_VALUE).toString());
            RentalPropertyPageDM.setEstimatedMonthlyRentalIncome(objects.get(RentalPropertyExcellndices.ESTIMATED_MONTHLY_RENTAL_INCOME).toString());
            RentalPropertyPageDM.setDownPayment(objects.get(RentalPropertyExcellndices.DOWN_PAYMENT).toString());
            RentalPropertyPageDM.setTwoYearFixedOption(objects.get(RentalPropertyExcellndices.TWO_YEAR_FIXED_OPTION).toString());
            RentalPropertyPageDM.setFiveYearFixedOption(objects.get(RentalPropertyExcellndices.FIVE_YEAR_FIXED_OPTION).toString());
            RentalPropertyPageDM.setFinanceAmount(objects.get(RentalPropertyExcellndices.FINANCE_AMOUNT).toString());
            RentalPropertyPageDM.setMonthlyCosts(objects.get(RentalPropertyExcellndices.MONTHLY_COSTS).toString());
            RentalPropertyPageDM.setexpectedErrMsg(objects.get(RentalPropertyExcellndices.EXPECTED_ERROR_MSG).toString());
            rentalPropertyFinanceTestData.add(RentalPropertyPageDM);

        }

    }
}
