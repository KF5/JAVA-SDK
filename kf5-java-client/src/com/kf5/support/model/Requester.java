package com.kf5.support.model;

import java.util.ArrayList;
import java.util.List;

public class Requester {

	private int id; // ������ţ���������ʱϵͳ�Զ�����
	
	private String url; //�˹�����url��ַ
	
	private String title; //����
	
	private String description; //��һ�������ظ����ı�����
	
	private String type; //���ͣ�"problem", "incident", "question", "task"
	
	private String status; //״̬��"new","open", "pending", "solved", "closed"
	
	private String priority; //���ȼ���"low", "medium", "high", "urgent"
	
	private String recipient; //�ʼ�������ԭ�ռ��˵�ַ
	
	private int requester_id;//������id
	
	private int assignee_id; //����ͷ�id
	
	private int organization_id; //������������˾��֯id
	
	private int group_id; //����ͷ���id
	
	private String due_date; //task�����Ľ�ֹʱ��
	
	private String created_at; //����ʱ��
	
	private String updated_at; //������ʱ��
	
	private String source; //������Դ
	
	private List<CustomField> customFields = new ArrayList<CustomField>(); //�����Զ����ֶ�

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
