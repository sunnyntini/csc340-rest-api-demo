package com.csc340.RestAPI;

import java.util.Arrays;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author sentini
 */
@RestController
public class RestApiController {

    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format("Hello, %s!", name);
    }

    @GetMapping("/countries")
    public List<Object> getCountries() {
        String url = "https://restcountries.com/v3.1/all";
        RestTemplate restTemplate = new RestTemplate();
        Object[] countryList = restTemplate.getForObject(url, Object[].class);
        return Arrays.asList(countryList);
    }

    @GetMapping("/universities")
    public List<Object> getUniversities() {
        String url = "http://universities.hipolabs.com/search";
        RestTemplate restTemplate = new RestTemplate();
        Object[] universities = restTemplate.getForObject(url, Object[].class);
        return Arrays.asList(universities);
    }

}
