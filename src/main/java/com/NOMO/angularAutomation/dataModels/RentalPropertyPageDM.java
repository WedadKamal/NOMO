package com.NOMO.angularAutomation.dataModels;

public class RentalPropertyPageDM extends MainDataModel{

    private String estimatedPropertyValue;
    private String estimatedMonthlyRentalIncome;
    private String downPayment;
    private String lengthForFixedRatePeriod;
    private String fiveYearFixedOption;
    private String twoYearFixedOption;
    private String financeAmount;
    private String monthlyCosts;

    public String getEstimatedPropertyValue() {
        return estimatedPropertyValue;
    }

    public void setEstimatedPropertyValue(String estimatedPropertyValue) {
        this.estimatedPropertyValue = estimatedPropertyValue;
    }

    public String getEstimatedMonthlyRentalIncome() {
        return estimatedMonthlyRentalIncome;
    }

    public void setEstimatedMonthlyRentalIncome(String estimatedMonthlyRentalIncome) {
        this.estimatedMonthlyRentalIncome = estimatedMonthlyRentalIncome;
    }

    public String getDownPayment() {
        return downPayment;
    }

    public void setDownPayment(String downPayment) {
        this.downPayment = downPayment;
    }

    public String getLengthForFixedRatePeriod() {
        return lengthForFixedRatePeriod;
    }

    public void setLengthForFixedRatePeriod(String lengthForFixedRatePeriod) {
        this.lengthForFixedRatePeriod = lengthForFixedRatePeriod;
    }

    public String getFiveYearFixedOption() {
        return fiveYearFixedOption;
    }

    public void setFiveYearFixedOption(String fiveYearFixedOption) {
        this.fiveYearFixedOption = fiveYearFixedOption;
    }

    public String getTwoYearFixedOption() {
        return twoYearFixedOption;
    }

    public void setTwoYearFixedOption(String twoYearFixedOption) {
        this.twoYearFixedOption = twoYearFixedOption;
    }

    public String getFinanceAmount() {
        return financeAmount;
    }

    public void setFinanceAmount(String financeAmount) {
        this.financeAmount = financeAmount;
    }

    public String getMonthlyCosts() {
        return monthlyCosts;
    }

    public void setMonthlyCosts(String monthlyCosts) {
        this.monthlyCosts = monthlyCosts;
    }



}
