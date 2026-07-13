package com.example.springboot_study.dto;

import com.example.springboot_study.domain.Article;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


// JPA 전용 기본 생성자
@NoArgsConstructor
// 클래스의 모든 필드 값을 파라미터로 받는 생성자를 자동으로 생성
@AllArgsConstructor
// Lombok 자동 getter 생성
@Getter
public class AddArticleRequest {
    // 선언
    private String title;
    private String content;

    // DTO(요청 데이터)를 데이터베이스 저장용 Article 엔티티 객체로 변환
    public Article toEntity() {
        // 빌더 패턴으로 Article 엔티티 객체 생성후 return
        return Article.builder()
                .title(title)
                .content(content)
                .build();
    }
}
