package com.example.springboot_study.service;

import com.example.springboot_study.dto.UploadResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public class LocalFileStorageService implements FileStorageService{

    //파일 시스템에서 파일을 찾는 데 사용할 수 있는 객체
    private final Path uploadDir;

    public LocalFileStorageService(@Value("${app.upload-dir:uploads}") String uploadDir) {
        // Paths: 경로 문자열이나 URI를 변환하여 경로를 반환하는 정적 메서드
        // toAbsolutePath(): 이 경로의 절대 경로를 나타내는 Paths 객체를 반환합니다
        // normalize: 결과 경로 또는 중복 이름 요소가 없는 경로를 반환

        this.uploadDir = Paths.get(uploadDir).toAbsolutePath().normalize();
    }

    @Override
    public UploadResponse store(byte[] bytes, String filename) {
        try {
            Files.createDirectories(uploadDir);// 존재하지 않는 모든 부모 디렉터리를 먼저 생성하여 디렉터리를 생성합니다.  디렉터리가 이미 존재해 생성할 수 없으면 예외가 투입되지 않습니다.
            // 매개변수:
//            dir – 생성할 디렉터리
//            attrs – 디렉터리를 생성할 때 원자적으로 설정할 수 있는 선택적 파일 속성 목록

            String ext = filename.contains(".")
                    ? filename.substring(filename.lastIndexOf('.'))
                    : ".png"; // 확장자 추출
            String saved = UUID.randomUUID() + ext;// UUID: 보편적 고유 식별자
            // randomUUID: 무작위 생성

            Files.write(uploadDir.resolve(saved), bytes);

            return new UploadResponse("/upload/" + saved);
        } catch (IOException e) {
            throw new RuntimeException("파일 저장에 실패했습니다: " + filename, e);
        }
    }
}
