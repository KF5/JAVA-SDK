package com.kf5.support.model;


/**
 * 请求返回值泛型管理类
 * 
 * @author chosen
 *
 * @version 创建时间：2016年9月27日  下午2:19:20
 */
public class KF5Entity<T> {

	private int resultCode;
	
	private String message;
	
	private T data;

	public int getResultCode() {
		return resultCode;
	}

	public void setResultCode(int resultCode) {
		this.resultCode = resultCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getData() {
		return data;
	}

	public void setData(T t) {
		this.data = t;
	}
	
	
		
	
}
