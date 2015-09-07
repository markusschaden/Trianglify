package ch.avendia.trianglify_lib;

/**
 * Created by Markus on 02.09.2015.
 */
public class TrianglifyDefaultSettings extends TrianglifySettings {

    public TrianglifyDefaultSettings() {
        RandomColor randomColor = new RandomColor();

        setCellSize(400);
        setVariance(0.75f);
        setSeed(null);
        TriangleColor color = randomColor.getRandomColor();
        setxColors(color);
        setyColors(color);
        setStrokeWidth(1.51f);
    }
}
