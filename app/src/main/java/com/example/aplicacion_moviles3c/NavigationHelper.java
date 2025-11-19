package com.example.aplicacion_moviles3c;

import android.content.Intent;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public final class NavigationHelper {

    private NavigationHelper() {
    }

    public static void setupMenuButton(AppCompatActivity activity) {
        Button backButton = activity.findViewById(R.id.buttonVolverMenu);
        if (backButton != null) {
            backButton.setOnClickListener(v -> {
                Intent intent = new Intent(activity, MenuActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                activity.startActivity(intent);
                activity.finish();
            });
        }
    }
}
