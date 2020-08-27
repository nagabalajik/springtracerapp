package com.example.springtracerapp.serviceimpl;

import com.example.springtracerapp.service.OkHttpRestClientFactory;
import com.example.springtracerapp.service.RootService;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Request.Builder;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.Arrays;

@Service
public class RootServiceImpl implements RootService{
    @Autowired
    RestTemplate restTemplate;

    @Autowired
    private OkHttpRestClientFactory okHttpRestClientFactory;
    @Autowired
    private OkHttpClient client;

    @Override
    public String getUsingRestTemplate(){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.ALL));
        HttpEntity<String> entity = new HttpEntity<String>(headers);

        return restTemplate.exchange("http://localhost:8081/",
                HttpMethod.GET,
                entity,
                String.class).getBody();
    }

    @Override
    public String getUsingOkhttp() throws IOException {
        Builder requestBuilder = new Request.Builder()
                .url("http://localhost:8081/");
        return callWithTracingEnabled(requestBuilder, client).body().string();
    }

    private Response callWithTracingEnabled(Request.Builder requestBuilder, OkHttpClient client)
            throws IOException{
        Request request = requestBuilder.build();
        Call.Factory clientWithTracer = okHttpRestClientFactory.getTracerClient(client);
        Response response = clientWithTracer.newCall(request).execute();
        return response;

    }
}
