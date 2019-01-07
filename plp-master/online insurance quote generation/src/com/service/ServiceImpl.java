package com.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bean.Agent;
import com.bean.Customers;
import com.bean.ProfileCreation;
import com.dao.AgentDaoImpl;
import com.dao.IAgentDao;

public class ServiceImpl implements IService{
	IAgentDao agentDao=null;
	
	@Override
	public List<Agent> viewPolicy() throws ClassNotFoundException, IOException, SQLException {
		// TODO Auto-generated method stub
		agentDao=new AgentDaoImpl();
		List<Agent> agentList=null;
		agentList=agentDao.viewPolicy();
		
		return agentList;
	}
	@Override
	public List<Customers> viewCustomers() throws ClassNotFoundException, IOException, SQLException {
		// TODO Auto-generated method stub
		agentDao=new AgentDaoImpl();
		List<Customers> customerList=null;
	    customerList=agentDao.viewCustomers( "");
		return customerList;
		
	}
	@Override
	public List<Customers> customerDetails() throws ClassNotFoundException, IOException, SQLException {
		
		agentDao=new AgentDaoImpl();
		List<Customers> customerDetail=new ArrayList<>();
	    customerDetail=agentDao.customerDetails();
		return customerDetail;
	}
	@Override
	public String addProfile(ProfileCreation profile) throws ClassNotFoundException, IOException, SQLException {
		// TODO Auto-generated method stub
		agentDao=new AgentDaoImpl();
		
		String profileCreation;
		profileCreation= agentDao.addProfile(profile);
		return profileCreation; 
		
	}

	

}
