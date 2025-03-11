package com.example.crm.chat.zalo;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface ZaloService {
    public ResponseEntity<ZaloUser> sendMessage(ZaloUser zlUser);
    public ResponseEntity<ZaloUser> getZaloUser(String uuId);
}
