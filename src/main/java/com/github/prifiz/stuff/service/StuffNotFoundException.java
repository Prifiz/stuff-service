package com.github.prifiz.stuff.service;

import java.io.IOException;

public class StuffNotFoundException extends IOException {

    public StuffNotFoundException(String message) {
        super(message);
    }
}
