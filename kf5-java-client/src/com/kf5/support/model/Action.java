package com.kf5.support.model;

public class Action {

	private String company_id;
	private String group_id;
	private String subject;// 主题。当执行通知邮件时，可以填写此选项
	private String source;// 动作来源，例如"工单状态""工单发起人"等
	private String body;// 内容。当执行通知邮件或者内部提醒时，可以填写此选项
	private String value;// 所设定的值，例如"受理中""已关闭"等
	private String deleted_at;
	private String overflowable;
	private String overflow_type;
	public String getCompany_id() {
		return company_id;
	}
	public void setCompany_id(String company_id) {
		this.company_id = company_id;
	}
	public String getGroup_id() {
		return group_id;
	}
	public void setGroup_id(String group_id) {
		this.group_id = group_id;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getDeleted_at() {
		return deleted_at;
	}
	public void setDeleted_at(String deleted_at) {
		this.deleted_at = deleted_at;
	}
	public String getOverflowable() {
		return overflowable;
	}
	public void setOverflowable(String overflowable) {
		this.overflowable = overflowable;
	}
	public String getOverflow_type() {
		return overflow_type;
	}
	public void setOverflow_type(String overflow_type) {
		this.overflow_type = overflow_type;
	}

}
