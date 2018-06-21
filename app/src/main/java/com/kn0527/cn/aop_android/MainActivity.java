package com.kn0527.cn.aop_android;

import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.kn0527.cn.aop_android.annotation.BehaviorTrace;
import com.kn0527.cn.aop_android.annotation.UserInfoBehaviorTrace;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @BehaviorTrace("摇一摇性能监测")
    @UserInfoBehaviorTrace("摇一摇")
    public void mShake(View view) {
        SystemClock.sleep(new Random().nextInt(2000));
    }


    public void mAudio(View view) {

    }

    public void mVideo(View view) {

    }

    public void saySomething(View view) {

    }

}
