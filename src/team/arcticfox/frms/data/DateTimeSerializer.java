package team.arcticfox.frms.data;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.ObjectSerializer;

import java.io.IOException;
import java.lang.reflect.Type;

public final class DateTimeSerializer implements ObjectSerializer, ObjectDeserializer {
    @Override
    public void write(JSONSerializer jsonSerializer, Object o, Object o1, Type type, int i) throws IOException {
        jsonSerializer.write(o.toString());
    }

    @Override
    public DateTime deserialze(DefaultJSONParser defaultJSONParser, Type type, Object o) {
        return DateTime.parse(defaultJSONParser.parse().toString());
    }

    @Override
    public int getFastMatchToken() {
        return 0;
    }
}
