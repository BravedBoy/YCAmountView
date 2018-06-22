package com.ycbjie.ycamountview;

import android.annotation.SuppressLint;
import android.nfc.Tag;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yc on 2018/6/20.
 */

public class FirstActivity extends AppCompatActivity {

    private static final String TAG = "FirstActivity------------";
    private Gson gson;
    private Gson gson1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        //通过构造函数来获取
        gson = new Gson();
        //通过 GsonBuilder 来获取，可以进行多项特殊配置
        gson1 = new GsonBuilder().create();

        toJson();
        toJson1();
        jsonToArray();
        arrayToJson();
        jsonToList();
        listToJson();
        personModelToJson();
        jsonToPersonModel();
        listModelToJson();
        jsonToListMode();
        test1();
        test2();
        jsonAndString();
        toJsonSerializer();
        toJsonDeserializer();
    }


    @SuppressLint("LongLogTag")
    private void toJson() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("String", "leavesC");
        jsonObject.addProperty("Number_Integer", 23);
        jsonObject.addProperty("Number_Double", 22.9);
        jsonObject.addProperty("Boolean", true);
        jsonObject.addProperty("Char", 'c');
        //Log.e(TAG,jsonObject.getAsString());      //这个会崩溃
        Log.e(TAG,jsonObject.toString());
        Log.e(TAG,jsonObject+"");
        //{"String":"leavesC","Number_Integer":23,"Number_Double":22.9,"Boolean":true,"Char":"c"}
        //{"String":"leavesC","Number_Integer":23,"Number_Double":22.9,"Boolean":true,"Char":"c"}
    }

    @SuppressLint("LongLogTag")
    private void toJson1() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("String", "leavesC");
        jsonObject.addProperty("Number", 23);
        jsonObject.addProperty("Number", 22.9);
        jsonObject.addProperty("Boolean", true);
        jsonObject.addProperty("Char", 'c');

        JsonObject jsonElement = new JsonObject();
        jsonElement.addProperty("Boolean", false);
        jsonElement.addProperty("Double", 25.9);
        jsonElement.addProperty("Char", 'c');
        jsonObject.add("JsonElement", jsonElement);
        Log.e(TAG,jsonObject.toString());

        //{"String":"leavesC","Number":22.9,"Boolean":true,"Char":"c","JsonElement":{"Boolean":false,"Double":25.9,"Char":"c"}}
    }


    @SuppressLint("LongLogTag")
    private void jsonToArray() {
        //Json数组 转为 字符串数组
        String[] arr = {"2222","3333","4444","5555"};
        //這種崩潰
        //String jsonArray = "{\"2222\",\"3333\",\"4444\",\"5555\"}";
        //這種正常
        String jsonArray = "[\"2222\",\"3333\",\"4444\",\"5555\"]";
        String[] strings = gson.fromJson(jsonArray, String[].class);
        System.out.println("Json数组 转为 字符串数组: ");
        for (String string : strings) {
            Log.e(TAG,string);
        }
    }

    @SuppressLint("LongLogTag")
    private void arrayToJson() {
        String jsonArray = "[\"2222\",\"3333\",\"4444\",\"5555\"]";
        //字符串数组 转为 Json数组
        jsonArray = gson.toJson(jsonArray, new TypeToken<String>() {}.getType());
        Log.e(TAG,jsonArray);

        //打印日誌
        //"[\"2222\",\"3333\",\"4444\",\"5555\"]"
    }


    @SuppressLint("LongLogTag")
    private void jsonToList() {
        //Json数组 转为 List
        String jsonArray = "[\"2222\",\"3333\",\"4444\",\"5555\"]";
        List<String> stringList = gson.fromJson(jsonArray, new TypeToken<List<String>>() {}.getType());
        for (String string : stringList) {
            Log.e(TAG,string);
        }
    }


    @SuppressLint("LongLogTag")
    private void listToJson() {
        String jsonArray = "[\"2222\",\"3333\",\"4444\",\"5555\"]";
        List<String> stringList = gson.fromJson(jsonArray, new TypeToken<List<String>>() {}.getType());
        //List 转为 Json数组
        jsonArray = gson.toJson(stringList, new TypeToken<List<String>>() {}.getType());
        Log.e(TAG,jsonArray);
        //打印日誌
        //["2222","3333","4444","5555"]
    }

    @SuppressLint("LongLogTag")
    private void personModelToJson() {
        //序列化
        Person person = new Person("yangChong", 25, true);
        Gson gson = new Gson();
        String s = gson.toJson(person);
        Log.e(TAG,s);
        //打印日志
        //{"age":25,"name":"yangChong","sex":true}
    }

    @SuppressLint("LongLogTag")
    private void jsonToPersonModel() {
        //反序列化
        String userJson = "{\"age\":25,\"name\":\"yangChong\",\"sex\":true}";
        Gson gson = new Gson();
        Person person = gson.fromJson(userJson, Person.class);
        Log.e(TAG,person.toString());
        //打印日志
        //Person{name='yangChong', age=25, sex=true}
    }


    @SuppressLint("LongLogTag")
    private void listModelToJson() {
        Person model1 = new Person("yangChong", 25, true);
        Person model2 = new Person("doubi", 26, false);
        final ArrayList<Person> lists = new ArrayList<>();
        lists.add(model1);
        lists.add(model2);
        Gson gson = new Gson();
        String s = gson.toJson(lists);
        Log.e(TAG,s);
        //打印日志
        //[{"age":25,"name":"yangChong","sex":true},{"age":26,"name":"doubi","sex":false}]
    }


    @SuppressLint("LongLogTag")
    private void jsonToListMode() {
        String json = "[{\"age\":25,\"name\":\"yangChong\",\"sex\":true},{\"age\":26,\"name\":\"doubi\",\"sex\":false}]";
        Gson gson = new Gson();
        List<Person> list = gson.fromJson(json, new TypeToken<List<Person>>() {}.getType());
        for (Person person : list) {
            Log.e(TAG,person.toString());
        }
        //打印日志
        //Person{name='yangChong', age=25, sex=true}
        //Person{name='doubi', age=26, sex=false}
    }


    //TODO
    @SuppressLint("LongLogTag")
    private void test1() {
        //反序列化
        String userJson = "{\"age\":25,\"userName\":\"yangChong\",\"sex\":true}";
        Gson gson = new Gson();
        Person person = gson.fromJson(userJson, Person.class);
        Log.e(TAG,person.toString());
        //打印日志
        //
    }


    @SuppressLint("LongLogTag")
    private void test2() {
        //反序列化
        Gson gson = new Gson();
        String userJson = "{\"userName\":\"leavesC\",\"age\":24,\"sex\":true}";
        User user = gson.fromJson(userJson, User.class);
        Log.e(TAG,user.toString());

        userJson = "{\"user_name\":\"leavesC\",\"age\":24,\"sex\":true}";
        user = gson.fromJson(userJson, User.class);
        System.out.println();
        Log.e(TAG,user.toString());

        userJson = "{\"Name\":\"leavesC\",\"age\":24,\"sex\":true}";
        user = gson.fromJson(userJson, User.class);
        Log.e(TAG,user.toString());
    }

    /**
     * 序列化和反序列化
     */
    @SuppressLint("LongLogTag")
    private void jsonAndString() {
        Gson gson = new GsonBuilder().registerTypeAdapter(User.class, new UserTypeAdapter()).create();
        User user = new User("leavesC", 24, true);
        String s = gson.toJson(user);
        Log.e(TAG,s);

        String json = "{\"Name\":\"leavesC\",\"age\":24,\"sex\":true}";
        user = gson.fromJson(json, User.class);
        System.out.println();
        System.out.println(user);
    }

    /**
     * 序列化过程
     */
    @SuppressLint("LongLogTag")
    private void toJsonSerializer() {
        Gson gson = new GsonBuilder().registerTypeAdapter(User.class, new JsonSerializer<User>() {
            @Override
            public JsonElement serialize(User user, Type type, JsonSerializationContext jsonSerializationContext) {
                JsonObject jsonObject = new JsonObject();
                jsonObject.addProperty("NameHi", user.getName());
                jsonObject.addProperty("Sex", user.isSex());
                jsonObject.addProperty("Age", user.getAge());
                return jsonObject;
            }
        }).create();
        User user = new User("leavesC", 24, true);
        String s = gson.toJson(user);
        Log.e(TAG,s);
    }

    /**
     * 反序列化过程
     */
    private void toJsonDeserializer() {
        Gson gson = new GsonBuilder().registerTypeAdapter(User.class, new JsonDeserializer<User>() {
            @Override
            public User deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
                JsonObject jsonObject = jsonElement.getAsJsonObject();
                String name = null;
                //同时支持 userName 和 name 两种情况
                if (jsonObject.has("userName")) {
                    name = jsonObject.get("userName").getAsString();
                } else if (jsonObject.has("name")) {
                    name = jsonObject.get("name").getAsString();
                }
                int age = jsonObject.get("age").getAsInt();
                boolean sex = jsonObject.get("sex").getAsBoolean();
                return new User(name, age, sex);
            }
        }).create();
        String json = "{\"userName\":\"leavesC\",\"sex\":true,\"age\":24}";
        User user = gson.fromJson(json, User.class);
        System.out.println();
        System.out.println(user);

        json = "{\"name\":\"leavesC\",\"sex\":true,\"age\":24}";
        user = gson.fromJson(json, User.class);
        System.out.println();
        System.out.println(user);
    }



}
