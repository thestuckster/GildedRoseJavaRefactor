package com.gildedrose;

import com.gildedrose.items.Item;
import com.gildedrose.items.ItemType;

class GildedRose {
    final Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (var item : items) {
            final var itemType = ItemType.fromName(item.name);

            //note sulfuras is missing because its sellin and quality never change;
            switch (itemType) {
                case AgedBrie -> updateAgedBrie(item);
                case BackstagePass -> updateBackstagePasses(item);
                case Conjured -> updateConjuredItem(item);
                case Normal -> updateNormalItem(item);
            }
        }
    }

    private void updateAgedBrie(Item item) {
        if (item.quality < 50) item.quality++;
        item.sellIn--;
    }

    private void updateBackstagePasses(Item item) {
        item.sellIn--;

        if (item.quality == 0 && item.sellIn < 0) return;

        final var sellIn = item.sellIn;
        if (sellIn <= 10 && sellIn > 5) item.quality += 2;
        else if (sellIn <= 5 && sellIn > 0) item.quality += 3;
        else item.quality = 0;
    }

    private void updateConjuredItem(Item item) {
        item.sellIn--;

        if (item.quality == 0) return;

        if (isPastSellDate(item)) item.quality -= 4;
        else item.quality -= 2;
    }

    private void updateNormalItem(Item item) {
        item.sellIn--;

        if (item.quality == 0) return;

        if (isPastSellDate(item)) item.quality -= 2;
        else item.quality--;
    }

    private boolean isPastSellDate(Item item) {
        return item.sellIn < 0;
    }
}
