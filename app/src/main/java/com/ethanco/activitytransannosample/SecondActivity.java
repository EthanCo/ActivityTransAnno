package com.ethanco.activitytransannosample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.ethanco.anno.ActivityTransition;
import com.ethanco.anno.TransInjector;
import com.ethanco.anno.Transition;

/**
 * @Description TODO
 * Created by YOLANDA on 2016-01-21.
 */
@ActivityTransition(Transition.Explode)
public class SecondActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        TransInjector.inject(this);
        setContentView(R.layout.activity_second);
    }
}
