package io.github.toorajam.rgbcolornamer;

public class Main {
    public static void main(String[] args) {
        System.out.println(RGBColorNamer.getColorName("#11AA55"));
        System.out.println(RGBColorNamer.getColorName("#1A5"));
        System.out.println(RGBColorNamer.getColorName(17, 170, 85));

        System.out.println(RGBColorNamer.getColorName("#CCCCCC"));
        System.out.println(RGBColorNamer.getColorName("#CCC"));
        System.out.println(RGBColorNamer.getColorName(204, 204, 204));

        System.out.println(RGBColorNamer.getColorName("#476931"));
        System.out.println(RGBColorNamer.getColorName(71, 105, 49));
    }
}
