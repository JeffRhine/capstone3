package com.techelevator.npgeek.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.techelevator.npgeek.model.Park;
import com.techelevator.npgeek.model.ParkDAO;
import com.techelevator.npgeek.model.Survey;
import com.techelevator.npgeek.model.SurveyDAO;
import com.techelevator.npgeek.model.Weather;




@Controller
public class SurveyController {

	@Autowired
	SurveyDAO surveyDAO;
	
	@Autowired
	private ParkDAO parkDAO;


	@RequestMapping(path="/surveyInput", method=RequestMethod.GET)
	public String showRegistrationForm(ModelMap modelHolder) {
		if(! modelHolder.containsAttribute("surveyInput")){
			modelHolder.put("surveyInput", new Survey());
		}
		return "surveyInput";
	}
	
	@RequestMapping(path = "/surveyInput", method = RequestMethod.POST)
	public String processSurveyForm(@Valid @ModelAttribute Survey survey, BindingResult result, RedirectAttributes flash){		
		flash.addFlashAttribute("surveyInput",survey);	
		if(result.hasErrors()){
			flash.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX+"surveyInput",result);
			return "redirect:/surveyInput";
		}
		surveyDAO.createSurvey(survey);
		return "redirect:/surveyResults";
	}
	@RequestMapping(path = "/surveyResults", method = RequestMethod.GET)
	public String survey(ModelMap modelHolder) {	
		List<Survey> survey = surveyDAO.getSurveyCount();
		modelHolder.put("surveyCount", survey);
		return "surveyResults";
	}

}
//@RequestMapping(path = { "/parkDetail" }, method = RequestMethod.GET)
//public String parkDetail(@RequestParam String parkCode, ModelMap modelHolder) {
//	List<Park> park = parkDAO.getParkDetails(parkCode);
//	List<Weather> weather = weatherDAO.getParkWeather(parkCode);
//	modelHolder.put("parkDetails", park);
//	modelHolder.put("parkWeather", weather);
//	return "parkDetail";
//}
