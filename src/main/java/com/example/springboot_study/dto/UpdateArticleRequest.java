package com.example.springboot_study.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


// JPA 전용 기본 생성자
@NoArgsConstructor
// 클래스의 모든 필드 값을 파라미터로 받는 생성자를 자동으로 생성
@AllArgsConstructor
// Lombok 자동 getter 생성
@Getter
public class UpdateArticleRequest {
    // 수정 API용 DTO
    private String title;
    private String content;
    private String imageUrl;

    public UpdateArticleRequest(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
