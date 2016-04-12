/*
 * Copyright 1999-2101 Alibaba Group.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.kf5.support.fastjson.serializer;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.regex.Pattern;

import org.kf5.support.fastjson.parser.DefaultJSONParser;
import org.kf5.support.fastjson.parser.JSONToken;
import org.kf5.support.fastjson.parser.deserializer.ObjectDeserializer;

/**
 * @author wenshao[szujobs@hotmail.com]
 */
public class PatternCodec implements ObjectSerializer, ObjectDeserializer {

    public final static PatternCodec instance = new PatternCodec();

    public void write(JSONSerializer serializer, Object object, Object fieldName, Type fieldType, int features) throws IOException {
        if (object == null) {
            serializer.writeNull();
            return;
        }
        
        Pattern p = (Pattern) object;
        serializer.write(p.pattern());
    }

    @SuppressWarnings("unchecked")
    public <T> T deserialze(DefaultJSONParser parser, Type clazz, Object fieldName) {
        Object value = parser.parse();

        if (value == null) {
            return null;
        }
        
        String pattern = (String) value;
        
        return (T) Pattern.compile(pattern);
    }

    public int getFastMatchToken() {
        return JSONToken.LITERAL_STRING;
    }
}
