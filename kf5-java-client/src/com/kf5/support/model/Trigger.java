package com.kf5.support.model;

import java.util.List;

/**
 * 触发器实体
 * 
 * @author chosen
 *
 * @version 创建时间：2017年8月21日 下午5:47:51
 */
public class Trigger {

	private String created_at;// 触发器创建时间
	private int id;// 创建触发器时系统自动分配
	private int sort;
	private String title;// 触发器的标题
	private List<Action> actions;// 触发器触发后，执行的动作
	private String url;// 此触发器的url地址
	private boolean status;// 该触发器是否被启用，"true"or"false"
	private List<Condition> allConditions;// 触发器被触发的条件，AND逻辑，其中所包含的条件，必须全部满足
	private List<Condition> anyConditions;// 触发器被触发的条件，OR逻辑，其中所包含的条件，必须满足任一或多个

	public List<Condition> getAllConditions() {
		return allConditions;
	}

	public void setAllConditions(List<Condition> allConditions) {
		this.allConditions = allConditions;
	}

	public List<Condition> getAnyConditions() {
		return anyConditions;
	}

	public void setAnyConditions(List<Condition> anyConditions) {
		this.anyConditions = anyConditions;
	}

	public String getCreated_at() {
		return created_at;
	}

	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSort() {
		return sort;
	}

	public void setSort(int sort) {
		this.sort = sort;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<Action> getActions() {
		return actions;
	}

	public void setActions(List<Action> actions) {
		this.actions = actions;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

}
