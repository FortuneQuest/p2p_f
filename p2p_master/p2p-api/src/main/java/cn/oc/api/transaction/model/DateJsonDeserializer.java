package cn.oc.api.transaction.model;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 *
 * @ClassName : DateJsonDeserialializer
 * @Author: oc
 * @Date: 2023/03/19/0:42
 * @Description:  时间反序列化
 **/

public class DateJsonDeserializer extends JsonDeserializer<Date> {
    @Override
    public Date deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            return  simpleDateFormat.parse(jsonParser.getValueAsString());
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
