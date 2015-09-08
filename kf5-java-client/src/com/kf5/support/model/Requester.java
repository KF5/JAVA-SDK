package com.kf5.support.model;

import java.util.ArrayList;
import java.util.List;

public class Requester {

	private int id; // 工单编号，创建工单时系统自动分配
	
	private String url; //此工单的url地址
	
	private String title; //标题
	
	private String description; //第一条工单回复的文本内容
	
	private String type; //类型："problem", "incident", "question", "task"
	
	private String status; //状态："new","open", "pending", "solved", "closed"
	
	private String priority; //优先级："low", "medium", "high", "urgent"
	
	private String recipient; //邮件工单的原收件人地址
	
	private int requester_id;//发起人id
	
	private int assignee_id; //受理客服id
	
	private int organization_id; //发起人所属公司组织id
	
	private int group_id; //受理客服组id
	
	private String due_date; //task工单的截止时间
	
	private String created_at; //创建时间
	
	private String updated_at; //最后更新时间
	
	private String source; //工单来源
	
	private List<CustomField> customFields = new ArrayList<CustomField>(); //工单自定义字段

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public String getRecipient() {
		return recipient;
	}

	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}

	public int getRequester_id() {
		return requester_id;
	}

	public void setRequester_id(int requester_id) {
		this.requester_id = requester_id;
	}

	public int getAssignee_id() {
		return assignee_id;
	}

	public void setAssignee_id(int assignee_id) {
		this.assignee_id = assignee_id;
	}

	public int getOrganization_id() {
		return organization_id;
	}

	public void setOrganization_id(int organization_id) {
		this.organization_id = organization_id;
	}

	public int getGroup_id() {
		return group_id;
	}

	public void setGroup_id(int group_id) {
		this.group_id = group_id;
	}

	public String getDue_date() {
		return due_date;
	}

	public void setDue_date(String due_date) {
		this.due_date = due_date;
	}

	public String getCreated_at() {
		return created_at;
	}

	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}

	public String getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(String updated_at) {
		this.updated_at = updated_at;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public List<CustomField> getCustomFields() {
		return customFields;
	}

	public void setCustomFields(List<CustomField> customFields) {
		this.customFields = customFields;
	}
	
	
	
}
