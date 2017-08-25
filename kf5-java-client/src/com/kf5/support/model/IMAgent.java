package com.kf5.support.model;

public class IMAgent {

	/**
	 * "max_serve": 8, "app_status": "offline", "name": "客服小叶", "photo":
	 * "https://fs.kf5.com/upload/59/201503/1427102374_568.jpg", "web_status":
	 * "offline", "id": 122, "display_name": "客服小叶"
	 */
	private int max_serve;
	private String app_status;
	private String name;
	private String photo;
	private String web_status;
	private int id;
	private String diplay_name;

	public int getMax_serve() {
		return max_serve;
	}

	public void setMax_serve(int max_serve) {
		this.max_serve = max_serve;
	}

	public String getApp_status() {
		return app_status;
	}

	public void setApp_status(String app_status) {
		this.app_status = app_status;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getWeb_status() {
		return web_status;
	}

	public void setWeb_status(String web_status) {
		this.web_status = web_status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDiplay_name() {
		return diplay_name;
	}

	public void setDiplay_name(String diplay_name) {
		this.diplay_name = diplay_name;
	}

}
