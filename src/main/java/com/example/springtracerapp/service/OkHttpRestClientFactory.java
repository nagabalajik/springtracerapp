package com.example.springtracerapp.service;

import io.opentracing.Tracer;
import io.opentracing.contrib.okhttp3.TracingCallFactory;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class OkHttpRestClientFactory {
    private final Tracer tracer;

    public OkHttpRestClientFactory(Tracer tracer) {
        this.tracer = tracer;
    }

    @Bean
    @Primary
    public OkHttpClient createClient() {
        return new OkHttpClient.Builder()
                .build();
    }

    public Call.Factory getTracerClient(OkHttpClient client) {
        return new TracingCallFactory(client, tracer);
    }
}
