package com.kf5.support.model;

public class Condition {
	
	private String company_id;
	private String source;//条件来源，例如"工单状态""工单发起人"等
	private String value;//所设定的值，例如"受理中""已关闭"等
	private String delete_at;
	private String operator;//操作符，例如"小于""改变为"等
	public String getCompany_id() {
		return company_id;
	}
	public void setCompany_id(String company_id) {
		this.company_id = company_id;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getDelete_at() {
		return delete_at;
	}
	public void setDelete_at(String delete_at) {
		this.delete_at = delete_at;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}

	
}
