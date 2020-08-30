package reader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel {
	public static String[][] get(String filename) {
		String[][] dataTable = null;
		File file = new File(filename);
		try {
			FileInputStream xlfile = new FileInputStream(file);
			XSSFWorkbook xlwb = new XSSFWorkbook(xlfile);
			XSSFSheet xlSheet = xlwb.getSheetAt(0);

			// Get the number of rows and columns
			int numRows = xlSheet.getLastRowNum() + 1;
			int numCols = xlSheet.getRow(0).getLastCellNum();

			dataTable = new String[numRows][numCols];
			for (int i = 0; i < numRows; i++) {
				XSSFRow xlRow = xlSheet.getRow(i);

				for (int j = 0; j < numCols; j++) {
					XSSFCell xlCell = xlRow.getCell(j);
					if (xlCell == null) {
						dataTable[i][j] = "";
					} else
						dataTable[i][j] = xlCell.toString();
				}
			}
			xlwb.close();
		} catch (IOException e) {
			System.out.println("ERROR FILE HANDLING " + e.toString());
		}
		return dataTable;
	}
}
