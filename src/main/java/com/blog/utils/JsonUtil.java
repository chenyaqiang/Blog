package com.blog.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

/**
 * @description:
 * @author: wb
 * @data: 2017/8/9 8:55
 * @see:
 * @since:
 */
public class JsonUtil {

    // 定义jackson对象
    private static final ObjectMapper MAPPER = new ObjectMapper();

    public static String objectToJson(Object data){
        try {
            String string = MAPPER.writeValueAsString(data);
            return string;
        }catch (JsonProcessingException e){
            e.printStackTrace();
        }
        return null;
    }

    public static <T> T jsonToObject(String json,Class<T> clazz){
        try {
            T t =  MAPPER.readValue(json,clazz);
            return t;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 将json数据转换成pojo对象list
     * @param jsonData
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T>List<T> jsonToList(String jsonData, Class<T> clazz){
        JavaType javaType = MAPPER.getTypeFactory().constructParametricType(List.class,clazz);
        try {
            List<T> list = MAPPER.readValue(jsonData,javaType);
            return list;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
