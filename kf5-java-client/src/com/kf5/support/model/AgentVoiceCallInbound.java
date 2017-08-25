package com.kf5.support.model;

public class AgentVoiceCallInbound {

	/**
	 * "avg_callduration": 12, "ticket_num": 1, "agent_id": "1000698",
	 * "agent_name": "吕贵", "score_rate": "100%", "callduration": 12,
	 * "answer_rate": "50%", "total": 2, "score_num": 1, "answer": 1,
	 * "cancel_rate": "-", "user_cancel": 0, "avg_score": "20%"
	 */

	private int avg_callduration;
	private int ticket_num;
	private String agent_id;
	private String agent_name;
	private String score_rate;
	private int callduration;
	private String answer_rate;
	private int total;
	private int score_num;
	private int answer;
	private String cancel_rate;
	private int user_cancel;
	private String avg_score;

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

	public String getAgent_id() {
		return agent_id;
	}

	public void setAgent_id(String agent_id) {
		this.agent_id = agent_id;
	}

	public String getAgent_name() {
		return agent_name;
	}

	public void setAgent_name(String agent_name) {
		this.agent_name = agent_name;
	}

	public String getScore_rate() {
		return score_rate;
	}

	public void setScore_rate(String score_rate) {
		this.score_rate = score_rate;
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

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getScore_num() {
		return score_num;
	}

	public void setScore_num(int score_num) {
		this.score_num = score_num;
	}

	public int getAnswer() {
		return answer;
	}

	public void setAnswer(int answer) {
		this.answer = answer;
	}

	public String getCancel_rate() {
		return cancel_rate;
	}

	public void setCancel_rate(String cancel_rate) {
		this.cancel_rate = cancel_rate;
	}

	public int getUser_cancel() {
		return user_cancel;
	}

	public void setUser_cancel(int user_cancel) {
		this.user_cancel = user_cancel;
	}

	public String getAvg_score() {
		return avg_score;
	}

	public void setAvg_score(String avg_score) {
		this.avg_score = avg_score;
	}

}
