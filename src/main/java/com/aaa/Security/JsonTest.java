package com.aaa.Security;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;

public class JsonTest {
    public static String prettyjson(String reqJson)
    {
        JSONObject object =JSONObject.parseObject(reqJson);
        String prettyJson = JSON.toJSONString(object,SerializerFeature.PrettyFormat,
                SerializerFeature.WriteMapNullValue,
                SerializerFeature.WriteDateUseDateFormat);
        return prettyJson;
    }
}
