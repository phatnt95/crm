package com.example.crm.callout;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class CalloutServiceImpl implements CalloutService {
    @Autowired
    RestTemplate restTemplate;

    /**
     * @param url
     * @param requestBody
     * @return
     */
    @Override
    public ResponseEntity<Object> excutePost(String url, Object requestBody) {
        return restTemplate.postForEntity(url, requestBody, Object.class);
    }
}
