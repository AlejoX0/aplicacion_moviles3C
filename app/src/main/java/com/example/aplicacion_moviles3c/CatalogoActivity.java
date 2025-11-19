package com.example.aplicacion_moviles3c;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.chip.ChipGroup;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CatalogoActivity extends AppCompatActivity {

    private static final String CATEGORY_AUDIO = "audio";
    private static final String CATEGORY_PERIPHERALS = "perifericos";
    private static final String CATEGORY_MOUSEPADS = "mousepads";
    private static final String CATEGORY_MONITORS = "monitores";
    private static final String CATEGORY_ACCESSORIES = "accesorios";

    private final List<CatalogItem> catalogItems = new ArrayList<>();
    private CatalogAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalogo);

        RecyclerView recyclerView = findViewById(R.id.recyclerViewCatalogo);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new CatalogAdapter();
        recyclerView.setAdapter(adapter);

        seedData();
        adapter.submitList(new ArrayList<>(catalogItems));

        ChipGroup chipGroup = findViewById(R.id.chipGroupCategorias);
        chipGroup.setOnCheckedStateChangeListener((group, checkedIds) -> {
            if (checkedIds.isEmpty()) {
                adapter.submitList(new ArrayList<>(catalogItems));
            } else {
                filterCatalog(checkedIds.get(0));
            }
        });

        NavigationHelper.setupMenuButton(this);
    }

    private void seedData() {
        catalogItems.clear();
        catalogItems.add(new CatalogItem("Sony WH-1000XM5", CATEGORY_AUDIO, "Cancelación de ruido y hasta 30h de batería.", "$1.690.000"));
        catalogItems.add(new CatalogItem("HyperX Cloud III Wireless", CATEGORY_AUDIO, "Micrófono desmontable y sonido espacial DTS.", "$820.000"));
        catalogItems.add(new CatalogItem("Logitech Zone Vibe 125", CATEGORY_AUDIO, "Ligereza para videollamadas y teams corporativos.", "$640.000"));

        catalogItems.add(new CatalogItem("Keychron Q1 Pro", CATEGORY_PERIPHERALS, "Teclado mecánico inalámbrico con perillas programables.", "$1.050.000"));
        catalogItems.add(new CatalogItem("Logitech MX Master 3S", CATEGORY_PERIPHERALS, "Mouse ergonómico con Flow multi-dispositivo.", "$580.000"));
        catalogItems.add(new CatalogItem("Razer Basilisk V3 Pro", CATEGORY_PERIPHERALS, "Sensor Focus Pro 30K y carga inalámbrica.", "$720.000"));

        catalogItems.add(new CatalogItem("SteelSeries QcK Heavy XXL", CATEGORY_MOUSEPADS, "Superficie micro tejida para sensores ópticos.", "$210.000"));
        catalogItems.add(new CatalogItem("Logitech G740", CATEGORY_MOUSEPADS, "5 mm de grosor para sesiones prolongadas.", "$180.000"));

        catalogItems.add(new CatalogItem("LG UltraGear 27GP850", CATEGORY_MONITORS, "Nano IPS QHD 165Hz para esports.", "$1.980.000"));
        catalogItems.add(new CatalogItem("Dell UltraSharp U2723QE", CATEGORY_MONITORS, "Hub USB-C 90W y cobertura 98% DCI-P3.", "$3.450.000"));
        catalogItems.add(new CatalogItem("Samsung Odyssey G9", CATEGORY_MONITORS, "Panel mini-LED de 49'' con 240Hz.", "$5.900.000"));

        catalogItems.add(new CatalogItem("Elgato Stream Deck +", CATEGORY_ACCESSORIES, "Controles táctiles y perillas para automatizar flujos.", "$1.250.000"));
        catalogItems.add(new CatalogItem("APC Back-UPS Pro 1500VA", CATEGORY_ACCESSORIES, "Protección eléctrica con monitoreo vía app.", "$1.320.000"));
        catalogItems.add(new CatalogItem("Synology DS923+", CATEGORY_ACCESSORIES, "NAS compacto para respaldos híbridos.", "$3.800.000"));
    }

    private void filterCatalog(int chipId) {
        String category = null;
        if (chipId == R.id.chipAudifonos) {
            category = CATEGORY_AUDIO;
        } else if (chipId == R.id.chipPerifericos) {
            category = CATEGORY_PERIPHERALS;
        } else if (chipId == R.id.chipMousepads) {
            category = CATEGORY_MOUSEPADS;
        } else if (chipId == R.id.chipMonitores) {
            category = CATEGORY_MONITORS;
        } else if (chipId == R.id.chipAccesorios) {
            category = CATEGORY_ACCESSORIES;
        }

        if (category == null) {
            adapter.submitList(new ArrayList<>(catalogItems));
            return;
        }

        List<CatalogItem> filtered = catalogItems.stream()
                .filter(item -> category.equals(item.getCategory()))
                .collect(Collectors.toList());
        adapter.submitList(filtered);
    }
}
