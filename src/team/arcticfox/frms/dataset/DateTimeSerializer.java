package team.arcticfox.frms.dataset;

import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.ObjectSerializer;

import java.io.IOException;
import java.lang.reflect.Type;

/**
 * DateTime Serializer
 *
 * @author Guanyu Hu
 * @date 2022/6/8 16:23
 */
public class DateTimeSerializer implements ObjectSerializer {
    @Override
    public void write(JSONSerializer jsonSerializer, Object o, Object o1, Type type, int i) throws IOException {
        jsonSerializer.write(o.toString());
    }
}
