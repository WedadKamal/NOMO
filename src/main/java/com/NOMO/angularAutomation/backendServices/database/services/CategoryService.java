package com.NOMO.angularAutomation.backendServices.database.services;

import com.NOMO.angularAutomation.constants.GeneralConstants;
import com.NOMO.angularAutomation.backendServices.database.DBConnection;
import com.NOMO.angularAutomation.backendServices.database.daos.CategoryDAO;
import com.NOMO.angularAutomation.dataModels.CategoryDM;

import java.sql.Connection;
import java.sql.SQLException;

public class CategoryService {

    public CategoryDM getCategoryDetails(String CategoryEnName)throws SQLException, ClassNotFoundException {
        //Open connection to users database
        DBConnection conn = new DBConnection();
        Connection connection = conn.openConnection(GeneralConstants.CORE_DB_NAME);
        CategoryDAO CategoryDAO = new CategoryDAO();
        CategoryDM CategoryDM = CategoryDAO.getCategoryDetails(connection ,CategoryEnName);
        //close db connection
        conn.closeDBConnection(connection);
        return CategoryDM;
    }
    public CategoryDM getAllCategoryDetails()throws SQLException, ClassNotFoundException {
        //Open connection to users database
        DBConnection conn = new DBConnection();
        Connection connection = conn.openConnection(GeneralConstants.CORE_DB_NAME);
        CategoryDAO CategoryDAO = new CategoryDAO();
        CategoryDM CategoryDM = CategoryDAO.getAllCategoryDetails(connection );
        //close db connection
        conn.closeDBConnection(connection);
        return CategoryDM;
    }



    public CategoryDM getCategoryStatus(String CategoryEnName)throws SQLException, ClassNotFoundException {
        //Open connection to users database
        DBConnection conn = new DBConnection();
        Connection connection = conn.openConnection(GeneralConstants.CORE_DB_NAME);
        CategoryDAO CategoryDAO = new CategoryDAO();
        CategoryDM CategoryDM = CategoryDAO.getCategoryStatus(connection ,CategoryEnName);
        //close db connection
        conn.closeDBConnection(connection);
        return CategoryDM;
    }
    public CategoryDM getDeletedCategory()throws SQLException, ClassNotFoundException {
        //Open connection to users database
        DBConnection conn = new DBConnection();
        Connection connection = conn.openConnection(GeneralConstants.CORE_DB_NAME);
        CategoryDAO CategoryDAO = new CategoryDAO();
        CategoryDM CategoryDM = CategoryDAO.getDeletedCategoryDetails(connection);
        //close db connection
        conn.closeDBConnection(connection);
        return CategoryDM;
    }
    public CategoryDM getCategoryEventsCount(String CategoryEnName)throws SQLException, ClassNotFoundException {
        //Open connection to users database
        DBConnection conn = new DBConnection();
        Connection connection = conn.openConnection(GeneralConstants.CORE_DB_NAME);
        CategoryDAO CategoryDAO = new CategoryDAO();
        CategoryDM CategoryDM = CategoryDAO.getCategoryEventsCount(connection, CategoryEnName);
        //close db connection
        conn.closeDBConnection(connection);
        return CategoryDM;
    }

}
