package com.example.springtracerapp.service;

import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public interface RootService {
    String getUsingRestTemplate();
    String getUsingOkhttp() throws IOException;
}
