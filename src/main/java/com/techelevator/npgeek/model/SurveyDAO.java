package com.techelevator.npgeek.model;

import java.util.List;


public interface SurveyDAO {

	public List<Survey> getSurveyCount();
	public void createSurvey(Survey survey);
	
}


