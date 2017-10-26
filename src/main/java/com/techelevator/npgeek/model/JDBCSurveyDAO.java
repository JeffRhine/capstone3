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
	public List<Survey> getSurveyCount() {
			List<Survey> allSurvey = new ArrayList<>();
			String sqlSelect = "SELECT COUNT(parkcode),parkcode FROM survey_result GROUP BY parkcode ORDER BY COUNT DESC,parkcode LIMIT 5";
			SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelect);
			while(results.next()) {
				Survey s = new Survey();
				s.setParkCode(results.getString("parkcode"));
				s.setCount(results.getInt("count"));
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