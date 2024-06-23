package com.example.wyymusic;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;

import androidx.annotation.RequiresApi;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

    }

    /**
     * 修改状态栏颜色，支持4.4以上版本
     * @param activity
     * @param colorId
     */
    @RequiresApi(api = Build.VERSION_CODES.M)
    public static void setStatusBarColor(Activity activity, int colorId){

            //这一行获取了与当前Activity关联的窗口（Window）对象。
            Window window = activity.getWindow();

            //修改状态栏颜色
            window.setStatusBarColor(activity.getResources().getColor(colorId, Resources.getSystem().newTheme()));
    }

    /**
     * 设置状态栏为亮色模式(这会自动将字体变为黑色)
     * @param activity
     */
    public static void setStatusBckColor(Activity activity){

        //设置状态栏为亮色模式(这会自动将字体变为黑色)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {

            //这一行获取了与当前Activity关联的窗口（Window）对象。
            Window window = activity.getWindow();

            //这一行代码清除了窗口的FLAG_TRANSLUCENT_STATUS标志。这个标志通常用于使状态栏透明或半透明。清除这个标志意味着状态栏将不再是透明的，而是显示为完全不透明的状态。
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

            //这一行代码为窗口添加了FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS标志。
            // 这个标志允许应用程序自定义系统栏（如状态栏和导航栏）的背景。添加这个标志后，应用程序可以控制这些系统栏的背景颜色或图像。
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);

            //这一行代码设置了系统UI的可见性。View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR是一个特定的系统UI标志，
            // 用于指示状态栏应该使用浅色背景，这对于深色主题的应用程序来说特别有用，因为这样可以使状态栏的文本和其他元素更清晰地显示在深色背景上。
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }
    }


    /**
     * 设置状态栏为普通模式(这会自动将字体变为白色)
     * @param activity
     */
    public static void setNavigationBckColor(Activity activity){

        //设置状态栏为亮色模式(这会自动将字体变为黑色)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {

            //这一行获取了与当前Activity关联的窗口（Window）对象。
            Window window = activity.getWindow();

            //这一行代码清除了窗口的FLAG_TRANSLUCENT_STATUS标志。这个标志通常用于使状态栏透明或半透明。清除这个标志意味着状态栏将不再是透明的，而是显示为完全不透明的状态。
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

            //这一行代码为窗口添加了FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS标志。这个标志允许应用程序自定义系统栏（如状态栏和导航栏）的背景。添加这个标志后，应用程序可以控制这些系统栏的背景颜色或图像。
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);

            //这一行代码设置了系统UI的可见性。View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR是一个特定的系统UI标志，用于指示状态栏应该使用浅色背景，这对于深色主题的应用程序来说特别有用，因为这样可以使状态栏的文本和其他元素更清晰地显示在深色背景上。
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR);
        }
    }

    /**
     * 关闭输入法
     */
    public static void exitInput(Activity activity){

        //获取当前拥有焦点的视图
        View view = activity.getCurrentFocus();

        //获取到存在有焦点的视图再关闭输入法
        if (view != null){

            //获取InputMethodManager服务
            InputMethodManager imm = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);

            //隐藏软键盘
            imm.hideSoftInputFromWindow(view.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }


    /**
     * 设置渐变
     * @param from
     * @param end
     * @return
     */
    public static GradientDrawable showGradual(String from, String end){
        //设置渐变形状
        GradientDrawable gradientDrawable = new GradientDrawable(
                GradientDrawable.Orientation.BL_TR,
                new int[]{Color.parseColor(from), Color.parseColor(end)}
        );

        //设置渐变背景的形状和圆角半径
        gradientDrawable.setShape(GradientDrawable.RECTANGLE);
        gradientDrawable.setCornerRadius(10);

        //将渐变背景设置为视图的背景
        return gradientDrawable;

    }

    /**
     * 设置渐变1
     * @param from
     * @param end
     * @return
     */
    public static GradientDrawable showGradual1(String from, String body, String end){
        //设置渐变形状
        GradientDrawable gradientDrawable = new GradientDrawable(
                GradientDrawable.Orientation.BL_TR,
                new int[]{Color.parseColor(from), Color.parseColor(body), Color.parseColor(end)}
        );

        //设置渐变背景的形状和圆角半径
        gradientDrawable.setShape(GradientDrawable.RECTANGLE);
        gradientDrawable.setCornerRadius(10);

        //将渐变背景设置为视图的背景
        return gradientDrawable;

    }

}

















