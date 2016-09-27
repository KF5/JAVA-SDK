package com.kf5.support.controller;

import org.kf5.support.fastjson.JSONObject;

import com.kf5.support.internet.HttpRequest;
import com.kf5.support.model.KF5Fields;
import com.kf5.support.model.KF5PaginationEntity;
import com.kf5.support.model.MessageStatus;
import com.kf5.support.model.builder.KF5EntityBuilder;
import com.kf5.support.util.Base64Utils;

class BaseSupport {

	private String domain;

	private String username;

	private String password;

	private String token;

	protected String baseToken;

	/**
	 * 使用邮箱和密码进行验证
	 * 
	 * @param domain
	 *            平台地址
	 * @param username
	 *            登录邮箱
	 * @param password
	 *            密码
	 */
	public void initWithPassword(String domain, String username, String password) {
		this.domain = domain;
		this.username = username;
		this.password = password;
		String code = this.username + ":" + this.password;
		this.baseToken = Base64Utils.encode(code);
	}

	/**
	 * 使用邮箱和平台开放api的通信秘钥进行验证
	 * 
	 * @param domain
	 *            平台地址
	 * @param username
	 *            登录邮箱
	 * @param apiToken
	 *            通信秘钥，具体位置在：系统设置——>api接口——>通信秘钥
	 */
	public void initWithApiToken(String domain, String username, String apiToken) {

		this.domain = domain;
		this.username = username;
		this.token = apiToken;
		String code = this.username + "/token:" + this.token;
		this.baseToken = Base64Utils.encode(code);
	}

	protected void checkHasId(String... ids) {

		if (ids != null) {
			int size = ids.length;
			for (int i = 0; i < size; i++) {
				if (ids[i] == null) {
					throw new IllegalArgumentException("id can not be null");
				}
			}
		} else {
			throw new IllegalArgumentException("id can not be null");
		}

	}

	protected <T> void setPagesAndCount(KF5PaginationEntity<T> kf5Entity, JSONObject jsonObject) {
		if (kf5Entity == null || jsonObject == null)
			return;
		kf5Entity.setCount(KF5EntityBuilder.safeInt(jsonObject, KF5Fields.COUNT));
		kf5Entity.setNextPage(KF5EntityBuilder.safeInt(jsonObject, KF5Fields.NEXT_PAGE));
		kf5Entity.setPreviousPage(KF5EntityBuilder.safeInt(jsonObject, KF5Fields.PREVIOUS_PAGE));
	}

	/**
	 * Get请求
	 * 
	 * @param url
	 * @return
	 */
	protected MessageStatus sendGetRequest(String url) {
		checkBaseToken();
		return HttpRequest.sendGetRequest(url, baseToken);
	}

	/**
	 * POST请求
	 * 
	 * @param url
	 * @param params
	 * @return
	 */
	protected MessageStatus sendPostRequest(String url, String params) {
		checkBaseToken();
		return HttpRequest.sendPostRequest(url, baseToken, params);
	}

	/**
	 * PUT请求
	 * 
	 * @param url
	 * @param params
	 * @return
	 */
	protected MessageStatus sendPutRequest(String url, String params) {
		checkBaseToken();
		return HttpRequest.sendPutRequest(url, baseToken, params);
	}

	/**
	 * DELETE请求
	 * 
	 * @param url
	 * @return
	 */
	protected MessageStatus sendDeleteRequest(String url) {
		checkBaseToken();
		return HttpRequest.sendDeleteRequest(url, baseToken);
	}

	/**
	 * 返回二级域名
	 * 
	 * @return
	 */
	protected String getDomain() {
		return domain;
	}

	private void checkBaseToken() {
		if (baseToken == null) {
			throw new IllegalArgumentException(
					"you must call the function named initWithPassword or initWithApiToken to init baseToken");
		}
	}

}
