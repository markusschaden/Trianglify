package ch.avendia.trianglify;

/**
 * Created by Markus on 03.09.2015.
 */
public class WallpaperPreferences {

    int waitTime = 5 * 1000;
    //int fadeTime = 1000;
    //float fadeProgress = 0.02f;
    int cellSizeMin = 100;
    int cellSizeMax = 300;
    float varianceMin = 0.25f;
    float varianceMax = 0.85f;

    public int getWaitTime() {
        return waitTime;
    }

    public void setWaitTime(int waitTime) {
        this.waitTime = waitTime;
    }

    public int getCellSizeMin() {
        return cellSizeMin;
    }

    public void setCellSizeMin(int cellSizeMin) {
        this.cellSizeMin = cellSizeMin;
    }

    public int getCellSizeMax() {
        return cellSizeMax;
    }

    public void setCellSizeMax(int cellSizeMax) {
        this.cellSizeMax = cellSizeMax;
    }

    public float getVarianceMin() {
        return varianceMin;
    }

    public void setVarianceMin(float varianceMin) {
        this.varianceMin = varianceMin;
    }

    public float getVarianceMax() {
        return varianceMax;
    }

    public void setVarianceMax(float varianceMax) {
        this.varianceMax = varianceMax;
    }
}
