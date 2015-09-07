package ch.avendia.trianglify_lib;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.View;

/**
 * Created by Markus on 02.09.2015.
 */
public class TrianglifyView extends View {

    Trianglify trianglify;

    public TrianglifyView(Context context) {
        super(context);
        trianglify = new Trianglify(new TrianglifyDefaultSettings());
    }

    public TrianglifyView(Context context, TrianglifySettings settings) {
        super(context);
        trianglify = new Trianglify(settings);
    }


    protected void onDraw(Canvas canvas) {

        Bitmap bitmap = trianglify.draw(canvas.getWidth(), canvas.getHeight());
        canvas.drawBitmap(bitmap, 0,0, null);
    }


    public void setSettings(TrianglifySettings settings) {
        trianglify.settings = settings;
    }


}
