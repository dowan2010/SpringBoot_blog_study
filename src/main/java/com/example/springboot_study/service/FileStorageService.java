package com.example.springboot_study.service;

import com.example.springboot_study.dto.UploadResponse;

// 의존성 역전 원칙
public interface FileStorageService {
    UploadResponse store(byte[] bytes, String filename);
}
