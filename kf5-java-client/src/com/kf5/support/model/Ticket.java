package com.kf5.support.model;

import java.util.List;


/**
 * 工单(客服)model
 * @author chosen
 *
 * @version 创建时间：2015年9月1日  下午2:07:04
 */
public class Ticket {

	private int id; //创建工单时系统自动分配
	 
	private String url; // 此工单的url地址
	
	private String title; // 标题
	
	private String description; // 工单描述，即第一条工单回复的文本内容
	
	private String type; // 类型："problem", "incident", "question", "task"
	
	private String status; // 状态："new","open", "pending", "solved", "closed"
	
	private String priority; // 优先级："low", "medium", "high", "urgent"
	
	private String recipient; // 邮件工单的原收件人地址
	
	private int requesterId; // 发起人id
	
	private int organizationId; // 发起人所属公司组织id
	
	private int assigneeId;// 受理客服id
	
	private int groupId; // 受理客服组id
	
	private int problemId; // incident工单所关联的problem工单的id
	
	private long dueDate; // task工单的截止时间
	
	private String createdAt; // 创建时间
	
	private String updatedAt; // 最后更新时间
	
	private String assigneedAt;//首次被受理时间
	
	private String resolvedAt; //工单被解决时间
	
	private String closedAt;//工单被关闭时间
	
	private String source; //工单来源："web", "tab", "chat", "email","mobile", "weibo", "api"
	
	private String satisfactionRating; // 满意度评价
	
	private List<CustomField> listCustomFields; //工单自定义字段

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

	public int getRequesterId() {
		return requesterId;
	}

	public void setRequesterId(int requesterId) {
		this.requesterId = requesterId;
	}

	public int getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(int organizationId) {
		this.organizationId = organizationId;
	}

	public int getAssigneeId() {
		return assigneeId;
	}

	public void setAssigneeId(int assigneeId) {
		this.assigneeId = assigneeId;
	}

	public int getGroupId() {
		return groupId;
	}

	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}

	public int getProblemId() {
		return problemId;
	}

	public void setProblemId(int problemId) {
		this.problemId = problemId;
	}

	
	public long getDueDate() {
		return dueDate;
	}

	public void setDueDate(long dueDate) {
		this.dueDate = dueDate;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public String getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	}

	public String getAssigneedAt() {
		return assigneedAt;
	}

	public void setAssigneedAt(String assigneedAt) {
		this.assigneedAt = assigneedAt;
	}

	public String getResolvedAt() {
		return resolvedAt;
	}

	public void setResolvedAt(String resolvedAt) {
		this.resolvedAt = resolvedAt;
	}

	public String getClosedAt() {
		return closedAt;
	}

	public void setClosedAt(String closedAt) {
		this.closedAt = closedAt;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getSatisfactionRating() {
		return satisfactionRating;
	}

	public void setSatisfactionRating(String satisfactionRating) {
		this.satisfactionRating = satisfactionRating;
	}

	public List<CustomField> getListCustomFields() {
		return listCustomFields;
	}

	public void setListCustomFields(List<CustomField> listCustomFields) {
		this.listCustomFields = listCustomFields;
	}
	
	
}
