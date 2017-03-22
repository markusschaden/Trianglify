package ch.avendia.trianglify_lib;

/**
 * Created by Markus on 02.09.2015.
 */
public class ColorBrewer implements TriangleColor {


    public static final ColorBrewer YlGn = new ColorBrewer(new String[] {"#ffffe5","#f7fcb9","#d9f0a3","#addd8e","#78c679","#41ab5d","#238443","#006837","#004529"});
    public static final ColorBrewer YlGnBu = new ColorBrewer(new String[] {"#ffffd9","#edf8b1","#c7e9b4","#7fcdbb","#41b6c4","#1d91c0","#225ea8","#253494","#081d58"});
    public static final ColorBrewer GnBu = new ColorBrewer(new String[] {"#f7fcf0","#e0f3db","#ccebc5","#a8ddb5","#7bccc4","#4eb3d3","#2b8cbe","#0868ac","#084081"});
    public static final ColorBrewer BuGn = new ColorBrewer(new String[] {"#f7fcfd","#e5f5f9","#ccece6","#99d8c9","#66c2a4","#41ae76","#238b45","#006d2c","#00441b"});
    public static final ColorBrewer PuBuGn = new ColorBrewer(new String[] {"#fff7fb","#ece2f0","#d0d1e6","#a6bddb","#67a9cf","#3690c0","#02818a","#016c59","#014636"});
    public static final ColorBrewer PuBu = new ColorBrewer(new String[] {"#fff7fb","#ece7f2","#d0d1e6","#a6bddb","#74a9cf","#3690c0","#0570b0","#045a8d","#023858"});
    public static final ColorBrewer BuPu = new ColorBrewer(new String[] {"#f7fcfd","#e0ecf4","#bfd3e6","#9ebcda","#8c96c6","#8c6bb1","#88419d","#810f7c","#4d004b"});
    public static final ColorBrewer RdPu = new ColorBrewer(new String[] {"#fff7f3","#fde0dd","#fcc5c0","#fa9fb5","#f768a1","#dd3497","#ae017e","#7a0177","#49006a"});
    public static final ColorBrewer PuRd = new ColorBrewer(new String[] {"#f7f4f9","#e7e1ef","#d4b9da","#c994c7","#df65b0","#e7298a","#ce1256","#980043","#67001f"});
    public static final ColorBrewer OrRd = new ColorBrewer(new String[] {"#fff7ec","#fee8c8","#fdd49e","#fdbb84","#fc8d59","#ef6548","#d7301f","#b30000","#7f0000"});
    public static final ColorBrewer YlOrRd = new ColorBrewer(new String[] {"#ffffcc","#ffeda0","#fed976","#feb24c","#fd8d3c","#fc4e2a","#e31a1c","#bd0026","#800026"});
    public static final ColorBrewer YlOrBr = new ColorBrewer(new String[] {"#ffffe5","#fff7bc","#fee391","#fec44f","#fe9929","#ec7014","#cc4c02","#993404","#662506"});
    public static final ColorBrewer Purples = new ColorBrewer(new String[] {"#fcfbfd","#efedf5","#dadaeb","#bcbddc","#9e9ac8","#807dba","#6a51a3","#54278f","#3f007d"});
    public static final ColorBrewer Blues = new ColorBrewer(new String[] {"#f7fbff","#deebf7","#c6dbef","#9ecae1","#6baed6","#4292c6","#2171b5","#08519c","#08306b"});
    public static final ColorBrewer Greens = new ColorBrewer(new String[] {"#f7fcf5","#e5f5e0","#c7e9c0","#a1d99b","#74c476","#41ab5d","#238b45","#006d2c","#00441b"});
    public static final ColorBrewer Oranges = new ColorBrewer(new String[] {"#fff5eb","#fee6ce","#fdd0a2","#fdae6b","#fd8d3c","#f16913","#d94801","#a63603","#7f2704"});
    public static final ColorBrewer Reds = new ColorBrewer(new String[] {"#fff5f0","#fee0d2","#fcbba1","#fc9272","#fb6a4a","#ef3b2c","#cb181d","#a50f15","#67000d"});
    public static final ColorBrewer Greys = new ColorBrewer(new String[] {"#ffffff","#f0f0f0","#d9d9d9","#bdbdbd","#969696","#737373","#525252","#252525","#000000"});
    public static final ColorBrewer PuOr = new ColorBrewer(new String[] {"#7f3b08","#b35806","#e08214","#fdb863","#fee0b6","#f7f7f7","#d8daeb","#b2abd2","#8073ac","#542788","#2d004b"});
    public static final ColorBrewer BrBG = new ColorBrewer(new String[] {"#543005","#8c510a","#bf812d","#dfc27d","#f6e8c3","#f5f5f5","#c7eae5","#80cdc1","#35978f","#01665e","#003c30"});
    public static final ColorBrewer PRGn = new ColorBrewer(new String[] {"#40004b","#762a83","#9970ab","#c2a5cf","#e7d4e8","#f7f7f7","#d9f0d3","#a6dba0","#5aae61","#1b7837","#00441b"});
    public static final ColorBrewer PiYG = new ColorBrewer(new String[] {"#8e0152","#c51b7d","#de77ae","#f1b6da","#fde0ef","#f7f7f7","#e6f5d0","#b8e186","#7fbc41","#4d9221","#276419"});
    public static final ColorBrewer RdBu = new ColorBrewer(new String[] {"#67001f","#b2182b","#d6604d","#f4a582","#fddbc7","#f7f7f7","#d1e5f0","#92c5de","#4393c3","#2166ac","#053061"});
    public static final ColorBrewer RdGy = new ColorBrewer(new String[] {"#67001f","#b2182b","#d6604d","#f4a582","#fddbc7","#ffffff","#e0e0e0","#bababa","#878787","#4d4d4d","#1a1a1a"});
    public static final ColorBrewer RdYlBu = new ColorBrewer(new String[] {"#a50026","#d73027","#f46d43","#fdae61","#fee090","#ffffbf","#e0f3f8","#abd9e9","#74add1","#4575b4","#313695"});
    public static final ColorBrewer Spectral = new ColorBrewer(new String[] {"#9e0142","#d53e4f","#f46d43","#fdae61","#fee08b","#ffffbf","#e6f598","#abdda4","#66c2a5","#3288bd","#5e4fa2"});
    public static final ColorBrewer RdYlGn = new ColorBrewer(new String[] {"#a50026","#d73027","#f46d43","#fdae61","#fee08b","#ffffbf","#d9ef8b","#a6d96a","#66bd63","#1a9850","#006837"});


