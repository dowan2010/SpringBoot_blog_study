package com.example.springboot_study.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

// 클래스를 DB 테이블로 인식
@Entity
// getter 자동 생성 (Lombok)
@Getter
// JPA 전용 기본 생성자
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Article {
    // PK(기본키) 지정
    @Id
    // id 자동 증가를 DB에 위임
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // NOT NULL, 수정 불가 컬럼
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "content", nullable = false)
    private String content;

    // 객체 생성 패턴 - 기본 생성자
    @Builder
    public Article(String title, String content) {
        this.title = title;
        this.content = content;
    }

    // 글 제목/내용 수정 — JPA 변경 감지로 UPDATE 자동 실행
    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
