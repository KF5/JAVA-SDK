package com.kf5.support.controller;

import org.kf5.support.fastjson.JSONObject;

import com.kf5.support.model.KF5Entity;
import com.kf5.support.model.KF5Fields;
import com.kf5.support.model.KF5PaginationEntity;
import com.kf5.support.model.MessageStatus;
import com.kf5.support.model.StatusCode;
import com.kf5.support.model.builder.KF5EntityBuilder;

class DataSupport {

	protected static final int RESULT_OK = StatusCode.OK;

	protected static final int RESULT_ERROR = StatusCode.ERROR;

	protected <T> void setPagesAndCount(KF5PaginationEntity<T> kf5Entity, JSONObject jsonObject) {
		if (kf5Entity == null || jsonObject == null)
			return;
		kf5Entity.setCount(KF5EntityBuilder.safeInt(jsonObject, KF5Fields.COUNT));
		kf5Entity.setNextPage(KF5EntityBuilder.safeGet(jsonObject, KF5Fields.NEXT_PAGE));
		kf5Entity.setPreviousPage(KF5EntityBuilder.safeGet(jsonObject, KF5Fields.PREVIOUS_PAGE));
	}

	protected <T> KF5PaginationEntity<T> dealPaginationListData(KF5PaginationEntity<T> kf5Entity, T list,
			JSONObject jsonObject, int resultCode) {

		kf5Entity.setResultCode(resultCode);
		if (resultCode == RESULT_OK) {
			kf5Entity.setData(list);
			setPagesAndCount(kf5Entity, jsonObject);
		} else {
			kf5Entity.setMessage(jsonObject.toString());
		}
		return kf5Entity;
	}

	protected <T> KF5Entity<T> dealData(KF5Entity<T> kf5Entity, T t, JSONObject jsonObject, int resultCode) {

		kf5Entity.setResultCode(resultCode);
		if (resultCode == RESULT_OK) {
			kf5Entity.setData(t);
		} else {
			kf5Entity.setMessage(jsonObject.toString());
		}
		return kf5Entity;
	}

	protected int getResultCode(MessageStatus messageStatus) {
		return messageStatus.getStatus();
	}

	protected JSONObject getResultObj(MessageStatus messageStatus) {
		return messageStatus.getJsonObject();
	}

}
