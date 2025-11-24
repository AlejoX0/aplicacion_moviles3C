package com.example.aplicacion_moviles3c;

import androidx.annotation.DrawableRes;

public class CatalogItem {
    private final String name;
    private final String categoryKey;
    private final String categoryLabel;
    private final String description;
    private final String highlight;
    private final String price;
    private final int imageResId;
    private final String imageUrl;

    public CatalogItem(
            String name,
            String categoryKey,
            String categoryLabel,
            String description,
            String highlight,
            String price,
            @DrawableRes int imageResId,
            String imageUrl
    ) {
        this.name = name;
        this.categoryKey = categoryKey;
        this.categoryLabel = categoryLabel;
        this.description = description;
        this.highlight = highlight;
        this.price = price;
        this.imageResId = imageResId;
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public String getCategoryKey() {
        return categoryKey;
    }

    public String getCategoryLabel() {
        return categoryLabel;
    }

    public String getDescription() {
        return description;
    }

    public String getHighlight() {
        return highlight;
    }

    public String getPrice() {
        return price;
    }

    public int getImageResId() {
        return imageResId;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}
