package com.example.aplicacion_moviles3c;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class ContactanosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contactanos);

        findViewById(R.id.buttonEnviarCorreo).setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_SENDTO);
            intent.setData(Uri.parse("mailto:" + getString(R.string.contacto_email)));
            intent.putExtra(Intent.EXTRA_SUBJECT, "Solicitud desde la app Zenit");
            startActivity(Intent.createChooser(intent, "Enviar correo"));
        });

        findViewById(R.id.buttonLlamar).setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:" + getString(R.string.contacto_phone)));
            startActivity(intent);
        });

        findViewById(R.id.buttonAbrirMapa).setOnClickListener(v -> {
            Uri location = Uri.parse("geo:0,0?q=" + Uri.encode(getString(R.string.contacto_address)));
            Intent intent = new Intent(Intent.ACTION_VIEW, location);
            startActivity(intent);
        });

        NavigationHelper.setupMenuButton(this);
    }
}
