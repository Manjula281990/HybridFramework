package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class Excel {
	
	public static HashMap<Integer, ArrayList<String>> readAllData(String sheetName) throws Exception{
		
		File file = new File("F:\\LearningCoreJava\\HybridFramework\\src\\testdata\\Data.xls");
		FileInputStream inputStream = new FileInputStream(file);
		HSSFWorkbook workbook = new HSSFWorkbook(inputStream);
		HSSFSheet sheet = workbook.getSheet(sheetName);
		int maxRows = sheet.getLastRowNum();
		HashMap<Integer, ArrayList<String>> map = new HashMap<>();
		for(int i=0; i<=maxRows;i++) {
			ArrayList<String> list = new ArrayList<>();
			HSSFRow row = sheet.getRow(i);
			int maxCells = row.getLastCellNum();
			for(int j=0; j<maxCells;j++) {
				HSSFCell cell = row.getCell(j);
				//System.out.print(cell.getStringCellValue());
				list.add(cell.getStringCellValue());
			}
			//System.out.println();
			//System.out.println(list);
			map.put(i, list);
		}
	
		return map;
	}
	
	public static void updateRow(String sheetName, int rowNumber,String result) throws Exception
	{
	File file=new File("F:\\LearningCoreJava\\HybridFramework\\src\\testdata\\Data.xls");
	FileInputStream inputStream=new FileInputStream(file);
	
	HSSFWorkbook workbook=new HSSFWorkbook(inputStream);
	HSSFSheet sheet = workbook.getSheet(sheetName);
	
	HSSFRow row=sheet.getRow(rowNumber);
	int lastCell=row.getLastCellNum();

	HSSFCell cell = row.createCell(lastCell);
	cell.setCellValue(result);
	
	FileOutputStream out = new FileOutputStream(file);
	workbook.write(out);
	out.close();
	}
	
}
	

