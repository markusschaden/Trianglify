package ch.avendia.trianglify_lib;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Point;
import android.util.Log;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import ch.avendia.trianglify_lib.triangulation.Delaunay_Triangulation;
import ch.avendia.trianglify_lib.triangulation.Point_dt;
import ch.avendia.trianglify_lib.triangulation.Triangle_dt;

/**
 * Created by Markus on 02.09.2015.
 */
public class Trianglify {

    TrianglifySettings settings;
    private List<Triangle> triangles;
    private Canvas mCanvas;
    private Bitmap mBitmap;

    public Trianglify(TrianglifySettings settings) {

        this.settings = settings;
    }

    public Bitmap draw(int width, int height) {
        mBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        mCanvas = new Canvas(mBitmap);

        calculate(mCanvas.getWidth(), mCanvas.getHeight());
        render(mCanvas);
        return mBitmap;
    }

    public void calculate(int width, int height) {
        Random random;
        if (settings.getSeed() == null) {
            random = new Random();
        } else {
            random = new Random(settings.getSeed());
        }

        // How many cells we're going to have on each axis (pad by 2 cells on each edge)
        double cellsX = Math.floor((width + 4 * settings.getCellSize()) / settings.getCellSize());
        double cellsY = Math.floor((height + 4 * settings.getCellSize()) / settings.getCellSize());

        // figure out the bleed widths to center the grid
        double bleedX = ((cellsX * settings.getCellSize()) - width) / 2;
        double bleedY = ((cellsY * settings.getCellSize()) - height) / 2;

        // how much can out points wiggle (+/-) given the cell padding?
        double variance = settings.getCellSize() * settings.getVariance() / 2;

        // generate a point mesh
        List<Point> points = new ArrayList<>();
        for (double i = -bleedX; i < width + bleedX; i += settings.getCellSize()) {
            for (double j = -bleedY; j < height + bleedY; j += settings.getCellSize()) {
                double x = i + settings.getCellSize() / 2 + _map(random.nextDouble(), new double[]{0, 1}, new double[]{-variance, variance});
                double y = j + settings.getCellSize() / 2 + _map(random.nextDouble(), new double[]{0, 1}, new double[]{-variance, variance});
                Point p = new Point();
                p.set((int) Math.floor(x), (int) Math.floor(y));
                points.add(p);
            }
        }

        // delaunay.triangulate gives us indices into the original coordinate array

        List<Point_dt> points2 = new ArrayList<>();
        for (Point p : points) {
            points2.add(new Point_dt(p.x, p.y));
        }
        Delaunay_Triangulation delaunay_triangulation = new Delaunay_Triangulation(points2.toArray(new Point_dt[points2.size()]));

        //List<Point> geom_indices = delaunay.triangulate(points);

        Iterator<Triangle_dt> iterator = delaunay_triangulation.trianglesIterator();

       /* // iterate over the indices in groups of three to flatten them into polygons, with color lookup
        List<Triangle> triangles = new ArrayList<>();
        //var lookup_point = function(i) { return points[i];};
        for (int i=0; i < geom_indices.size(); i += 3) {
            Triangle triangle = new Triangle();

            double[][] vertices = new double[2][2];
            List<Point> verticesList = new ArrayList<>();

            for(int border = 0; border < 3; border++) {
                Point point = new Point();
                point.set(points.get(i).x, points.get(i).y);
                verticesList.add(point);

                vertices[border][0] =  point.x;
                vertices[border][1] =  point.y;
            }

            //var vertices = [geom_indices[i], geom_indices[i+ 1], geom_indices[i+2]].map(lookup_point);

            triangle.setPoints(verticesList);

            Point centroid = _centroid(vertices);

            Color color = gradient(norm_x(centroid.x, bleedX, width), norm_y(centroid.y, bleedY, height));
            triangle.setColor(color);

            triangles.add(triangle);
        }*/
        triangles = new ArrayList<>();
        while (iterator.hasNext()) {
            Triangle_dt triangle = iterator.next();
            Triangle triangle1 = new Triangle();

            if (triangle.p1() == null || triangle.p2() == null || triangle.p3() == null) continue;
            double[][] vertices = new double[3][3];
            vertices[0][0] = triangle.p1().x();
            vertices[0][1] = triangle.p1().y();

            vertices[1][0] = triangle.p2().x();
            vertices[1][1] = triangle.p2().y();

            vertices[2][0] = triangle.p3().x();
            vertices[2][1] = triangle.p3().y();

            triangle1.setColor(gradient(_centroid(vertices), width, height));
            triangle1.setTriangle_dt(triangle);
            triangles.add(triangle1);

        }
    }

