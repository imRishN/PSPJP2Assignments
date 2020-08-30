import java.util.List;

import controllers.SummaryReportGenerator;
import models.Summary;

public class FeeCalculatorRunner {
	
	public static void main(String args[]) {
		
		SummaryReportGenerator summaryReport = new SummaryReportGenerator();
		List<Summary> summaries = summaryReport.getSummaryReport();
		
		for(Summary summary: summaries)
		{
			System.out.println(summary.toString());
		}
	}
}
