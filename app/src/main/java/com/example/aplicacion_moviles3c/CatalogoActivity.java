package com.example.aplicacion_moviles3c;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.aplicacion_moviles3c.databinding.ActivityCatalogoBinding;

import java.util.ArrayList;
import java.util.List;

public class CatalogoActivity extends AppCompatActivity {

    private static final String CATEGORY_AUDIO = "audio";
    private static final String CATEGORY_PERIPHERALS = "perifericos";
    private static final String CATEGORY_MOUSEPADS = "mousepads";
    private static final String CATEGORY_MONITORS = "monitores";
    private static final String CATEGORY_ACCESSORIES = "accesorios";

    private final List<CatalogItem> catalogItems = new ArrayList<>();
    private CatalogAdapter adapter;
    private ActivityCatalogoBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCatalogoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.recyclerViewCatalogo.setLayoutManager(new LinearLayoutManager(this));
        adapter = new CatalogAdapter();
        binding.recyclerViewCatalogo.setAdapter(adapter);

        seedData();
        adapter.submitList(new ArrayList<>(catalogItems));

        binding.chipGroupCategorias.setOnCheckedStateChangeListener((group, checkedIds) -> {
            if (checkedIds == null || checkedIds.isEmpty()) {
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
        catalogItems.add(new CatalogItem("Bose QuietComfort Ultra", CATEGORY_AUDIO, "Acústica inmersiva con Bluetooth multipunto.", "$2.100.000"));
        catalogItems.add(new CatalogItem("Sennheiser Momentum 4 Wireless", CATEGORY_AUDIO, "Hasta 60h de autonomía y app de ecualización.", "$1.950.000"));
        catalogItems.add(new CatalogItem("HyperX Cloud III Wireless", CATEGORY_AUDIO, "Micrófono desmontable y sonido espacial DTS.", "$820.000"));
        catalogItems.add(new CatalogItem("Logitech Zone Vibe 125", CATEGORY_AUDIO, "Ligereza para videollamadas corporativas.", "$640.000"));
        catalogItems.add(new CatalogItem("SteelSeries Arctis Nova Pro", CATEGORY_AUDIO, "DAC con cancelación activa híbrida.", "$1.780.000"));
        catalogItems.add(new CatalogItem("Corsair HS80 RGB Wireless", CATEGORY_AUDIO, "Sonido espacial Dolby Atmos para gaming.", "$690.000"));
        catalogItems.add(new CatalogItem("Razer BlackShark V2 Pro", CATEGORY_AUDIO, "Drivers TriForce Titanium y banda ligera.", "$830.000"));
        catalogItems.add(new CatalogItem("Audio-Technica ATH-M50xBT2", CATEGORY_AUDIO, "Referencia de estudio con 50h de batería.", "$1.050.000"));
        catalogItems.add(new CatalogItem("Jabra Evolve2 85", CATEGORY_AUDIO, "Certificación Teams con ANC profesional.", "$2.350.000"));

        catalogItems.add(new CatalogItem("Keychron Q1 Pro", CATEGORY_PERIPHERALS, "Teclado mecánico inalámbrico con perillas.", "$1.050.000"));
        catalogItems.add(new CatalogItem("Logitech MX Mechanical", CATEGORY_PERIPHERALS, "Switches táctiles low-profile y Flow.", "$780.000"));
        catalogItems.add(new CatalogItem("Razer Huntsman V3 Pro", CATEGORY_PERIPHERALS, "Switch óptico lineal con ajustes de recorrido.", "$1.250.000"));
        catalogItems.add(new CatalogItem("Logitech MX Master 3S", CATEGORY_PERIPHERALS, "Mouse ergonómico con 8K DPI y MagSpeed.", "$580.000"));
        catalogItems.add(new CatalogItem("Razer Basilisk V3 Pro", CATEGORY_PERIPHERALS, "Sensor Focus Pro 30K y carga inalámbrica.", "$720.000"));
        catalogItems.add(new CatalogItem("SteelSeries Aerox 5 Wireless", CATEGORY_PERIPHERALS, "Ultraligero con 180h de batería.", "$620.000"));
        catalogItems.add(new CatalogItem("Logitech G Pro X Superlight 2", CATEGORY_PERIPHERALS, "Mouse e-sports de 60 g con Lightspeed.", "$920.000"));
        catalogItems.add(new CatalogItem("ASUS ROG Azoth", CATEGORY_PERIPHERALS, "Teclado gasket mount con OLED y triple modo.", "$1.350.000"));
        catalogItems.add(new CatalogItem("Glorious Model O 2", CATEGORY_PERIPHERALS, "Sensor BAMF 2.0 y diseño honecomb.", "$520.000"));
        catalogItems.add(new CatalogItem("Logitech G915 TKL", CATEGORY_PERIPHERALS, "Switches GL low-profile y LIGHTSPEED.", "$1.150.000"));

        catalogItems.add(new CatalogItem("SteelSeries QcK Heavy XXL", CATEGORY_MOUSEPADS, "Superficie micro tejida para sensores ópticos.", "$210.000"));
        catalogItems.add(new CatalogItem("Logitech G740", CATEGORY_MOUSEPADS, "5 mm de grosor para sesiones prolongadas.", "$180.000"));
        catalogItems.add(new CatalogItem("Razer Strider Chroma", CATEGORY_MOUSEPADS, "Alfombrilla híbrida con RGB direccionable.", "$520.000"));
        catalogItems.add(new CatalogItem("Corsair MM700 RGB", CATEGORY_MOUSEPADS, "Extended con hub USB y bordes iluminados.", "$410.000"));
        catalogItems.add(new CatalogItem("Glorious Helios XL", CATEGORY_MOUSEPADS, "Superficie dura de poliuretano ultradelgada.", "$230.000"));
        catalogItems.add(new CatalogItem("Artisan Zero XSoft XL", CATEGORY_MOUSEPADS, "Textura japonesa de control premium.", "$480.000"));
        catalogItems.add(new CatalogItem("HyperX Pulsefire Mat", CATEGORY_MOUSEPADS, "Tejido antidesgaste y base de goma.", "$160.000"));
        catalogItems.add(new CatalogItem("ASUS ROG Sheath BLK", CATEGORY_MOUSEPADS, "Tamaño extendido para teclado y mouse.", "$190.000"));
        catalogItems.add(new CatalogItem("BenQ Zowie G-SR II", CATEGORY_MOUSEPADS, "Tono uniforme para tracking de e-sports.", "$260.000"));
        catalogItems.add(new CatalogItem("Cooler Master MP511 XL", CATEGORY_MOUSEPADS, "Tejido Cordura resistente a derrames.", "$150.000"));

        catalogItems.add(new CatalogItem("LG UltraGear 27GP850", CATEGORY_MONITORS, "Nano IPS QHD 165Hz para esports.", "$1.980.000"));
        catalogItems.add(new CatalogItem("Dell UltraSharp U2723QE", CATEGORY_MONITORS, "Hub USB-C 90W y 98% DCI-P3.", "$3.450.000"));
        catalogItems.add(new CatalogItem("Samsung Odyssey G9", CATEGORY_MONITORS, "Panel mini-LED de 49'' con 240Hz.", "$5.900.000"));
        catalogItems.add(new CatalogItem("ASUS ProArt PA279CV", CATEGORY_MONITORS, "Calibrado de fábrica para creadores.", "$3.050.000"));
        catalogItems.add(new CatalogItem("Gigabyte M28U 4K 144Hz", CATEGORY_MONITORS, "HDMI 2.1 ideal para consolas.", "$2.600.000"));
        catalogItems.add(new CatalogItem("BenQ EX3210U", CATEGORY_MONITORS, "IPS 144Hz con audio treVolo integrado.", "$3.200.000"));
        catalogItems.add(new CatalogItem("AOC 24G2 144Hz", CATEGORY_MONITORS, "Relación precio/rendimiento imbatible.", "$890.000"));
        catalogItems.add(new CatalogItem("MSI MPG Artymis 343CQR", CATEGORY_MONITORS, "Ultrawide 34'' 165Hz con curva 1000R.", "$2.450.000"));
        catalogItems.add(new CatalogItem("ViewSonic ColorPro VP2768a", CATEGORY_MONITORS, "USB-C 90W para flujos de diseño.", "$2.150.000"));
        catalogItems.add(new CatalogItem("LG UltraFine OLED Pro 27EP950", CATEGORY_MONITORS, "Negros perfectos para coloristas.", "$8.900.000"));

        catalogItems.add(new CatalogItem("Elgato Stream Deck +", CATEGORY_ACCESSORIES, "Controles táctiles para automatizar flujos.", "$1.250.000"));
        catalogItems.add(new CatalogItem("APC Back-UPS Pro 1500VA", CATEGORY_ACCESSORIES, "Protección eléctrica con monitoreo vía app.", "$1.320.000"));
        catalogItems.add(new CatalogItem("Synology DS923+", CATEGORY_ACCESSORIES, "NAS compacto para respaldos híbridos.", "$3.800.000"));
        catalogItems.add(new CatalogItem("Samsung T7 Shield 2TB", CATEGORY_ACCESSORIES, "SSD portátil resistente a golpes y agua.", "$620.000"));
        catalogItems.add(new CatalogItem("Logitech Brio 4K", CATEGORY_ACCESSORIES, "Webcam HDR con autoenfoque y cancelación de fondo.", "$850.000"));
        catalogItems.add(new CatalogItem("Blue Yeti X", CATEGORY_ACCESSORIES, "Micrófono USB con monitoreo y presets.", "$720.000"));
        catalogItems.add(new CatalogItem("TP-Link Archer AXE75", CATEGORY_ACCESSORIES, "Router Wi-Fi 6E tribanda para oficinas híbridas.", "$750.000"));
        catalogItems.add(new CatalogItem("Noctua NH-D15 chromax.black", CATEGORY_ACCESSORIES, "Doble torre para CPU de alto rendimiento.", "$520.000"));
        catalogItems.add(new CatalogItem("Corsair iCUE Link H150i", CATEGORY_ACCESSORIES, "Refrigeración líquida con ecosistema unificado.", "$1.150.000"));
        catalogItems.add(new CatalogItem("NZXT H6 Flow", CATEGORY_ACCESSORIES, "Chasis panorámico con flujo de aire elevado.", "$650.000"));
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

        List<CatalogItem> filtered = new ArrayList<>();
        for (CatalogItem item : catalogItems) {
            if (category.equals(item.getCategory())) {
                filtered.add(item);
            }
        }
        adapter.submitList(filtered);
    }
}