    public void render(Canvas canvas) {
        Pattern pattern = new Pattern();
        pattern.renderCanvas(triangles, canvas);
    }

    // Set up normalizers
    private double norm_x(double x, double bleedX, int width) {
        double[] inRange = {-bleedX, width + bleedX};
        double[] outRange = {0, 1};
        return _map(x, inRange, outRange);
    }

    ;

    private double norm_y(double y, double bleedY, int height) {
        double[] inRange = {-bleedY, height + bleedY};
        double[] outRange = {0, 1};
        return _map(y, inRange, outRange);
    }

    ;


    private double _map(double num, double[] inRange, double[] outRange) {
        return (num - inRange[0]) * (outRange[1] - outRange[0]) / (inRange[1] - inRange[0]) + outRange[0];
    }

    //triangles only!
    private Point _centroid(double[][] d) {
        Point point = new Point();
        point.set((int) ((d[0][0] + d[1][0] + d[2][0]) / 3), (int) ((d[0][1] + d[1][1] + d[2][1]) / 3));
        return point;
    }


    private int gradient(Point point, double width, double height) {

        int f1 = settings.getxColors().getColors().length - 1;
        int f2 = settings.getyColors().getColors().length - 1;

        double xPos = point.x / (width / f1);
        if (xPos < 0) xPos = 0;
        if (xPos >= settings.getxColors().getColors().length - 1)
            xPos = settings.getxColors().getColors().length - 2;
        double yPos = point.y / (height / f2);
        if (yPos < 0) yPos = 0;
        if (yPos >= settings.getyColors().getColors().length - 1)
            yPos = settings.getyColors().getColors().length - 2;

        int xPos1 = (int) Math.floor(xPos);
        int xColor1 = Color.parseColor(settings.getxColors().getColors()[xPos1]);
        int xColor2 = Color.parseColor(settings.getxColors().getColors()[xPos1 + 1]);

        double colorXPos = (width/f1)*xPos1;
        float amountX = (float)(((point.x - colorXPos)*f1)/width);
        if(point.x < 0) amountX = 0f;
        else if(point.x > width) amountX = 1f;


        int xColor = mixTwoColors(xColor1, xColor2, 1.0f-amountX);

        int yPos1 = (int) Math.floor(yPos);
        int yColor1 = Color.parseColor(settings.getyColors().getColors()[yPos1]);
        int yColor2 = Color.parseColor(settings.getyColors().getColors()[yPos1 + 1]);

        double colorYPos = (height/f2)*yPos1;
        float amountY = (float)(((point.y - colorYPos)*f2)/height);
        if(point.y < 0) amountY = 0f;
        else if(point.y > height) amountY = 1f;

        int yColor = mixTwoColors(yColor1, yColor2, 1.0f-amountY);

        return mixTwoColors(xColor, yColor, 0.5f);
        //return yColor;
    }


    public int mixTwoColors(int color1, int color2, float amount) {
        final byte ALPHA_CHANNEL = 24;
        final byte RED_CHANNEL = 16;
        final byte GREEN_CHANNEL = 8;
        final byte BLUE_CHANNEL = 0;

        final float inverseAmount = 1.0f - amount;

        int a = ((int) (((float) (color1 >> ALPHA_CHANNEL & 0xff) * amount) +
                ((float) (color2 >> ALPHA_CHANNEL & 0xff) * inverseAmount))) & 0xff;
        int r = ((int) (((float) (color1 >> RED_CHANNEL & 0xff) * amount) +
                ((float) (color2 >> RED_CHANNEL & 0xff) * inverseAmount))) & 0xff;
        int g = ((int) (((float) (color1 >> GREEN_CHANNEL & 0xff) * amount) +
                ((float) (color2 >> GREEN_CHANNEL & 0xff) * inverseAmount))) & 0xff;
        int b = ((int) (((float) (color1 & 0xff) * amount) +
                ((float) (color2 & 0xff) * inverseAmount))) & 0xff;

        return a << ALPHA_CHANNEL | r << RED_CHANNEL | g << GREEN_CHANNEL | b << BLUE_CHANNEL;
    }


    public void setSettings(TrianglifyRandomSettings settings) {
        this.settings = settings;
    }
}
