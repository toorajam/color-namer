package io.github.toorajam.colornamer;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Locale;
import java.util.Properties;

/**
 * A utility class for converting rgb color code to its name.
 * <br>
 * <br>
 * sample:
 * <pre>
 * RGBColorNamer.getColorName("#11AA55");                   // seagreen
 * RGBColorNamer.getColorName("#CCC");                      // lightgray
 * RGBColorNamer.getColorName(new RGBColor(71, 105, 49);    // darkolivegreen
 * </pre>
 */
public class RGBColorNamer {
    private static final HashMap<RGBColor, String> KNOWN_COLORS_MAP;

    static {
        KNOWN_COLORS_MAP = new HashMap<>();
        Properties colorProps = new Properties();
        try {
            // initial filling of colorProps
            InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream("knownColors.properties");
            colorProps.load(in);
            if (in != null) {
                in.close();
            }

            // initial filling of KNOWN_COLORS_MAP from colorProps
            for (Object key : colorProps.keySet()) {
                String hexColor = colorProps.getProperty(String.valueOf(key));
                KNOWN_COLORS_MAP.put(new RGBColor(hexColor), String.valueOf(key));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private RGBColorNamer() {
    }

    /**
     * Find name of given rgb color. It is using super simple vectorization.
     *
     * @param colorHex The hex code of color in #112233 or #123 format.
     * @return Name of the hex. e.g. khaki
     * @throws IllegalArgumentException if the specified {@code colorHex} format is invalid or not supported.
     */
    public static String getColorName(String colorHex) {
        if (!colorHex.toUpperCase(Locale.ROOT).matches("(#[0-9A-F]{3})|(#[0-9A-F]{6})")) {
            throw new IllegalArgumentException("Invalid or not supported hex code format of color.");
        }
        RGBColor inputColor = new RGBColor(colorHex);
        return getColorName(inputColor);
    }

    /**
     * Find name of given rgb color. It is using super simple vectorization.
     *
     * @param red   A positive integer less than 256 represent red component of the input color
     * @param green A positive integer less than 256 represent green component of the input color
     * @param blue  A positive integer less than 256 represent blue component of the input color
     * @return Name of the rgb color. e.g. khaki
     * @throws IllegalArgumentException if the specified {@code colorHex} format is invalid or not supported.
     */
    public static String getColorName(int red, int green, int blue) {
        if (red < 0 || red >= 256 || green < 0 || green >= 256 || blue < 0 || blue >= 256) {
            throw new IllegalArgumentException("Invalid parameter of color.");
        }
        RGBColor inputColor = new RGBColor(red, green, blue);
        return getColorName(inputColor);

    }

    /**
     * Find name of given rgb color. It is using super simple vectorization.
     *
     * @param inputColor The input color to find its name
     * @return Name of the rgb color. e.g. khaki
     */
    public static String getColorName(RGBColor inputColor) {
        RGBColor closestColor = new RGBColor("#ffffff");
        double closestColorDistance = Double.MAX_VALUE;

        // find the closest color
        for (RGBColor color : KNOWN_COLORS_MAP.keySet()) {
            double distance = inputColor.distance(color);
            if (distance < closestColorDistance) {
                closestColor = color;
                closestColorDistance = distance;
            }
        }

        // return name of the closest color
        return KNOWN_COLORS_MAP.get(closestColor);
    }
}
