package com.example.aplicacion_moviles3c;

import java.util.ArrayList;
import java.util.List;

public class CatalogDatasource {

    public static final String CATEGORY_AUDIO = "audio";
    public static final String CATEGORY_PERIPHERALS = "perifericos";
    public static final String CATEGORY_MOUSEPADS = "mousepads";
    public static final String CATEGORY_MONITORS = "monitores";
    public static final String CATEGORY_ACCESSORIES = "accesorios";

    public List<CatalogItem> getCatalogItems() {
        List<CatalogItem> items = new ArrayList<>();
        items.add(new CatalogItem("Sony WH-1000XM5", CATEGORY_AUDIO, "Cancelación de ruido y hasta 30h de batería.", "$1.690.000"));
        items.add(new CatalogItem("HyperX Cloud III Wireless", CATEGORY_AUDIO, "Micrófono desmontable y sonido espacial DTS.", "$820.000"));
        items.add(new CatalogItem("Logitech Zone Vibe 125", CATEGORY_AUDIO, "Ligereza para videollamadas y teams corporativos.", "$640.000"));

        items.add(new CatalogItem("Keychron Q1 Pro", CATEGORY_PERIPHERALS, "Teclado mecánico inalámbrico con perillas programables.", "$1.050.000"));
        items.add(new CatalogItem("Logitech MX Master 3S", CATEGORY_PERIPHERALS, "Mouse ergonómico con Flow multi-dispositivo.", "$580.000"));
        items.add(new CatalogItem("Razer Basilisk V3 Pro", CATEGORY_PERIPHERALS, "Sensor Focus Pro 30K y carga inalámbrica.", "$720.000"));

        items.add(new CatalogItem("SteelSeries QcK Heavy XXL", CATEGORY_MOUSEPADS, "Superficie micro tejida para sensores ópticos.", "$210.000"));
        items.add(new CatalogItem("Logitech G740", CATEGORY_MOUSEPADS, "5 mm de grosor para sesiones prolongadas.", "$180.000"));

        items.add(new CatalogItem("LG UltraGear 27GP850", CATEGORY_MONITORS, "Nano IPS QHD 165Hz para esports.", "$1.980.000"));
        items.add(new CatalogItem("Dell UltraSharp U2723QE", CATEGORY_MONITORS, "Hub USB-C 90W y cobertura 98% DCI-P3.", "$3.450.000"));
        items.add(new CatalogItem("Samsung Odyssey G9", CATEGORY_MONITORS, "Panel mini-LED de 49'' con 240Hz.", "$5.900.000"));

        items.add(new CatalogItem("Elgato Stream Deck +", CATEGORY_ACCESSORIES, "Controles táctiles y perillas para automatizar flujos.", "$1.250.000"));
        items.add(new CatalogItem("APC Back-UPS Pro 1500VA", CATEGORY_ACCESSORIES, "Protección eléctrica con monitoreo vía app.", "$1.320.000"));
        items.add(new CatalogItem("Synology DS923+", CATEGORY_ACCESSORIES, "NAS compacto para respaldos híbridos.", "$3.800.000"));
        return items;
    }
}
