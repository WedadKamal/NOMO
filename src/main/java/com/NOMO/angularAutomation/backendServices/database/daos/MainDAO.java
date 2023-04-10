package com.NOMO.angularAutomation.backendServices.database.daos;

import com.NOMO.angularAutomation.constants.GeneralConstants;
import com.NOMO.angularAutomation.utils.PropertiesFilesHandler;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

public class MainDAO {
    PropertiesFilesHandler propHandler = new PropertiesFilesHandler();
    Properties generalCofigsProps = propHandler.loadPropertiesFile(GeneralConstants.GENERAL_CONFIG_FILE_NAME);
    String validUserMail = generalCofigsProps.getProperty(GeneralConstants.VALID_Vendor_MAIL);

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

    public String getAfterFiveDate()
    {
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        Date date = new Date();
        Date tomorrow = new Date(date.getTime() + (1000 * 60 * 60 * 600));
        String tomorrowDate= dateFormat.format(tomorrow);
        return tomorrowDate;
    }

}
