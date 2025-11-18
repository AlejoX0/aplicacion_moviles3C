package com.example.aplicacion_moviles3c;

import android.content.Context;
import android.content.SharedPreferences;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Maneja la persistencia local de las citas agendadas.
 */
public class AppointmentStorage {
    private static final String PREFS_NAME = "appointments_prefs";
    private static final String KEY_APPOINTMENTS = "appointments";

    private final SharedPreferences sharedPreferences;

    public AppointmentStorage(Context context) {
        sharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
    }

    public List<Appointment> getAppointments() {
        String json = sharedPreferences.getString(KEY_APPOINTMENTS, "[]");
        try {
            JSONArray jsonArray = new JSONArray(json);
            List<Appointment> appointments = new ArrayList<>();
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject object = jsonArray.getJSONObject(i);
                appointments.add(Appointment.fromJson(object));
            }
            return appointments;
        } catch (JSONException e) {
            return Collections.emptyList();
        }
    }

    public void saveAppointment(Appointment appointment) {
        List<Appointment> appointments = new ArrayList<>(getAppointments());
        appointments.add(appointment);
        JSONArray jsonArray = new JSONArray();
        for (Appointment item : appointments) {
            try {
                jsonArray.put(item.toJson());
            } catch (JSONException ignored) {
            }
        }
        sharedPreferences.edit().putString(KEY_APPOINTMENTS, jsonArray.toString()).apply();
    }
}
