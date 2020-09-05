package com.sapient.model;

import java.time.LocalDate;
import java.time.Period;

public class DateUtil {
	public static String localDateToString(LocalDate localDate)
	{
		return Integer.toString(localDate.getDayOfMonth())+"/"
				+Integer.toString(localDate.getMonthValue())+"/"
				+Integer.toString(localDate.getYear());
	}
	
	public static String PeriodToString(Period period)
	{
		return (period.getYears()+ " years" + period.getMonths()+ " months" + " and" +  period.getDays()+ " days");
	}
}