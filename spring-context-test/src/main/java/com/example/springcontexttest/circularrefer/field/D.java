package com.example.springcontexttest.circularrefer.field;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class D {

    @Autowired
    private C c;
}
