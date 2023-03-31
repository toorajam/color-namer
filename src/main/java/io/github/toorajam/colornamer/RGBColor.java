package io.github.toorajam.colornamer;

import java.util.Objects;

/**
 * Represent a single color in rgb format
 */
public class RGBColor {

    /**
     * A positive integer less than 256 represent red component of the color
     */
    private final int red;

    /**
     * A positive integer less than 256 represent green component of the color
     */
    private final int green;

    /**
     * A positive integer less than 256 represent blue component of the color
     */
    private final int blue;

    /**
     * Constructs a RGBColor object using input hex string
     *
     * @param hexString A hexadecimal color is specified with: #RRGGBB, where the RR (red), GG (green) and BB (blue) hexadecimal integers specify the components of the color.
     */
    public RGBColor(String hexString) {
        if (hexString.startsWith("#")) {
            hexString = hexString.substring(1);
        }
        if (hexString.length() == 3) {
            hexString = String.valueOf(hexString.charAt(0)) +
                    String.valueOf(hexString.charAt(0)) +
                    String.valueOf(hexString.charAt(1)) +
                    String.valueOf(hexString.charAt(1)) +
                    String.valueOf(hexString.charAt(2)) +
                    String.valueOf(hexString.charAt(2));
        }

        String[] split = hexString.split("(?<=\\G.{2})");

        this.red = Integer.parseInt(split[0], 16);
        this.green = Integer.parseInt(split[1], 16);
        this.blue = Integer.parseInt(split[2], 16);
    }


    /**
     * Constructs a RGBColor object using input integers specify the three components of the color.
     *
     * @param red   A positive integer less than 256 represent red component of the color
     * @param green A positive integer less than 256 represent green component of the color
     * @param blue  A positive integer less than 256 represent blue component of the color
     */
    public RGBColor(int red, int green, int blue) {
        this.red = red;
        this.green = green;
        this.blue = blue;
    }

    /**
     * @return red component of the color
     */
    public final int getRed() {
        return red;
    }

    /**
     * @return green component of the color
     */
    public final int getGreen() {
        return green;
    }

    /**
     * @return blue component of the color
     */
    public final int getBlue() {
        return blue;
    }

    /**
     * Computes the distance between this color and given color {@code (r1, g1, b1)}.
     *
     * @param r1 A positive integer less than 256 represent red component of the color
     * @param g1 A positive integer less than 256 represent green component of the color
     * @param b1 A positive integer less than 256 represent blue component of the color
     * @return the distance between this color and given color {@code (r1, g1, b1)}.
     */
    public double distance(int r1, int g1, int b1) {
        int dr = getRed() - r1;
        int dg = getGreen() - g1;
        int db = getBlue() - b1;
        return Math.sqrt(dr * dr + dg * dg + db * db);
    }

    /**
     * Computes the distance between this color and given color {@code color}.
     *
     * @param color the other color
     * @return the distance between this color and the specified {@code color}.
     * @throws NullPointerException if the specified {@code color} is null
     */
    public double distance(RGBColor color) {
        return distance(color.getRed(), color.getGreen(), color.getBlue());
    }

    /**
     * Returns a string representation of this {@code RGBColor}.
     * This method is intended to be used only for informational purposes.
     * The content and format of the returned string might vary between
     * implementations.
     * The returned string might be empty but cannot be {@code null}.
     */
    @Override
    public String toString() {
        return "RGBColor [r = " + getRed() + ", g = " + getGreen() + ", b = " + getBlue() + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RGBColor rgbColor = (RGBColor) o;
        return red == rgbColor.red && green == rgbColor.green && blue == rgbColor.blue;
    }

    @Override
    public int hashCode() {
        return Objects.hash(red, green, blue);
    }
}