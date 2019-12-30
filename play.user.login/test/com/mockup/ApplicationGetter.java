package com.mockup;

import play.Application;
import play.inject.guice.GuiceApplicationBuilder;

public class ApplicationGetter {
    public static Application fakeapp = new GuiceApplicationBuilder()
        .build();
}
