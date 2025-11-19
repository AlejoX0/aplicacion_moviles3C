package com.example.aplicacion_moviles3c;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class RedesSocialesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_redes_sociales);

        findViewById(R.id.buttonInstagram).setOnClickListener(v -> openUrl("https://www.instagram.com/techtarget"));
        findViewById(R.id.buttonLinkedin).setOnClickListener(v -> openUrl("https://www.linkedin.com/company/techstars"));
        findViewById(R.id.buttonYoutube).setOnClickListener(v -> openUrl("https://www.youtube.com/@LinusTechTips"));

        NavigationHelper.setupMenuButton(this);
    }

    private void openUrl(String url) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(intent);
    }
}
