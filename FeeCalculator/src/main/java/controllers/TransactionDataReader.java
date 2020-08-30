package controllers;

import java.util.ArrayList;
import java.util.List;

import models.Transaction;
import reader.CSV;

//class to read transaction from multiple file types
public class TransactionDataReader {
	
	public static List<Transaction> readCSV(String fileLocation)
	{
		List<Transaction> transactions = CSV.getTransaction(fileLocation);
		return transactions;
	}
	
	public static List<Transaction> readXLSX(String fileLocation)
	{
		List<Transaction> transactions = new ArrayList<Transaction>();
		return transactions;
	}

}
