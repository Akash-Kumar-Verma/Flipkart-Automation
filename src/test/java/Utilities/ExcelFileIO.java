package Utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Calendar;
import java.util.HashMap;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

// includes read and write operation for excel file

public class ExcelFileIO {

	public String path;
	public FileInputStream fis = null;
	public FileOutputStream fileOut = null;
	private XSSFWorkbook workbook = null;
	private XSSFSheet sheet = null;
	private XSSFRow row = null;
	private XSSFCell cell = null;

	public ExcelFileIO(String path) {
		this.path = path;

		try (FileInputStream fis = new FileInputStream(path)) {
			workbook = new XSSFWorkbook(fis);
			sheet = workbook.getSheetAt(0);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	// returns the row count in a sheet
	public int getRowCount(String sheetName) {
		int index = workbook.getSheetIndex(sheetName);
		if (index == -1)
			return 0;
		else {
			sheet = workbook.getSheetAt(index);
            return sheet.getLastRowNum() + 1;
		}
	}

	// returns the data from a cell
	@SuppressWarnings({ "static-access" })
	public String getCellData(String sheetName, String colName, int rowNum) {

		try {
			int colNum = -1;

			XSSFSheet sheet = workbook.getSheet(sheetName);
			if (sheet == null) {
				return "";
			}

			XSSFRow headerRow = sheet.getRow(0);

			// Find column number
			for (int i = 0; i < headerRow.getLastCellNum(); i++) {
				if (headerRow.getCell(i).getStringCellValue().trim()
						.equalsIgnoreCase(colName.trim())) {
					colNum = i;
					break;
				}
			}

			if (colNum == -1) {
				return "";
			}

			XSSFRow row = sheet.getRow(rowNum);
			if (row == null) {
				return "";
			}

			XSSFCell cell = row.getCell(colNum);
			if (cell == null) {
				return "";
			}

			return cell.toString();

		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}

	// returns the data from a cell
	@SuppressWarnings({ "static-access" })

	// find whether sheets exists
	public boolean isSheetExist(String sheetName) {
		int index = workbook.getSheetIndex(sheetName);
		if (index == -1) {
			index = workbook.getSheetIndex(sheetName.toUpperCase());
			if (index == -1)
				return false;
			else
				return true;
		} else
			return true;
	}

	// returns number of columns in a sheet
	public int getColumnCount(String sheetName) {
		// check if sheet exists
		if (!isSheetExist(sheetName))
			return -1;

		sheet = workbook.getSheet(sheetName);
		row = sheet.getRow(0);

		if (row == null)
			return -1;

		return row.getLastCellNum();

	}

	// Returns all data of specific row
	public HashMap<String, String> getRowTestData(String worksheetName, String testName) {

		HashMap<String, String> testData = new HashMap<String, String>();
		for (int i = 2; i <= getRowCount(worksheetName); i++) {
			if (getCellData(worksheetName, String.valueOf(0), i).equals(testName)) {
				for (int j = 0; j <= getColumnCount(worksheetName); j++) {
					testData.put((getCellData(worksheetName, String.valueOf(j), 1)), getCellData(worksheetName, String.valueOf(j), i));
				}
				break;
			}
		}
		return testData;
	}

}
