package pages;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FileUtility {
	FileInputStream fis; 
	Workbook workbook; 
	/**
	 * This method will give the String Data from the Excel Sheet.
	 * @param sheet
	 * @param rowNum
	 * @param cellNum
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public String readStringDataFromExcel(String sheet,int rowNum, int cellNum) throws EncryptedDocumentException, IOException {
		fis=new FileInputStream("./src/test/resources/GoodReadsData.xlsx.xlsx");
		workbook=WorkbookFactory.create(fis);
		return workbook.getSheet(sheet).getRow(rowNum).getCell(cellNum).getStringCellValue();
	}
	/**
	 * This method will give the Numeric Data from the Excel Sheet.
	 * @param sheet
	 * @param rowNum
	 * @param cellNum
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public int readNumericDataFromExcel(String sheet,int rowNum, int cellNum) throws EncryptedDocumentException, IOException {
		fis=new FileInputStream("./src/test/resources/GoodReadsData.xlsx.xlsx");
		workbook=WorkbookFactory.create(fis);
		return (int)workbook.getSheet(sheet).getRow(rowNum).getCell(cellNum).getNumericCellValue();
	}
}
