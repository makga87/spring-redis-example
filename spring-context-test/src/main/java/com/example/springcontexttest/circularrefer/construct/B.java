package com.example.springcontexttest.circularrefer.construct;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("ci")
@Component
public class B {

    private final A a;

    public B(A a){
        this.a = a;
    }
}
