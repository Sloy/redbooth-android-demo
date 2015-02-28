package com.sloydev.redbooth.data.api;

import com.sloydev.redbooth.data.preferences.StringPreference;
import com.sloydev.redbooth.data.preferences.Token;

import javax.inject.Inject;

import retrofit.RequestInterceptor;

public class AuthenticatorRequestInterceptor implements RequestInterceptor {

    private final StringPreference token;

    @Inject public AuthenticatorRequestInterceptor(@Token StringPreference token) {
        this.token = token;
    }

    @Override public void intercept(RequestFacade request) {
        request.addQueryParam("access_token", token.get());
//        request.addHeader("Authentication", "Bearer " + token.get());
    }
}
