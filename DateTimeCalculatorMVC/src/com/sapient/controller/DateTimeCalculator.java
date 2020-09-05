package com.sapient.controller;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.TemporalField;
import java.time.temporal.WeekFields;
import java.util.Locale;

import org.springframework.stereotype.Service;

import com.sapient.model.Date;
import com.sapient.model.DateUtil;


@Service
public class DateTimeCalculator {

	public Period getDifferenceBetweenTwoDates(String startDateString, String endDateString) {

		Date date1 = new Date(startDateString);
		Date date2 = new Date(endDateString);
		
		boolean isDate1Bigger = true;

		if (date1.getYear() < date2.getYear()) {
			isDate1Bigger = false;
		} else if (date1.getYear() == date2.getYear()) {
			if (date1.getMonth() < date2.getMonth()) {
				isDate1Bigger = false;
			} else if (date1.getMonth() == date2.getMonth()) {
				if (date1.getDay() < date2.getDay()) {
					isDate1Bigger = false;
				}
			}
		}

		LocalDate endDate = LocalDate.of(date2.getYear(), date2.getMonth(), date2.getDay());
		LocalDate startDate = LocalDate.of(date1.getYear(), date1.getMonth(), date1.getDay());
		Period diff;
		if(isDate1Bigger)
			diff = Period.between(endDate, startDate);
		else diff = Period.between(startDate, endDate);
		
		return diff;
	}
	
	public String addNDays(String dateString, int n)
	{
		Date date = new Date(dateString);
		LocalDate startDate = LocalDate.of(date.getYear(), date.getMonth(), date.getDay());
		LocalDate futureDate = startDate.plusDays(n);
		return DateUtil.localDateToString(futureDate);
	}
	
	public String addNWeeks(String dateString, int n)
	{
		Date date = new Date(dateString);
		LocalDate startDate = LocalDate.of(date.getYear(), date.getMonth(), date.getDay());
		LocalDate futureDate = startDate.plusWeeks(n);
		return DateUtil.localDateToString(futureDate);
	}
	
	public String addNMonths(String dateString, int n)
	{
		Date date = new Date(dateString);
		LocalDate startDate = LocalDate.of(date.getYear(), date.getMonth(), date.getDay());
		LocalDate futureDate = startDate.plusMonths(n);
		return DateUtil.localDateToString(futureDate);
	}
	
	public String subtractNDays(String dateString, int n)
	{
		Date date = new Date(dateString);
		LocalDate startDate = LocalDate.of(date.getYear(), date.getMonth(), date.getDay());
		LocalDate pastDate = startDate.minusDays(n);
		return DateUtil.localDateToString(pastDate);
	}
	
	public String subtractNWeeks(String dateString, int n)
	{
		Date date = new Date(dateString);
		LocalDate startDate = LocalDate.of(date.getYear(), date.getMonth(), date.getDay());
		LocalDate pastDate = startDate.minusWeeks(n);
		return DateUtil.localDateToString(pastDate);
	}
	
	public String subtractNMonths(String dateString, int n)
	{
		Date date = new Date(dateString);
		LocalDate startDate = LocalDate.of(date.getYear(), date.getMonth(), date.getDay());
		LocalDate pastDate = startDate.minusMonths(n);
		return DateUtil.localDateToString(pastDate);
	}
	
	public String subtractNYears(String dateString, int n)
	{
		Date date = new Date(dateString);
		LocalDate startDate = LocalDate.of(date.getYear(), date.getMonth(), date.getDay());
		LocalDate pastDate = startDate.minusYears(n);
		return DateUtil.localDateToString(pastDate);
	}
	
	public String addNYears(String dateString, int n)
	{
		Date date = new Date(dateString);
		LocalDate startDate = LocalDate.of(date.getYear(), date.getMonth(), date.getDay());
		LocalDate futureDate = startDate.plusYears(n);
		return DateUtil.localDateToString(futureDate);
	}
	public String getDayOfWeek(String dateString)
	{
		Date date = new Date(dateString);
		LocalDate startDate = LocalDate.of(date.getYear(), date.getMonth(), date.getDay());
		String dayString = startDate.getDayOfWeek().toString();
		return dayString;
	}
	
	public int getWeekNumber(String dateString)
	{
		Date date = new Date(dateString);
		LocalDate startDate = LocalDate.of(date.getYear(), date.getMonth(), date.getDay());
		WeekFields wf = WeekFields.of(Locale.getDefault()); 
		TemporalField weekNum = wf.weekOfWeekBasedYear(); 
		int week = Integer.parseInt(String.format("%02d", startDate.get(weekNum))); 
		return week;
	}

}
