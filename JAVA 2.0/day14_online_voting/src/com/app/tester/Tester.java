package com.app.tester;

import java.util.List;
import java.util.Scanner;

import com.app.custom_exception.CustomException;
import com.app.dao.CandidateDaoImpl;
import com.app.dao.UserDaoImpl;
import com.app.entities.Candidate;
import com.app.entities.User;

public class Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try (Scanner sc = new Scanner(System.in)) {
			UserDaoImpl userDao = new UserDaoImpl();
			CandidateDaoImpl candidatedao = new CandidateDaoImpl();
			
			boolean exit = false;

			while (!exit) {
				System.out.println("1.Display All Candidates \n2.Increment Candidate Votes"
						+ "\n3.Dissplay Top TWO Candidates"
						+ "\n4.Diplay part wise votes \n0.Exit");
				try {
					switch (sc.nextInt()) {
					case 1:
						
						List<Candidate> allCandidate = candidatedao.getAllCandidate();
						allCandidate.forEach(System.out::println);
						
						break;
						
					case 2:
						System.out.print("Enter voter id :");
						System.out.println(candidatedao.incrementCandidateVotes(sc.nextInt()));
						break;
						
					case 3:
						System.out.println("Dissplay Top TWO Candidates");
						candidatedao.getTopTwoCandidatesByVotes().forEach(System.out::println);
						break;
						
					case 4:
						System.out.println("Dissplay Party wise votes");
//						candidatedao.getPartyVotes().forEach(c->System.out.println(c ->));
						break;
					case 0:
						exit = true;
						candidatedao.cleanUp();
					}
					
				}catch(Exception e) {
					e.printStackTrace();
					sc.nextLine();
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
