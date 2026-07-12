package com.example.removebg.service;


import org.springframework.web.multipart.MultipartFile;

public interface IRemoveBackgroundService {

    public byte[] removeBackground(MultipartFile file);



}
