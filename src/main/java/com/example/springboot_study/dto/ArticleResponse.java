package com.example.springboot_study.dto;

import com.example.springboot_study.domain.Article;
import lombok.Getter;

// Lombok 자동 getter 생성
@Getter
public class ArticleResponse {
    private final String title;
    private final String content;

    // Article 받아서 Article.java 에 있는 getter 로 접근 - (캡슐화)
    public ArticleResponse(Article article) {
        this.title = article.getTitle();
        this.content = article.getContent();
    }
}
