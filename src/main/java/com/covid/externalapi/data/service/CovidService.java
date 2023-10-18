package com.covid.externalapi.data.service;

import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import javax.print.DocFlavor;

@Service
@Slf4j
public class CovidService {

    private static final String url = "https://corona-virus-world-and-india-data.p.rapidapi.com/api";
    private  static final String xRapidAPIKey = "6db8cbeeb5msh02172fa73cdd081p1c90aejsn67573a3e2037";
    private static final String xRapidAPIHost = "corona-virus-world-and-india-data.p.rapidapi.com";

    @Autowired
    private RestTemplate restTemplate;

    public Object getAllCountryCovidData(){
        try {

            //set header values
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.set("X-RapidAPI-Key",xRapidAPIKey);
            httpHeaders.set("X-RapidAPI-Host",xRapidAPIHost);

            //Make call to endpoint
            ResponseEntity<String> response =  restTemplate.exchange(url, HttpMethod.GET,new HttpEntity<>(httpHeaders), String.class);
            log.info("Response from RapidAPI", response.getBody());

            return response.getBody();

        }
        catch (Exception e){
            log.error("Something went wrong while getting details from RapidAPI",e);
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    "Exception while calling endpoint of RapidAPI for corona",
                    e
            );
        }

    }
}


