package com.example.aplicacion_moviles3c;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class AgendarServicioActivity extends AppCompatActivity {

    private long selectedDateInMillis;
    private EditText serviceEditText;
    private AppointmentStorage appointmentStorage;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agendar_servicio);

        CalendarView calendarView = findViewById(R.id.calendarView);
        serviceEditText = findViewById(R.id.editTextServicio);
        Button agendarButton = findViewById(R.id.buttonAgendarServicio);
        ListView listView = findViewById(R.id.listViewCitas);

        appointmentStorage = new AppointmentStorage(this);
        selectedDateInMillis = calendarView.getDate();

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                Calendar calendar = Calendar.getInstance();
                calendar.set(year, month, dayOfMonth, 0, 0, 0);
                selectedDateInMillis = calendar.getTimeInMillis();
            }
        });

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, new ArrayList<>());
        listView.setAdapter(adapter);
        loadAppointments();

        agendarButton.setOnClickListener(v -> saveAppointment());
    }

    private void saveAppointment() {
        String description = serviceEditText.getText().toString().trim();
        if (description.isEmpty()) {
            serviceEditText.setError(getString(R.string.hint_servicio));
            return;
        }

        Appointment appointment = new Appointment(selectedDateInMillis, description);
        appointmentStorage.saveAppointment(appointment);
        serviceEditText.setText("");
        loadAppointments();
        Toast.makeText(this, R.string.message_cita_guardada, Toast.LENGTH_SHORT).show();
    }

    private void loadAppointments() {
        List<Appointment> appointments = appointmentStorage.getAppointments();
        List<String> displayList = new ArrayList<>();
        for (Appointment appointment : appointments) {
            displayList.add(appointment.toDisplayString());
        }
        adapter.clear();
        adapter.addAll(displayList);
        adapter.notifyDataSetChanged();
    }
}
