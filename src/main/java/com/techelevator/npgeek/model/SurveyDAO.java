package com.techelevator.npgeek.model;

import java.util.List;


public interface SurveyDAO {

	public List<Survey> getAllSurveys();
	public void createSurvey(Survey survey);

}


