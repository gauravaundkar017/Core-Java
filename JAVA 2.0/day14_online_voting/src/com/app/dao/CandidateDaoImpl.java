package com.app.dao;

import static com.app.utils.DBUtils.openConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.app.custom_exception.CustomException;
import com.app.entities.Candidate;
import com.app.entities.User;
import com.mysql.cj.jdbc.CallableStatement;

public class CandidateDaoImpl implements CandidateDao {
	private Connection cn;
	private CallableStatement cst;
	private PreparedStatement pst, pst1;
	private Statement st;
	private ResultSet rst, rst1, rst2;

	public CandidateDaoImpl() throws SQLException {
		cn = openConnection();
		st = cn.createStatement();

		// update vote

		// toop 2

		// part wise vote

	}

	@Override
	public List<Candidate> getAllCandidate() throws SQLException, CustomException {
		// TODO Auto-generated method stub
		
		
			rst = st.executeQuery("Select * from candidates");
			List<Candidate> listOfCandidate = new ArrayList<Candidate>();
			while (rst.next()) {
				listOfCandidate.add(new Candidate(rst.getString(2), rst.getString(3), rst.getInt(4)));
			}

			if (listOfCandidate.isEmpty())
				throw new CustomException("Candiate List is empty.");
			return listOfCandidate;
		

	}

	@Override
	public String incrementCandidateVotes(int id) throws SQLException, CustomException {
		// TODO Auto-generated method stub
		pst = cn.prepareStatement("update candidates set votes = votes + 1 where id = ?");
		pst.setInt(1, id);

		int updatedvotes = pst.executeUpdate();
		if (updatedvotes == 1)
			return "Vote updated";
		throw new CustomException("Id is not able to vote");
	}

	@Override
	public List<Candidate> getTopTwoCandidatesByVotes() throws SQLException, CustomException {
		// TODO Auto-generated method stub
		rst1 = st.executeQuery(
				"select * from candidates c where 2 > (select count(*) from (select distinct votes from candidates) cv where cv.votes > c.votes ) order by votes desc");
		List<Candidate> listOfTopTwoCandidates = new ArrayList<Candidate>();
		while (rst1.next()) {
			listOfTopTwoCandidates.add(new Candidate(rst1.getString(2), rst1.getString(3), rst1.getInt(4)));
		}
		if (listOfTopTwoCandidates.isEmpty())
			throw new CustomException("List is empty");
		return listOfTopTwoCandidates;
	}
	
	@Override
	public Map<String, Integer> getPartyVotes() throws SQLException, CustomException {
	    Map<String, Integer> partyVotesMap = new HashMap<>();
	    rst2 = st.executeQuery("SELECT party, SUM(votes) FROM candidates GROUP BY party");
	    while (rst2.next()) {
	        partyVotesMap.put(rst2.getString(1), rst2.getInt(2));
	    }
	    if (partyVotesMap.isEmpty()) {
	        throw new CustomException("Empty map: partyVotesMap");
	    }
	    return partyVotesMap;
	}

//	@Override
//	public List<Candidate> getPartyVotes() throws SQLException, CustomException {
//		List<Candidate> listOfPartyWiseVotes = new ArrayList<Candidate>();
//		rst2 = st.executeQuery("select party , sum(votes) from candidates group by party;");
//		// TODO Auto-generated method stub
//		while (rst2.next()) {
//			listOfPartyWiseVotes.add(new Candidate(rst2.getString(1), rst2.getInt(2)));
//		}
//		if (listOfPartyWiseVotes.isEmpty())
//			throw new CustomException("Empty list : listOfPartyWiseVotes");
//		return listOfPartyWiseVotes;
//	}

	public void cleanUp() throws SQLException {
		if (rst != null)
			rst.close();
		if (rst1 != null)
			rst1.close();
		if (rst2 != null)
			rst2.close();

		if (st != null)
			st.close();

		if (pst != null)
			pst.close();

	}
}