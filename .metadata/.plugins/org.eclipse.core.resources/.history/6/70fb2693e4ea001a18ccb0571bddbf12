package com.sapient.DateTimeCalculator;

import java.io.IOException;
import java.time.Period;
import java.util.*;

import nlp.NLPMap;
import session.Session;

public class DateTimeCalculatorMenu {

	private static Scanner scanner;
	private static DateTimeCalculator dateTimeCalculator;
	private static Session session;

	public static void main(String[] args) throws IOException{

		scanner = new Scanner(System.in);
		session = new Session();
		dateTimeCalculator = new DateTimeCalculator();
		System.out.println("Welcome to Date-Time Calculator\n");
		System.out.println("Enter your choice:");
		System.out.println("\n1. Add/Subtract between two dates");
		System.out.println("2. Add/Subtract 'n' days/months/weeks from a given date");
		System.out.println("3. Determine the Day of the Week for a given date");
		System.out.println("4. Determine the Week number for a given a date");
		System.out.println("5. Enter Custom Language");

		int choice = scanner.nextInt();

		switch (choice) {
		case 1:
			getDateDifference();
			break;

		case 2:
			addSubtractNDays();
			break;

		case 3:
			getDayOfWeek();
			break;

		case 4:
			getWeekNumber();
			break;
			
		case 5:
			runNLP();
			break;

		default:
			break;
		}
	}

	private static void getDateDifference() {
		System.out.println("\nEnter two dates in format DD/MM/YYYY");

		String d1 = scanner.next();
		String d2 = scanner.next();
	
		Period diffPeriod = dateTimeCalculator.getDifferenceBetweenTwoDates(d1, d2);
		session.write(d1 + "-" + d2 + " ->" + diffPeriod.getYears() + diffPeriod.getMonths() + diffPeriod.getDays());
		System.out.print("Difference " + "between two dates is: ");
		System.out.printf("%d years, %d months" + " and %d days ", diffPeriod.getYears(), diffPeriod.getMonths(), diffPeriod.getDays());

	}

	private static void addSubtractNDays() {
		
		System.out.println("\nEnter a date in format DD/MM/YYYY");
		String d = scanner.next();
		
		System.out.println("\nEnter days to be added/subtracted");
		int n = scanner.nextInt();
		
		String futureDate = dateTimeCalculator.addNDays(d, n);
		String pastDate = dateTimeCalculator.subtractNDays(d, n);
		

		System.out.println("Future Date is: " + futureDate);
		System.out.println("Past Date is: " + pastDate);
		
	}
	
	private static void getDayOfWeek() {
		System.out.println("\nEnter a date in format DD/MM/YYYY");
		String d = scanner.next();
		
		String dayString = dateTimeCalculator.getDayOfWeek(d);
		System.out.println("Day of Week: " + dayString);
	}
	
	private static void getWeekNumber()
	{
		System.out.println("\nEnter a date in format DD/MM/YYYY");
		String d = scanner.next();
		
		int weekNumber = dateTimeCalculator.getWeekNumber(d);
		System.out.println("Week Number: "+ weekNumber);
	}
	
	private static void runNLP()
	{
		System.out.println("\nEnter text");
		String d = scanner.next();
		
		System.out.println("\nEnter number associated");
		int n = scanner.nextInt();
		
		NLPMap nlpMap = new NLPMap();
		nlpMap.NLPConverter(d, n);
	}

}
