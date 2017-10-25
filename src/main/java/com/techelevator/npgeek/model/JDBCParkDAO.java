package com.techelevator.npgeek.model;


import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;



@Component
public class JDBCParkDAO implements ParkDAO{

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public JDBCParkDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	@Override
	public List<Park> getAllParks()  {
		List<Park> allParks = new ArrayList<>();
		String sqlSelect = "SELECT * FROM park";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelect);
		while(results.next()) {
			Park p = new Park();
			p.setParkCode(results.getString("parkcode"));
			p.setParkName(results.getString("parkname"));
			p.setState(results.getString("state"));
			p.setParkDescription(results.getString("parkdescription"));
			p.setAcreage(results.getInt("acreage"));
			p.setElevationInFeet(results.getInt("elevationinfeet"));
			p.setMilesOfTrail(results.getDouble("milesoftrail"));
			p.setNumberOfCampsites(results.getInt("numberofcampsites"));
			p.setClimate(results.getString("climate"));
			p.setYearFounded(results.getInt("yearfounded"));
			p.setAnnualVisitorCount(results.getInt("annualvisitorcount"));
			p.setQuote(results.getString("inspirationalquote"));
			p.setQuoteSource(results.getString("inspirationalquotesource"));
			p.setEntryFee(results.getInt("entryfee"));
			allParks.add(p);
	}
		return allParks;
	
	
}

	@Override
	public List<Park> getParkDetails(String parkCode) {
		List<Park> parkDetail = new ArrayList<>();
		String sqlSelect = "SELECT * FROM park WHERE parkcode=?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelect, parkCode);
		while(results.next()) {
			Park p = new Park();
			p.setParkCode(results.getString("parkcode"));
			p.setParkName(results.getString("parkname"));
			p.setState(results.getString("state"));
			p.setParkDescription(results.getString("parkdescription"));
			p.setAcreage(results.getInt("acreage"));
			p.setElevationInFeet(results.getInt("elevationinfeet"));
			p.setMilesOfTrail(results.getDouble("milesoftrail"));
			p.setNumberOfCampsites(results.getInt("numberofcampsites"));
			p.setClimate(results.getString("climate"));
			p.setYearFounded(results.getInt("yearfounded"));
			p.setAnnualVisitorCount(results.getInt("annualvisitorcount"));
			p.setQuote(results.getString("inspirationalquote"));
			p.setQuoteSource(results.getString("inspirationalquotesource"));
			p.setEntryFee(results.getInt("entryfee"));
			p.setNumberOfAnimals(results.getInt("numberofanimalspecies"));
			parkDetail.add(p);
	}
		return parkDetail;
	}
}
