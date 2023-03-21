# rgb-color-namer
A translator for RGB colors to their names written in Java It is based on super-simple vectorization.

How to use
----------
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

