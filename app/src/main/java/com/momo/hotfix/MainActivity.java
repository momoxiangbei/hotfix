package com.momo.hotfix;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.momo.fix.Main;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Main.init(this,5);
    }
}
