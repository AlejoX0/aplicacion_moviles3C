package com.example.aplicacion_moviles3c;

import java.text.NumberFormat;
import java.util.Locale;

public class ComponentOption {
    private final String label;
    private final long price;

    public ComponentOption(String label, long price) {
        this.label = label;
        this.price = price;
    }

    public String getLabel() {
        return label;
    }

    public long getPrice() {
        return price;
    }

    @Override
    public String toString() {
        NumberFormat format = NumberFormat.getInstance(new Locale("es", "CO"));
        format.setMaximumFractionDigits(0);
        return label + " - $" + format.format(price);
    }
}
