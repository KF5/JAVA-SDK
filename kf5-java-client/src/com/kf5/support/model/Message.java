package com.kf5.support.model;

public class Message {

	private int id;// 消息ID

	private int chat_id; // 所属对话ID

	private String type; // 消息状态

	private String name; // 访客姓名

	private String msg; // 消息内容

	public boolean isReply_timeout() {
		return reply_timeout;
	}

	public void setReply_timeout(boolean reply_timeout) {
		this.reply_timeout = reply_timeout;
	}

	private int user_id;// 消息提交者ID

	private int upload_id; // 文件ID
	
	private boolean reply_timeout;

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	private boolean is_read; // 是否已读

	private String create_at;// 消息发送时间

	private Upload upload;// 文件内容

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getChat_id() {
		return chat_id;
	}

	public void setChat_id(int chat_id) {
		this.chat_id = chat_id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public int getUpload_id() {
		return upload_id;
	}

	public void setUpload_id(int upload_id) {
		this.upload_id = upload_id;
	}

	public boolean isIs_read() {
		return is_read;
	}

	public void setIs_read(boolean is_read) {
		this.is_read = is_read;
	}

	public String getCreate_at() {
		return create_at;
	}

	public void setCreate_at(String create_at) {
		this.create_at = create_at;
	}

	public Upload getUpload() {
		return upload;
	}

	public void setUpload(Upload upload) {
		this.upload = upload;
	}

}
