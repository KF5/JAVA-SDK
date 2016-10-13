package com.kf5.support.model;

import java.util.List;

public class Chat {

	private int id; // 对话ID

	private String type; // 对话类型

	private String started_by; // 对话创建者的身份类型

	private String status; // 对话状态

	private int agent_id;// 对话受理坐席ID

	private int visitor_id; // 访客ID

	private String created_at;// 对话创建时间

	private String assigned_at; // 对话受理时间

	private String end_at; // 对话结束时间

	private List<Message> list; // 对话的消息列表

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStarted_by() {
		return started_by;
	}

	public void setStarted_by(String started_by) {
		this.started_by = started_by;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getAgent_id() {
		return agent_id;
	}

	public void setAgent_id(int agent_id) {
		this.agent_id = agent_id;
	}


	public int getVisitor_id() {
		return visitor_id;
	}

	public void setVisitor_id(int visitor_id) {
		this.visitor_id = visitor_id;
	}

	public String getCreated_at() {
		return created_at;
	}

	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}

	public String getAssigned_at() {
		return assigned_at;
	}

	public void setAssigned_at(String assigned_at) {
		this.assigned_at = assigned_at;
	}

	public String getEnd_at() {
		return end_at;
	}

	public void setEnd_at(String end_at) {
		this.end_at = end_at;
	}

	public List<Message> getList() {
		return list;
	}

	public void setList(List<Message> list) {
		this.list = list;
	}

}
