package controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import models.Summary;
import models.Transaction;

public class SummaryReportGenerator {
	private List<Transaction> transactions;
	private HashMap<String, Integer> map; 
	public SummaryReportGenerator()
	{
		FeeCalculator feeCalculator = new FeeCalculator();
		map = new HashMap<String, Integer>();
		transactions = feeCalculator.getTransactions();
		generateSummaryReport();
	}
	
	public void generateSummaryReport()
	{
		for(Transaction transaction: transactions)
		{
			String data = transaction.getClientId() 
							+ "," + transaction.getTransactionType()
							+ "," + transaction.getTransactionDateString()
							+ "," + transaction.getPriorityFlag();
			if(map.containsKey(data))
			{
				int value = map.get(data);
				value+=transaction.getTransactionFees();
				map.replace(data, value);
			}
			else {
				map.put(data, transaction.getTransactionFees());
			}
		}
	}
	
	public List<Summary> getSummaryReport()
	{
		List<Summary> summaryReport = new ArrayList<Summary>();
		for (Map.Entry<String,Integer> entry : map.entrySet())  
		{
			String data = entry.getKey();
			int fees = entry.getValue();
			String field[] = data.split(",");
			Summary summary = new Summary(field[0], field[1], field[2], field[3], fees);
			summaryReport.add(summary);
		}
		Collections.sort(summaryReport, new SummaryComparator());
		return summaryReport;
	}
}

class SummaryComparator implements Comparator<Summary>
{

	public int compare(Summary o1, Summary o2) {
		int value1 = o1.getClientId().compareTo(o2.getClientId());
		if(value1==0)
		{
			int value2 = o1.getTransactionType().compareTo(o2.getTransactionType());
			if(value2==0)
			{
				int value3 = o1.getTransactionDate().compareTo(o2.getTransactionDate());
				if(value3==0)
				{
					return o1.getPriority().compareTo(o2.getPriority());
				}
				return value3;
			}
			return value2;
		}
		return value1;
	}
}
