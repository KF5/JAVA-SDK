package com.kf5.support.model.builder;

import com.kf5.support.model.ItemType;

import net.sf.json.JSONArray;
import net.sf.json.JSONException;
import net.sf.json.JSONObject;

public class KF5EntityBuilder {
	
	
	public static Object buildEntityByType(ItemType type,JSONObject object) throws JSONException{
		
		Object obj = null;
		JSONObject current = null;
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
		
		if (object.has(field)) {
			return object.getString(field);
		} else {
			return null;
		}
		
	}

	public static JSONObject safeObject(JSONObject object, String field)
			throws JSONException {

		if (object.has(field)) {
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
		
		if (object.has(fledsString)) {
			
			return object.getJSONObject(fledsString);
		}
		return null;
	}
	
	public static JSONObject safeObject(String result){
		
		try {
			return JSONObject.fromObject(result);
		} catch (JSONException e) {
			// TODO: handle exception
		}
		return null;
	}
	

	public static JSONArray safeArray(JSONObject object, String field)
			throws JSONException {
		if (object.has(field)) {
			return object.getJSONArray(field);
		} else {
			return null;
		}
	}

	protected static Float safeFloat(JSONObject object, String field)
			throws JSONException {
		if (object.has(field)) {
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
		if (object!=null&&object.has(field)) {
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
		if (object.has(field)) {
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
		if (object.has(field)) {
			return Boolean.parseBoolean(object.getString(field));
		} else {
			return Boolean.FALSE;
		}
	}
	
	
	
}
