package com.example.wyymusic.home;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.wyymusic.App;
import com.example.wyymusic.MainActivity;
import com.example.wyymusic.R;
import com.example.wyymusic.bean.SearchWyyMusicBean;
import com.example.wyymusic.bean.WyyMusicBean;
import com.example.wyymusic.util.HttpUtil;
import com.google.gson.Gson;

import java.util.HashMap;

public class SearchDetialActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_detial);

        //TODO 这个设置的状态栏的颜色必须使用 color.xml 中定义的颜色,这里将他设置为白色
        App.setStatusBckColor(SearchDetialActivity.this);
        App.setStatusBarColor(this, R.color.white);

        EditText search_edit = findViewById(R.id.search_edit);

        //进入页面自动获取焦点
        search_edit.requestFocus();

        TextView search_btn = findViewById(R.id.search_btn);

        search_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(search_edit.getText())){
                    Toast.makeText(SearchDetialActivity.this, "您输入的歌曲名不能为空", Toast.LENGTH_SHORT).show();
                }else {

                    new Thread(new Runnable() {
                        @RequiresApi(api = Build.VERSION_CODES.N)
                        @Override
                        public void run() {
                            HttpUtil.getMap("http://music.cyrilstudio.top/search", new HashMap<String, Object>() {{
                                put("keywords", search_edit.getText().toString());
                            }}, new HttpUtil.onRequest() {
                                @Override
                                public void onRequest(String json) {
                                    WyyMusicBean.Result.Songs wyyMusicBean = new Gson().fromJson(json, WyyMusicBean.class).getResult().getSongs().get(0);

                                    Log.e("PDXWYY", wyyMusicBean.getId());

                                    /*--------*/

                                    HttpUtil.getMap("http://music.cyrilstudio.top/song/url", new HashMap<String, Object>() {{
                                        put("id", wyyMusicBean.getId());
                                    }}, new HttpUtil.onRequest() {
                                        @Override
                                        public void onRequest(String json) {

                                            SearchWyyMusicBean.DataDTO data = new Gson().fromJson(json, SearchWyyMusicBean.class).getData().get(0);

                                            Log.e("PDXWYYSEARCH", data.getUrl());

                                            runOnUiThread(new Runnable() {
                                                @Override
                                                public void run() {
                                                    if (data.getUrl().equals("null") || data.getUrl().equals("") || data.getUrl() == null){

                                                        Toast.makeText(SearchDetialActivity.this, "未找到歌曲源", Toast.LENGTH_SHORT).show();

                                                    }else {

                                                        MainActivity.musicName = search_edit.getText().toString();
                                                        MainActivity.playMusic(data.getUrl());
                                                        SearchDetialActivity.this.finish();

                                                    }
                                                }
                                            });
                                        }
                                    });
                                    /*--------*/
                                }
                            });
                        }
                    }).start();
                }
            }
        });
    }
}