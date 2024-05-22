package com.gildedrose.items;

import org.apache.commons.lang3.StringUtils;

public enum ItemType {

    Sulfuras, AgedBrie, BackstagePass, Conjured, Normal;

    public static ItemType fromName(String name) {
        if(StringUtils.equalsIgnoreCase(name, ItemNames.SULFURAS)) return Sulfuras;

        if(StringUtils.equalsIgnoreCase(name, ItemNames.AGED_BRIE)) return AgedBrie;

        if(StringUtils.containsIgnoreCase(name, "Backstage passes")) return BackstagePass;

        if(StringUtils.containsIgnoreCase(name, "conjured")) return Conjured;

        return Normal;
    }
}
