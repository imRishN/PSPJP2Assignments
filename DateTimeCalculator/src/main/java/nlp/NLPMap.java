package nlp;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.NoSuchElementException;

public class NLPMap {
	
	public LocalDate NLPConverter(String text, int n) {
		
		LocalDate todayDate = LocalDate.now();
		HashMap<String, NLP> map = new HashMap<String, NLP>();

		map.put("today", (today, x) -> {});
		map.put("tomorrow", (today, x) -> {
			todayDate.plusDays(1);
		});
		map.put("yesterday", (today, x) -> {
			todayDate.minusDays(1);
		});
		map.put("day after tomorrow", (today, x) -> {
			todayDate.plusDays(2);
		});
		map.put("day before yesterday", (today, x) -> {
			todayDate.minusDays(2);
		});
		map.put("next week", (today, x) -> {
			todayDate.plusWeeks(1);
		});
		map.put("last week", (today, x) -> {
			todayDate.minusWeeks(1);
		});
		map.put("previous week", (today, x) -> {
			todayDate.minusWeeks(1);
		});
		map.put("next month", (today, x) -> {
			todayDate.plusMonths(1);
		});
		map.put("last month", (today, x) -> {
			todayDate.minusMonths(1);
		});
		map.put("months after", (today, x) -> {
			todayDate.plusMonths(n);
		});
		map.put("months before", (today, x) -> {
			todayDate.minusMonths(n);
		});
		map.put("next year", (today, x) -> {
			todayDate.plusYears(1);
		});
		map.put("last year", (today, x) -> {
			todayDate.minusYears(1);
		});
		map.put("days from now", (today, x) -> {
			todayDate.plusDays(n);
		});
		map.put("weeks from now", (today, x) -> {
			todayDate.plusWeeks(n);
		});
		map.put("months from now", (today, x) -> {
			todayDate.plusMonths(n);
		});
		map.put("years from now", (today, x) -> {
			todayDate.plusYears(n);
		});
		map.put("weeks earlier", (today, x) -> {
			todayDate.minusWeeks(n);
		});
		map.put("months earlier", (today, x) -> {
			todayDate.minusMonths(n);
		});
		map.put("years earlier", (today, x) -> {
			todayDate.minusYears(n);
		});
		
		NLP nlp;
		if(map.containsKey(text))
		{
			nlp = map.get(text);
			nlp.convert(text, n);
		}
		else {
			throw new NoSuchElementException("Not a valid text");
		}
		
		return todayDate;
	
	}

}
