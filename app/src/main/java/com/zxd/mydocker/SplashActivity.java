package com.zxd.mydocker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.zxd.mydocker.view.circleView;

public class SplashActivity extends AppCompatActivity {


    private circleView circle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        circle = (circleView) findViewById(R.id.myview);

      //  new Thread(circle).start();
    }
}
