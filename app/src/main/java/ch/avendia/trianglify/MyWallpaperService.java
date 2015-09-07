package ch.avendia.trianglify;

import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.service.wallpaper.WallpaperService;
import android.view.MotionEvent;
import android.view.SurfaceHolder;

import ch.avendia.trianglify_lib.Trianglify;
import ch.avendia.trianglify_lib.TrianglifyRandomSettings;

/**
 * Created by Markus on 02.09.2015.
 */
public class MyWallpaperService extends WallpaperService {

    @Override
    public WallpaperService.Engine onCreateEngine() {
        return new MyWallpaperEngine();
    }

    private class MyWallpaperEngine extends Engine {
        private final Handler handler = new Handler();
        private final Runnable drawRunner = new Runnable() {
            @Override
            public void run() {
                draw();
            }

        };
        private Trianglify trianglify;
        private int width;
        private int height;
        private boolean visible = true;
        private boolean touchEnabled = false;
        private WallpaperPreferences wallpaperPreferences = new WallpaperPreferences();


        private static final int FADE_MILLISECONDS = 1000; // 1 second fade effect
        private static final int FADE_STEP = 25;          // 100ms refresh

        // Calculate our alpha step from our fade parameters
        private static final int ALPHA_STEP = 255 / (FADE_MILLISECONDS / FADE_STEP);

        // Initializes the alpha to 255
        private Paint alphaPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

        // Need to keep track of the current alpha value
        private int currentAlpha = 0;


        public MyWallpaperEngine() {
            SharedPreferences prefs =getApplicationContext().getSharedPreferences("settings.xml", MODE_PRIVATE);
                    /*PreferenceManager
                    .getDefaultSharedPreferences(MyWallpaperService.this);*/

            handler.post(drawRunner);

            int secs = prefs.getInt("WAIT_TIME_VALUE", 5);
            wallpaperPreferences.setWaitTime(secs * 1000);

            trianglify = new Trianglify(new TrianglifyPreferenceSettings(wallpaperPreferences));
        }

        @Override
        public void onVisibilityChanged(boolean visible) {
            this.visible = visible;
            if (visible) {
                handler.post(drawRunner);
            } else {
                handler.removeCallbacks(drawRunner);
            }
        }


        @Override
        public void onSurfaceDestroyed(SurfaceHolder holder) {
            super.onSurfaceDestroyed(holder);
            this.visible = false;
            handler.removeCallbacks(drawRunner);
        }

        @Override
        public void onSurfaceChanged(SurfaceHolder holder, int format,
                                     int width, int height) {
            this.width = width;
            this.height = height;
            super.onSurfaceChanged(holder, format, width, height);
        }

        @Override
        public void onTouchEvent(MotionEvent event) {
            if (touchEnabled) {

                float x = event.getX();
                float y = event.getY();


                super.onTouchEvent(event);
            }
        }

        private Bitmap lastBitmap;
        private Bitmap newBitmap;

        private void draw() {
            SurfaceHolder holder = getSurfaceHolder();
            Canvas canvas = null;
            try {
                canvas = holder.lockCanvas();
                if (canvas != null) {

                    if(lastBitmap == null) {
                        lastBitmap = trianglify.draw(canvas.getWidth(), canvas.getHeight());
                        canvas.drawBitmap(lastBitmap, 0, 0, null);
                        trianglify.setSettings(new TrianglifyRandomSettings());
                        newBitmap = trianglify.draw(canvas.getWidth(), canvas.getHeight());
                    }



                    if (currentAlpha < 255) {
                        canvas.drawBitmap(lastBitmap, 0, 0, null);
                        // Draw your character at the current alpha value
                        canvas.drawBitmap(newBitmap, 0, 0, alphaPaint);

                        // Update your alpha by a step
                        alphaPaint.setAlpha(currentAlpha);
                        currentAlpha += ALPHA_STEP;

                        handler.postDelayed(drawRunner, FADE_STEP);

                    } else {
                        // No character draw, just reset your alpha paint
                        currentAlpha = 0;
                        alphaPaint.setAlpha(currentAlpha);

                        trianglify.setSettings(new TrianglifyRandomSettings());
                        lastBitmap = newBitmap;
                        newBitmap = trianglify.draw(canvas.getWidth(), canvas.getHeight());
                        canvas.drawBitmap(lastBitmap, 0, 0, null);

                        handler.removeCallbacks(drawRunner);
                        if (visible) {
                            if(wallpaperPreferences.getWaitTime() > 0) {
                                handler.postDelayed(drawRunner, wallpaperPreferences.getWaitTime());
                            }
                        }
                    }



                    /*int width = canvas.getWidth();
                    int height = canvas.getHeight();
                    holder.unlockCanvasAndPost(canvas);
                    trianglify.calculate(width, height);

                    float alphaFertig = 1.0f;
                    for(float alpha = 0; alpha < alphaFertig; alpha += 0.02) {
                        canvas = holder.lockCanvas();
                        trianglify.render(canvas, alpha);
                        holder.unlockCanvasAndPost(canvas);
                        Thread.sleep(10);
                    }*/


                }
            } /*catch (InterruptedException e) {
                e.printStackTrace();
            } */finally {
                holder.unlockCanvasAndPost(canvas);
            }


        }

    }


}
