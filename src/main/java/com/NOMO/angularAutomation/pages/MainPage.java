package com.NOMO.angularAutomation.pages;

import com.NOMO.angularAutomation.constants.GeneralConstants;
import com.NOMO.angularAutomation.utils.Log;
import com.NOMO.angularAutomation.utils.PropertiesFilesHandler;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Properties;

public class MainPage {

    // Initialize web drivers
    WebDriver driver;
    JavascriptExecutor jsDriver;
    WebDriverWait wait;


    public MainPage(WebDriver driver) {
        this.driver = driver;
        this.jsDriver = (JavascriptExecutor) driver;
        //Set a delay of 30 secs to wait for elements' visibility
        AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 30);
        PageFactory.initElements(factory, this);
        wait = new WebDriverWait(driver, 10);
    }

    //locate all mat error messages dispalyed in the page
    @FindBy(xpath = "//*[contains(@class,'p-inline-message-text')]")
    public List<WebElement> matErrMsgs;

    // locate all pop-up notification errors
    @FindBy(xpath = "//*[@role='alert']//div//div")
    List<WebElement> notificationMsgs;

    @FindBy(xpath = "//*[@role='progressbar]")
    WebElement progressBar;

    @FindBy(xpath = "//*[@role='option']")
    List<WebElement> selectOptions;

    @FindBy(xpath ="//*[@class='p-multiselect-item p-ripple']")
    List<WebElement> selectOptionsForEventLocations;


    //Initialize instances of properties files to be used in all pages
    PropertiesFilesHandler propHandler = new PropertiesFilesHandler();
    Properties generalCofigsProps = propHandler.loadPropertiesFile(GeneralConstants.GENERAL_CONFIG_FILE_NAME);

    // Browser's default download path config from properties file
    String browserDefaultDownloadpath = System.getProperty("user.dir") + generalCofigsProps.getProperty(GeneralConstants.DEFAULT_DOWNLOAD_PATH);

    //Do not perform action on input text unless  text in test data sheet contains a values. Otherwise, keep it value as is.
    public void setTextValue(WebElement inputText, String testDataText) throws Exception {

        if ((testDataText != null && !testDataText.trim().isEmpty()))
            if (inputText != null) {
                {
                    inputText.clear();
                    if (!testDataText.equalsIgnoreCase(GeneralConstants.CLEAR)) {
                        inputText.sendKeys(testDataText);
                    }
                }
            } else
                throw new Exception("Web element 'Input' is null .. it could not be located");
        Thread.sleep(100);
    }
    public void specialsetTextValue(WebElement inputText, String testDataText) throws Exception {

        if ((testDataText != null && !testDataText.trim().isEmpty()))
            if (inputText != null) {
                {
                    inputText.clear();
                    if (!testDataText.equalsIgnoreCase(GeneralConstants.CLEAR)) {
                        inputText.sendKeys(testDataText);
                        inputText.clear();
                        inputText.sendKeys(testDataText);
                    }
                }
            } else
                throw new Exception("Web element 'Input' is null .. it could not be located");
        Thread.sleep(100);
    }
    public void setTextEmptyValue(WebElement inputText, String testDataText) throws Exception {
            if (inputText != null) {
                {
                    scrollToElement(inputText);
                    inputText.click();
                    inputText.clear();
                    if (testDataText.equalsIgnoreCase(GeneralConstants.CLEAR)) {
                        inputText.sendKeys(testDataText);
                    }
                }
            } else
                throw new Exception("Web element 'Input' is null .. it could not be located");
        Thread.sleep(100);
    }


    public String emptyRequiredFields(WebElement inputText) {
        try {
     /*    new   new Actions(driver).moveToElement(inputText)
                    .perform();
*/
            inputText.clear();

            Log.info("empty Required Fields.");

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
    // select mat-select's option(s) by displayed text
    public void selectOptionByDisplayedText(WebElement select, String displayedText) throws Exception {
        if (select != null) {
            // check if matselect is not disabled and selected option(s) are not empty
            if (displayedText != null && !displayedText.trim()
                    .isEmpty()) {
                select.click();
                Thread.sleep(500);
                if (selectOptions.size() != 0) {
                    String[] selectedOptions = null;
                    for (WebElement selectOption : selectOptions)
                        if (selectOption.getText().trim().equalsIgnoreCase(displayedText.trim())) {
                            selectOption.click();
                            break;
                        }
                } else {
                    throw new Exception("Drop down list is empty and has no listed options");
                }
            }
        } else
            throw new Exception("Web element 'dropDown' is null .. it could not be located");

    }

    public String getTodaysDate()
    {
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        Date date = new Date();
        String todayDate= dateFormat.format(date);
        return todayDate;
    }


    public String getTomorrowsDate()
    {
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        Date date = new Date();
        Date tomorrow = new Date(date.getTime() + (1000 * 60 * 60 * 24));
        String tomorrowDate= dateFormat.format(tomorrow);
        return tomorrowDate;
    }

    public void selectOptionByDisplayedTextforEventLocation(WebElement select, String displayedText) throws Exception {
        if (select != null) {
            // check if matselect is not disabled and selected option(s) are not empty
            if (displayedText != null && !displayedText.trim()
                    .isEmpty()) {
                select.click();
                Thread.sleep(500);
                if (selectOptionsForEventLocations.size() != 0) {
                    String[] selectedOptions = null;
                    for (WebElement selectOption : selectOptionsForEventLocations)
                        if (selectOption.getText().trim().equalsIgnoreCase(displayedText.trim())) {
                            selectOption.click();
                            break;
                        }
                } else {
                    throw new Exception("Drop down list is empty and has no listed options");
                }
            }
        } else
            throw new Exception("Web element 'dropDown' is null .. it could not be located");

    }

    // select another option than the selected and return its value.
    public String selectAnotherOption(WebElement select, String flag) throws Exception {
        String displayedText = "";
        if (select != null) {
            // check if matselect is not disabled and selected option(s) are not empty
            if (flag != null && !flag.trim()
                    .isEmpty()) {
                select.click();
                int size = selectOptions.size();
                Thread.sleep(500);
                if (size != 0) {
                    for (WebElement selectOption : selectOptions)
                        if (selectOption.getAttribute("aria-selected").equalsIgnoreCase("false")) {
                            displayedText = selectOption.getText();
                            selectOption.click();
                            break;
                        }
                } else {
                    throw new Exception("Drop down list is empty and has no listed options");
                }
            }
        } else
            throw new Exception("Web element 'dropDown' is null .. it could not be located");
        return displayedText;
    }
    public void selectOptionsFromMultiSelect(WebElement inputText, String testDataText) throws Exception {

        if ((testDataText != null && !testDataText.trim().isEmpty()))
            if (inputText != null) {
                {
                    String[] weekDays = testDataText.split("-");
                    if (weekDays.length != 0)
                    {
                        inputText.click();
                        for (int i = 0; i < weekDays.length; i++) {
                            driver.findElement(By.xpath("//li[@aria-label='" + weekDays[i] + "']")).click();
                        }
                    }
                }
            } else
                throw new Exception("Web element 'Input' is null .. it could not be located");
        Thread.sleep(100);
    }
    // Get all error messages whether mat-error or pop-up notification into one string separated with GeneralConstants.STRING_DELIMETER
    public String getAllErrMsgs(String errType) {
        Log.info("Start collecting all massages");

        StringBuilder allErrorMsgsString = new StringBuilder();
        try {
            if (errType.equalsIgnoreCase(GeneralConstants.ERR_TYPE_PAGE)) {
                //wait just 3 seconds for all errors to be displayed
                Thread.sleep(300);

                Log.info("Number of displayed mat error messages in page" + matErrMsgs.size());

                for (int i = 0; i < matErrMsgs.size(); i++) {
                    if (matErrMsgs.get(i).getText().isEmpty())
                        continue;
                    allErrorMsgsString.append(matErrMsgs.get(i).getText());
                    if (i != matErrMsgs.size() - 1)
                        allErrorMsgsString.append(GeneralConstants.STRING_DELIMITER);
                }
            } else if (errType.equalsIgnoreCase(GeneralConstants.ERR_TYPE_NOTIFICATION)) {
                Log.info("Number of displayed pop-up notification error messages in page is :  " + notificationMsgs.size());
                for (int j = 0; j < notificationMsgs.size(); j++) {
                    if (notificationMsgs.get(j).getText().isEmpty())
                        continue;
                    allErrorMsgsString.append(notificationMsgs.get(j).getText());
                    if (j != notificationMsgs.size() - 1)
                        allErrorMsgsString.append(GeneralConstants.STRING_DELIMITER);
                }
            }
            Log.info("Actual Result = " + allErrorMsgsString);
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
        return allErrorMsgsString.toString();
    }


    // select mat-select's option(s) by displayed texts for multiple selection drop down lists
    public String selectOptionByindex(WebElement select, String optionIndex) throws Exception {
        String selectedOptionString = "";

        if (select != null) {
            // check if matselect is not disabled and selected option(s) are not empty
            if (optionIndex != null && !optionIndex.trim()
                    .isEmpty()) {
                select.click();
                Thread.sleep(2000);
                if (selectOptions.size() != 0) {
                    selectedOptionString = selectOptions.get(Integer.parseInt(optionIndex)).getText();
                    selectOptions.get(Integer.parseInt(optionIndex)).click();
                } else
                    throw new Exception("Drop down list is empty and has no listed options");
            }
        } else
            throw new Exception("Web element 'matSelect' is null .. it could not be located");

        return selectedOptionString;
    }

    public void waitForFileDownload(String expectedFileName)  {
        FluentWait<WebDriver> wait = new FluentWait(driver)
                .withTimeout(Duration.ofSeconds(60))
                .pollingEvery(Duration.ofNanos(10));

        File fileToCheck = new File(expectedFileName);

        wait.until((WebDriver wd) -> fileToCheck.exists());

    }

    public void scrollUp() throws InterruptedException {
        //to scroll up the page
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,-700)", "");
        Thread.sleep(1000);

    }

    public void scrollIntoView(WebElement element) throws InterruptedException {
        //to scroll down the page
        Thread.sleep(1000);
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,200)", "");
        jse.executeScript("arguments[0].scrollIntoView();", element);
        Thread.sleep(1000);

    }

    public void jsClick(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        scrollToElement(element);
        jsDriver.executeScript("return document.readyState").toString().equals("complete");
        wait.until(ExpectedConditions.elementToBeClickable(element));
        jsDriver.executeScript("arguments[0].click();", element);
        jsDriver.executeScript("return document.readyState").toString().equals("complete");}

    public void scrollToElement(WebElement element) {
        jsDriver.executeScript("arguments[0].scrollIntoView();", element);}

    public void scrollIntoViewAndClick(WebElement element) throws InterruptedException {
        //to scroll down the page
        Thread.sleep(1000);
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView();", element);
        Thread.sleep(1000);
        jse.executeScript("arguments[0].click();", element);

    }

    public void scrollIntoViewAndClickListElements(List<WebElement> element) throws InterruptedException {
        //to scroll down the page
        Thread.sleep(1000);
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView();", element);
        Thread.sleep(1000);
        jse.executeScript("arguments[0].click();", element);

    }

}