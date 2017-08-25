package com.kf5.support.model;

public class AgentVoiceCallSubsectionOutbound {

	/**
	 * "avg_callduration": 0, "ticket_num": 0, "answer": 0, "unanswer": 0,
	 * "time": "2017-08-18", "answer_rate": "-", "agent_num": 0
	 */

	private int avg_callduration;
	private int ticket_num;
	private int answer;
	private int unanswer;
	private String time;
	private String answer_rate;
	private int agent_num;
	public int getAvg_callduration() {
		return avg_callduration;
	}
	public void setAvg_callduration(int avg_callduration) {
		this.avg_callduration = avg_callduration;
	}
	public int getTicket_num() {
		return ticket_num;
	}
	public void setTicket_num(int ticket_num) {
		this.ticket_num = ticket_num;
	}
	public int getAnswer() {
		return answer;
	}
	public void setAnswer(int answer) {
		this.answer = answer;
	}
	public int getUnanswer() {
		return unanswer;
	}
	public void setUnanswer(int unanswer) {
		this.unanswer = unanswer;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getAnswer_rate() {
		return answer_rate;
	}
	public void setAnswer_rate(String answer_rate) {
		this.answer_rate = answer_rate;
	}
	public int getAgent_num() {
		return agent_num;
	}
	public void setAgent_num(int agent_num) {
		this.agent_num = agent_num;
	}

	
}
