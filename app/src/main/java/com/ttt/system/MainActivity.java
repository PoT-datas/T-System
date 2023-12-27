package com.ttt.system;

import androidx.appcompat.app.AppCompatActivity;
import api.ttt.system.TPerm;

import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String v = TPerm.getInfos();

        Toast.makeText(this, v, Toast.LENGTH_LONG).show();
    }
}