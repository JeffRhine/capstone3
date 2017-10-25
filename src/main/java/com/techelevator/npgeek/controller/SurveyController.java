package com.techelevator.npgeek.controller;

import java.util.List;

import javax.validation.Valid;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.techelevator.npgeek.model.Survey;




@Controller
public class SurveyController {

	

//	@RequestMapping(path = "/surveyInput", method = RequestMethod.GET)
//	public String survey() {
//		return "surveyInput";
//	}
	@RequestMapping(path="/surveyInput", method=RequestMethod.GET)
	public String showRegistrationForm(ModelMap modelHolder) {
		if(! modelHolder.containsAttribute("surveyInput")){
			modelHolder.put("surveyInput", new Survey());
		}
		return "surveyInput";
	}
	
	@RequestMapping(path = "/surveyResult", method = RequestMethod.POST)
	public String processSurveyForm(@Valid @ModelAttribute Survey survey, BindingResult result, RedirectAttributes flash){		
		flash.addFlashAttribute("surveyInput",survey);	
		if(result.hasErrors()){
			flash.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX+"surveyInput",result);
			return "redirect:/surveyInput";
		}
		return "redirect:/surveyResult";
	}

}

