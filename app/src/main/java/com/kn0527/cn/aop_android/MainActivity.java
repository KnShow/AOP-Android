package com.kn0527.cn.aop_android;

import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void mShake(View view) {
        SystemClock.sleep(new Random().nextInt(2000));
        long begin = System.currentTimeMillis();
        SystemClock.sleep(new Random().nextInt(2000));
        long duration = System.currentTimeMillis() - begin;
        System.out.println("摇一摇功能花费了 "+duration+"毫秒");
    }

    public void mAudio(View view) {

    }

    public void mVideo(View view) {

    }

    public void saySomething(View view) {

    }

}
