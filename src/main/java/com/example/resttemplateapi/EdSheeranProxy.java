package com.example.resttemplateapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
@Component
public class EdSheeranProxy {

    @Autowired
    RestTemplate restTemplate;

    public String makeEdSheeranRequest(String term, Integer limit){
        String uri = "https://itunes.apple.com/search?term= " + term+ "&limit=" + limit;
        ResponseEntity<String> exchange = restTemplate.exchange(
                uri,
                HttpMethod.GET,
                null,
                String.class
        );
        return exchange.getBody();
    }
}
