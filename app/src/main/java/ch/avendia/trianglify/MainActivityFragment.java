package ch.avendia.trianglify;

import android.app.WallpaperManager;
import android.content.ComponentName;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import ch.avendia.trianglify_lib.TrianglifyRandomSettings;
import ch.avendia.trianglify_lib.TrianglifyView;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        LinearLayout mainLayout = (LinearLayout)rootView.findViewById(R.id.mainLayout);

        final TrianglifyView trianglifyView = new TrianglifyView(getActivity(), new TrianglifyRandomSettings());
        mainLayout.addView(trianglifyView);
        mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                trianglifyView.setSettings(new TrianglifyRandomSettings());
                trianglifyView.invalidate();
            }
        });

        final Button button = (Button)rootView.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WallpaperManager.ACTION_CHANGE_LIVE_WALLPAPER);
                intent.putExtra(WallpaperManager.EXTRA_LIVE_WALLPAPER_COMPONENT,
                        new ComponentName(getActivity(), MyWallpaperService.class));
                startActivity(intent);
            }
        });

        return rootView;
    }
}
