package com.kf5.support.model;

import java.util.ArrayList;
import java.util.List;

public class TicketField {

	
	private int id; //�����ֶ�id����ϵͳ�Զ�����
	
	private String url; //��ǰ��Դurl
	
	private String name; //�����ֶε����ƣ���ʽΪ"field_{id}"
	
	private String type; //�ֶ�����
	
	private String agent_title; //�ֶζԿͷ�����ʾ����
	
	private boolean agent_required; //�ͷ��ڴ�����ʱ�Ƿ����
	
	private boolean enduser_visible; //��ͨ�û��ύ����ʱ�ܷ񿴵��ֶ�
	
	private String  enduser_title; //�ֶζ���ͨ�û�����ʾ����
	
	private boolean enduser_editable;  //��ͨ�û��Ƿ��ܱ༭���ֶ�
	
	private String enduser_description ; //����ͨ�û���ʾ���ֶ�˵��
	
	private boolean enduser_required; //�ͷ����ύ����ʱ�Ƿ����
	
	private boolean active; //�ֶ��Ƿ�����
	 
	private String regexp_for_validation; //����ƥ���ֶεı��ʽ
	
	private List<CustomFieldOption> customFieldOptions = new ArrayList<>(); //�����˵��ֶε�ѡ������

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getAgent_title() {
		return agent_title;
	}

	public void setAgent_title(String agent_title) {
		this.agent_title = agent_title;
	}

	public boolean isAgent_required() {
		return agent_required;
	}

	public void setAgent_required(boolean agent_required) {
		this.agent_required = agent_required;
	}

	public boolean isEnduser_visible() {
		return enduser_visible;
	}

	public void setEnduser_visible(boolean enduser_visible) {
		this.enduser_visible = enduser_visible;
	}

	public String getEnduser_title() {
		return enduser_title;
	}

	public void setEnduser_title(String enduser_title) {
		this.enduser_title = enduser_title;
	}

	public boolean isEnduser_editable() {
		return enduser_editable;
	}

	public void setEnduser_editable(boolean enduser_editable) {
		this.enduser_editable = enduser_editable;
	}

	public String getEnduser_description() {
		return enduser_description;
	}

	public void setEnduser_description(String enduser_description) {
		this.enduser_description = enduser_description;
	}

	public boolean isEnduser_required() {
		return enduser_required;
	}

	public void setEnduser_required(boolean enduser_required) {
		this.enduser_required = enduser_required;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getRegexp_for_validation() {
		return regexp_for_validation;
	}

	public void setRegexp_for_validation(String regexp_for_validation) {
		this.regexp_for_validation = regexp_for_validation;
	}

	public List<CustomFieldOption> getCustomFieldOptions() {
		return customFieldOptions;
	}

	public void setCustomFieldOptions(List<CustomFieldOption> customFieldOptions) {
		this.customFieldOptions = customFieldOptions;
	}
	
	
	
}
