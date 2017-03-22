package ch.avendia.trianglify;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;

public class WallpaperSettingsFragment extends PreferenceFragment implements SharedPreferences.OnSharedPreferenceChangeListener {

    private SeekBarPreference _seekBarPref;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        PreferenceManager manager = getPreferenceManager();
        manager.setSharedPreferencesName("settings.xml");

        addPreferencesFromResource(R.xml.preferences);

        // Get widgets :
        _seekBarPref = (SeekBarPreference) this.findPreference("WAIT_TIME_VALUE");

        // Set listener :
        getPreferenceScreen().getSharedPreferences().registerOnSharedPreferenceChangeListener(this);

        // Set seekbar summary :
        int radius = PreferenceManager.getDefaultSharedPreferences(this.getActivity().getApplicationContext()).getInt("WAIT_TIME_VALUE", 5);
        _seekBarPref.setSummary(this.getString(R.string.settings_summary).replace("$1", "" + radius));


    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {

        // Set seekbar summary :
        int radius = PreferenceManager.getDefaultSharedPreferences(this.getActivity().getApplicationContext()).getInt("WAIT_TIME_VALUE", 5);
        _seekBarPref.setSummary(this.getString(R.string.settings_summary).replace("$1", ""+radius));

    }
}
