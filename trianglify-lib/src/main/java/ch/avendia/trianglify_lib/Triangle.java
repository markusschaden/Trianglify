package ch.avendia.trianglify_lib;

import android.graphics.Color;
import android.graphics.Point;

import java.util.ArrayList;
import java.util.List;

import ch.avendia.trianglify_lib.triangulation.Triangle_dt;

/**
 * Created by Markus on 02.09.2015.
 */
public class Triangle {

    private int color;
    private Triangle_dt triangle_dt;

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public Triangle_dt getTriangle_dt() {
        return triangle_dt;
    }

    public void setTriangle_dt(Triangle_dt triangle_dt) {
        this.triangle_dt = triangle_dt;
    }
}
