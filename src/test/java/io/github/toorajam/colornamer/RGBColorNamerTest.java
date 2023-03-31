package io.github.toorajam.colornamer;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class RGBColorNamerTest {

    @Test
    public void getColorName_string() {
        Assert.assertEquals("color hex in 6 character format", "seagreen", RGBColorNamer.getColorName("#11AA55"));
        Assert.assertEquals("color hex in 6 character format", "lightgray", RGBColorNamer.getColorName("#CCCCCC"));
        Assert.assertEquals("color hex in 6 character format", "darkolivegreen", RGBColorNamer.getColorName("#476931"));
        Assert.assertEquals("color hex in 3 character format", "seagreen", RGBColorNamer.getColorName("#1A5"));
        Assert.assertEquals("color hex in 3 character format", "lightgray", RGBColorNamer.getColorName("#CCC"));
    }

    @Test
    public void getColorName_RGBColor() {
        Assert.assertEquals("color in rgb ints", "seagreen", RGBColorNamer.getColorName(new RGBColor(17, 170, 85)));
        Assert.assertEquals("color in rgb ints", "lightgray", RGBColorNamer.getColorName(new RGBColor(204, 204, 204)));
        Assert.assertEquals("color in rgb ints", "darkolivegreen", RGBColorNamer.getColorName(new RGBColor(71, 105, 49)));
    }

    @Test
    public void getColorName_int_int_int() {
        Assert.assertEquals("color in rgb ints", "seagreen", RGBColorNamer.getColorName(17, 170, 85));
        Assert.assertEquals("color in rgb ints", "lightgray", RGBColorNamer.getColorName(204, 204, 204));
        Assert.assertEquals("color in rgb ints", "darkolivegreen", RGBColorNamer.getColorName(71, 105, 49));
    }
}