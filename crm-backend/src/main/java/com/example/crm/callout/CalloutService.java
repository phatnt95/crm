package com.example.crm.callout;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface CalloutService {
    public ResponseEntity<Object> excutePost(String url, Object requestBody);
}
