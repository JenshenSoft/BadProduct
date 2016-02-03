package ua.regin.badproduct.ui.settings;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.preference.XpPreferenceFragment;

import ua.regin.badproduct.R;

public class SettingsFragment extends XpPreferenceFragment {

    @Override
    public void onCreatePreferences2(final Bundle savedInstanceState, final String rootKey) {
        addPreferencesFromResource(R.xml.preferance);
    }

    public static Fragment newInstance() {
        return new SettingsFragment();
    }
}