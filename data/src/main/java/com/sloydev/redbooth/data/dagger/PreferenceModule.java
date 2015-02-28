package com.sloydev.redbooth.data.dagger;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import com.sloydev.redbooth.data.preferences.StringPreference;
import com.sloydev.redbooth.data.preferences.Token;

import dagger.Module;
import dagger.Provides;

@Module(
        library = true,
        complete = false
)
public class PreferenceModule {

    @Provides SharedPreferences provideSharedPreferences(Application application) {
        return application.getSharedPreferences("redbooth", Context.MODE_PRIVATE);
    }

    @Provides @Token StringPreference provideToken(SharedPreferences sharedPreferences) {
        return new StringPreference(sharedPreferences, "token");
    }
}
