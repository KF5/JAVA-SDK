package com.kf5.support.model;

import java.util.ArrayList;
import java.util.List;

public class User {

	private int id;//�û�id����ϵͳϵͳ����
	
	private String url; // ��Դurl
	
	private String email; // �û�����
	
	private String name; //�û��ǳ�
	
	private String agentDisplayName; //�ͷ�������ʱ��ʾ����
	
	private String role; //�û���ɫ����ѡֵ:end_user,agent,admin
	
	private String phone;//�û��ֻ�
	
	private boolean phoneBind; //�ֻ��Ƿ��
	
	private String signature; //�ͷ�������ʱ��ʾǩ��
	
	private String details; //��ϸ��Ϣ
	
	private String notes; //�û�˵��
	
	private int organizationId;//�û�������֯id
	
	private String language;//�û���ƫ������
	
	private String createdAt;//����ʱ��
	
	private String updatedAt;//������ʱ��
	
	private String lastLoginAt;//�����¼ʱ��
	
	private String status; //�û�״̬����ѡֵ��suspended��ͣ,active����,unverifiedδ���
	
	private String photo; //�û�ͷ��ͼƬ��url��ַ
	
	private boolean modetator; //�ͷ��ĵ�Ȩ�ޣ�true��ʾ�ܱ༭�ĵ�
	
	private boolean publicComments; //�ͷ��ظ�����Ȩ�ޣ�falseΪֻ��˽�ܻظ�
	
	private String ticketRestriction;//�ͷ�������Ȩ�ޣ�all��ʾ�����������й�����groups��ʾֻ������ͷ���Ĺ�����assigned��ʾֻ���������Ĺ���
	
	private boolean managePeople; //�ͷ������û�Ȩ�ޣ�true��ʾ���Թ����û�
	
	private int customRoleId; //�ͷ��������Զ����ɫid���߼�����ģʽ���д˹��ܡ���ֵ��Ϊ�գ���ô����Ŀͷ�Ȩ���ֶβ��������ã�Ȩ�ް���custom_role���������Ч
	
	private List<UserFiled> userFileds = new ArrayList<UserFiled>();//�û��Զ����ֶ�

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAgentDisplayName() {
		return agentDisplayName;
	}

	public void setAgentDisplayName(String agentDisplayName) {
		this.agentDisplayName = agentDisplayName;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public boolean isPhoneBind() {
		return phoneBind;
	}

	public void setPhoneBind(boolean phoneBind) {
		this.phoneBind = phoneBind;
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public int getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(int organizationId) {
		this.organizationId = organizationId;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
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

	public String getLastLoginAt() {
		return lastLoginAt;
	}

	public void setLastLoginAt(String lastLoginAt) {
		this.lastLoginAt = lastLoginAt;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public boolean isModetator() {
		return modetator;
	}

	public void setModetator(boolean modetator) {
		this.modetator = modetator;
	}

	public boolean isPublicComments() {
		return publicComments;
	}

	public void setPublicComments(boolean publicComments) {
		this.publicComments = publicComments;
	}

	public String getTicketRestriction() {
		return ticketRestriction;
	}

	public void setTicketRestriction(String ticketRestriction) {
		this.ticketRestriction = ticketRestriction;
	}

	public boolean isManagePeople() {
		return managePeople;
	}

	public void setManagePeople(boolean managePeople) {
		this.managePeople = managePeople;
	}

	public int getCustomRoleId() {
		return customRoleId;
	}

	public void setCustomRoleId(int customRoleId) {
		this.customRoleId = customRoleId;
	}

	public List<UserFiled> getUserFileds() {
		return userFileds;
	}

	public void setUserFileds(List<UserFiled> userFileds) {
		this.userFileds = userFileds;
	}

	
}
