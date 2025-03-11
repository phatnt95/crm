package com.example.crm.chat.zalo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

public class ZaloServiceImpl implements ZaloService {
    @Autowired
    ZaloUserRepository zaloUserRepository;


    /**
     * @return
     */
    @Override
    public ResponseEntity<ZaloUser> sendMessage(ZaloUser zlUser) {
        zaloUserRepository.save(zlUser);
        return null;
    }

    /**
     * @param uuId
     * @return
     */
    @Override
    public ResponseEntity<ZaloUser> getZaloUser(String uuId) {
        ZaloUser zlUser = zaloUserRepository.findByuuId(uuId);
        if(zlUser == null) {
            // do callout
        }
        return new ResponseEntity<> (zlUser, HttpStatus.CREATED);
    }
}
