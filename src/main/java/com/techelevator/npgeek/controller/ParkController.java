package com.techelevator.npgeek.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.techelevator.npgeek.model.Park;
import com.techelevator.npgeek.model.ParkDAO;
import com.techelevator.npgeek.model.Weather;
import com.techelevator.npgeek.model.WeatherDAO;

@Controller
public class ParkController {

	@Autowired
	private ParkDAO parkDAO;
	
	@Autowired
	private WeatherDAO weatherDAO;

	@RequestMapping(path = { "/", "/home" }, method = RequestMethod.GET)

	public String home(ModelMap modelHolder) {
		List<Park> parks = parkDAO.getAllParks();
		modelHolder.put("allParks", parks);
		return "home";
	}

	@RequestMapping(path = { "/parkDetail" }, method = RequestMethod.GET)
	public String parkDetail(@RequestParam String parkCode, ModelMap modelHolder) {
		List<Park> park = parkDAO.getParkDetails(parkCode);
		List<Weather> weather = weatherDAO.getParkWeather(parkCode);
		modelHolder.put("parkDetails", park);
		modelHolder.put("parkWeather", weather);
		return "parkDetail";
	}

//	@RequestMapping(path = { "/parkDetail" }, method = RequestMethod.GET)
//	public String parkWeather(@RequestParam String parkCode, ModelMap modelHolder) {
//		List<Park> park = parkDAO.getParkDetails(parkCode);
//		modelHolder.put("parkDetails", park);
//		return "parkDetail";
//	}
}
