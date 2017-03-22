package ch.avendia.trianglify_lib;

/**
 * Created by Markus on 02.09.2015.
 */
public class TrianglifySettings {

    private int cellSize;
    private float variance;
    private Long seed;
    private TriangleColor xColors;
    private TriangleColor yColors;
    private float strokeWidth;

    public int getCellSize() {
        return cellSize;
    }

    public void setCellSize(int cellSize) {
        this.cellSize = cellSize;
    }

    public float getVariance() {
        return variance;
    }

    public void setVariance(float variance) {
        this.variance = variance;
    }

    public Long getSeed() {
        return seed;
    }

    public void setSeed(Long seed) {
        this.seed = seed;
    }

    public TriangleColor getxColors() {
        return xColors;
    }

    public void setxColors(TriangleColor xColors) {
        this.xColors = xColors;
    }

    public TriangleColor getyColors() {
        return yColors;
    }

    public void setyColors(TriangleColor yColors) {
        this.yColors = yColors;
    }

    public float getStrokeWidth() {
        return strokeWidth;
    }

    public void setStrokeWidth(float strokeWidth) {
        this.strokeWidth = strokeWidth;
    }
}
