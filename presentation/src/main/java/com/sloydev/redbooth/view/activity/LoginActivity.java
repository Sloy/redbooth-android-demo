package com.sloydev.redbooth.view.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.sloydev.redbooth.R;
import com.sloydev.redbooth.presenter.LoginPresenter;
import com.sloydev.redbooth.view.LoginView;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.InjectView;


public class LoginActivity extends BaseActivity implements LoginView{

    @InjectView(R.id.webview) WebView webView;

    @Inject LoginPresenter presenter;

    @Override protected int getLayoutResource() {
        return R.layout.activity_login;
    }

    @Override protected void initializeViews() {
        ButterKnife.inject(this);

        webView.setWebViewClient(new WebViewClient() {
            @Override public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                presenter.onStartLoadingOAuthPage(url);
            }
        });
    }

    @Override protected void initializePresenter() {
        presenter.initialize(this);
    }

    @Override public void showOAuthLoginForm(String url) {
        webView.loadUrl(url);
    }

    @Override public void hideOAuthLoginForm() {
        webView.setVisibility(View.GONE);
    }

    @Override public void navigateToTaskList() {
        startActivity(new Intent(this, TaskListActivity.class));
        finish();
    }
}
