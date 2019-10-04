/*
 * Copyright (C) 2019 The MoKee Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.lineageos.settings.device.sound;

import android.os.Bundle;
import android.util.Log;

import android.support.v14.preference.PreferenceFragment;
import android.support.v14.preference.SwitchPreference;
import android.support.v7.preference.SeekBarPreference;
import android.support.v7.preference.Preference;

import org.lineageos.settings.device.R;

import android.provider.Settings;
import android.content.Context;
import android.os.UserHandle;
import android.app.Activity;
import android.preference.PreferenceActivity;

public class SoundSettingsFragment extends PreferenceFragment
    implements Preference.OnPreferenceChangeListener {

    private static final String TAG = "Kowalski OS";

    private Context mContext;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.mContext = (Context)activity;
    }

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        addPreferencesFromResource(R.xml.sound_settings);
    }

    @Override
    public boolean onPreferenceChange(Preference preference, Object newValue) {
        String pref = preference.getKey();
        boolean res = (Boolean)newValue;
        int p = res ? 1 : 0;
        Settings.Secure.putIntForUser(mContext.getContentResolver(),
            pref, p, UserHandle.USER_CURRENT);
        return true;
    }

    @Override
    public void addPreferencesFromResource(int preferencesResId) {
        super.addPreferencesFromResource(preferencesResId);
        this.addPreference(Settings.Secure.HEADSET_STARTS_MUSIC_PLAYER);
        this.addPreference(Settings.Secure.BT_STARTS_MUSIC_PLAYER);
    }

    private void addPreference(String pref) {
        SwitchPreference b = (SwitchPreference) findPreference(pref);
        if (b == null) return;
        boolean res = Settings.Secure.getIntForUser(mContext.getContentResolver(),
            pref, 0, UserHandle.USER_CURRENT) != 0;
        b.setChecked(res);
        b.setOnPreferenceChangeListener(this);
    }
}
