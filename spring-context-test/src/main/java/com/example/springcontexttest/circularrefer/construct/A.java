package com.example.springcontexttest.circularrefer.construct;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("ci")
@Component
public class A {

    private final B b;

    public A(B _b){
        this.b = _b;
    }

}
