package utilities;

import java.io.File;
import java.io.IOException;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.write.WriteException;


public class DataFile {
	
	private Workbook workBook;
	private Sheet workSheet;

	private File fileXLS;  //data file
	
	public DataFile(String filePath, String sheetName)
	{
		try
		{
		fileXLS = new File(filePath);
		workBook =  Workbook.getWorkbook(fileXLS);
		workSheet = workBook.getSheet(sheetName);	

		}
		catch(Exception e)
		{
			System.out.println(e.toString());
		}
	}
	public String getDataFromColumn(String columnHeader, int rowNumber)
	{
		Cell cell;
		String column = "start";
		String cellData = "no value found";
		int colNumber = 0;
		
		int colCount = workSheet.getColumns();
		
		while(colNumber < colCount)
		{		
			cell = workSheet.getCell(colNumber,0);	
			column = cell.getContents();
			
			if(column.equals(columnHeader))
			{
				cell = workSheet.getCell(colNumber,rowNumber);
				cellData = cell.getContents();
				break;
			}
			colNumber++;
					
		}
		return cellData;
	
	}
	
	public int getRowCount()
	{
		return workSheet.getRows();
	}
	
	public void close() throws IOException, WriteException
	{
		workBook.close();

	}
}

