package com.example.wyymusic.util;

import android.content.Context;
import android.os.Build;

import androidx.annotation.RequiresApi;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Map;

import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okio.BufferedSink;

public class HttpUtil {

    private static Context context;

    private static OkHttpClient client = new OkHttpClient();

    public static void init(Context context_init){
        context = context_init;
    }

    public interface onRequest{
        void onRequest(String json);
    }

    /**
     * 发送Get请求
     * @param url
     * @param map
     * @param onRequest
     */
    @RequiresApi(api = Build.VERSION_CODES.N)
    public static void getMap(String url, Map<String, Object> map, onRequest onRequest){

        //创建一个HttpUrl.Builder 对象，并指定基本的 URL
        HttpUrl.Builder builder = HttpUrl.parse(url).newBuilder();

        //添加查询参数
        map.forEach((String key, Object value) ->{
            builder.addQueryParameter(key, String.valueOf(value));
//            builder.addEncodedQueryParameter()
        });

        //构建最终的 URL
        String zUrl = builder.build().toString();

        //构建请求对象
        Request request = new Request.Builder()
                .url(zUrl)
                .build();


        //发送请求
        try {

            Response response = client.newCall(request).execute();
            onRequest.onRequest(response.body().string());

        } catch (Exception e){
            e.printStackTrace();
        }

    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public static void getMap1(String url, Map<String, Object> map, onRequest onRequest){

        OkHttpClient client = new OkHttpClient();

        HttpUrl.Builder builder = HttpUrl.parse(url).newBuilder();

        map.forEach((k, v) -> {
            builder.addQueryParameter(k, String.valueOf(v));
        });

        String zUrl = builder.build().toString();

        Request request = new Request.Builder()
                .get()
                .url(zUrl)
                .build();

        try {
            Response response = client.newCall(request).execute();
            onRequest.onRequest(response.body().string());

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static void postMap(String url, Map<String, Object> map, onRequest onRequest){

        //创建一个HttpUrl.builder 对象，并指定基本的URL
        HttpUrl.Builder builder = HttpUrl.parse(url).newBuilder();

        MediaType mediaType = MediaType.Companion.parse("application/json;charset=utf-8");

        RequestBody body = RequestBody.Companion.create(new JSONObject(map).toString(), mediaType);

        //构建请求对象
        Request request = new Request.Builder()
                .url(builder.build().toString())
                .post(body)
                .build();

        //发送请求
        try {

            Response response = client.newCall(request).execute();
            onRequest.onRequest(response.body().string());

        } catch (Exception e){
            e.printStackTrace();
        }

    }

}






























