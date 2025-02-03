package com.example.chromou

import android.app.Application
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import dagger.hilt.android.HiltAndroidApp
import java.io.File


@HiltAndroidApp
class ChromouApplication : Application() {
    val dataStore: DataStore<Preferences> by lazy {
        PreferenceDataStoreFactory.create(produceFile = {
            File(filesDir, "datastore/theme_preferences.preferences_pb")
        })
    }
}