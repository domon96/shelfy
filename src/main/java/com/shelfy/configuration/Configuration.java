package com.shelfy.configuration;

import org.springframework.context.annotation.Bean;

import java.net.http.HttpClient;

@org.springframework.context.annotation.Configuration
public class Configuration {

    @Bean
    public HttpClient httpClient() {
        return HttpClient.newHttpClient();
    }
}
