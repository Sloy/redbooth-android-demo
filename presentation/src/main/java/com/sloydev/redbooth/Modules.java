package com.sloydev.redbooth;

import com.sloydev.redbooth.dagger.RedboothModule;

public class Modules {
    static Object[] list(RedboothApplication app) {
        return new Object[] {
                new RedboothModule(app)
        };
    }
}
