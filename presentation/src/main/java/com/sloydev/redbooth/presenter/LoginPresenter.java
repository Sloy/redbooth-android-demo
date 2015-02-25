package com.sloydev.redbooth.presenter;

import android.net.Uri;
import android.util.Log;

import com.sloydev.redbooth.view.LoginView;

import javax.inject.Inject;

public class LoginPresenter implements Presenter {

    private static final String LOGIN_URL = "https://redbooth.com/oauth2/authorize?client_id=%s&redirect_uri=%s&response_type=token";
    private static final String REDIRECT_URL = "http%3A%2F%2Fredbooth.sloydev.com%2Fauth";
    private static final String CLIENT_ID = "491eb8a119f22244e4e7ca40778c84480d59f28a0727dbacabb2d7eeb673f80d";

    private static final String ACCESS_TOKEN_PARAMETER = "access_token";

    private LoginView loginView;

    @Inject public LoginPresenter() {
    }

    public void initialize(LoginView loginView) {
        this.loginView = loginView;
        this.showViewLoginForm();
    }

    public void onStartLoadingOAuthPage(String url) {
        if (url.contains(ACCESS_TOKEN_PARAMETER)) {
            String accessToken = accessTokenFromUrl(url);
            this.storeAccessToken(accessToken);
            this.closeViewLoginForm();
        }
    }

    private String accessTokenFromUrl(String url) {
        Uri uri = Uri.parse(url.replace("#", "?"));
        return uri.getQueryParameter(ACCESS_TOKEN_PARAMETER);
    }

    private String authenticationUrl() {
        return String.format(LOGIN_URL, CLIENT_ID, REDIRECT_URL);
    }

    private void storeAccessToken(String accessToken) {
        //TODO store token in preferences
        Log.d("Access Token", accessToken);
    }

    private void showViewLoginForm() {
        loginView.showOAuthLoginForm(authenticationUrl());
    }

    private void closeViewLoginForm() {
        loginView.hideOAuthLoginForm();
        loginView.navigateToTaskList();
    }
}
