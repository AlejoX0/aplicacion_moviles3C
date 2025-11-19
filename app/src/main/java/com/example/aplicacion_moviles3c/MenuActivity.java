package com.example.aplicacion_moviles3c;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        TextView greetingTextView = findViewById(R.id.textViewGreeting);
        String userName = getIntent().getStringExtra(UserRepository.EXTRA_USER_NAME);
        if (!TextUtils.isEmpty(userName)) {
            greetingTextView.setText(getString(R.string.menu_bienvenida, userName));
        }

        configureButton(R.id.buttonPresentacion, PresentacionActivity.class);
        configureButton(R.id.buttonTemaPrincipal, TemaPrincipalActivity.class);
        configureButton(R.id.buttonCatalogo, CatalogoActivity.class);
        configureButton(R.id.buttonAgendar, AgendarServicioActivity.class);
        configureButton(R.id.buttonCotizacion, CotizacionActivity.class);
        configureButton(R.id.buttonQuienesSomos, QuienesSomosActivity.class);
        configureButton(R.id.buttonMisionVision, MisionVisionActivity.class);
        configureButton(R.id.buttonGaleria, GaleriaActivity.class);
        configureButton(R.id.buttonVideo, VideoPromocionalActivity.class);
        configureButton(R.id.buttonContactanos, ContactanosActivity.class);
        configureButton(R.id.buttonRedes, RedesSocialesActivity.class);
    }

    private void configureButton(int id, Class<?> destination) {
        Button button = findViewById(id);
        button.setOnClickListener(v -> startActivity(new Intent(MenuActivity.this, destination)));
    }
}
