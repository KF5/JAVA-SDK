package com.kf5.support.model;

public class AgentVoiceCallSubsectionInbound {

	/**
	 * "avg_callduration": 0, "ticket_num": 0, "answer": 0,
	 * "avg_response_duration": 0, "time": "2017-08-20", "answer_rate": "-",
	 * "acd_cancel": 0, "agent_num": 0, "ivr_cancel": 0, "agent_reject": 0,
	 * "avg_score": "0%"
	 */

	private int avg_callduration;// 平均通话时长
	private int ticket_num;// 工单数
	private int answer;// 接通量
	private int avg_response_duration;// 平均响应时长
	private String time;// 时段
	private String answer_rate;// 接通率
	private int acd_cancel;// ACD排队放弃量
	private int agent_num;// 参与客服数
	private int ivr_cancel;// IVR放弃量
	private int agent_reject;// 坐席放弃量
	private String avg_score;// 平均评价

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

	public int getAvg_response_duration() {
		return avg_response_duration;
	}

	public void setAvg_response_duration(int avg_response_duration) {
		this.avg_response_duration = avg_response_duration;
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

	public int getAcd_cancel() {
		return acd_cancel;
	}

	public void setAcd_cancel(int acd_cancel) {
		this.acd_cancel = acd_cancel;
	}

	public int getAgent_num() {
		return agent_num;
	}

	public void setAgent_num(int agent_num) {
		this.agent_num = agent_num;
	}

	public int getIvr_cancel() {
		return ivr_cancel;
	}

	public void setIvr_cancel(int ivr_cancel) {
		this.ivr_cancel = ivr_cancel;
	}

	public int getAgent_reject() {
		return agent_reject;
	}

	public void setAgent_reject(int agent_reject) {
		this.agent_reject = agent_reject;
	}

	public String getAvg_score() {
		return avg_score;
	}

	public void setAvg_score(String avg_score) {
		this.avg_score = avg_score;
	}

}
