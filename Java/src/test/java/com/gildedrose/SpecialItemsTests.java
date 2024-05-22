package com.gildedrose;

import com.gildedrose.items.Item;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SpecialItemsTests {

    @Test
    void shouldRaiseQualityOfAgedBrie() {
        final var items = new Item[] { new Item("Aged Brie", 1, 0) };
        var app = new GildedRose(items);
        app.updateQuality();

        assertThat(items[0].quality).isEqualTo(1);
    }

    @Test
    void shouldNeverRaiseQualityPast50() {
        final var items = new Item[] { new Item("Aged Brie", 1, 50) };
        var app = new GildedRose(items);
        app.updateQuality();

        assertThat(items[0].quality).isEqualTo(50);
    }

    @Test
    void shouldNeverUpdateSulfuras() {
        final var items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 1, 80) };
        var app = new GildedRose(items);
        app.updateQuality();

        assertThat(items[0].quality).isEqualTo(80);
        assertThat(items[0].sellIn).isEqualTo(1);
    }

    @Test
    void shouldIncreaseBackstagePassQuality_By2() {
        final var items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 10, 0) };
        var app = new GildedRose(items);
        app.updateQuality();

        assertThat(items[0].quality).isEqualTo(2);
        assertThat(items[0].sellIn).isEqualTo(9);
    }

    @Test
    void shouldIncreaseBackstagePassQuality_By3() {
        final var items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 4, 0) };
        var app = new GildedRose(items);
        app.updateQuality();

        assertThat(items[0].quality).isEqualTo(3);
        assertThat(items[0].sellIn).isEqualTo(3);
    }

    @Test
    void shouldUpdateBaskStagePassQualityToZero() {
        final var items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 0, 100) };
        var app = new GildedRose(items);
        app.updateQuality();

        assertThat(items[0].quality).isEqualTo(0);
        assertThat(items[0].sellIn).isEqualTo(-1);
    }

    @Test
    void shouldDegradeConjuredItemQualityBy2() {
        final var items = new Item[] { new Item("Conjured Foo", 1, 2) };
        var app = new GildedRose(items);
        app.updateQuality();

        assertThat(items[0].quality).isEqualTo(0);
    }
}
