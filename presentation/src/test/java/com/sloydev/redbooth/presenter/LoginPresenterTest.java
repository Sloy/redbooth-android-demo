package com.sloydev.redbooth.presenter;


import com.sloydev.redbooth.data.preferences.StringPreference;
import com.sloydev.redbooth.view.LoginView;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class LoginPresenterTest {

    private static final String TOKEN_STUB = "token";
    private static final String TOKEN_NULL = null;

    @Mock StringPreference token;
    @Mock LoginView loginView;

    private LoginPresenter presenter;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        presenter = new LoginPresenter(token);
    }

    @Test
    public void shouldNotShowLoginIfTokenExists() throws Exception {
        when(token.isSet()).thenReturn(true);
        when(token.get()).thenReturn(TOKEN_STUB);

        presenter.initialize(loginView);

        verify(loginView, never()).showOAuthLoginForm(anyString());
    }


    @org.junit.Test
    public void shouldShowLoginIfTokenNotExists() throws Exception {
        when(token.isSet()).thenReturn(false);
        when(token.get()).thenReturn(TOKEN_NULL);

        presenter.initialize(loginView);

        verify(loginView, times(1)).showOAuthLoginForm(anyString());
    }
}