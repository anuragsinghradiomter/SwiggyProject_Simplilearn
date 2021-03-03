package SwiggyPOI;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class SwiggyExcelData
{
	public XSSFSheet ExcelRSheet;
	public XSSFWorkbook ExcelRBook;
	public XSSFSheet ExcelWSheet;
	public XSSFWorkbook ExcelWBook;
	public SwiggyExcelData() 
	{
		//Default constructor
	}


	public String[] SwiggyLocationData(String FilePath, String SheetName, int SheetRow) throws Exception
	{   
		String [] LocationData = new String[2];
		try
		{
			FileInputStream InputStream = new FileInputStream(FilePath);
			this.ExcelRBook = new XSSFWorkbook(InputStream);		
			this.ExcelRSheet = ExcelRBook.getSheet(SheetName);  
			
			XSSFRow ROW = ExcelRSheet.getRow(SheetRow);
			XSSFCell City = ROW.getCell(0);
			LocationData[0] = City.getStringCellValue();
			XSSFCell CityLocality = ROW.getCell(1);
			LocationData[1] = CityLocality.getStringCellValue();	
			System.out.println("City: " + LocationData[0] + " Locality: " + LocationData[1]);
			
			this.ExcelRBook.close();
			return LocationData;
		}
		catch (FileNotFoundException e)
		{
			System.out.println("Could not read the Excel sheet");
			e.printStackTrace();
			return null;
		}
		catch (IOException e)
		{
			System.out.println("Could not read the Excel sheet");
			e.printStackTrace();
			return null;
		}
	}
	
	public String[][] SwiggyMenuDataRead(String FilePath, String SheetName, int SheetRow) throws Exception
	{   
		String [][] MenuData = new String[5][2];
		DataFormatter formatter = new DataFormatter();
		try
		{
			FileInputStream InputStream = new FileInputStream(FilePath);
			this.ExcelRBook = new XSSFWorkbook(InputStream);		
			this.ExcelRSheet = ExcelRBook.getSheet(SheetName);  
			
			XSSFRow ROW = ExcelRSheet.getRow(SheetRow);
			XSSFCell Restaurant = ROW.getCell(0);
			MenuData[0][0] = Restaurant.getStringCellValue();
			
			XSSFCell Menu1 = ROW.getCell(1);
			MenuData[1][0] = Menu1.getStringCellValue();
			XSSFCell Menu1Price = ROW.getCell(2);
			MenuData[1][1] = formatter.formatCellValue(Menu1Price);
			
			XSSFCell Menu2 = ROW.getCell(3);
			MenuData[2][0] = Menu2.getStringCellValue();
			XSSFCell Menu2Price = ROW.getCell(4);
			MenuData[2][1] = formatter.formatCellValue(Menu2Price);
			
			XSSFCell Menu3 = ROW.getCell(5);
			MenuData[3][0] = Menu3.getStringCellValue();
			XSSFCell Menu3Price = ROW.getCell(6);
			MenuData[3][1] = formatter.formatCellValue(Menu3Price);
						
			this.ExcelRBook.close();
			return MenuData;
		}
		catch (FileNotFoundException e)
		{
			System.out.println("Could not read the Excel sheet");
			e.printStackTrace();
			return null;
		}
		catch (IOException e)
		{
			System.out.println("Could not read the Excel sheet");
			e.printStackTrace();
			return null;
		}
	}
	
	public boolean SwiggyMenuDataWrite(String FilePath, String SheetName, int SheetRow, String[][] LiveMenu) throws Exception
	{   
		try
		{
			FileInputStream InputStream = new FileInputStream(FilePath);
			this.ExcelWBook = new XSSFWorkbook(InputStream);		
			this.ExcelWSheet = ExcelWBook.getSheet(SheetName);  			
			XSSFRow ROW = ExcelWSheet.getRow(SheetRow);
			
			XSSFCell Menu1 = ROW.createCell(0);
			Menu1.setCellValue(LiveMenu[0][0]);
			XSSFCell Menu1Price = ROW.createCell(1);
			Menu1Price.setCellValue(LiveMenu[0][1]);
			
			XSSFCell Menu2 = ROW.createCell(2);
			Menu2.setCellValue(LiveMenu[1][0]);
			XSSFCell Menu2Price = ROW.createCell(3);
			Menu2Price.setCellValue(LiveMenu[1][1]);
			
			XSSFCell Menu3 = ROW.createCell(4);
			Menu3.setCellValue(LiveMenu[2][0]);
			XSSFCell Menu3Price = ROW.createCell(5);
			Menu3Price.setCellValue(LiveMenu[2][1]);
			
			FileOutputStream outputStream = new FileOutputStream(FilePath);
			this.ExcelWBook.write(outputStream);
			this.ExcelWBook.close();

			return true;
		}
		catch (FileNotFoundException e)
		{
			System.out.println("Could not read the Excel sheet");
			e.printStackTrace();
			return false;
		}
		catch (IOException e)
		{
			System.out.println("Could not read the Excel sheet");
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean SwiggyTestStatusWrite(String FilePath, String SheetName, int SheetRow, String TestCaseID ,String TestStatus) throws Exception
	{   
		try
		{
			FileInputStream InputStream = new FileInputStream(FilePath);
			this.ExcelWBook = new XSSFWorkbook(InputStream);		
			this.ExcelWSheet = ExcelWBook.getSheet(SheetName);  			
			XSSFRow ROW = ExcelWSheet.getRow(SheetRow);
			
			XSSFCell TestID = ROW.createCell(0);
			TestID.setCellValue(TestCaseID);
			XSSFCell TestOutcome = ROW.createCell(1);
			TestOutcome.setCellValue(TestStatus);
						
			FileOutputStream outputStream = new FileOutputStream(FilePath);
			this.ExcelWBook.write(outputStream);
			this.ExcelWBook.close();

			return true;
		}
		catch (FileNotFoundException e)
		{
			System.out.println("Could not read/write the Excel sheet");
			e.printStackTrace();
			return false;
		}
		catch (IOException e)
		{
			System.out.println("Could not read/write the Excel sheet");
			e.printStackTrace();
			return false;
		}
	}

	public String SwiggyTestStatusRead(String FilePath, String SheetName, int SheetRow) throws Exception
	{   
		String TestStatusData;
		try
		{
			FileInputStream InputStream = new FileInputStream(FilePath);
			this.ExcelRBook = new XSSFWorkbook(InputStream);		
			this.ExcelRSheet = ExcelRBook.getSheet(SheetName);  
			
			XSSFRow ROW = ExcelRSheet.getRow(SheetRow);
			XSSFCell Status = ROW.getCell(1);
			TestStatusData = Status.getStringCellValue();
				
			this.ExcelRBook.close();
			return TestStatusData;
		}
		catch (FileNotFoundException e)
		{
			System.out.println("Could not read the Excel sheet");
			e.printStackTrace();
			return null;
		}
		catch (IOException e)
		{
			System.out.println("Could not read the Excel sheet");
			e.printStackTrace();
			return null;
		}
	}
	
	public int[] SwiggyBillCheck(String FilePath, String SheetName, int SheetRow) throws Exception
	{   
		int [] BillDetails = new int[5];
		try
		{
			FileInputStream InputStream = new FileInputStream(FilePath);
			this.ExcelRBook = new XSSFWorkbook(InputStream);		
			this.ExcelRSheet = ExcelRBook.getSheet(SheetName);  
			
			XSSFRow ROW = ExcelRSheet.getRow(SheetRow);
			XSSFCell MenuPrice1 = ROW.getCell(1);
			BillDetails[0] = Integer.parseInt(MenuPrice1.getStringCellValue());
			
			XSSFCell MenuPrice2 = ROW.getCell(3);
			BillDetails[1] = Integer.parseInt(MenuPrice2.getStringCellValue());
			
			XSSFCell MenuPrice3 = ROW.getCell(5);
			BillDetails[2] = Integer.parseInt(MenuPrice3.getStringCellValue());
									
			this.ExcelRBook.close();
			return BillDetails;
		}
		catch (FileNotFoundException e)
		{
			System.out.println("Could not read the Excel sheet");
			e.printStackTrace();
			return null;
		}
		catch (IOException e)
		{
			System.out.println("Could not read the Excel sheet");
			e.printStackTrace();
			return null;
		}
	}
}
