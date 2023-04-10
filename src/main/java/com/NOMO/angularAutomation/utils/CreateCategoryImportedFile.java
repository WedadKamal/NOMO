package com.NOMO.angularAutomation.utils;
import java.io.FileOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;

import com.NOMO.angularAutomation.constants.GeneralConstants;
import com.NOMO.angularAutomation.dataModels.CategoryDM;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class CreateCategoryImportedFile {

    public ArrayList<CategoryDM> writeInImportedFile() {
        ArrayList<CategoryDM> CategoryDMObj = new ArrayList<CategoryDM>();
        try {
            //Initialize instances of properties files to be used in all pages
            PropertiesFilesHandler propHandler = new PropertiesFilesHandler();
            Properties generalCofigsProps = propHandler.loadPropertiesFile(GeneralConstants.GENERAL_CONFIG_FILE_NAME);
            //Create workbook in .xlsx format
            Workbook workbook = new XSSFWorkbook();
            //For .xsl workbooks use new HSSFWorkbook();
            //Create Sheet
            Sheet sh = workbook.createSheet("categories-sample (4)");
            //Create top row with column headings
            String[] columnHeadings = {GeneralConstants.CATEGORY_CODE,GeneralConstants.CATEGORY_EN_NAME,GeneralConstants.CATEGORY_AR_NAME,GeneralConstants.CATEGORY_IMAGE_URL};
            //Create the header row
            Row headerRow = sh.createRow(0);
            //Iterate over the column headings to create columns
            for(int i=0;i<columnHeadings.length;i++) {
                Cell cell = headerRow.createCell(i);
                cell.setCellValue(columnHeadings[i]);
            }
            //Fill data
             CategoryDMObj = createData();
            CreationHelper creationHelper= workbook.getCreationHelper();
            int rownum =1;
            for(CategoryDM i : CategoryDMObj) {
                //System.out.println("rownum-before"+(rownum));
                Row row = sh.createRow(rownum++);
                //System.out.println("rownum-after"+(rownum));
                row.createCell(0).setCellValue(i.getCategoryCode());
                row.createCell(1).setCellValue(i.getEnCategoryName());
                row.createCell(2).setCellValue(i.getArCategoryName());
                row.createCell(3).setCellValue(i.getCategoryimage());
            }
            //Autosize columns
            for(int i=0;i<columnHeadings.length;i++) {
                sh.autoSizeColumn(i);
            }
            //Write the output to file
            FileOutputStream fileOut = new FileOutputStream(System.getProperty("user.dir") + generalCofigsProps.getProperty(GeneralConstants.DEFAULT_UPLOAD_PATH) + "/" +GeneralConstants.ImportedFileName);
            workbook.write(fileOut);
            fileOut.close();
            workbook.close();
            Log.info("Data is Genterated in the Imported File");

        } catch (Exception e) {
            Log.error("Error occurred in " + new Object() {
            }
                    .getClass().getName() + "." + new Object() {
            }
                    .getClass()
                    .getEnclosingMethod()
                    .getName(), e);

        }

        return CategoryDMObj;
    }

    private static ArrayList<CategoryDM> createData() throws ParseException {
    String timeStamp = new SimpleDateFormat("hhmmss").format(new Date());
        ArrayList<CategoryDM> CategoryDMObj = new ArrayList();
        CategoryDMObj.add(new CategoryDM(GeneralConstants.CATEGORY_CODE+timeStamp, GeneralConstants.CATEGORY_EN_NAME_CONTENT+timeStamp, GeneralConstants.CATEGORY_AR_NAME_CONTENT+timeStamp, GeneralConstants.CATEGORY_IMAGE_CONTENT));
        return CategoryDMObj;
    }

}

