package com.sapient;

import java.time.LocalDate;

public class Date {
	
	private int day;
	private int month;
	private int year;
	private LocalDate localDate;
	
	public Date(String dateString)
	{
		String dateData[] = dateString.split("/");
		day = Integer.parseInt(dateData[0]);
		month = Integer.parseInt(dateData[1]);
		year = Integer.parseInt(dateData[2]);
		this.localDate = LocalDate.of(year, month, day);
	}
	
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}

	public LocalDate getLocalDate() {
		return localDate;
	}

	public void setLocalDate(LocalDate date) {
		this.localDate = date;
	}

}

