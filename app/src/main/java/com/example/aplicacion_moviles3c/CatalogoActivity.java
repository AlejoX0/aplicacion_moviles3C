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

    private final CatalogDatasource datasource = new CatalogDatasource();
    private final List<CatalogItem> catalogItems = datasource.getCatalogItems();
    private CatalogAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalogo);

        RecyclerView recyclerView = findViewById(R.id.recyclerViewCatalogo);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new CatalogAdapter();
        recyclerView.setAdapter(adapter);

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

    private void filterCatalog(int chipId) {
        String category;
        if (chipId == R.id.chipAudifonos) {
            category = CatalogDatasource.CATEGORY_AUDIO;
        } else if (chipId == R.id.chipPerifericos) {
            category = CatalogDatasource.CATEGORY_PERIPHERALS;
        } else if (chipId == R.id.chipMousepads) {
            category = CatalogDatasource.CATEGORY_MOUSEPADS;
        } else if (chipId == R.id.chipMonitores) {
            category = CatalogDatasource.CATEGORY_MONITORS;
        } else if (chipId == R.id.chipAccesorios) {
            category = CatalogDatasource.CATEGORY_ACCESSORIES;
        } else {
            category = null;
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
