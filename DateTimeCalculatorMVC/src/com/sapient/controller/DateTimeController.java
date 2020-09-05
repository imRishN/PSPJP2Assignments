package com.sapient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DateTimeController {
	
	@Autowired
	private DateTimeCalculator dateTimeCalculator;
	
	@RequestMapping(value = "/ops", method = RequestMethod.GET)
	public String getOps() {
		System.out.println("Reached here");
		return "ops";
	}
	
	@RequestMapping(value = "/diffTwoDates", method = RequestMethod.GET)
	public String period(@RequestParam String date1, @RequestParam String date2, ModelMap map) {
		map.addAttribute("result", dateTimeCalculator.getDifferenceBetweenTwoDates(date1, date2));
		return "result";
	}
	
	@RequestMapping(value = "/addDays", method = RequestMethod.GET)
	public String addDays(@RequestParam String date1, @RequestParam String n, ModelMap map) {
		map.addAttribute("result", dateTimeCalculator.addNDays(date1, Integer.parseInt(n)));
		return "result";
	}
	
	@RequestMapping(value = "/subtractDays", method = RequestMethod.GET)
	public String subtractDays(@RequestParam String date1, @RequestParam String n, ModelMap map) {
		map.addAttribute("result", dateTimeCalculator.subtractNDays(date1, Integer.parseInt(n)));
		return "result";
	}
	
	@RequestMapping(value = "/addWeeks", method = RequestMethod.GET)
	public String addWeeks(@RequestParam String date1, @RequestParam String n, ModelMap map) {
		map.addAttribute("result", dateTimeCalculator.addNWeeks(date1, Integer.parseInt(n)));
		return "result";
	}
	
	@RequestMapping(value = "/subtractWeeks", method = RequestMethod.GET)
	public String subtractWeeks(@RequestParam String date1, @RequestParam String n, ModelMap map) {
		map.addAttribute("result", dateTimeCalculator.subtractNWeeks(date1, Integer.parseInt(n)));
		return "result";
	}
	
	@RequestMapping(value = "/addMonths", method = RequestMethod.GET)
	public String addMonths(@RequestParam String date1, @RequestParam String n, ModelMap map) {
		map.addAttribute("result", dateTimeCalculator.addNMonths(date1, Integer.parseInt(n)));
		return "result";
	}
	
	@RequestMapping(value = "/subtractMonths", method = RequestMethod.GET)
	public String subtractMonths(@RequestParam String date1, @RequestParam String n, ModelMap map) {
		map.addAttribute("result", dateTimeCalculator.subtractNMonths(date1, Integer.parseInt(n)));
		return "result";
	}
	
	@RequestMapping(value = "/dayOfWeek", method = RequestMethod.GET)
	public String dayOfWeek(@RequestParam String date1, ModelMap map) {
		map.addAttribute("result", dateTimeCalculator.getDayOfWeek(date1));
		return "result";
	}
	
	@RequestMapping(value = "/weekNumber", method = RequestMethod.GET)
	public String weekNumber(@RequestParam String date1, ModelMap map) {
		map.addAttribute("result", Integer.toString(dateTimeCalculator.getWeekNumber(date1)));
		return "result";
	}


}
