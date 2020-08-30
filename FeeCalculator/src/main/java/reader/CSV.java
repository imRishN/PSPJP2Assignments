package reader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import models.Transaction;

public class CSV {
	
	public static List<Transaction> getTransaction(String fileName) 
	{
		List<Transaction> data = new ArrayList<Transaction>();
		String testRow;
		BufferedReader br = null;
		try {
			// Open and read the file
			br = new BufferedReader(new FileReader(fileName));
			br.readLine();
			while ((testRow = br.readLine()) != null) {
				String[] line = testRow.split(",");
				Transaction transaction = new Transaction(line[0], line[1], line[2], line[3], line[4], line[5], line[6]);
				data.add(transaction);
			}
		} catch (FileNotFoundException e) {
			System.out.println("ERROR: File not found " + fileName);
		} catch (IOException e) {
			System.out.println("ERROR: Could not read " + fileName);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
		
		return data;
	}
	
}
