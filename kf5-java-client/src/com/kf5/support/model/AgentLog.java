package com.kf5.support.model;

/**
 * 
 * @author chosen
 *
 * @version 创建时间：2017年8月22日 上午11:13:00
 */
public class AgentLog {

	private long log_id;
	private String operate;
	private int user_id;
	private int max_serve;
	private long created;
	private String user_name;

	public long getLog_id() {
		return log_id;
	}

	public void setLog_id(long log_id) {
		this.log_id = log_id;
	}

	public String getOperate() {
		return operate;
	}

	public void setOperate(String operate) {
		this.operate = operate;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getMax_serve() {
		return max_serve;
	}

	public void setMax_serve(int max_serve) {
		this.max_serve = max_serve;
	}

	public long getCreated() {
		return created;
	}

	public void setCreated(long created) {
		this.created = created;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getPlatform() {
		return platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}

	private String platform;

}
