package com.kf5.support.model;

public class AgentVoiceStateTime {

	/**
	 * "avg_online_duration": 3, "agentid": 1168, "agent_name": "Android 用户",
	 * "avg_break_duration": 0, "avg_busy_duration": 0, "online_duration": 85,
	 * "break_duration": 0, "busy_duration": 0
	 */

	private int avg_online_duration;// 日平均在线时长
	private int agentid;// 语音账号ID
	private String agent_name;// 客服名称
	private int avg_break_duration;// 日平均小休时长
	private int avg_busy_duration;// 日平均忙碌时长
	private int online_duration;// 总在线时长
	private int break_duration;// 总小休时长
	private int busy_duration;// 总忙碌时长

	public int getAvg_online_duration() {
		return avg_online_duration;
	}

	public void setAvg_online_duration(int avg_online_duration) {
		this.avg_online_duration = avg_online_duration;
	}

	public int getAgentid() {
		return agentid;
	}

	public void setAgentid(int agentid) {
		this.agentid = agentid;
	}

	public String getAgent_name() {
		return agent_name;
	}

	public void setAgent_name(String agent_name) {
		this.agent_name = agent_name;
	}

	public int getAvg_break_duration() {
		return avg_break_duration;
	}

	public void setAvg_break_duration(int avg_break_duration) {
		this.avg_break_duration = avg_break_duration;
	}

	public int getAvg_busy_duration() {
		return avg_busy_duration;
	}

	public void setAvg_busy_duration(int avg_busy_duration) {
		this.avg_busy_duration = avg_busy_duration;
	}

	public int getOnline_duration() {
		return online_duration;
	}

	public void setOnline_duration(int online_duration) {
		this.online_duration = online_duration;
	}

	public int getBreak_duration() {
		return break_duration;
	}

	public void setBreak_duration(int break_duration) {
		this.break_duration = break_duration;
	}

	public int getBusy_duration() {
		return busy_duration;
	}

	public void setBusy_duration(int busy_duration) {
		this.busy_duration = busy_duration;
	}

}
