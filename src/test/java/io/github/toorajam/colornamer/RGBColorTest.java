package io.github.toorajam.colornamer;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class RGBColorTest {

    @Test
    public void distance_RGBColor() {
        Assert.assertEquals(0d, new RGBColor("#CCC").distance(new RGBColor("#CCC")), 0d);
        Assert.assertEquals(0d, new RGBColor("#CCC").distance(new RGBColor("#CCCCCC")), 0d);
        Assert.assertEquals(0d, new RGBColor("#CCC").distance(new RGBColor(204, 204, 204)), 0d);

        Assert.assertEquals(224.24d, new RGBColor("#CCC").distance(new RGBColor("#1A5")), 0.01d);
        Assert.assertEquals(226.96d, new RGBColor("#CCC").distance(new RGBColor("#476931")), 0.01d);
    }

    @Test
    public void distance_int_int_int() {
        Assert.assertEquals(0d, new RGBColor("#CCC").distance(204, 204, 204), 0d);
        Assert.assertEquals(224.24d, new RGBColor("#CCC").distance(17, 170, 85), 0.01d);
        Assert.assertEquals(226.96d, new RGBColor("#CCC").distance(71, 105, 49), 0.01d);
    }

    @Test
    public void testToString() {
        Assert.assertEquals("RGBColor [r = 204, g = 204, b = 204]", new RGBColor("#CCC").toString());
        Assert.assertEquals("RGBColor [r = 204, g = 204, b = 204]", new RGBColor(204, 204, 204).toString());
    }
}