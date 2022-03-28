package practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class fileExcelHandeling {
	public String accessExcelProperties(String Sheetname, int rownum,int cellnum) throws IOException
	{
		FileInputStream fls=new FileInputStream("D:\\software\\testing.xlsx");
		Workbook book=WorkbookFactory.create(fls);
		DataFormatter format=new DataFormatter();
		return format.formatCellValue(book.getSheet(Sheetname).getRow(rownum).getCell(cellnum));
		
	}


}
