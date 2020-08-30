import java.util.List;

import controllers.IncomeCalculator;
import models.Summary;

public class IncomeCalculatorRunner {

	public static void main(String[] args) {
		IncomeCalculator incomeCalculator = new IncomeCalculator();
		List<Summary> summaries = incomeCalculator.getProcessedData();
		
		for(Summary summary: summaries)
		{
			System.out.println(summary.toString());
		}
	}

}
