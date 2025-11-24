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
        bindHeroImage();
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

    private void bindHeroImage() {
        if (catalogItems.isEmpty()) {
            return;
        }

        Glide.with(this)
                .load(catalogItems.get(0).getImageUrl())
                .placeholder(R.drawable.gallery_placeholder)
                .error(R.drawable.gallery_placeholder)
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
                R.drawable.gallery_placeholder,
                "https://store.storeimages.cdn-apple.com/4982/as-images.apple.com/is/mba13-midnight-select-202402?wid=2000&hei=1536&fmt=jpeg&qlt=90&.v=1707434878666"
        ));
        catalogItems.add(new CatalogItem(
                "Dell XPS 14 (9440)",
                CATEGORY_LAPTOPS,
                "Ultraportátiles",
                "Intel Core Ultra 7, pantalla OLED 3K y chasis de aluminio mecanizado.",
                "Para ejecutivos que necesitan potencia y estilo en viajes.",
                "$9.800.000 COP",
                R.drawable.gallery_placeholder,
                "https://i.dell.com/sites/csimages/Master_Imagery/all/xps-14-9440-laptop-black-gallery-1.png"
        ));
        catalogItems.add(new CatalogItem(
                "Lenovo ThinkPad X1 Carbon Gen 12",
                CATEGORY_LAPTOPS,
                "Ultraportátiles",
                "Intel Core Ultra, chasis de fibra de carbono y certificación MIL-STD 810H.",
                "Teclado legendario y conectividad 5G opcional para ejecutivos.",
                "$8.450.000 COP",
                R.drawable.gallery_placeholder,
                "https://www.lenovo.com/medias/lenovo-laptop-thinkpad-x1-carbon-gen-12-front.png?context=bWFzdGVyfHJvb3R8MTYyODU4fGltYWdlL3BuZ3xoNmMvaGI5LzE2ODM1MjI4MTA4NTc0LnBuZ3wzODNhOGQwNWMyOWUyNTA2OTVhZjQ3MzRlN2UwZTUwMTJiZjMyZjdiMTA2YzRhN2NjZmY2YWYxNjQ5ZTU1NThh"
        ));
        catalogItems.add(new CatalogItem(
                "iPhone 15 Pro",
                CATEGORY_PHONES,
                "Smartphones",
                "Pantalla Super Retina XDR de 6.1'' y chip A17 Pro con USB-C.",
                "Fotos ProRAW y video Log listos para postproducción móvil.",
                "$5.799.000 COP",
                R.drawable.gallery_placeholder,
                "https://store.storeimages.cdn-apple.com/4982/as-images.apple.com/is/iphone-15-pro-finish-select-202309-6-7inch-bluetitanium_AV1?wid=5120&hei=2880&fmt=jpeg&qlt=80&.v=1692844597674"
        ));
        catalogItems.add(new CatalogItem(
                "Samsung Galaxy S24 Ultra",
                CATEGORY_PHONES,
                "Smartphones",
                "Pantalla QHD+ de 6.8'' a 120Hz, S-Pen incluido y cámara 200MP.",
                "Integración Galaxy AI para notas, traducción y retoque.",
                "$6.499.900 COP",
                R.drawable.gallery_placeholder,
                "https://images.samsung.com/is/image/samsung/p6pim/co/sm-s928bzageeo/gallery/co-galaxy-s24-ultra-sm-s928-sm-s928bzageeo-538107658"
        ));
        catalogItems.add(new CatalogItem(
                "Sony WH-1000XM5",
                CATEGORY_AUDIO,
                "Audio",
                "Cancelación activa de ruido, 30 horas de batería y modo atención rápida.",
                "Auriculares referencia para viajes y videollamadas.",
                "$1.690.000 COP",
                R.drawable.gallery_placeholder,
                "https://m.media-amazon.com/images/I/71CGl5+j51L._AC_SL1500_.jpg"
        ));
        catalogItems.add(new CatalogItem(
                "Bose QuietComfort Ultra Earbuds",
                CATEGORY_AUDIO,
                "Audio",
                "Cancelación adaptativa, Bluetooth multipunto y certificación IPX4.",
                "Audio inmersivo para jornadas híbridas y desplazamientos.",
                "$1.580.000 COP",
                R.drawable.gallery_placeholder,
                "https://m.media-amazon.com/images/I/51lTQGHlZhL._AC_SL1500_.jpg"
        ));
        catalogItems.add(new CatalogItem(
                "PlayStation 5 Slim",
                CATEGORY_GAMING,
                "Gaming",
                "CPU AMD Zen 2, SSD ultra rápido y mando DualSense con hápticos.",
                "Consola compacta para salas de experiencia y torneos.",
                "$3.299.000 COP",
                R.drawable.gallery_placeholder,
                "https://m.media-amazon.com/images/I/61-0VnlzvWL._SL1500_.jpg"
        ));
        catalogItems.add(new CatalogItem(
                "Nintendo Switch OLED",
                CATEGORY_GAMING,
                "Gaming",
                "Pantalla OLED de 7'', dock con puerto LAN y 64GB de almacenamiento.",
                "Ideal para activaciones, zonas de descanso y gaming familiar.",
                "$1.799.000 COP",
                R.drawable.gallery_placeholder,
                "https://m.media-amazon.com/images/I/51YsGQL8w4L._SL1000_.jpg"
        ));
        catalogItems.add(new CatalogItem(
                "Google Nest Hub (2da gen)",
                CATEGORY_SMART_HOME,
                "Hogar inteligente",
                "Asistente con pantalla de 7'' para dashboards de salas y control de IoT.",
                "Micrófonos de campo lejano y sensor Soli para gestos.",
                "$629.900 COP",
                R.drawable.gallery_placeholder,
                "https://m.media-amazon.com/images/I/61kNq1DqdzL._AC_SL1500_.jpg"
        ));
        catalogItems.add(new CatalogItem(
                "Philips Hue Starter Kit (E26)",
                CATEGORY_SMART_HOME,
                "Hogar inteligente",
                "Incluye bridge, 3 bombillos white & color y control desde app o asistentes.",
                "Automatiza escenas de oficinas y zonas creativas.",
                "$999.900 COP",
                R.drawable.gallery_placeholder,
                "https://m.media-amazon.com/images/I/71QWLiqLDhL._AC_SL1500_.jpg"
        ));
    }

    private void applyFilter(List<Integer> checkedIds) {
        if (checkedIds == null || checkedIds.isEmpty() || checkedIds.get(0) == R.id.chipTodos) {
            binding.textViewEmptyState.setVisibility(View.GONE);
            adapter.submitList(new ArrayList<>(catalogItems));
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
        adapter.submitList(filtered);
    }

    @Override
    public void onItemClick(CatalogItem item) {
        if (item.getImageUrl() == null || item.getImageUrl().isEmpty()) {
            return;
        }

        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(item.getImageUrl()));
        startActivity(intent);
    }
}
