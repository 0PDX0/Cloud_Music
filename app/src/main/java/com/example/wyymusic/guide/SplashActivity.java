package com.example.wyymusic.guide;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.example.wyymusic.App;
import com.example.wyymusic.MainActivity;
import com.example.wyymusic.R;

public class SplashActivity extends AppCompatActivity {

    private ImageView img;
    private LinearLayout splah_ll;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        App.setStatusBarColor(this, R.color.red);

        img = findViewById(R.id.img);

        splah_ll = findViewById(R.id.splah_ll);

        Glide.with(this).load(R.mipmap.wyy).transform(new CenterCrop()).into(img);

        //也可以通过一个简单的多线程实现
//        try {
//            new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    try {
//                        Thread.sleep(2000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//
//                    startActivity(new Intent(SplashActivity.this, MainActivity.class));
//                }
//            }).start();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        //设置渐变效果
        setAlphaAnimation();
    }

    /**
     * 设置渐变效果
     */
    private void setAlphaAnimation(){

        //生成动画对象
        AlphaAnimation animation = new AlphaAnimation(0.8f, 1.0f);

        //设置持续时间
        animation.setDuration(500);

        splah_ll.setAnimation(animation);

        //给控件设置动画
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                startActivity(new Intent(SplashActivity.this, MainActivity.class));
                SplashActivity.this.finish();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

    }

}




















