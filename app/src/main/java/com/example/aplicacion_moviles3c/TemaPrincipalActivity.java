package com.example.aplicacion_moviles3c;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class TemaPrincipalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tema_principal);
        NavigationHelper.setupMenuButton(this);
    }
}
