package com.kf5.support.model;

import java.util.List;

public class ChatSourceStatistics {

	private ChatSourceOverview chatSourceOverview;
	private List<ChatSource> chatSources;

	public ChatSourceOverview getChatSourceOverview() {
		return chatSourceOverview;
	}

	public void setChatSourceOverview(ChatSourceOverview chatSourceOverview) {
		this.chatSourceOverview = chatSourceOverview;
	}

	public List<ChatSource> getChatSources() {
		return chatSources;
	}

	public void setChatSources(List<ChatSource> chatSources) {
		this.chatSources = chatSources;
	}

}
