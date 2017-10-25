package com.techelevator.npgeek.model;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;



@Component
public class JDBCSurveyDAO implements SurveyDAO{

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public JDBCSurveyDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<Survey> getAllSurveys() {
			List<Survey> allSurvey = new ArrayList<>();
			String sqlSelect = "SELECT * FROM survey_result";
			SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelect);
			while(results.next()) {
				Survey s = new Survey();
				s.setParkCode(results.getString("parkcode"));
				s.setEmailAddress(results.getString("emailaddress"));
				s.setState(results.getString("state"));
				s.setActivityLevel(results.getString("activitylevel"));
				allSurvey.add(s);
		}
			return allSurvey;
		
		
	}

	@Override
	public void createSurvey(Survey survey) {
		
		String sqlCreateSurvey = "INSERT INTO survey_result( parkcode, emailaddress, state, activitylevel) "
									+ "VALUES( ?, ?, ?,?) ";
		jdbcTemplate.update(sqlCreateSurvey, survey.getParkCode(), survey.getEmailAddress(),survey.getState(),survey.getActivityLevel());
	}
	
}

//public void save(ForumPost post) {
//	Long id = getNextId();
//	String sqlInsertPost = "INSERT INTO forum_post(id, username, subject, message, post_date) VALUES (?,?,?,?,?)";
//	jdbcTemplate.update(sqlInsertPost, id, post.getUsername(), post.getSubject(), post.getMessage(), post.getDatePosted());
//	post.setId(id);
////}