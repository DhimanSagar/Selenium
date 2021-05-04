package Lib;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExeclDataConfig {
	
	public FileInputStream fis = null;
	public XSSFWorkbook workbook = null;
	public XSSFSheet sheet = null;
	public XSSFRow row = null;
	public XSSFCell cell = null;

	
	XSSFWorkbook wb;
	XSSFSheet sheet1;
	
	public  ExeclDataConfig(String excelPath) throws IOException
	{

		try {
			File src = 	new File("D:\\Excel Data\\TestData.xlsx");
			FileInputStream fis = new FileInputStream(src);
			wb = new XSSFWorkbook(fis);
		
		} 
		catch (IOException e) {
			
			System.out.println(e.getMessage());
			
		}
	}
		
		public String getData(int sheetNumber,int rowNum,int columnNum)
		{
			//sheet1 = wb.getSheetAt(sheetNumber);
			//String data = String.valueOf(sheet1.getRow(row).getCell(column).getNumericCellValue());
			sheet1 = wb.getSheetAt(sheetNumber);
			row = sheet1.getRow(rowNum);
			cell = row.getCell(columnNum);
			
			if(cell.getCellType() == CellType.STRING)
				return cell.getStringCellValue();
			else if(cell.getCellType()==CellType.NUMERIC || cell.getCellType()== CellType.FORMULA) 
			{
			String cellValue = String.valueOf(Math.round(cell.getNumericCellValue()));
			return cellValue;
			}
			return null;		
			}
		
		  public int getRowCount(int sheetindex)
		    {
		        int row = wb.getSheetAt(sheetindex).getLastRowNum();

		        row = row+1;

		        return row;
		    }

		}

/*	sheet1 = wb.getSheetAt(sheetNumber);
			row = sheet.getRow(rowNum);
			cell = row.getCell(columnNum);
			
			if(cell.getCellType() == CellType.STRING)
				return cell.getStringCellValue();
			else if(cell.getCellType()==CellType.NUMERIC || cell.getCellType()== CellType.FORMULA) {
			
			String cellValue = String.valueOf(cell.getNumericCellValue());}
			return null;
			
			Second method
			sheet1 = wb.getSheetAt(sheetNumber);
			String data = sheet1.getRow(row).getCell(column).getStringCellValue(); ;
			*/

/*if(cell.getCellType()==CellType.STRING) 
data = cell.getStringCellValue(); 
else if(cell.getCellType()==CellType.NUMERIC) 
data = String.valueOf(cell.getNumericCellValue());
else
return data;*/
