package com.github.toorajam.rgbcolornamer;

import java.util.Objects;

public class RGBColor {

    private final int r;
    private final int g;
    private final int b;

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

        this.r = Integer.parseInt(split[0], 16);
        this.g = Integer.parseInt(split[1], 16);
        this.b = Integer.parseInt(split[2], 16);
    }

    public RGBColor(int r, int g, int b) {
        this.r = r;
        this.g = g;
        this.b = b;
    }

    public final int getR() {
        return r;
    }

    public final int getG() {
        return g;
    }

    public final int getB() {
        return b;
    }

    /**
     * Computes the distance between this color and given color {@code (r1, g1, b1)}.
     *
     * @param r1 the r part of other color
     * @param g1 the g part of other color
     * @param b1 the b part of other color
     * @return the distance between this color and given color {@code (r1, g1, b1)}.
     */
    public double distance(int r1, int g1, int b1) {
        int dr = getR() - r1;
        int dg = getG() - g1;
        int db = getB() - b1;
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
        return distance(color.getR(), color.getG(), color.getB());
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
        return "RGBColor [r = " + getR() + ", g = " + getG() + ", b = " + getB() + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RGBColor rgbColor = (RGBColor) o;
        return r == rgbColor.r && g == rgbColor.g && b == rgbColor.b;
    }

    @Override
    public int hashCode() {
        return Objects.hash(r, g, b);
    }
}