package org.kf5.support.fastjson;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import org.kf5.support.fastjson.serializer.JSONSerializable;
import org.kf5.support.fastjson.serializer.JSONSerializer;
import org.kf5.support.fastjson.serializer.SerializeWriter;

public class JSONPObject implements JSONSerializable {

    private String             function;

    private final List<Object> parameters = new ArrayList<Object>();
    
    public JSONPObject() {
        
    }
    
    public JSONPObject(String function) {
        this.function = function;
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    public List<Object> getParameters() {
        return parameters;
    }
    
    public void addParameter(Object parameter) {
        this.parameters.add(parameter);
    }

    public String toJSONString() {
        return null;
    }

    public void write(JSONSerializer serializer, Object fieldName, Type fieldType, int features) throws IOException {
        SerializeWriter writer = serializer.getWriter();
        writer.write(function);
        writer.write('(');
        for (int i = 0; i < parameters.size(); ++i) {
            if (i != 0) {
                writer.write(',');
            }
            serializer.write(parameters.get(i));
        }
        writer.write(')');
    }

    public String toString() {
        return JSON.toJSONString(this);
    }
}
