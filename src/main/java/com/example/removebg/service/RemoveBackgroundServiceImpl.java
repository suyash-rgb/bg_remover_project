package com.example.removebg.service;

import com.example.removebg.client.ClipDropClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class RemoveBackgroundServiceImpl implements IRemoveBackgroundService{

    @Value("${clipdrop.apikey}")
    private String apiKey;

    @Autowired
    private ClipDropClient clipDropClient;

    @Override
    public byte[] removeBackground(MultipartFile file){
        return clipDropClient.removeBackground(file, apiKey);
    }
}
