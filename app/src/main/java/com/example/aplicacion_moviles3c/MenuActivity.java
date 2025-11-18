package com.example.aplicacion_moviles3c;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Button agendarButton = findViewById(R.id.buttonAgendar);
        Button catalogoButton = findViewById(R.id.buttonCatalogo);
        Button cotizacionButton = findViewById(R.id.buttonCotizacion);
        Button quienesSomosButton = findViewById(R.id.buttonQuienesSomos);

        agendarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, AgendarServicioActivity.class);
                startActivity(intent);
            }
        });

        catalogoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, CatalogoActivity.class);
                startActivity(intent);
            }
        });

        cotizacionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, CotizacionActivity.class);
                startActivity(intent);
            }
        });

        quienesSomosButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, QuienesSomosActivity.class);
                startActivity(intent);
            }
        });
    }
}
