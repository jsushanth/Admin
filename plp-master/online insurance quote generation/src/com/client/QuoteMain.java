package com.client;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.bean.AdminBean;
import com.bean.Agent;
import com.bean.Customers;
import com.bean.ProfileCreation;
import com.dao.AgentDaoImpl;
import com.dao.IAgentDao;
import com.service.IService;
import com.service.ServiceImpl;
import com.sun.org.apache.xpath.internal.operations.Equals;

public class QuoteMain {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		AdminBean bean = null;

		while (true) {
			System.out.println("**********Admin access***************");
			System.out.println("1. Check agent details");
			System.out.println("2. Check customer details");
			System.out.println("3. Profile Creation");

			try {

				int option = 0;
				option = sc.nextInt();

				switch (option) {

				case 1:

					ServiceImpl iservice = new ServiceImpl();

					List<Agent> al = new ArrayList();
					al = iservice.viewPolicy();

					int number = 0;

					for (Agent ad : al) {

						number++;
						System.out.println(number + " " + ad);
					}

					System.out.println("enter the choice");
					int value = sc.nextInt();
					List<Customers> a2 = new ArrayList();
					for (int i = 0; i < al.size(); i++) {
						if (i == (value - 1)) {
							System.out.println(al.get(i));
							Agent agent = new Agent();
							agent = al.get(i);
							System.out.println(agent.getAgentName());
							IAgentDao dao = new AgentDaoImpl();
							a2 = dao.viewCustomers(agent.getAgentName());
							System.out.println(a2);
						}
					}

					break;
				case 2:
					ServiceImpl service = new ServiceImpl();

					IAgentDao dao = new AgentDaoImpl();
					List<Customers> a = new ArrayList<Customers>();
					a = dao.customerDetails();

					for (Customers ad : a) {

						System.out.println(" " + ad);
					}

					break;
				case 3:
					ProfileCreation profileCreation = null;

					while (profileCreation == null) {
						profileCreation = populateProfileCreation();

					}

					try {

						service = new ServiceImpl();

						AgentDaoImpl dao1 = new AgentDaoImpl();
						dao1.addProfile(profileCreation);
						System.out.println("profile creation successfully completed ");

					} catch (Exception e) {

						e.printStackTrace();
					}
					break;
				default:
					System.out.println("out of the application");

				}
			} catch (Exception e) {
				System.out.println("hell");
			}

		}

	}

	private static ProfileCreation populateProfileCreation() {
		// TODO Auto-generated method stub
		ProfileCreation profileCreation = new ProfileCreation();

		System.out.println("\n Enter Details");

		System.out.println("Create username: ");
		profileCreation.setUserName(sc.next());

		System.out.println("Create password: ");
		profileCreation.setPassword(sc.next());

		System.out.println("Enter RoleCode");
		profileCreation.setRoleCode(sc.next());

		return profileCreation;
	}
}
