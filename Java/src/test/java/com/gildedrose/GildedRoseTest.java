package com.gildedrose;

import com.gildedrose.items.Item;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void shouldLowerSellin() {
        final var items = new Item[] { new Item("foo", 1, 0) };

        var app = new GildedRose(items);
        app.updateQuality();

        assertThat(app.items[0].name).isEqualTo("foo");
        assertThat(app.items[0].sellIn).isEqualTo(0);
    }




}
