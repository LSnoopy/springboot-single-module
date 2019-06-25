package org.knowleaf.test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;


public class ControllerTest extends BaseSpringBootJunitTest {

    @Autowired
    private TestRestTemplate restTemplate;


    @Test
    public void controller() {
        post("/h", "");
    }

    private String post(String url, String param) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.valueOf("application/json;UTF-8"));
        HttpEntity<String> strEntity = new HttpEntity<>(param, headers);

        String body = restTemplate.postForObject(url, strEntity, String.class);
        System.out.println(body);
        return body;
    }

}
