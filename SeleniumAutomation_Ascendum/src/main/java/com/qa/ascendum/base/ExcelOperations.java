package com.qa.ascendum.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;

import com.qa.ascendum.pageLocators.HomePageLocators;

public class ExcelOperations extends TestBase {

	public File file;
	public FileInputStream fis;
	public XSSFWorkbook workbook;
	public XSSFSheet sheet;
	public Row row;
	public Cell cell;

	public static final Logger log = Logger.getLogger(ExcelOperations.class.getName());

	// Launches the excel file
	public FileInputStream FileInput(String excelPath) throws IOException {
		fis = new FileInputStream(new File(excelPath));
		return fis;
	}

	// Fetches the workbook required from the excel file path specified
	public XSSFWorkbook fetchWorkBook(Object object) throws IOException {
		workbook = new XSSFWorkbook(fis);
		return workbook;

	}

	// Fetches the workSheet required from the excel file path specified with the
	// index no
	public XSSFWorkbook fetchWorkSheet(Object object, int sheetNo) throws IOException {
		sheet = workbook.getSheetAt(sheetNo);
		return workbook;

	}

	// Fetches the workSheet required from the excel file path specified with the
	// name
	public XSSFWorkbook fetchWorkSheet(Object object, String sheetName) throws IOException {
		sheet = workbook.getSheet(sheetName);
		return workbook;

	}

	// Iterate over the rows
	public void iterateOverRows() {
		// Iterate through each rows one by one
		Iterator<Row> rowIterator = sheet.iterator();
		while (rowIterator.hasNext()) {
			Row row = rowIterator.next();
			// For each row, iterate through all the columns
			Iterator<Cell> cellIterator = row.cellIterator();

			while (cellIterator.hasNext()) {
				Cell cell = cellIterator.next();
				// Check the cell type and format accordingly
				switch (cell.getCellType()) {
				case Cell.CELL_TYPE_NUMERIC:
					log.info(cell.getNumericCellValue() + "***");
					break;
				case Cell.CELL_TYPE_STRING:
					log.info(cell.getStringCellValue() + "***");
					break;
				}
			}
			System.out.println("");
		}
	}

	// close the file opened
	public void closeFile() throws IOException {
		fis.close();
	}

	// code to read data at a particular row
	public Object readCellDataFromExcel(int rowNo, int cellNo) {
		row = sheet.getRow(rowNo);
		cell = row.getCell(cellNo);
		log.info("Data in the cell is : " + cell.toString());
		return cell;

	}

	// code to read data at a particular row - cell and enters it in the specified
	// element on the web page
	public Object readCellDataFromExcel(int rowNo, int cellNo, By locator) {
		row = sheet.getRow(rowNo);
		cell = row.getCell(cellNo);
		WebElement element = driver.findElement(locator);
		element.sendKeys(cell.toString());
		log.info("The cell data is : " + "\"" + cell.toString() + "\""
				+ " is succesfully entered in the specified web element");
		return cell;

	}

	public void enterTextFromExcelInLocator() {
		try {
			FileInput(System.getProperty("user.dir") + properties.getProperty("excelFilePath"));
			fetchWorkBook(workbook);
			fetchWorkSheet(workbook, "SearchText");
			readCellDataFromExcel(5, 1, HomePageLocators.textBox_search);

			closeFile();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
