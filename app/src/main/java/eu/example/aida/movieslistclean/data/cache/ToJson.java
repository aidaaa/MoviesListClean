package eu.example.aida.movieslistclean.data.cache;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

/**
 * Created by Aida on 1/1/2019.
 */

public class ToJson {

    private Gson gson;

    public ToJson() {
        this.gson = new Gson();
    }

    public String serialzation(Object o,Class aClass){
        return gson.toJson(o,aClass);
    }

   public  <T> T deSerialzation(String o,Class<T> aClass){
        return gson.fromJson(o,aClass);
    }

    public  <T> T deSerial_t(String s,Class<T> aClass){
        Type type=new TypeToken<T>(){}.getType();
        return gson.fromJson(s,type);
    }

}
