package com.kf5.support.model;

import java.util.ArrayList;
import java.util.List;

public class Post {

	private int id; // 文档id，由系统自动分配
	
	private String url; //资源url
	
	private int forum_id; //该文档所属的文档分类
	
	private String title; //文档名称
	
	private String content; //文档内容
	
	private int author_id; //文档创建者
	
	private boolean disable_comments;// 是否关闭评论
	
	private boolean is_home; //是否放置首页
	
	private boolean is_highlight;//是否高亮
	
	private boolean is_top; //是否置顶
	
	private boolean is_draft;//是否为草稿
	
	private String created_at;//创建时间
	
	private String updated_at;//最后更新时间
	
	private List<Attachment> attachments = new ArrayList<Attachment>();//附件列表

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

	public int getForum_id() {
		return forum_id;
	}

	public void setForum_id(int forum_id) {
		this.forum_id = forum_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getAuthor_id() {
		return author_id;
	}

	public void setAuthor_id(int author_id) {
		this.author_id = author_id;
	}

	public boolean isDisable_comments() {
		return disable_comments;
	}

	public void setDisable_comments(boolean disable_comments) {
		this.disable_comments = disable_comments;
	}

	public boolean isIs_home() {
		return is_home;
	}

	public void setIs_home(boolean is_home) {
		this.is_home = is_home;
	}

	public boolean isIs_highlight() {
		return is_highlight;
	}

	public void setIs_highlight(boolean is_highlight) {
		this.is_highlight = is_highlight;
	}

	public boolean isIs_top() {
		return is_top;
	}

	public void setIs_top(boolean is_top) {
		this.is_top = is_top;
	}

	public boolean isIs_draft() {
		return is_draft;
	}

	public void setIs_draft(boolean is_draft) {
		this.is_draft = is_draft;
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

	public List<Attachment> getAttachments() {
		return attachments;
	}

	public void setAttachments(List<Attachment> attachments) {
		this.attachments = attachments;
	}
	
	
	
}
