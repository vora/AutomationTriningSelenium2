package com.qa.ascendum.resources;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebElement;

import com.qa.ascendum.base.TestBase;
import com.qa.ascendum.pageLocators.HomePageLocators;

public class TestClass extends TestBase{

	public static void main(String[] args) throws IOException {

		String element = driver.findElement(HomePageLocators.link_careers).getText();
		FileInputStream fis = new FileInputStream("C:\\Users\\Rajeshwari.prem\\Desktop\\dataDrivenTest.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);

		XSSFSheet sheet = workbook.getSheet("TestData");

		Row row = sheet.createRow(5);
		Cell cell = row.createCell(7);
		cell.setCellType(cell.CELL_TYPE_STRING);
		cell.setCellValue(element);
		FileOutputStream fos = new FileOutputStream("C:\\Users\\Rajeshwari.prem\\Desktop\\dataDrivenTest.xlsx");
		workbook.write(fos);
	}

}
