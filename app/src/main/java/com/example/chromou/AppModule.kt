package com.example.chromou

import android.app.Application
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import com.example.chromou.data.ThemePreferencesRepository
import com.example.chromou.domain.UpdateHueUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import java.io.File
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideDataStore(app: Application): DataStore<Preferences> {
        return PreferenceDataStoreFactory.create(produceFile = {
            File(app.filesDir, "datastore/theme_preferences.preferences_pb")
        })
    }

    @Provides
    @Singleton
    fun provideThemePreferencesRepository(dataStore: DataStore<Preferences>): ThemePreferencesRepository {
        return ThemePreferencesRepository(dataStore)
    }

    @Provides
    @Singleton
    fun provideUpdateHueUseCase(repository: ThemePreferencesRepository): UpdateHueUseCase {
        return UpdateHueUseCase(repository)
    }
}