package com.kf5.support.model;

public class VoiceCallUnAnswered {

	/**
	 * "reason": "40", "user_id": "24874114", "created": "2017-08-21 10:34:30",
	 * "alerting_seconds": "0", "from": "073184147110", "id": "9147431",
	 * "callduration": "13"
	 */

	private String reason;// 户取消 0，坐席全忙 20，坐席拒接 40，排队人数限制 50，排队超时 51，非工作时间 60
	private String user_id;// 用户UID
	private String created;// 创建时间
	private String alerting_seconds;// 响应时长
	private String from;// 主叫号码
	private String id;// 通话明细ID
	private String callduration;// 呼叫时长

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getCreated() {
		return created;
	}

	public void setCreated(String created) {
		this.created = created;
	}

	public String getAlerting_seconds() {
		return alerting_seconds;
	}

	public void setAlerting_seconds(String alerting_seconds) {
		this.alerting_seconds = alerting_seconds;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCallduration() {
		return callduration;
	}

	public void setCallduration(String callduration) {
		this.callduration = callduration;
	}

}
