package com.example.resttemplateapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class RestTemplateApiApplication {
    @Autowired
    EdSheeranProxy edSheeranClient;
    public static void main(String[] args) {
        SpringApplication.run(RestTemplateApiApplication.class, args);
    }
    @EventListener(ApplicationStartedEvent.class)
    public void makeRequestEdSheeranEndpoint(){
        String response = edSheeranClient.makeEdSheeranRequest("edsheeran", 1);
        System.out.println(response);
    }
}
