package com.kf5.support.model;

public class VoiceCall {

	/**
	 * "callsid": "170822182506282000010227000e73c4", "recordurl": "",
	 * "user_name": "18620301774", "alerting_seconds": 0, "created_at":
	 * "2017-08-22 18:25:06", "callduration": 0, "type": "outbound", "duration":
	 * 0, "user_id": 30524100, "from": "01083036353", "id": 9194169, "to":
	 * "18620301774", "is_answered": 0
	 */

	private String callsid;
	private String recordurl;
	private String user_name;
	private int alerting_seconds;
	private String created_at;
	private int callduration;
	private String type;
	private int duration;
	private int user_id;
	private String from;
	private int id;
	private String to;
	private int is_answered;

	public String getCallsid() {
		return callsid;
	}

	public void setCallsid(String callsid) {
		this.callsid = callsid;
	}

	public String getRecordurl() {
		return recordurl;
	}

	public void setRecordurl(String recordurl) {
		this.recordurl = recordurl;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public int getAlerting_seconds() {
		return alerting_seconds;
	}

	public void setAlerting_seconds(int alerting_seconds) {
		this.alerting_seconds = alerting_seconds;
	}

	public String getCreated_at() {
		return created_at;
	}

	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}

	public int getCallduration() {
		return callduration;
	}

	public void setCallduration(int callduration) {
		this.callduration = callduration;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public int getIs_answered() {
		return is_answered;
	}

	public void setIs_answered(int is_answered) {
		this.is_answered = is_answered;
	}
}
