package com.covid.externalapi.data.controller;

import com.covid.externalapi.data.service.CovidService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/covid")
@RequiredArgsConstructor
public class CovidController {


   @Autowired
   private CovidService covidService;
    @GetMapping("/get-all-countries-covid-data")
    public ResponseEntity<?> callRapidEndpointToGetCovidData(){
        return ResponseEntity.ok(covidService.getAllCountryCovidData());
    }

}
