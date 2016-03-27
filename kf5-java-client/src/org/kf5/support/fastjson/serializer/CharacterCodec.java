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

import org.kf5.support.fastjson.parser.DefaultJSONParser;
import org.kf5.support.fastjson.parser.JSONToken;
import org.kf5.support.fastjson.parser.deserializer.ObjectDeserializer;
import org.kf5.support.fastjson.util.TypeUtils;

/**
 * @author wenshao[szujobs@hotmail.com]
 */
public class CharacterCodec implements ObjectSerializer, ObjectDeserializer {

    public final static CharacterCodec instance = new CharacterCodec();

    public void write(JSONSerializer serializer, Object object, Object fieldName, Type fieldType, int features) throws IOException {
        SerializeWriter out = serializer.getWriter();

        Character value = (Character) object;
        if (value == null) {
            out.writeString("");
            return;
        }

        char c = value.charValue();
        if (c == 0) {
            out.writeString("\u0000");
        } else {
            out.writeString(value.toString());
        }
    }

    @SuppressWarnings("unchecked")
    public <T> T deserialze(DefaultJSONParser parser, Type clazz, Object fieldName) {
        Object value = parser.parse();

        if (value == null) {
            return null;
        }
        
        return (T) TypeUtils.castToChar(value);
    }

    public int getFastMatchToken() {
        return JSONToken.LITERAL_STRING;
    }
}
