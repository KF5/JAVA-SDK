package com.kf5.support.model;

import java.util.List;

public class AgentStatusTimeStatistics {

	private List<AgentStatusTime> agentStatusTimes;
	private AgentStatusSummary agentStatusSummary;

	public List<AgentStatusTime> getAgentStatusTimes() {
		return agentStatusTimes;
	}

	public void setAgentStatusTimes(List<AgentStatusTime> agentStatusTimes) {
		this.agentStatusTimes = agentStatusTimes;
	}

	public AgentStatusSummary getAgentStatusSummary() {
		return agentStatusSummary;
	}

	public void setAgentStatusSummary(AgentStatusSummary agentStatusSummary) {
		this.agentStatusSummary = agentStatusSummary;
	}

}
