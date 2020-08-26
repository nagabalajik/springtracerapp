package com.example.springtracerapp.serviceimpl;

import com.example.springtracerapp.service.RootService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Service
public class RootServiceImpl implements RootService{
    @Autowired
    RestTemplate restTemplate;

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

}
