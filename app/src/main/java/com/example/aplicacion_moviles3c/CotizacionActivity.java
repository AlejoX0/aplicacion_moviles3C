package com.example.aplicacion_moviles3c;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.NumberFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class CotizacionActivity extends AppCompatActivity {

    private Spinner spinnerProcesador;
    private Spinner spinnerRam;
    private Spinner spinnerMotherboard;
    private Spinner spinnerSsd;
    private Spinner spinnerMonitor;
    private Spinner spinnerFuente;
    private TextView textViewResultado;
    private RadioGroup radioGroupTipo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cotizacion);

        spinnerProcesador = findViewById(R.id.spinnerProcesador);
        spinnerRam = findViewById(R.id.spinnerRam);
        spinnerMotherboard = findViewById(R.id.spinnerMotherboard);
        spinnerSsd = findViewById(R.id.spinnerSsd);
        spinnerMonitor = findViewById(R.id.spinnerMonitor);
        spinnerFuente = findViewById(R.id.spinnerFuente);
        textViewResultado = findViewById(R.id.textViewResultado);
        radioGroupTipo = findViewById(R.id.radioGroupTipo);

        setupSpinner(spinnerProcesador, getProcessors());
        setupSpinner(spinnerRam, getRamModules());
        setupSpinner(spinnerMotherboard, getMotherboards());
        setupSpinner(spinnerSsd, getSsds());
        setupSpinner(spinnerMonitor, getMonitors());
        setupSpinner(spinnerFuente, getPowerSupplies());

        findViewById(R.id.buttonSolicitarCotizacion).setOnClickListener(v -> calcular());
        NavigationHelper.setupMenuButton(this);
    }

    private void setupSpinner(Spinner spinner, List<ComponentOption> options) {
        ArrayAdapter<ComponentOption> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, options);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }

    private void calcular() {
        ComponentOption procesador = (ComponentOption) spinnerProcesador.getSelectedItem();
        ComponentOption ram = (ComponentOption) spinnerRam.getSelectedItem();
        ComponentOption motherboard = (ComponentOption) spinnerMotherboard.getSelectedItem();
        ComponentOption ssd = (ComponentOption) spinnerSsd.getSelectedItem();
        ComponentOption monitor = (ComponentOption) spinnerMonitor.getSelectedItem();
        ComponentOption fuente = (ComponentOption) spinnerFuente.getSelectedItem();

        boolean esEscritorio = radioGroupTipo.getCheckedRadioButtonId() == R.id.radioButtonEscritorio;
        long base = esEscritorio ? 350_000L : 250_000L;
        long total = base + procesador.getPrice() + ram.getPrice() + motherboard.getPrice()
                + ssd.getPrice() + monitor.getPrice() + fuente.getPrice();

        NumberFormat format = NumberFormat.getInstance(new Locale("es", "CO"));
        format.setMaximumFractionDigits(0);
        String tipo = esEscritorio ? "de escritorio" : "portátil";
        String detalle = "CPU: " + procesador.getLabel()
                + "\nRAM: " + ram.getLabel()
                + "\nPlaca: " + motherboard.getLabel()
                + "\nSSD: " + ssd.getLabel()
                + "\nMonitor: " + monitor.getLabel()
                + "\nFuente: " + fuente.getLabel();

        textViewResultado.setText(getString(R.string.cotizacion_result_format, tipo, detalle, format.format(total)));
    }

    private List<ComponentOption> getProcessors() {
        return Arrays.asList(
                new ComponentOption("AMD Ryzen 9 7950X", 3_200_000L),
                new ComponentOption("AMD Ryzen 7 7800X3D", 2_550_000L),
                new ComponentOption("AMD Ryzen 5 7600", 1_580_000L),
                new ComponentOption("Intel Core i9-14900K", 3_350_000L),
                new ComponentOption("Intel Core i7-14700KF", 2_350_000L),
                new ComponentOption("Intel Core i5-14600K", 1_950_000L),
                new ComponentOption("Intel Core Ultra 7 165H", 2_150_000L),
                new ComponentOption("Intel Core i9-13900HX", 2_950_000L),
                new ComponentOption("AMD Ryzen 9 7945HX3D", 3_600_000L),
                new ComponentOption("AMD Threadripper PRO 7975WX", 6_900_000L)
        );
    }

    private List<ComponentOption> getRamModules() {
        return Arrays.asList(
                new ComponentOption("Corsair Vengeance DDR5 32GB 6000MT/s", 780_000L),
                new ComponentOption("G.Skill Trident Z5 Neo 32GB 6400MT/s", 890_000L),
                new ComponentOption("Kingston Fury Beast DDR5 32GB 5200MT/s", 650_000L),
                new ComponentOption("Crucial Pro DDR5 32GB 5600MT/s", 610_000L),
                new ComponentOption("HyperX Impact SO-DIMM 32GB 3200MT/s", 520_000L),
                new ComponentOption("TeamGroup T-Force Delta RGB 32GB 7200MT/s", 1_050_000L),
                new ComponentOption("Adata XPG Lancer 64GB 6000MT/s", 1_320_000L),
                new ComponentOption("Samsung DDR5 ECC 32GB 4800MT/s", 990_000L),
                new ComponentOption("Corsair Dominator Platinum 64GB 6600MT/s", 1_780_000L),
                new ComponentOption("Lexar ARES DDR5 32GB 6200MT/s", 720_000L)
        );
    }

    private List<ComponentOption> getMotherboards() {
        return Arrays.asList(
                new ComponentOption("ASUS ROG Strix X670E-E Gaming WiFi", 2_350_000L),
                new ComponentOption("ASUS TUF Gaming B650-PLUS", 1_150_000L),
                new ComponentOption("MSI MAG Z790 Tomahawk WiFi", 1_850_000L),
                new ComponentOption("Gigabyte Z790 Aorus Elite AX", 1_720_000L),
                new ComponentOption("ASRock B550 Taichi", 1_480_000L),
                new ComponentOption("MSI MPG B650I Edge WiFi", 1_360_000L),
                new ComponentOption("Gigabyte B760M DS3H AX", 980_000L),
                new ComponentOption("ASUS ProArt Z790-Creator WiFi", 2_450_000L),
                new ComponentOption("MSI PRO Z790-P WiFi", 1_420_000L),
                new ComponentOption("Gigabyte X670 Aorus Master", 2_650_000L)
        );
    }

    private List<ComponentOption> getSsds() {
        return Arrays.asList(
                new ComponentOption("Samsung 990 Pro 2TB", 1_350_000L),
                new ComponentOption("WD Black SN850X 1TB", 890_000L),
                new ComponentOption("Seagate FireCuda 530 1TB", 1_050_000L),
                new ComponentOption("Kingston KC3000 2TB", 1_200_000L),
                new ComponentOption("Crucial T700 2TB", 1_650_000L),
                new ComponentOption("Sabrent Rocket 4 Plus 1TB", 930_000L),
                new ComponentOption("Lexar NM790 2TB", 980_000L),
                new ComponentOption("MSI Spatium M570 1TB", 1_100_000L),
                new ComponentOption("WD Blue SN580 1TB", 620_000L),
                new ComponentOption("Corsair MP700 2TB", 1_580_000L)
        );
    }

    private List<ComponentOption> getMonitors() {
        return Arrays.asList(
                new ComponentOption("LG UltraGear 27GP850-B", 1_980_000L),
                new ComponentOption("Samsung Odyssey G7 32''", 2_850_000L),
                new ComponentOption("ASUS ProArt PA279CV", 3_150_000L),
                new ComponentOption("Dell UltraSharp U2723QE", 3_450_000L),
                new ComponentOption("AOC 24G2 144Hz", 890_000L),
                new ComponentOption("BenQ PD3205U", 3_250_000L),
                new ComponentOption("MSI Optix MAG274QRF-QD", 2_150_000L),
                new ComponentOption("Gigabyte M28U 144Hz", 2_600_000L),
                new ComponentOption("LG UltraWide 34WN80C", 2_550_000L),
                new ComponentOption("ViewSonic ColorPro VP2786-4K", 3_600_000L)
        );
    }

    private List<ComponentOption> getPowerSupplies() {
        return Arrays.asList(
                new ComponentOption("Corsair RM850x Shift 80+ Gold", 980_000L),
                new ComponentOption("Seasonic Prime TX-1000", 1_650_000L),
                new ComponentOption("EVGA SuperNOVA 850 G7", 1_050_000L),
                new ComponentOption("ASUS ROG Loki SFX-L 750W", 1_280_000L),
                new ComponentOption("be quiet! Straight Power 12 1000W", 1_580_000L),
                new ComponentOption("Cooler Master V850 Gold i", 1_180_000L),
                new ComponentOption("Thermaltake Toughpower GF3 1200W", 1_720_000L),
                new ComponentOption("NZXT C750 80+ Gold", 880_000L),
                new ComponentOption("XPG CyberCore II 1000W", 1_320_000L),
                new ComponentOption("MSI MPG A850G PCIe5", 1_140_000L)
        );
    }
}
