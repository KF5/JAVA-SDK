package com.kf5.support.model;

import java.util.List;

public class AgentWorkStatusStatistics {

	private List<AgentWorkStatus> agentWorkStatus;
	private AgentWorkStatusOverview agentWorkStatusOverview;


	public List<AgentWorkStatus> getAgentWorkStatus() {
		return agentWorkStatus;
	}

	public void setAgentWorkStatus(List<AgentWorkStatus> agentWorkStatus) {
		this.agentWorkStatus = agentWorkStatus;
	}

	public AgentWorkStatusOverview getAgentWorkStatusOverview() {
		return agentWorkStatusOverview;
	}

	public void setAgentWorkStatusOverview(AgentWorkStatusOverview agentWorkStatusOverview) {
		this.agentWorkStatusOverview = agentWorkStatusOverview;
	}

}
