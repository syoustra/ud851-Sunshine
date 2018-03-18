package com.example.android.sunshine;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.preference.CheckBoxPreference;
import android.support.v7.preference.ListPreference;
import android.support.v7.preference.Preference;
import android.support.v7.preference.PreferenceFragmentCompat;
import android.support.v7.preference.PreferenceManager;
import android.support.v7.preference.PreferenceScreen;

/**
 * Created by stephanieyoustra on 3/18/18.
 */

public class SettingsFragment extends PreferenceFragmentCompat implements SharedPreferences.OnSharedPreferenceChangeListener {

                                                                                //SOLUTION HAS setPrefSummary BEFORE onCreatePref
    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {    //SOLUTION HAS Bundle bundle, String s
        addPreferencesFromResource(R.xml.pref_general);

        SharedPreferences sharedPreferences = getPreferenceScreen().getSharedPreferences();
        PreferenceScreen prefScreen = getPreferenceScreen();
        int count = prefScreen.getPreferenceCount();

        for (int i = 0; i < count; i++) {
            Preference p = prefScreen.getPreference(i);
            if (!(p instanceof CheckBoxPreference)) {
                String value = sharedPreferences.getString(p.getKey(), null);       //SOLUTION HAS defValue: ""
                setPreferenceSummary(p, value);
            }
        }

    }

    private void setPreferenceSummary(Preference preference, Object value) {
        String stringValue = value.toString();                                        //THESE TWO FROM SOLUTION
        String key = preference.getKey();

        if (preference instanceof ListPreference) {
            ListPreference listPreference = (ListPreference) preference;
            int prefIndex = listPreference.findIndexOfValue(stringValue);
            if (prefIndex >= 0) {
                listPreference.setSummary(listPreference.getEntries()[prefIndex]);
            }
        } else {                                                                         //ALSO FROM SOLUTION
            preference.setSummary(stringValue);
        }
    }


                                                                                //SOLUTION SEQUENCE IS onStop, onStart, onSharedPrefChange
    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        Preference preference = findPreference(key);
        if (null != preference) {
            if(!(preference instanceof CheckBoxPreference)) {
                                    //SOLUTION COMBINES TO setPreferenceSummary(preference, sharedPreferences.getString(key, ""));
                String value = sharedPreferences.getString(preference.getKey(), "");
                setPreferenceSummary(preference, value);
            }
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        getPreferenceScreen().getSharedPreferences().registerOnSharedPreferenceChangeListener(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        getPreferenceScreen().getSharedPreferences().unregisterOnSharedPreferenceChangeListener(this);
    }
}
