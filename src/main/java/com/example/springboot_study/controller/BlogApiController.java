package com.example.springboot_study.controller;


import com.example.springboot_study.domain.Article;
import com.example.springboot_study.dto.*;
import com.example.springboot_study.service.BlogService;
import com.example.springboot_study.service.WritingAssistantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Lombok으로 DI(의존성 주입)의 방법 중에 생성자 주입.
@RequiredArgsConstructor
// RESTful API를 위한 컨트롤러, JSON, XML 등의 데이터 형식을 반환
@RestController
public class BlogApiController {

    // 의존성 주입
    private final BlogService blogService;
    private final WritingAssistantService writingAssistantService;

    @PostMapping("/api/articles")
    // ResponseEntity<Article> HTTP 응답 전체를 표현하는 객체
    // @RequestBody AddArticleRequest request 클라이언트가 보낸 JSON을 자바 객체로 자동 변환
    public ResponseEntity<Article> addArticle(@RequestBody AddArticleRequest request) {

        // BlogService 에서 save 불러와 글 저장
        Article savedArticle = blogService.save(request);

        // 서버 상태 코드와 body(응답 데이터) 추가
        return ResponseEntity.status(HttpStatus.CREATED).body(savedArticle);
    }

    @GetMapping("/api/articles")
    // 제네릭 중첩 — 타입 안에 타입
    public ResponseEntity<List<ArticleResponse>> findAllArticles() {
        // DB 에서 전체 조회
        // .stream()으로
        List<ArticleResponse> articles = blogService.findAll()
                .stream()
                .map(ArticleResponse::new)
                .toList();

        // 성공 확인, articles 돌려줌
        return ResponseEntity.ok()
                .body(articles);
    }

    @GetMapping("/api/articles/{id}")
    // @PathVariable long id URL 경로 안에 박혀있는 그 값을, 메서드 파라미터로 꺼냄
    public ResponseEntity<ArticleResponse> findArticle(@PathVariable long id) {
        Article article = blogService.findById(id);

        // 새 객체 생성하여 전달
        return ResponseEntity.ok().body(new ArticleResponse(article));
    }

    @DeleteMapping("/api/articles/{id}")
    public ResponseEntity<Void> deleteArticle(@PathVariable long id) {
        blogService.delete(id);

        // .build();으로 전달
        return ResponseEntity.ok()
                .build();
    }

    @PutMapping("/api/articles/{id}")
    // @RequestBody AddArticleRequest request 클라이언트가 보낸 JSON을 자바 객체로 자동 변환
    // @PathVariable long id URL 경로 안에 박혀있는 그 값을, 메서드 파라미터로 꺼냄
    public ResponseEntity<Article> updateArticle(@PathVariable long id,
                                                 @RequestBody UpdateArticleRequest request) {

        // id로 받
        Article updatedArticle = blogService.update(id, request);
            return ResponseEntity.ok()
                    .body(updatedArticle);

    }

    @PostMapping("/api/ai-suggestions")
    public ResponseEntity<WritingSuggestionResponse> writingAssist(@RequestBody WritingSuggestionRequest request) {
        WritingSuggestionResponse response = writingAssistantService.getWritingAssist(request);

        return ResponseEntity.ok().body(response);
    }
}



