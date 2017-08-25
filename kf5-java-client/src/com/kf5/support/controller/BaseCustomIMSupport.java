package com.kf5.support.controller;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.security.GeneralSecurityException;
import java.util.UUID;

import com.kf5.support.internet.HttpRequest;
import com.kf5.support.model.IMAgentInfo;
import com.kf5.support.model.KF5Entity;
import com.kf5.support.model.KF5Fields;
import com.kf5.support.model.MessageStatus;
import com.kf5.support.model.builder.EntityBuilder;
import com.kf5.support.model.builder.KF5EntityBuilder;
import com.kf5.support.util.AuthorizationUtil;
import com.kf5.support.util.Utils;

class BaseCustomIMSupport extends DataSupport {

	private static final long TIMESTAMP = System.currentTimeMillis() / 1000;

	private static final String NONCE = UUID.randomUUID().toString();

	private static final String OAUTH_SIGNATURE_METHOD = "HMAC-SHA1";

	private static final float OAUTH_VERSION = 1.0f;

	private String appid;
	private String appkey;
	private String method;
	private String domain;

	BaseCustomIMSupport(String domian, String appid, String appkey, String method) {
		this.appid = (String) Utils.checkNotNull(appid, "appid can't be null");
		this.appkey = (String) Utils.checkNotNull(appkey, "appkey cant't be null");
		this.method = (String) Utils.checkNotNull(method, "method cant't be null");
		this.domain = (String) Utils.checkNotNull(domian, "domain can't be null");
	}

	protected MessageStatus sendPostRequest(String url, String param) {
		return HttpRequest.sendCustomIMPostRequest(url, getSecretKey(url), domain, param);
	}
	
	protected String uploadAttachment(String url ,File file){
		try {
			return HttpRequest.uploadCustomIMAttachment(url, file, getSecretKey(url), domain);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}
	

	protected KF5Entity<IMAgentInfo> buildIMAgentInfo(MessageStatus messageStatus) {
		IMAgentInfo imAgentInfo = null;
		if (getResultCode(messageStatus) == RESULT_OK) {
			imAgentInfo = EntityBuilder
					.buildIMAgentInfo(KF5EntityBuilder.safeObject(getResultObj(messageStatus), KF5Fields.DATA));
		}
		return dealData(new KF5Entity<IMAgentInfo>(), imAgentInfo, getResultObj(messageStatus),
				getResultCode(messageStatus));
	}

	private String getSecretKey(String url) {
		try {
			return AuthorizationUtil.generateAuthorizationHeader(appid, appkey, OAUTH_SIGNATURE_METHOD, TIMESTAMP,
					NONCE, OAUTH_VERSION, null, null, null, url, null, method);
		} catch (URISyntaxException | IOException | GeneralSecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}

}
