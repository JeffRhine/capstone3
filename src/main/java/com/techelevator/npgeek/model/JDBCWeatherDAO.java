package com.techelevator.npgeek.model;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JDBCWeatherDAO implements WeatherDAO {

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public JDBCWeatherDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	@Override
	public List<Weather> getParkWeather(String parkCode)  {
		List<Weather> allWeather = new ArrayList<>();
		String sqlSelect = "SELECT * FROM weather WHERE parkcode = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelect, parkCode);
		while(results.next()) {
			Weather w = new Weather();
			w.setFiveDayForecast(results.getInt("fivedayforecastvalue"));
			w.setParkCode(results.getString("parkcode"));
			w.setLow(results.getInt("low"));
			w.setHigh(results.getInt("high"));
			w.setForecast(results.getString("forecast"));
			allWeather.add(w);
	}
		return allWeather;
	
	
}
}