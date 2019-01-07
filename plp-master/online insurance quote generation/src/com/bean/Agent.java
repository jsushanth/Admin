package com.bean;

public class Agent {
	String agentId;
	String agentName;
	int numofCustomers;
	public String getAgentId() {
		return agentId;
	}
	public void setAgentId(String agentId) {
		this.agentId = agentId;
	}
	public String getAgentName() {
		return agentName;
	}
	public void setAgentName(String agentName) {
		this.agentName = agentName;
	}
	public int getNumofCustomers() {
		return numofCustomers;
	}
	public void setNumofCustomers(int numofCustomers) {
		this.numofCustomers = numofCustomers;
	}
	@Override
	public String toString() {
		return "Agent [agentId=" + agentId + ", agentName=" + agentName + ", numofCustomers=" + numofCustomers + "]";
	}
	

}