    /*public static final ColorBrewer YlGn = new ColorBrewer(new String[]     {"#ffffe5","#78c679","#004529"});
    public static final ColorBrewer YlGnBu = new ColorBrewer(new String[]   {"#ffffd9","#41b6c4","#081d58"});
    public static final ColorBrewer GnBu = new ColorBrewer(new String[]     {"#f7fcf0","#7bccc4","#084081"});
    public static final ColorBrewer BuGn = new ColorBrewer(new String[]     {"#f7fcfd","#66c2a4","#00441b"});
    public static final ColorBrewer PuBuGn = new ColorBrewer(new String[]   {"#fff7fb","#67a9cf","#014636"});
    public static final ColorBrewer PuBu = new ColorBrewer(new String[]     {"#fff7fb","#74a9cf","#023858"});
    public static final ColorBrewer BuPu = new ColorBrewer(new String[]     {"#f7fcfd","#8c96c6","#4d004b"});
    public static final ColorBrewer RdPu = new ColorBrewer(new String[]     {"#fff7f3","#f768a1","#49006a"});
    public static final ColorBrewer PuRd = new ColorBrewer(new String[]     {"#f7f4f9","#df65b0","#67001f"});
    public static final ColorBrewer OrRd = new ColorBrewer(new String[]     {"#fff7ec","#fc8d59","#7f0000"});
    public static final ColorBrewer YlOrRd = new ColorBrewer(new String[]   {"#ffffcc","#fd8d3c","#800026"});
    public static final ColorBrewer YlOrBr = new ColorBrewer(new String[]   {"#ffffe5","#fe9929","#662506"});
    public static final ColorBrewer Purples = new ColorBrewer(new String[]  {"#fcfbfd","#9e9ac8","#3f007d"});
    public static final ColorBrewer Blues = new ColorBrewer(new String[]    {"#f7fbff","#6baed6","#08306b"});
    public static final ColorBrewer Greens = new ColorBrewer(new String[]   {"#f7fcf5","#74c476","#00441b"});
    public static final ColorBrewer Oranges = new ColorBrewer(new String[]  {"#fff5eb","#fd8d3c","#7f2704"});
    public static final ColorBrewer Reds = new ColorBrewer(new String[]     {"#fff5f0","#fb6a4a","#67000d"});
    public static final ColorBrewer Greys = new ColorBrewer(new String[]    {"#ffffff","#969696","#000000"});*/



    public static final ColorBrewer TEST = new ColorBrewer(new String[] {"#ff0000", "#00ff00", "#0000ff"});
    public static final ColorBrewer WERNER = new ColorBrewer(new String[] {"#000000", "#000099", "#ffffff"});

    private String[] colors;

    public ColorBrewer(String[] colors) {
        this.colors = colors;
    }


    @Override
    public String[] getColors() {
        return colors;
    }

}
