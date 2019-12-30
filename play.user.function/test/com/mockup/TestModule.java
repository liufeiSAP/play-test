package com.mockup;

import com.google.inject.AbstractModule;
import play.libs.akka.AkkaGuiceSupport;

public class TestModule  extends AbstractModule implements AkkaGuiceSupport {
    @Override
    protected void configure() {
    }
}
