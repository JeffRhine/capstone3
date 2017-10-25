package com.techelevator.npgeek.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.techelevator.npgeek.model.SurveyDAO;

@Controller
public class SurveyController {

	@Autowired
	private SurveyDAO surveyDAO;

	@RequestMapping(path = "/surveyInput", method = RequestMethod.GET)

	public String survey() {

		return "surveyInput";
	}
	@RequestMapping(path = "/surveyInput", method = RequestMethod.POST)

	public String surveyPost() {

		return "";
	}
}
