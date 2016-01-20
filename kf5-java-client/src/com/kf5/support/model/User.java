package com.kf5.support.model;

import java.util.ArrayList;
import java.util.List;

public class User {

	private int id;//用户id，有系统系统分配
	
	private String url; // 资源url
	
	private String email; // 用户邮箱
	
	private String name; //用户昵称
	
	private String agentDisplayName; //客服处理工单时显示名称
	
	private String role; //用户角色，可选值:end_user,agent,admin
	
	private String phone;//用户手机
	
	private boolean phoneBind; //手机是否绑定
	
	private String signature; //客服处理工单时显示签名
	
	private String details; //详细信息
	
	private String notes; //用户说明
	
	private int organizationId;//用户所属组织id
	
	private String language;//用户的偏好语言
	
	private String createdAt;//创建时间
	
	private String updatedAt;//最后更新时间
	
	private String lastLoginAt;//最近登录时间
	
	private String status; //用户状态，可选值：suspended暂停,active正常,unverified未审核
	
	private String photo; //用户头像图片的url地址
	
	private boolean modetator; //客服文档权限，true表示能编辑文档
	
	private boolean publicComments; //客服回复工单权限，false为只能私密回复
	
	private String ticketRestriction;//客服受理工单权限，all表示可以受理所有工单，groups表示只能受理客服组的工单，assigned表示只能受理分配的工单
	
	private boolean managePeople; //客服管理用户权限，true表示可以管理用户
	
	private int customRoleId; //客服所属的自定义角色id，高级服务模式才有此功能。若值不为空，那么上面的客服权限字段不再起作用，权限按照custom_role里的设置生效
	
	private List<UserFiled> userFileds = new ArrayList<UserFiled>();//用户自定义字段

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
