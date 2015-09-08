package com.kf5.support.model;

import java.util.ArrayList;
import java.util.List;

public class Comment {

	private int id; //回复id，由系统自动分配
	
	private String  content; //工单回复文本内容
	
	private String html_content; //工单回复html内容
	
	private boolean isPublic; //私密性，false则只有客服可见
	
	private String created_at; //回复的时间
	
	private int author_id; //回复的用户id
	
	private String author_name; // 回复的用户名称
	
	private List<Attachment> listAttachments = new ArrayList<Attachment>(); //附件

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getHtml_content() {
		return html_content;
	}

	public void setHtml_content(String html_content) {
		this.html_content = html_content;
	}

	public boolean isPublic() {
		return isPublic;
	}

	public void setPublic(boolean isPublic) {
		this.isPublic = isPublic;
	}

	public String getCreated_at() {
		return created_at;
	}

	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}

	public int getAuthor_id() {
		return author_id;
	}

	public void setAuthor_id(int author_id) {
		this.author_id = author_id;
	}

	public String getAuthor_name() {
		return author_name;
	}

	public void setAuthor_name(String author_name) {
		this.author_name = author_name;
	}

	public List<Attachment> getListAttachments() {
		return listAttachments;
	}

	public void setListAttachments(List<Attachment> listAttachments) {
		this.listAttachments = listAttachments;
	}
	
	
}
