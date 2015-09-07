package ch.avendia.trianglify_lib;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.Log;

import java.util.List;

import ch.avendia.trianglify_lib.triangulation.Triangle_dt;

/**
 * Created by Markus on 02.09.2015.
 */
public class Pattern {

    public void renderCanvas(List<Triangle> triangleList, Canvas canvas) {

        for(Triangle triangle : triangleList) {
            Paint paint = new Paint();
            int color = triangle.getColor();

            paint.setColor(color);
//            paint.setStyle(Paint.Style.STROKE);

            paint.setStyle(Paint.Style.FILL);
            paint.setStrokeWidth(1.51f);

            Triangle_dt triangle_dt = triangle.getTriangle_dt();

            try {
                Path path = new Path();
                path.moveTo((float) triangle_dt.p1().x(), (float) triangle_dt.p1().y());
                path.lineTo((float) triangle_dt.p2().x(), (float) triangle_dt.p2().y());
                path.lineTo((float) triangle_dt.p3().x(), (float) triangle_dt.p3().y());
                path.close();

                canvas.drawPath(path, paint);
            }catch(Exception e ) {
                Log.e("Render", e.getMessage());
                e.printStackTrace();
            }
        }

    }

}
