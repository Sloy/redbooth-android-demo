package com.sloydev.redbooth.data.dagger;

import com.facebook.stetho.okhttp.StethoInterceptor;
import com.sloydev.redbooth.data.api.AuthenticatorRequestInterceptor;
import com.sloydev.redbooth.data.api.RedboothApi;
import com.squareup.okhttp.OkHttpClient;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit.RestAdapter;
import retrofit.client.OkClient;

@Module(
        injects = {
                AuthenticatorRequestInterceptor.class
        },
        library = true,
        complete = false
)
public class ApiModule {

    @Provides @Singleton OkHttpClient provideOkHttpClient() {
        OkHttpClient client = new OkHttpClient();
        client.networkInterceptors().add(new StethoInterceptor());
        return client;
    }

    @Provides @Singleton RedboothApi provideRedboothApi(AuthenticatorRequestInterceptor authenticatorRequestInterceptor, OkHttpClient client) {
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint("https://redbooth.com/api/3")
                .setClient(new OkClient(client))
                .setRequestInterceptor(authenticatorRequestInterceptor)
                .build();
        return restAdapter.create(RedboothApi.class);
    }

}
