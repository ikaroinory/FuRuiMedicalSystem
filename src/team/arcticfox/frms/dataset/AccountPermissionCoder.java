package team.arcticfox.frms.dataset;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.ObjectSerializer;

import java.io.IOException;
import java.lang.reflect.Type;

public class AccountPermissionCoder implements ObjectSerializer, ObjectDeserializer {
    @Override
    public void write(JSONSerializer jsonSerializer, Object o, Object o1, Type type, int i) throws IOException {
        jsonSerializer.write(String.valueOf(o));
    }

    @Override
    public AccountPermission deserialze(DefaultJSONParser defaultJSONParser, Type type, Object o) {
        return AccountPermission.parse(String.valueOf(defaultJSONParser.parse()));
    }

    @Override
    public int getFastMatchToken() {
        return 0;
    }
}
