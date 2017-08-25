package com.kf5.support.model;

public class VoiceQueueCall {

	/**
	 * "callsid": "17072819174964210001022700690c84", "number": "180080xxx65",
	 * "source": null, "created": "2017-07-28 19:18:00", "queuetype": "0",
	 * "fromattr": "四川成都", "user_id": "17815427", "organization_name": "百度",
	 * "name": "龙湖三千集分店", "elaspe": 8
	 */

	private String callsid;// 会话ID
	private String number;// 来电号码
	private String source;// 按键来源
	private String created;// 呼入时间
	private String queuetype;// 队列类型
	private String fromattr;// 来自地区
	private String user_id;// 用户UID
	private String organization_name;// 公司组织
	private String name;// 用户名
	private int elaspe;// 已等候时长

	public String getCallsid() {
		return callsid;
	}

	public void setCallsid(String callsid) {
		this.callsid = callsid;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getCreated() {
		return created;
	}

	public void setCreated(String created) {
		this.created = created;
	}

	public String getQueuetype() {
		return queuetype;
	}

	public void setQueuetype(String queuetype) {
		this.queuetype = queuetype;
	}

	public String getFromattr() {
		return fromattr;
	}

	public void setFromattr(String fromattr) {
		this.fromattr = fromattr;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getOrganization_name() {
		return organization_name;
	}

	public void setOrganization_name(String organization_name) {
		this.organization_name = organization_name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getElaspe() {
		return elaspe;
	}

	public void setElaspe(int elaspe) {
		this.elaspe = elaspe;
	}

}
