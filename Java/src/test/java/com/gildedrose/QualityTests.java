package com.gildedrose;

import com.gildedrose.items.Item;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class QualityTests {

    @Test
    void shouldLowerQuality_NormalItem() {
        final var items = new Item[]{new Item("foo", 1, 1)};

        var app = new GildedRose(items);
        app.updateQuality();

        assertThat(app.items[0].name).isEqualTo("foo");
        assertThat(app.items[0].quality).isEqualTo(0);
    }

    @Test
    void shouldLowerQualityDoubleAfterSellIn() {
        final var items = new Item[]{new Item("foo", 0, 2)};

        var app = new GildedRose(items);
        app.updateQuality();

        assertThat(app.items[0].name).isEqualTo("foo");
        assertThat(app.items[0].quality).isEqualTo(0);
    }

    @Test
    void shouldNeverLowerQualityPastZero() {
        final var items = new Item[]{new Item("foo", 1, 0)};

        var app = new GildedRose(items);
        app.updateQuality();

        assertThat(app.items[0].name).isEqualTo("foo");
        assertThat(app.items[0].quality).isEqualTo(0);
    }
}
