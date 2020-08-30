package controllers;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import models.Transaction;

public class FeeCalculator {
	public static final String fileLocation = "G:\\Publicis Sapient FTE\\PJP 2\\Week2\\Sample_Data_Fee_Calculator.csv";
	private List<Transaction> transactions;
	private static final int INTRADAY = 10;
	private static final int HIGH_PRIORITY = 500;
	private static final int NORMAL_PRIORITY_SELL_WITHDRAW = 100;
	private static final int NORMAL_PRIORITY_BUY_DEPOSIT = 50;
	
	public FeeCalculator()
	{
		readData();
		sortData();
		calculateFeeForEachTransaction();
	}
	
	public void readData()
	{
		transactions = TransactionDataReader.readCSV(fileLocation);
	}
	
	public void sortData()
	{
		Collections.sort(transactions, new TransactionComparator());
//		calculateFeeForEachTransaction();
//		for(Transaction transaction: transactions)
//		{
//			System.out.println(transaction.toString());
//		}
	}
	
	public void calculateFeeForEachTransaction()
	{
		int size = transactions.size();
		
		for(int i=0; i<size-1; i++)
		{
			Transaction t1 = transactions.get(i);
			Transaction t2 = transactions.get(i+1);
			if(t1.getClientId().equals(t2.getClientId()) &&
					t1.getSecurityId().equals(t2.getSecurityId()) &&
					t1.getTransactionDate().equals(t2.getTransactionDate()))
			{
				t1.setTransactionFees(INTRADAY);
				t2.setTransactionFees(INTRADAY);
				i++;
			}
			else {
				setTransactionFees(t1);
			}
		}
		if(transactions.get(size-1).getTransactionFees()==0)
		{
			setTransactionFees(transactions.get(size-1));
		}
	}
	
	public List<Transaction> getTransactions()
	{
		return transactions;
	}
	
	public void setTransactionFees(Transaction t1)
	{
		if(t1.getPriorityFlag().equals("Y"))
		{
			t1.setTransactionFees(HIGH_PRIORITY);
		}
		else {
			if(t1.getTransactionType().equals("SELL") || t1.getTransactionType().equals("WITHDRAW"))
			{
				t1.setTransactionFees(NORMAL_PRIORITY_SELL_WITHDRAW);
			}
			else t1.setTransactionFees(NORMAL_PRIORITY_BUY_DEPOSIT);
		}
	}
}

class TransactionComparator implements Comparator<Transaction>
{

	public int compare(Transaction o1, Transaction o2) {
		
		int value1 = o1.getClientId().compareTo(o2.getClientId());
		if(value1==0)
		{
			int value2 = o1.getSecurityId().compareTo(o2.getSecurityId());
			if(value2==0)
			{
				return o1.getTransactionDate().compareTo(o2.getTransactionDate());
			}
			return value2;
		}
		return value1;
	}
	
}
