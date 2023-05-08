package helper;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;
import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelHelper {
	
	private Logger log=LoggerHelper.getLogger(ExcelHelper.class);
	
	
	public Object[][] getExceldata(String exelLocation, String sheetName) {
		try {
			
			Object [][] datasets=null;
			FileInputStream file=new FileInputStream(new File(exelLocation));
			
			//Create new workbook instance
			XSSFWorkbook workbook=new XSSFWorkbook(file);
			
			//Get sheetname from workbook
			XSSFSheet sheet=workbook.getSheet(sheetName);
			
			//Count active no of rows in sheet
			int totalRow=sheet.getLastRowNum();
			
			//Count active no of columns in sheet
			int totalCol=sheet.getRow(0).getLastCellNum();
			
			datasets=new Object[totalRow+1][totalCol];
			
			//Iterate through row each one by one
			
			Iterator<Row> rowIterator = sheet.rowIterator();
			int i=0;
			while(rowIterator.hasNext()) {
				i++;
				Row row = rowIterator.next();
				
				Iterator<Cell> cellIterator = row.cellIterator();
				int j=0;
				while(cellIterator.hasNext()) {
					j++;
					Cell cell = cellIterator.next();
					
					switch(cell.getCellType()) {
					case STRING:
						datasets[i-1][j-1]=cell.getStringCellValue();
						break;
					case NUMERIC:
						datasets[i-1][j-1]=cell.getNumericCellValue();
						break;
					case BOOLEAN:
						datasets[i-1][j-1]=cell.getBooleanCellValue();
						break;
					case FORMULA:
						datasets[i-1][j-1]=cell.getCellFormula();
						break;
					default:
						System.out.println("No matching data type found...!!!");
						break;
					}
				}
			}
			return datasets;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
