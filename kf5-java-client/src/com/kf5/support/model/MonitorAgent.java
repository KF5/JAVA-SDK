package com.kf5.support.model;

import java.util.List;

public class MonitorAgent {

	private List<AgentStatus> agentStatus;

	private AgentOverview agentOverview;

	public List<AgentStatus> getAgentStatus() {
		return agentStatus;
	}

	public void setAgentStatus(List<AgentStatus> agentStatus) {
		this.agentStatus = agentStatus;
	}

	public AgentOverview getAgentOverview() {
		return agentOverview;
	}

	public void setAgentOverview(AgentOverview agentOverview) {
		this.agentOverview = agentOverview;
	}

}
