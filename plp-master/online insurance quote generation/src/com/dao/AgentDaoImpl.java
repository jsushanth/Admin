package com.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bean.Agent;
import com.bean.Customers;
import com.bean.ProfileCreation;
import com.exception.AgentException;
import com.util.DBConnection;

public class AgentDaoImpl implements IAgentDao{

	@Override
	public List<Agent> viewPolicy() throws ClassNotFoundException, IOException, SQLException {
		

		Connection con=DBConnection.getConnection();
		int donorCount = 0;
		
		PreparedStatement ps=null;
		ResultSet resultset = null;
		
		List<Agent> al=new ArrayList<Agent>();
		try
		{
			ps=con.prepareStatement("select * from agent");
			resultset=ps.executeQuery();
			
			while(resultset.next())
			{	
				Agent agent=new Agent();
				agent.setAgentId(resultset.getString(1));
				agent.setAgentName(resultset.getString(2));
				agent.setNumofCustomers(resultset.getInt(3));
				al.add(agent);
				
				
			
			}			
			
		} catch (SQLException e) {
		e.printStackTrace();
		}
		return al;
	}

	@Override
	public List<Customers> viewCustomers(String agentId) throws ClassNotFoundException, IOException, SQLException {
		
Connection con=DBConnection.getConnection();
		PreparedStatement ps=null;
		ResultSet resultset = null;
		
		List<Customers> a2=new ArrayList<Customers>();
		try
		{
			ps=con.prepareStatement("select c.insuredname,c.agentname,c.businesssegment from agent_create_account c,agent a where c.agentname=a.agentname and a.agentname=?");
		
			ps.setString(1,agentId); 
				 

			resultset=ps.executeQuery();
			
			while(resultset.next())
			{	
				Customers customer=new Customers();
				
           
				customer.setAgentName(resultset.getString(1));
				customer.setInsuredName(resultset.getString(2));
				
				customer.setBusinessSegment(resultset.getString(3));
				a2.add(customer);
				
			}		
			
		} catch (SQLException e) {
		e.printStackTrace();
		}
		return a2;
	}

	@Override
	public List<Customers> customerDetails() throws ClassNotFoundException, IOException, SQLException {
		
		Connection con=DBConnection.getConnection();
		//PreparedStatement ps=null;
		ResultSet resultset = null;
		Statement st=null;
		List<Customers> a3=new ArrayList<Customers>();
		try
		{
			st=con.createStatement();
			resultset=st.executeQuery("select agentname,insuredname,accountnumber,businesssegment,policynumber,premiumamount from agent_create_account");
		
			
			
			while(resultset.next())
			{	
				Customers customer1=new Customers();
				
				
				
				customer1.setAgentName(resultset.getString(1));
				
				customer1.setInsuredName(resultset.getString(2));
				customer1.setAccountNumber(resultset.getLong(3));
				customer1.setBusinessSegment(resultset.getString(4));
				customer1.setPolicyNumber(resultset.getLong(5));
				customer1.setPremiumAmount(resultset.getLong(6));
				
				
				a3.add(customer1);
				
			}		
			
		} catch (SQLException e) {
		System.out.println("enter");
		}
		return a3;
	}

	@Override
	public String addProfile(ProfileCreation profile) throws ClassNotFoundException, IOException, SQLException {
		// TODO Auto-generated method stub
        Connection connection = DBConnection.getConnection();	
		
		PreparedStatement preparedStatement=null;		
		ResultSet resultSet = null;
		
		//String donorId=null;
		
		int queryResult=0;
		try
		{		
			preparedStatement=connection.prepareStatement("Insert into profiledetails values(?,?,?)");

			preparedStatement.setString(1,profile.getUserName());			
			preparedStatement.setString(2,profile.getPassword());
			preparedStatement.setString(3,profile.getRoleCode());
						
			
			queryResult=preparedStatement.executeUpdate();
			//preparedStatement = connection.prepareStatement(QueryMapper.DONARID_QUERY_SEQUENCE);
//			resultSet=preparedStatement.executeQuery();

			

		}
		catch(SQLException sqlException)
		{
			sqlException.printStackTrace();
			
			
		}
		return null ;

		
		}
		
		
	}

	


	

