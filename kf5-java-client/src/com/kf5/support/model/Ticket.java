package com.kf5.support.model;

import java.util.List;


/**
 * ����(�ͷ�)model
 * @author chosen
 *
 * @version ����ʱ�䣺2015��9��1��  ����2:07:04
 */
public class Ticket {

	private int id; //��������ʱϵͳ�Զ�����
	 
	private String url; // �˹�����url��ַ
	
	private String title; // ����
	
	private String description; // ��������������һ�������ظ����ı�����
	
	private String type; // ���ͣ�"problem", "incident", "question", "task"
	
	private String status; // ״̬��"new","open", "pending", "solved", "closed"
	
	private String priority; // ���ȼ���"low", "medium", "high", "urgent"
	
	private String recipient; // �ʼ�������ԭ�ռ��˵�ַ
	
	private int requesterId; // ������id
	
	private int organizationId; // ������������˾��֯id
	
	private int assigneeId;// ����ͷ�id
	
	private int groupId; // ����ͷ���id
	
	private int problemId; // incident������������problem������id
	
	private long dueDate; // task�����Ľ�ֹʱ��
	
	private String createdAt; // ����ʱ��
	
	private String updatedAt; // ������ʱ��
	
	private String assigneedAt;//�״α�����ʱ��
	
	private String resolvedAt; //���������ʱ��
	
	private String closedAt;//�������ر�ʱ��
	
	private String source; //������Դ��"web", "tab", "chat", "email","mobile", "weibo", "api"
	
	private String satisfactionRating; // ���������
	
	private List<CustomField> listCustomFields; //�����Զ����ֶ�

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
