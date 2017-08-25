package com.kf5.support.util;

public class Utils {

	private Utils(){
		throw new UnsupportedOperationException( "u can't instantiate me...");
	}
	
	/**
	 * 校验参数是否为空
	 * @param object
	 * @param exceptionMsg
	 * @return
	 */
	public static Object checkNotNull(Object object , String exceptionMsg){
		if (object== null) {
			throw new NullPointerException(exceptionMsg);
		}
		return object;
	}
	
}
