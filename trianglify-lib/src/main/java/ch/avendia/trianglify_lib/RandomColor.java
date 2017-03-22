package ch.avendia.trianglify_lib;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Markus on 02.09.2015.
 */
public class RandomColor {

    private List<TriangleColor> colorList = new ArrayList<>();
    private Random randomGenerator = new Random();

    public RandomColor() {
        colorList.add(ColorBrewer.YlGn);
        colorList.add(ColorBrewer.YlGnBu);
        colorList.add(ColorBrewer.GnBu);
        colorList.add(ColorBrewer.BuGn);
        colorList.add(ColorBrewer.PuBuGn);
        colorList.add(ColorBrewer.PuBu);
        colorList.add(ColorBrewer.BuPu);
        colorList.add(ColorBrewer.RdPu);
        colorList.add(ColorBrewer.PuRd);
        colorList.add(ColorBrewer.OrRd);
        colorList.add(ColorBrewer.YlOrRd);
        colorList.add(ColorBrewer.YlOrBr);
        colorList.add(ColorBrewer.Purples);
        colorList.add(ColorBrewer.Blues);
        colorList.add(ColorBrewer.Greens);
        colorList.add(ColorBrewer.Oranges);
        colorList.add(ColorBrewer.Reds);
        colorList.add(ColorBrewer.Greys);
        colorList.add(ColorBrewer.PuOr);
        colorList.add(ColorBrewer.BrBG);
        colorList.add(ColorBrewer.PRGn);
        colorList.add(ColorBrewer.PiYG);
        colorList.add(ColorBrewer.RdBu);
        colorList.add(ColorBrewer.RdGy);
        colorList.add(ColorBrewer.RdYlBu);
        colorList.add(ColorBrewer.Spectral);
        colorList.add(ColorBrewer.RdYlGn);
    }

    public TriangleColor getRandomColor(){
        int index = randomGenerator.nextInt(colorList.size());
        return colorList.get(index);
        //return ColorBrewer.WERNER;
    }
}
