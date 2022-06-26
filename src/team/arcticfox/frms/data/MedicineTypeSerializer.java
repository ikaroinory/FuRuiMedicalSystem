package team.arcticfox.frms.data;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.ObjectSerializer;

import java.io.IOException;
import java.lang.reflect.Type;

public final class MedicineTypeSerializer implements ObjectSerializer, ObjectDeserializer {
    @Override
    public void write(JSONSerializer jsonSerializer, Object o, Object o1, Type type, int i) throws IOException {
        jsonSerializer.write(((MedicineType) o).getLabel());
    }
    @Override
    public MedicineType deserialze(DefaultJSONParser defaultJSONParser, Type type, Object o) {
        return MedicineType.parse(((MedicineType) defaultJSONParser.parse()).getLabel());
    }
    @Override
    public int getFastMatchToken() {
        return 0;
    }
}
