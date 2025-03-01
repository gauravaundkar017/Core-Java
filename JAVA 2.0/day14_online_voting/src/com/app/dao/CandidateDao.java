package com.app.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.app.custom_exception.CustomException;
import com.app.entities.Candidate;

public interface CandidateDao {
	List<Candidate> getAllCandidate() throws SQLException, CustomException;
	String incrementCandidateVotes(int id) throws SQLException, CustomException;
	List<Candidate> getTopTwoCandidatesByVotes() throws SQLException, CustomException;
//	List<Candidate> getPartyVotes() throws SQLException, CustomException;
	Map<String, Integer> getPartyVotes() throws SQLException, CustomException ;

}
