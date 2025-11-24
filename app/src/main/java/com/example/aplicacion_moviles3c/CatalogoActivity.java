package com.example.aplicacion_moviles3c;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.aplicacion_moviles3c.databinding.ActivityCatalogoBinding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CatalogoActivity extends AppCompatActivity {

    private static final String CATEGORY_AUDIO = "audio";
    private static final String CATEGORY_PERIPHERALS = "peripherals";
    private static final String CATEGORY_MOUSEPADS = "mousepads";
    private static final String CATEGORY_MONITORS = "monitors";
    private static final String CATEGORY_ACCESSORIES = "accessories";

    private ActivityCatalogoBinding binding;
    private CatalogAdapter adapter;
    private final List<CatalogItem> catalogItems = new ArrayList<>();
    private final Map<Integer, String> categoryFilters = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCatalogoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        configureFilters();
        setupRecycler();
        seedCatalog();
        adapter.setItems(new ArrayList<>(catalogItems));

        binding.chipGroupCategorias.setOnCheckedStateChangeListener((group, checkedIds) -> applyFilter(checkedIds));

        binding.buttonVolverMenu.setOnClickListener(v -> {
            Intent intent = new Intent(CatalogoActivity.this, MenuActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
            startActivity(intent);
            finish();
        });
    }

    private void configureFilters() {
        categoryFilters.put(R.id.chipAudifonos, CATEGORY_AUDIO);
        categoryFilters.put(R.id.chipPerifericos, CATEGORY_PERIPHERALS);
        categoryFilters.put(R.id.chipMousepads, CATEGORY_MOUSEPADS);
        categoryFilters.put(R.id.chipMonitores, CATEGORY_MONITORS);
        categoryFilters.put(R.id.chipAccesorios, CATEGORY_ACCESSORIES);
    }

    private void setupRecycler() {
        adapter = new CatalogAdapter();
        binding.recyclerViewCatalogo.setLayoutManager(new LinearLayoutManager(this));
        binding.recyclerViewCatalogo.setAdapter(adapter);
    }

    private void seedCatalog() {
        catalogItems.clear();
        catalogItems.add(new CatalogItem(
                "Sony WH-1000XM5",
                CATEGORY_AUDIO,
                "Audio profesional",
                "Cancelación activa de ruido con 30h de batería y modo de atención rápida.",
                "Ideal para videollamadas silenciosas y vuelos largos.",
                "$1.690.000",
                R.drawable.gallery_placeholder
        ));
        catalogItems.add(new CatalogItem(
                "Bose QuietComfort Ultra",
                CATEGORY_AUDIO,
                "Audio profesional",
                "Acústica inmersiva con Bluetooth multipunto y ecualizador personalizable.",
                "Perfectos para oficinas híbridas con enfoque premium.",
                "$2.100.000",
                R.drawable.gallery_placeholder
        ));
        catalogItems.add(new CatalogItem(
                "Sennheiser Momentum 4 Wireless",
                CATEGORY_AUDIO,
                "Audio profesional",
                "Drivers de 42 mm, ANC adaptativa y hasta 60 horas de autonomía.",
                "Pensados para creativos que editan video y audio.",
                "$1.950.000",
                R.drawable.gallery_placeholder
        ));
        catalogItems.add(new CatalogItem(
                "Keychron Q1 Pro",
                CATEGORY_PERIPHERALS,
                "Teclados y mouse",
                "Teclado mecánico inalámbrico con marco de aluminio y perilla programable.",
                "Incluye montaje gasket para escritura silenciosa.",
                "$1.050.000",
                R.drawable.gallery_placeholder
        ));
        catalogItems.add(new CatalogItem(
                "Logitech MX Mechanical",
                CATEGORY_PERIPHERALS,
                "Teclados y mouse",
                "Switches low-profile, conectividad Bolt y hasta 15 días de batería.",
                "Optimizado para escritores y desarrolladores.",
                "$780.000",
                R.drawable.gallery_placeholder
        ));
        catalogItems.add(new CatalogItem(
                "Razer Basilisk V3 Pro",
                CATEGORY_PERIPHERALS,
                "Teclados y mouse",
                "Sensor Focus Pro 30K, rueda háptica y carga inalámbrica.",
                "Respuesta veloz para gaming competitivo.",
                "$720.000",
                R.drawable.gallery_placeholder
        ));
        catalogItems.add(new CatalogItem(
                "Logitech G Pro X Superlight 2",
                CATEGORY_PERIPHERALS,
                "Teclados y mouse",
                "Mouse de 60 g con tecnología Lightspeed y sensor HERO 2.",
                "Preferido por equipos de e-sports.",
                "$920.000",
                R.drawable.gallery_placeholder
        ));
        catalogItems.add(new CatalogItem(
                "Artisan Zero XSoft XL",
                CATEGORY_MOUSEPADS,
                "Mousepads",
                "Superficie japonesa de control premium con base antideslizante.",
                "Consistencia en cada flick para shooters tácticos.",
                "$480.000",
                R.drawable.gallery_placeholder
        ));
        catalogItems.add(new CatalogItem(
                "Razer Strider Chroma",
                CATEGORY_MOUSEPADS,
                "Mousepads",
                "Alfombrilla híbrida con iluminación RGB direccionable y base firme.",
                "Protege el escritorio y resalta el setup.",
                "$520.000",
                R.drawable.gallery_placeholder
        ));
        catalogItems.add(new CatalogItem(
                "SteelSeries QcK Heavy XXL",
                CATEGORY_MOUSEPADS,
                "Mousepads",
                "Tela microtejida de 6 mm diseñada para sensores ópticos y láser.",
                "Formato extendido para teclado y mouse.",
                "$210.000",
                R.drawable.gallery_placeholder
        ));
        catalogItems.add(new CatalogItem(
                "LG UltraGear 27GP850",
                CATEGORY_MONITORS,
                "Monitores",
                "Panel Nano IPS QHD de 165Hz con 1ms y compatibilidad G-Sync.",
                "Equilibrio ideal entre gaming y trabajo creativo.",
                "$1.980.000",
                R.drawable.gallery_placeholder
        ));
        catalogItems.add(new CatalogItem(
                "Dell UltraSharp U2723QE",
                CATEGORY_MONITORS,
                "Monitores",
                "Hub USB-C de 90W, 4K IPS Black y cobertura 98% DCI-P3.",
                "Listo para estaciones con un solo cable.",
                "$3.450.000",
                R.drawable.gallery_placeholder
        ));
        catalogItems.add(new CatalogItem(
                "Samsung Odyssey G9",
                CATEGORY_MONITORS,
                "Monitores",
                "Mini-LED de 49'' con 240Hz, HDR2000 y curvatura 1000R.",
                "Panel panorámico para trading y simuladores.",
                "$5.900.000",
                R.drawable.gallery_placeholder
        ));
        catalogItems.add(new CatalogItem(
                "Synology DS923+",
                CATEGORY_ACCESSORIES,
                "Accesorios",
                "NAS de cuatro bahías con Ryzen integrado y expansión 10GbE opcional.",
                "Ideal para respaldos híbridos y multimedia 4K.",
                "$3.800.000",
                R.drawable.gallery_placeholder
        ));
        catalogItems.add(new CatalogItem(
                "APC Back-UPS Pro 1500VA",
                CATEGORY_ACCESSORIES,
                "Accesorios",
                "UPS interactiva con monitoreo SmartConnect y tomas protegidas.",
                "Protege estaciones críticas y routers corporativos.",
                "$1.320.000",
                R.drawable.gallery_placeholder
        ));
        catalogItems.add(new CatalogItem(
                "Elgato Stream Deck +",
                CATEGORY_ACCESSORIES,
                "Accesorios",
                "Controles táctiles, perillas y pantalla LCD para automatizar flujos.",
                "Streamings y macros de producción con un toque.",
                "$1.250.000",
                R.drawable.gallery_placeholder
        ));
        catalogItems.add(new CatalogItem(
                "Samsung T7 Shield 2TB",
                CATEGORY_ACCESSORIES,
                "Accesorios",
                "SSD portátil resistente a golpes y agua con hasta 1.050 MB/s.",
                "Transporta bibliotecas creativas con seguridad.",
                "$620.000",
                R.drawable.gallery_placeholder
        ));
    }

    private void applyFilter(List<Integer> checkedIds) {
        if (checkedIds == null || checkedIds.isEmpty() || checkedIds.get(0) == R.id.chipTodos) {
            binding.textViewEmptyState.setVisibility(View.GONE);
            adapter.setItems(new ArrayList<>(catalogItems));
            return;
        }

        String category = categoryFilters.get(checkedIds.get(0));
        if (category == null) {
            binding.textViewEmptyState.setVisibility(View.GONE);
            adapter.setItems(new ArrayList<>(catalogItems));
            return;
        }

        List<CatalogItem> filtered = new ArrayList<>();
        for (CatalogItem item : catalogItems) {
            if (category.equals(item.getCategoryKey())) {
                filtered.add(item);
            }
        }

        binding.textViewEmptyState.setVisibility(filtered.isEmpty() ? View.VISIBLE : View.GONE);
        adapter.setItems(filtered);
    }
}
