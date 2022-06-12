package team.arcticfox.frms.data;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.ObjectSerializer;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class ShoppingItemSerializer implements ObjectSerializer, ObjectDeserializer {
    @Override
    public void write(JSONSerializer jsonSerializer, Object o, Object o1, Type type, int i) throws IOException {
        List<ShoppingItem> list = new ArrayList<>();
        for (Map.Entry<Integer, ShoppingItem> item : ((Map<Integer, ShoppingItem>) o).entrySet())
            list.add(item.getValue());
        jsonSerializer.write(list);
    }

    @Override
    public Map<Integer, ShoppingItem> deserialze(DefaultJSONParser defaultJSONParser, Type type, Object o) {
        List<JSONObject> list = (List<JSONObject>) defaultJSONParser.parse();
        Map<Integer, ShoppingItem> map = new HashMap<>();
        for (JSONObject jsonObject : list) {
            ShoppingItem item = JSON.parseObject(jsonObject.toJSONString(), ShoppingItem.class);
            map.put(item.id, item);
        }
        return map;
    }

    @Override
    public int getFastMatchToken() {
        return 0;
    }
}
