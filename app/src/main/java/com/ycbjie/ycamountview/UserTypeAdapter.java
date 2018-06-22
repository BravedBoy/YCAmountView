package com.ycbjie.ycamountview;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;


public class UserTypeAdapter extends TypeAdapter<User> {


    /**
     * 序列化
     */
    @Override
    public void write(JsonWriter jsonWriter, User user) throws IOException {
        //流式序列化成对象开始
        jsonWriter.beginObject();
        //将Json的Key值都指定为大写字母开头
        jsonWriter.name("Name").value(user.getName());
        jsonWriter.name("Age").value(user.getAge());
        jsonWriter.name("Sex").value(user.isSex());
        //流式序列化结束
        jsonWriter.endObject();
    }

    /**
     * 反序列化
     */
    @Override
    public User read(JsonReader jsonReader) throws IOException {
        User user = new User();
        //流式反序列化开始
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            switch (jsonReader.nextName()) {
                //首字母大小写均合法
                case "userName":
                case "name":
                case "Name":
                    user.setName(jsonReader.nextString());
                    break;
                case "age":
                    user.setAge(jsonReader.nextInt());
                    break;
                case "sex":
                    user.setSex(jsonReader.nextBoolean());
                    break;
            }

        }
        //流式反序列化结束
        jsonReader.endObject();
        return user;
    }


}
