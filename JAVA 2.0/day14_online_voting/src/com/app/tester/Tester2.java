package com.app.tester;

import java.util.List;
import java.util.Scanner;

import com.app.dao.CandidateDaoImpl;
import com.app.dao.UserDaoImpl;
import com.app.entities.Candidate;
import com.app.entities.User;

public class Tester2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try (Scanner sc = new Scanner(System.in)) {
			UserDaoImpl userDao = new UserDaoImpl();
			CandidateDaoImpl candidatedao = new CandidateDaoImpl();
//			User u = new User();
            User user = null; // Initialize user object

			boolean exit = false;
//			System.out.println("Enter email n password");
//			User user = userDao.signIn(sc.next(), sc.next());
			

			while (!exit) {
				try {
					if (user == null) { // If user is not logged in, prompt for login
                        System.out.println("Enter email and password:");
                        user = userDao.signIn(sc.next(), sc.next());
                        if (user == null) { // If login fails, continue to prompt for login
                            System.out.println("Login failed! Please try again.");
                            continue;
                        }
                    }
                    
					System.out.println("1.cast votes \n2.Display All Candidates" + "\n3.Dissplay Top TWO Candidates"
							+ "\n4.Diplay part wise votes \n0.Exit");

					switch (sc.nextInt()) {
					case 1:

						if (user != null && user.getRole().equals("voter")) {
							if (user.isStatus() == false) {
								System.out.print("Enter voter id: ");
								int voterId = sc.nextInt();
								System.out.print("Enter candidate id: ");
								int candidateId = sc.nextInt();
								candidatedao.incrementCandidateVotes(candidateId);
								userDao.changeVotingStatus(voterId, true);
								System.out.println("Vote successfully casted!");
							} else {
								System.out.println("You have already voted!");
							}
						} else {
							System.out.println("Access denied! Only voter can perform this operation.");

						}

						break;
					case 2:
						if (user.getRole().equals("admin")) {
							List<Candidate> allCandidate = candidatedao.getAllCandidate();
							allCandidate.forEach(System.out::println);
						} else {
							System.out.println("Access denied! Only admin can perform this operation.");
						}

						break;

					case 3:
						if (user.getRole().equals("admin")) {
							System.out.println("Dissplay Top TWO Candidates");
							candidatedao.getTopTwoCandidatesByVotes().forEach(System.out::println);
						} else {
							System.out.println("Access denied! Only admin can perform this operation.");
						}
						break;

					case 4:
						if (user.getRole().equals("admin")) {
							System.out.println("Dissplay Party wise votes");
					        candidatedao.getPartyVotes().forEach((party, votes) -> System.out.println(party + ": " + votes));
						} else {
							System.out.println("Access denied! Only admin can perform this operation.");
						}
						break;
					case 0:
						exit = true;
						candidatedao.cleanUp();
					}

				} catch (Exception e) {
					e.printStackTrace();
					sc.nextLine();
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}