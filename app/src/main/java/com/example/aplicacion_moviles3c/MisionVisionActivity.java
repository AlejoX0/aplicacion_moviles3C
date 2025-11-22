package com.example.aplicacion_moviles3c;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class MisionVisionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mision_vision);
        NavigationHelper.setupMenuButton(this);
    }
}
