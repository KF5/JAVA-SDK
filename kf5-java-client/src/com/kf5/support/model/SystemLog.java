package com.kf5.support.model;

public class SystemLog {

	/**
	 * "user_id": 6757897, "object_type": "ticket", "user_name": "逸创开发-刘强",
	 * "ip": "106.75.26.151", "action": "edit", "created_at": "1503557118",
	 * "id": 38109048, "object": "工单  #1009892"
	 */

	private int user_id;// 操作用户id
	private String object_type;// 被操作对象类型
	private String user_name;// 操作用户名称
	private String ip;// 操作环境ip
	private String action;// 执行动作
	private String created_at;// 创建时间戳
	private int id;// 日志id，由系统自动分配
	private String object;// 被操作对象信息

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getObject_type() {
		return object_type;
	}

	public void setObject_type(String object_type) {
		this.object_type = object_type;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getCreated_at() {
		return created_at;
	}

	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getObject() {
		return object;
	}

	public void setObject(String object) {
		this.object = object;
	}

}
