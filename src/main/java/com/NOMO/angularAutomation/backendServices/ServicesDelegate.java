package com.NOMO.angularAutomation.backendServices;

import com.NOMO.angularAutomation.utils.Log;
import com.NOMO.angularAutomation.backendServices.database.services.CategoryService;
import com.NOMO.angularAutomation.dataModels.CategoryDM;

public class ServicesDelegate {

    public ServicesDelegate()
    {
        Log.info(" *******   Create an instance of ServiceDelegate to access backend DB    ******** ");
    }



    public CategoryDM getCategoryDetails(String CategoryEnName)
    {
        CategoryDM CategoryDM= null;
        try {
            CategoryService CategoryService = new CategoryService();
            CategoryDM = CategoryService.getCategoryDetails(CategoryEnName);

        }

        catch (Exception e)
        {
            Log.error("ERROR occured in " + new Object() {}
                    .getClass().getName() + "." + new Object() {}
                    .getClass()
                    .getEnclosingMethod()
                    .getName(), e);
        }
        return CategoryDM;
    }


    public CategoryDM getCategoryStatus(String CategoryEnName)
    {
        CategoryDM CategoryDM= null;
        try {
            CategoryService CategoryService = new CategoryService();
            CategoryDM = CategoryService.getCategoryStatus(CategoryEnName);

        }

        catch (Exception e)
        {
            Log.error("ERROR occured in " + new Object() {}
                    .getClass().getName() + "." + new Object() {}
                    .getClass()
                    .getEnclosingMethod()
                    .getName(), e);
        }
        return CategoryDM;
    }

    public CategoryDM getDeletedCategory()
    {
        CategoryDM CategoryDM= null;
        try {
            CategoryService CategoryService = new CategoryService();
            CategoryDM = CategoryService.getDeletedCategory();

        }

        catch (Exception e)
        {
            Log.error("ERROR occured in " + new Object() {}
                    .getClass().getName() + "." + new Object() {}
                    .getClass()
                    .getEnclosingMethod()
                    .getName(), e);
        }
        return CategoryDM;
    }

    public CategoryDM getAllCategoryDetails()
    {
        CategoryDM CategoryDM= null;
        try {
            CategoryService CategoryService = new CategoryService();
            CategoryDM = CategoryService.getAllCategoryDetails();

        }

        catch (Exception e)
        {
            Log.error("ERROR occured in " + new Object() {}
                    .getClass().getName() + "." + new Object() {}
                    .getClass()
                    .getEnclosingMethod()
                    .getName(), e);
        }
        return CategoryDM;
    }

    public CategoryDM getCategoryEventsCount(String CategoryEnName)
    {
        CategoryDM CategoryDM= null;
        try {
            CategoryService CategoryService = new CategoryService();
            CategoryDM = CategoryService.getCategoryEventsCount(CategoryEnName);

        }

        catch (Exception e)
        {
            Log.error("ERROR occured in " + new Object() {}
                    .getClass().getName() + "." + new Object() {}
                    .getClass()
                    .getEnclosingMethod()
                    .getName(), e);
        }
        return CategoryDM;
    }
}
