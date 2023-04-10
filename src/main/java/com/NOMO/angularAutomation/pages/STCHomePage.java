package com.NOMO.angularAutomation.pages;

import com.NOMO.angularAutomation.constants.GeneralConstants;
import com.NOMO.angularAutomation.dataModels.STCHomePageDM;
import com.NOMO.angularAutomation.utils.Log;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class STCHomePage extends MainPage{


    public STCHomePage(WebDriver driver) {
        super(driver);
    }

    // Initialize page's web elements
    @FindBy(xpath="//a[@id='translation-btn']")
    WebElement EnglishBtn;

    @FindBy(id="name-lite")
    WebElement litePackageType;

    @FindBy(id="name-classic")
    WebElement classicPackageType;

    @FindBy(id="name-premium")
    WebElement premiumPackageType;

    @FindBy(id="country-name")
    WebElement countryName;

    @FindBy(id="bh-contry-lable")
    WebElement bahrainCountry;

    @FindBy(id="sa-contry-lable")
    WebElement KSACountry;

    @FindBy(id="kw-contry-lable")
    WebElement kuwaitCountry;

    @FindBy(xpath="//div[@id='currency-lite']//b")
    WebElement litePrice;

    @FindBy(xpath="//div[@id='currency-lite']//i")
    WebElement liteCurrency;

    @FindBy(xpath="//div[@id='currency-classic']//b")
    WebElement classicPrice;

    @FindBy(xpath="//div[@id='currency-lite']//i")
    WebElement classicCurrency;

    @FindBy(xpath="//div[@id='currency-premium']//b")
    WebElement premiumPrice;

    @FindBy(xpath="//div[@id='currency-premium']//i")
    WebElement premiumCurrency;


    public String selectEnglishLG() {
        try {
            Log.info("select English Language ");
            selectEnglish();
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
    public String selectKuwaitCountry() {
        try {
            Log.info("Navigate to Kuwait page");
            selectCountry(kuwaitCountry);
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
    public String selectKSACountry() {
        try {
            Log.info("Navigate to KSA page");
            selectCountry(KSACountry);
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
    public String selectBahrainCountry() {
        try {
            Log.info("Navigate to Bahrain page");
            selectCountry(bahrainCountry);
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
    public void selectCountry(WebElement countrySelected) {
        try {
            scrollIntoViewAndClick(countryName);
            countrySelected.click();
        } catch (InterruptedException e) {
            Log.error("Error occurred in " + new Object() {
            }
                    .getClass().getName() + "." + new Object() {
            }
                    .getClass()
                    .getEnclosingMethod()
                    .getName(), e);
        }

    }
    public void selectEnglish() {
        try {
            if(EnglishBtn.getText().equalsIgnoreCase("English")){
            scrollIntoViewAndClick(EnglishBtn);
            Thread.sleep(3000);}
        } catch (InterruptedException e) {
            Log.error("Error occurred in " + new Object() {
            }
                    .getClass().getName() + "." + new Object() {
            }
                    .getClass()
                    .getEnclosingMethod()
                    .getName(), e);
        }

    }

    public String validatePackgesType(STCHomePageDM STCHomePageDM) {
        String packageType = null;
        try {
           if(!STCHomePageDM.getLitePackage().isEmpty()){
               packageType=  litePackageType.getText();
           }   

           if(!STCHomePageDM.getClassicPackage().isEmpty()){
               packageType=  classicPackageType.getText();
           }   
           
           if(!STCHomePageDM.getPremiumPackage().isEmpty()){
               packageType=  premiumPackageType.getText();
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
        return packageType;

    }
    public String validatePackgesPrice(STCHomePageDM STCHomePageDM) {
        String packagePrice = null;
        try {
           if(!STCHomePageDM.getLitePackagePrice().isEmpty()){
               packagePrice=  litePrice.getText();
           }

           if(!STCHomePageDM.getClassicPackagePrice().isEmpty()){
               packagePrice=  classicPrice.getText();
           }

           if(!STCHomePageDM.getPremiumPackagePrice().isEmpty()){
               packagePrice=  premiumPrice.getText();
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
        return packagePrice;

    }
    public String validatePackgesCurrency(STCHomePageDM STCHomePageDM) {
        String packageCurrency = null;
        try {
           if(!STCHomePageDM.getLiteCurrency().isEmpty()){
               packageCurrency=  liteCurrency.getText();
           }

           if(!STCHomePageDM.getClassicCurrency().isEmpty()){
               packageCurrency=  classicCurrency.getText();
           }

           if(!STCHomePageDM.getPremiumCurrency().isEmpty()){
               packageCurrency=  premiumCurrency.getText();
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
        return packageCurrency;

    }


}
