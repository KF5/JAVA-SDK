package org.kf5.support.fastjson.parser.deserializer;

import java.lang.reflect.Type;

import org.kf5.support.fastjson.JSONArray;
import org.kf5.support.fastjson.parser.DefaultJSONParser;
import org.kf5.support.fastjson.parser.JSONToken;

public class JSONArrayDeserializer implements ObjectDeserializer {
    public final static JSONArrayDeserializer instance = new JSONArrayDeserializer();

    @SuppressWarnings("unchecked")
    public <T> T deserialze(DefaultJSONParser parser, Type clazz, Object fieldName) {
        JSONArray array = new JSONArray();
        parser.parseArray(array);
        return (T) array;
    }

    public int getFastMatchToken() {
        return JSONToken.LBRACKET;
    }
}
