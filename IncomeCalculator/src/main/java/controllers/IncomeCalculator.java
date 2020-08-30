package controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import models.AverageIncome;
import models.Summary;

public class IncomeCalculator {

	public static final String fileLocation = "G:\\Publicis Sapient FTE\\PJP 2\\Week2\\Sample input file Assignment 3.xlsx";
	private static List<AverageIncome> incomeData;
	private static final double INR_USD = 1.0/66;
	private static final double GBP_USD = 1.0/0.67;
	private static final double SGP_USD = 1.0/1.5;
	private static final double HKD_USD = 1.0/8;
	private HashMap<String, String> map;
	
	public IncomeCalculator()
	{
		incomeData = DataReader.readXLSX(fileLocation);
		map = new HashMap<String, String>();
		convertIncomeToDollar();
		groupData();
	}
	
	private void convertIncomeToDollar()
	{
		for(AverageIncome data: incomeData)
		{
			if(data.getCurrency().equals("INR"))
			{
				data.setAverageIncome(Double.toString(Double.parseDouble(data.getAverageIncome())*INR_USD));
			}
			else if(data.getCurrency().equals("GBP"))
			{
				data.setAverageIncome(Double.toString(Double.parseDouble(data.getAverageIncome())*GBP_USD));
			}
			else if(data.getCurrency().equals("SGP"))
			{
				data.setAverageIncome(Double.toString(Double.parseDouble(data.getAverageIncome())*SGP_USD));
			}
			else if(data.getCurrency().equals("HKD"))
			{
				data.setAverageIncome(Double.toString(Double.parseDouble(data.getAverageIncome())*HKD_USD));
			}
			
			data.setCurrency("USD");
		}
	}
	
	private void groupData()
	{
		for(AverageIncome data: incomeData)
		{
			String key = (data.getCountry().isEmpty()? data.getCity():data.getCountry()) + "," + data.getGender();
			if(map.containsKey(key))
			{
				String[] value = map.get(key).split(",");// value0 is the average income till now and value1 is the counter;
				int currCount = Integer.parseInt(value[1]);
				double currTotalValue = (Double.parseDouble(value[0]) * currCount);
				double newTotalValue = currTotalValue + Double.parseDouble(data.getAverageIncome());
				String newValue = Double.toString(newTotalValue) + "," + Integer.toString(currCount+1);
				map.replace(key, newValue);
			}
			else
			{
				map.put(key, data.getAverageIncome()+",1");
			}
		}
	}
	
	public List<Summary> getProcessedData()
	{
		List<Summary> summaries = new ArrayList<Summary>();
		for (Map.Entry<String,String> entry : map.entrySet())  
		{
			String data = entry.getKey();
			String value = entry.getValue();
			String dataFields[] = data.split(",");
			String valueFields[] = value.split(",");
			Summary summary = new Summary(dataFields[0], dataFields[1], valueFields[0]);
			summaries.add(summary);
		}
		Collections.sort(summaries, new SummaryComparator());
		return summaries;
	}

}

class SummaryComparator implements Comparator<Summary>
{

	public int compare(Summary o1, Summary o2) {
		int value1 = o1.getCountry().compareTo(o2.getCountry());
		if(value1==0)
		{
			int value2 = o1.getGender().compareTo(o2.getGender());
			if(value2==0)
			{
				return o1.getAverageIncome().compareTo(o2.getAverageIncome());
			}
			return value2;
		}
		return value1;
	}
}

