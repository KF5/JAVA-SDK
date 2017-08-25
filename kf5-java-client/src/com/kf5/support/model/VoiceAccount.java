package com.kf5.support.model;

public class VoiceAccount {

	/**
	 * "voip_account": "84942900000004", "user_id": "122", "created":
	 * "2015-02-14 18:13:07", "status_updated": "2017-06-30 06:07:41", "id":
	 * "10", "voip_pwd": "egsj5i3e", "type": "phone", "status": "0"
	 */

	private String voip_account;// voip 账号
	private String user_id;// 系统用户ID
	private String created;// 创建时间
	private String status_updated;// 状态更新时间
	private String id;// 资源ID
	private String voip_pwd;// voip 密码
	private String type;// ‘client’：非落地上班，‘phone’：落地上班
	private String status;// 坐席状态，0：离线 ，1：在线，2：忙碌，3：小休

	public String getVoip_account() {
		return voip_account;
	}

	public void setVoip_account(String voip_account) {
		this.voip_account = voip_account;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getCreated() {
		return created;
	}

	public void setCreated(String created) {
		this.created = created;
	}

	public String getStatus_updated() {
		return status_updated;
	}

	public void setStatus_updated(String status_updated) {
		this.status_updated = status_updated;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getVoip_pwd() {
		return voip_pwd;
	}

	public void setVoip_pwd(String voip_pwd) {
		this.voip_pwd = voip_pwd;
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

}
