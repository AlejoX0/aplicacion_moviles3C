package com.example.aplicacion_moviles3c;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.bumptech.glide.Glide;
import com.example.aplicacion_moviles3c.databinding.ActivityCatalogoBinding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CatalogoActivity extends AppCompatActivity implements CatalogAdapter.OnItemClickListener {

    private static final String CATEGORY_LAPTOPS = "laptops";
    private static final String CATEGORY_PHONES = "phones";
    private static final String CATEGORY_AUDIO = "audio";
    private static final String CATEGORY_GAMING = "gaming";
    private static final String CATEGORY_SMART_HOME = "smart_home";

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
        updateHeroSection(catalogItems);
        adapter.submitList(new ArrayList<>(catalogItems));

        binding.chipGroupCategorias.setOnCheckedStateChangeListener((group, checkedIds) -> applyFilter(checkedIds));

        binding.buttonVolverMenu.setOnClickListener(v -> {
            Intent intent = new Intent(CatalogoActivity.this, MenuActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
            startActivity(intent);
            finish();
        });
    }

    private void configureFilters() {
        categoryFilters.put(R.id.chipLaptops, CATEGORY_LAPTOPS);
        categoryFilters.put(R.id.chipTelefonos, CATEGORY_PHONES);
        categoryFilters.put(R.id.chipAudio, CATEGORY_AUDIO);
        categoryFilters.put(R.id.chipGaming, CATEGORY_GAMING);
        categoryFilters.put(R.id.chipSmartHome, CATEGORY_SMART_HOME);
    }

    private void setupRecycler() {
        adapter = new CatalogAdapter();
        adapter.setOnItemClickListener(this);
        binding.recyclerViewCatalogo.setLayoutManager(new LinearLayoutManager(this));
        binding.recyclerViewCatalogo.setAdapter(adapter);
    }

    private void updateHeroSection(List<CatalogItem> items) {
        if (items == null || items.isEmpty()) {
            binding.cardHero.setVisibility(View.GONE);
            return;
        }

        binding.cardHero.setVisibility(View.VISIBLE);
        CatalogItem heroItem = items.get(0);
        binding.textViewHeroTitle.setText(heroItem.getName());
        binding.textViewHeroSubtitle.setText(heroItem.getHighlight());
        binding.textViewHeroCategory.setText(heroItem.getCategoryLabel());
        binding.textViewHeroPrice.setText(heroItem.getPrice());

        Glide.with(this)
                .load(heroItem.getImageResId())
                .placeholder(R.drawable.gallery_placeholder)
                .centerCrop()
                .into(binding.imageViewHero);
    }

    private void seedCatalog() {
        catalogItems.clear();
        catalogItems.add(new CatalogItem(
                "MacBook Air M3 13'' (2024)",
                CATEGORY_LAPTOPS,
                "Ultraportátiles",
                "Chip Apple M3, 8GB RAM y SSD de 256GB con autonomía de hasta 18h.",
                "Ligera, silenciosa y lista para edición en movimiento.",
                "$6.899.000 COP",
                R.drawable.macbook_air_m3,
                null
        ));
        catalogItems.add(new CatalogItem(
                "Dell XPS 14 (9440)",
                CATEGORY_LAPTOPS,
                "Ultraportátiles",
                "Intel Core Ultra 7, pantalla OLED 3K y chasis de aluminio mecanizado.",
                "Para ejecutivos que necesitan potencia y estilo en viajes.",
                "$9.800.000 COP",
                R.drawable.dell_xps_14,
                null
        ));
        catalogItems.add(new CatalogItem(
                "Lenovo ThinkPad X1 Carbon Gen 12",
                CATEGORY_LAPTOPS,
                "Ultraportátiles",
                "Intel Core Ultra, chasis de fibra de carbono y certificación MIL-STD 810H.",
                "Teclado legendario y conectividad 5G opcional para ejecutivos.",
                "$8.450.000 COP",
                R.drawable.lenovo_thinkpad,
                null
        ));
        catalogItems.add(new CatalogItem(
                "iPhone 15 Pro",
                CATEGORY_PHONES,
                "Smartphones",
                "Pantalla Super Retina XDR de 6.1'' y chip A17 Pro con USB-C.",
                "Fotos ProRAW y video Log listos para postproducción móvil.",
                "$5.799.000 COP",
                R.drawable.iphone_15_pro,
                null
        ));
        catalogItems.add(new CatalogItem(
                "Samsung Galaxy S24 Ultra",
                CATEGORY_PHONES,
                "Smartphones",
                "Pantalla QHD+ de 6.8'' a 120Hz, S-Pen incluido y cámara 200MP.",
                "Integración Galaxy AI para notas, traducción y retoque.",
                "$6.499.900 COP",
                R.drawable.samsung_galaxy_s24_ultra,
                null
        ));
        catalogItems.add(new CatalogItem(
                "Sony WH-1000XM5",
                CATEGORY_AUDIO,
                "Audio",
                "Cancelación activa de ruido, 30 horas de batería y modo atención rápida.",
                "Auriculares referencia para viajes y videollamadas.",
                "$1.690.000 COP",
                R.drawable.sony_wh1000xm5,
                null
        ));
        catalogItems.add(new CatalogItem(
                "Bose QuietComfort Ultra Earbuds",
                CATEGORY_AUDIO,
                "Audio",
                "Cancelación adaptativa, Bluetooth multipunto y certificación IPX4.",
                "Audio inmersivo para jornadas híbridas y desplazamientos.",
                "$1.580.000 COP",
                R.drawable.bose_earbuds,
                null
        ));
        catalogItems.add(new CatalogItem(
                "PlayStation 5 Slim",
                CATEGORY_GAMING,
                "Gaming",
                "CPU AMD Zen 2, SSD ultra rápido y mando DualSense con hápticos.",
                "Consola compacta para salas de experiencia y torneos.",
                "$3.299.000 COP",
                R.drawable.playstation_5,
                null
        ));
        catalogItems.add(new CatalogItem(
                "Nintendo Switch OLED",
                CATEGORY_GAMING,
                "Gaming",
                "Pantalla OLED de 7'', dock con puerto LAN y 64GB de almacenamiento.",
                "Ideal para activaciones, zonas de descanso y gaming familiar.",
                "$1.799.000 COP",
                R.drawable.nintendo_switch_oled,
                null
        ));
        catalogItems.add(new CatalogItem(
                "Google Nest Hub (2da gen)",
                CATEGORY_SMART_HOME,
                "Hogar inteligente",
                "Asistente con pantalla de 7'' para dashboards de salas y control de IoT.",
                "Micrófonos de campo lejano y sensor Soli para gestos.",
                "$629.900 COP",
                R.drawable.google_nest_hub,
                null
        ));
        catalogItems.add(new CatalogItem(
                "Philips Hue Starter Kit (E26)",
                CATEGORY_SMART_HOME,
                "Hogar inteligente",
                "Incluye bridge, 3 bombillos white & color y control desde app o asistentes.",
                "Automatiza escenas de oficinas y zonas creativas.",
                "$999.900 COP",
                R.drawable.philips,
                null
        ));

        catalogItems.add(new CatalogItem(
                "Micrófono RGB para streaming",
                CATEGORY_AUDIO,
                "Audio",
                "Brazo articulado, filtro anti-pop y compatibilidad plug & play para PC y consolas.",
                "Optimiza voces claras en grabaciones y videollamadas nocturnas.",
                "$489.900 COP",
                R.drawable.microfono,
                null
        ));

        catalogItems.add(new CatalogItem(
                "Combo teclado + mouse RGB",
                CATEGORY_GAMING,
                "Gaming",
                "Teclado mecánico retroiluminado con switch táctil y mouse ergonómico con DPI ajustable.",
                "Set balanceado para estaciones mixtas de gaming y productividad.",
                "$359.900 COP",
                R.drawable.teclado_gamer,
                null
        ));

        catalogItems.add(new CatalogItem(
                "Monitor ASUS 27'' IPS 2K",
                CATEGORY_LAPTOPS,
                "Ultraportátiles",
                "Panel 2K de 27'' con 75Hz, marco ultradelgado y conectividad HDMI/DisplayPort.",
                "Perfecto para edición, dashboards y espacios minimalistas.",
                "$1.290.000 COP",
                R.drawable.monitor,
                null
        ));
    }

    private void applyFilter(List<Integer> checkedIds) {
        if (checkedIds == null || checkedIds.isEmpty() || checkedIds.get(0) == R.id.chipTodos) {
            binding.textViewEmptyState.setVisibility(View.GONE);
            adapter.submitList(new ArrayList<>(catalogItems));
            updateHeroSection(catalogItems);
            return;
        }

        String category = categoryFilters.get(checkedIds.get(0));
        if (category == null) {
            binding.textViewEmptyState.setVisibility(View.GONE);
            adapter.submitList(new ArrayList<>(catalogItems));
            return;
        }

        List<CatalogItem> filtered = new ArrayList<>();
        for (CatalogItem item : catalogItems) {
            if (category.equals(item.getCategoryKey())) {
                filtered.add(item);
            }
        }

        binding.textViewEmptyState.setVisibility(filtered.isEmpty() ? View.VISIBLE : View.GONE);
        adapter.submitList(new ArrayList<>(filtered));
        updateHeroSection(filtered);
    }

    @Override
    public void onItemClick(CatalogItem item) {
        // No hacer nada por ahora, ya que no tenemos una URL a la cual navegar.
    }
}
