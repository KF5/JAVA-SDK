package com.kf5.support.model.builder;

import org.kf5.support.fastjson.JSONArray;
import org.kf5.support.fastjson.JSONException;
import org.kf5.support.fastjson.JSONObject;

import com.kf5.support.model.ItemType;


public class KF5EntityBuilder {
	
	
	public static Object buildEntityByType(ItemType type,JSONObject object) throws JSONException{
		
		Object obj = null;
		switch (type) {
		case TICKET:
			obj = EntityBuilder.buildTicket(object);
			break;

		default:
			throw new IllegalArgumentException("Type '" + type+ "' is not supported yet");
		}
		return obj;
		
		
	}
	
	

	public static String safeGet(JSONObject object, String field)
			throws JSONException {
		
		if (object.containsKey(field)) {
			return object.getString(field);
		} else {
			return null;
		}
		
	}

	public static JSONObject safeObject(JSONObject object, String field)
			throws JSONException {

		if (object.containsKey(field)) {
			try {
				return object.getJSONObject(field);
			} catch (Exception e) {
				return null;
			}
		} else {
			return null;
		}
		
	}
	
	public static JSONObject getJsonObject(JSONObject object, String fledsString) throws JSONException{
		
		if (object.containsKey(fledsString)) {
			
			return object.getJSONObject(fledsString);
		}
		return null;
	}
	
	public static JSONObject safeObject(String result){
		
		try {
			return JSONObject.parseObject(result);
		} catch (JSONException e) {
			// TODO: handle exception
		}
		return null;
	}
	

	public static JSONArray safeArray(JSONObject object, String field)
			throws JSONException {
		if (object.containsKey(field)) {
			return object.getJSONArray(field);
		} else {
			return null;
		}
	}

	protected static Float safeFloat(JSONObject object, String field)
			throws JSONException {
		if (object.containsKey(field)) {
			try {
				return Float.parseFloat(object.getString(field));
			} catch (NumberFormatException e) {
				return Float.valueOf(0);
			}
		} else {
			return Float.valueOf(0);
		}
	}

	public static Integer safeInt(JSONObject object, String field)
			throws JSONException {
		if (object!=null&&object.containsKey(field)) {
			try {
				return Integer.parseInt(object.getString(field));
			} catch (NumberFormatException e) {
				return -100;
			}
		} else {
			return -100;
		}
	}

	protected static Long safeLong(JSONObject object, String field)
			throws JSONException {
		if (object.containsKey(field)) {
			try {
				return Long.parseLong(object.getString(field));
			} catch (NumberFormatException e) {
				return Long.valueOf(0);
			}
		} else {
			return Long.valueOf(0);
		}
	}

	protected static Boolean safeBoolean(JSONObject object, String field)
			throws JSONException {
		if (object.containsKey(field)) {
			return Boolean.parseBoolean(object.getString(field));
		} else {
			return Boolean.FALSE;
		}
	}
	
	
	
}
