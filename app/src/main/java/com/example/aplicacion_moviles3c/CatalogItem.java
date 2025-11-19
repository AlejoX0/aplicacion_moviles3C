package com.example.aplicacion_moviles3c;

public class CatalogItem {
    private final String name;
    private final String category;
    private final String description;
    private final String price;

    public CatalogItem(String name, String category, String description, String price) {
        this.name = name;
        this.category = category;
        this.description = description;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public String getDescription() {
        return description;
    }

    public String getPrice() {
        return price;
    }
}
