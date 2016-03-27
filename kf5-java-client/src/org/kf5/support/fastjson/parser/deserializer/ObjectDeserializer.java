package org.kf5.support.fastjson.parser.deserializer;

import java.lang.reflect.Type;

import org.kf5.support.fastjson.parser.DefaultJSONParser;

public interface ObjectDeserializer {
    <T> T deserialze(DefaultJSONParser parser, Type type, Object fieldName);
    
    int getFastMatchToken();
}
