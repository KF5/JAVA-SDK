package com.kf5.support.model;

import java.util.List;

public class AgentConversationStatistics {

	private List<AgentConversation> agentConversations;
	private AgentConversationOverview agentConversationOverview;

	public List<AgentConversation> getAgentConversations() {
		return agentConversations;
	}

	public void setAgentConversations(List<AgentConversation> agentConversations) {
		this.agentConversations = agentConversations;
	}

	public AgentConversationOverview getAgentConversationOverview() {
		return agentConversationOverview;
	}

	public void setAgentConversationOverview(AgentConversationOverview agentConversationOverview) {
		this.agentConversationOverview = agentConversationOverview;
	}

}
