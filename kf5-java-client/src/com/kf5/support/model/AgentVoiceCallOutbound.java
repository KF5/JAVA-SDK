package com.kf5.support.model;

public class AgentVoiceCallOutbound {

	/**
	 * "agentid": 1102, "total": 3, "avg_callduration": 0, "agent_name": "小娜",
	 * "answer": 0, "callduration": 0, "answer_rate": "0%"
	 */
	private int agentid;// 语音账号ID
	private int total;// 呼出量
	private int avg_callduration;// 平均通话时长
	private String agent_name;// 客服名称
	private int answer;// 接通量
	private int callduration;// 通话时长
	private String answer_rate;// 接通率

	public int getAgentid() {
		return agentid;
	}

	public void setAgentid(int agentid) {
		this.agentid = agentid;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getAvg_callduration() {
		return avg_callduration;
	}

	public void setAvg_callduration(int avg_callduration) {
		this.avg_callduration = avg_callduration;
	}

	public String getAgent_name() {
		return agent_name;
	}

	public void setAgent_name(String agent_name) {
		this.agent_name = agent_name;
	}

	public int getAnswer() {
		return answer;
	}

	public void setAnswer(int answer) {
		this.answer = answer;
	}

	public int getCallduration() {
		return callduration;
	}

	public void setCallduration(int callduration) {
		this.callduration = callduration;
	}

	public String getAnswer_rate() {
		return answer_rate;
	}

	public void setAnswer_rate(String answer_rate) {
		this.answer_rate = answer_rate;
	}

}
