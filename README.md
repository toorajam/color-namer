# color-namer
A translator for RGB colors to their names written in Java. It is based on super-simple vectorization.

## How to use?
```
RGBColorNamer.getColorName("#11AA55");      // seagreen
RGBColorNamer.getColorName("#1A5");         // seagreen
RGBColorNamer.getColorName(17, 170, 85);    // seagreen

RGBColorNamer.getColorName("#CCCCCC");      // lightgray
RGBColorNamer.getColorName("#CCC");         // lightgray
RGBColorNamer.getColorName(204, 204, 204);  // lightgray

RGBColorNamer.getColorName("#476931");      // darkolivegreen
RGBColorNamer.getColorName(71, 105, 49);    // darkolivegreen
```

## How does it work?
There is a list of known RGB colors, including their names and the RGB code for each. To find the name of a given color, you must try to find the nearest known color and return the name of that.


## Known issue
If we're using the RGB colorspace, the difference between two colors isn't the same as how humans perceive the difference, though. But yes, the basic idea is the same; we'd just have to map it into another color space. Maybe LAB.
