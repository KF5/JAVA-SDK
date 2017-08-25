package com.kf5.support.controller;

import java.io.File;

import org.kf5.support.fastjson.JSONObject;

import com.kf5.support.internet.KF5Interface;
import com.kf5.support.model.IMAgentInfo;
import com.kf5.support.model.KF5Entity;
import com.kf5.support.model.MessageStatus;
import com.kf5.support.model.builder.KF5EntityBuilder;

public class KF5CustomIMSupport extends BaseCustomIMSupport {

	private static final String URL = KF5Interface.getIMAgentList();

	private static final String ATTACHMENT = KF5Interface.uploadCustomIMAttachment();

	public KF5CustomIMSupport(String domian, String appid, String appkey, String method) {
		super(domian, appid, appkey, method);
	}

	/**
	 * 拉取客服和客服组信息
	 * 更多请访问：http://developer.kf5.com/restfulapi/kchat/custom_im/#customim-pull
	 */
	public KF5Entity<IMAgentInfo> getIMAgentInfo() {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("action", "get_agent_states");
		return buildIMAgentInfo(sendPostRequest(URL, jsonObject.toJSONString()));
	}

	/**
	 * 用户创建对话
	 * 
	 * @param jsonString
	 *            详细内容
	 *            更多请访问：http://developer.kf5.com/restfulapi/kchat/custom_im/#
	 *            customim-create-chat
	 * @return
	 */
	public boolean createIMChat(String jsonString) {
		return post(jsonString);
	}

	/**
	 * 用户向客服发送文本消息
	 * 
	 * @param jsonString
	 *            更多请访问：http://developer.kf5.com/restfulapi/kchat/custom_im/#
	 *            customim-send-text-to-agent
	 * @return
	 */
	public boolean sendTextMessage(String jsonString) {
		return post(jsonString);
	}

	/**
	 * 上传附件
	 * 
	 * @param file
	 *            更多请访问:http://developer.kf5.com/restfulapi/kchat/custom_im/#
	 *            customim-upload-image
	 * @return
	 */
	public String uploadAttachment(File file) {
		return uploadAttachment(ATTACHMENT, file);
	}

	/**
	 * 用户向客服发送图片信息
	 * 
	 * @param jsonString
	 *            更多请访问:http://developer.kf5.com/restfulapi/kchat/custom_im/#
	 *            customim-send-image-to-agent
	 * @return
	 */
	public boolean sendImageMessage(String jsonString) {
		return post(jsonString);
	}

	/**
	 * 更新用户信息
	 * 
	 * @param jsonString
	 *            更多请访问:http://developer.kf5.com/restfulapi/kchat/custom_im/#
	 *            customim-update-userinfo
	 * @return
	 */
	public boolean updateUserInfo(String jsonString) {
		return post(jsonString);
	}

	/**
	 * 用户主动结束对话
	 * 
	 * @param jsonString
	 *            更多请访问:http://developer.kf5.com/restfulapi/kchat/custom_im/#
	 *            customim-close-chat
	 * @return
	 */
	public boolean closeChat(String jsonString) {
		return post(jsonString);
	}

	private boolean post(String jsonString) {
		MessageStatus messageStatus = sendPostRequest(URL, jsonString);
		if (getResultCode(messageStatus) == RESULT_OK) {
			return KF5EntityBuilder.safeBoolean(getResultObj(messageStatus), "success");
		}
		return false;
	}
}
