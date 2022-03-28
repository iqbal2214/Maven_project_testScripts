package crm.com.autodesk.generic.utility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;



public class ExcelUtility {
	/**
	 * @author iqbal
	 * @param sheetname
	 * @param rownum
	 * @param cellnum
	 * @return  Data
	 * @throws IOException
	 */
	public String getExcelProperties(String sheetname,int rownum,int cellnum) throws IOException{
		
		/**
		 * it is used to read the data from script_data.xlsx based on argument
		 */
		FileInputStream fis=new FileInputStream("./src/test/resources/CommonData/script_data.xlsx");
		Workbook book=WorkbookFactory.create(fis);
		Sheet sheet=book.getSheet(sheetname);
		Row row=sheet.getRow(rownum);
		Cell cell=row.getCell(cellnum);
		String data=cell.getStringCellValue();
		return data;
	}

	public int getExcelRowLength(String sheetname,int row) throws Throwable
	{
		FileInputStream fis=new FileInputStream("./src/test/resources/CommonData/script_data.xlsx");
		Workbook book=WorkbookFactory.create(fis);
		Sheet sh=book.getSheet("Sheet1");
		book.close();
		return sh.getLastRowNum();
		
	}
	
	public void setDataExcel(String sheetname,int rownum,int cellnum, String data) throws Throwable {
		FileInputStream fis=new FileInputStream("./src/test/resources/CommonData/script_data.xlsx");
		Workbook book=WorkbookFactory.create(fis);
		Sheet sh=book.getSheet(sheetname);
		Row rw=sh.getRow(rownum);
		Cell cel=rw.createCell(cellnum);
		cel.setCellValue(data);
		FileOutputStream fos=new FileOutputStream("./src/test/resources/CommonData/script_data.xlsx");
		book.write(fos);
		book.close();
	}
}
