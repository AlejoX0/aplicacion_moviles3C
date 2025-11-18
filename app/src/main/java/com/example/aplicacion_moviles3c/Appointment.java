package com.example.aplicacion_moviles3c;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Representa una cita agendada por el usuario.
 */
public class Appointment {
    private static final String KEY_DATE = "date";
    private static final String KEY_DESCRIPTION = "description";
    private static final SimpleDateFormat DATE_FORMAT =
            new SimpleDateFormat("dd 'de' MMMM yyyy", new Locale("es", "CO"));

    private final long dateInMillis;
    private final String description;

    public Appointment(long dateInMillis, String description) {
        this.dateInMillis = dateInMillis;
        this.description = description;
    }

    public long getDateInMillis() {
        return dateInMillis;
    }

    public String getDescription() {
        return description;
    }

    public String toDisplayString() {
        return DATE_FORMAT.format(new Date(dateInMillis)) + " - " + description;
    }

    public JSONObject toJson() throws JSONException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put(KEY_DATE, dateInMillis);
        jsonObject.put(KEY_DESCRIPTION, description);
        return jsonObject;
    }

    public static Appointment fromJson(JSONObject object) throws JSONException {
        long date = object.getLong(KEY_DATE);
        String description = object.getString(KEY_DESCRIPTION);
        return new Appointment(date, description);
    }
}
