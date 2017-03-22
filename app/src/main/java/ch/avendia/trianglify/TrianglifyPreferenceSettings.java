package ch.avendia.trianglify;

import java.util.Random;

import ch.avendia.trianglify_lib.RandomColor;
import ch.avendia.trianglify_lib.TriangleColor;
import ch.avendia.trianglify_lib.TrianglifyRandomSettings;
import ch.avendia.trianglify_lib.TrianglifySettings;

/**
 * Created by Markus on 02.09.2015.
 */
public class TrianglifyPreferenceSettings extends TrianglifyRandomSettings {

    public TrianglifyPreferenceSettings(WallpaperPreferences wallpaperPreferences) {
        super();
        Random random = new Random();

        setCellSize(random.nextInt(wallpaperPreferences.getCellSizeMax())+wallpaperPreferences.getCellSizeMin());
        setVariance(Math.max(Math.min(wallpaperPreferences.getVarianceMax(), random.nextFloat()), wallpaperPreferences.getVarianceMin()));

    }
}
