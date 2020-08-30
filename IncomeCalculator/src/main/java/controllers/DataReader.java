package controllers;

import java.util.ArrayList;
import java.util.List;

import models.AverageIncome;
import reader.Excel;

public class DataReader {
	
	public static List<AverageIncome> readXLSX(String fileLocation)
	{
		String[][] data = Excel.get(fileLocation);
		List<AverageIncome> incomeData = new ArrayList<AverageIncome>();
		
		for(int i=1; i<data.length; i++)
		{
			AverageIncome row = new AverageIncome(data[i][0], data[i][1], data[i][2], 
					data[i][3], (data[i][4]));
			incomeData.add(row);
			
		}
		return incomeData;
	}
}
