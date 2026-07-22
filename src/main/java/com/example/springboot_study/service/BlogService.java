package com.example.springboot_study.service;

import com.example.springboot_study.domain.Article;
import com.example.springboot_study.dto.AddArticleRequest;
import com.example.springboot_study.dto.UpdateArticleRequest;
import com.example.springboot_study.repository.BlogRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

// Lombok으로 스프링에서 DI(의존성 주입)의 방법 중에 생성자 주입을 임의의 코드없이 자동으로 설정해주는 어노테이션.
@RequiredArgsConstructor
// 비즈니스 로직
@Service
public class BlogService {
    // 의존성 주입
    private final BlogRepository blogRepository;

    // DTO를 Entity로 바꿔서 DB 저장
    // AddArticleRequest — 타입, request — 변수명
    public Article save(AddArticleRequest request) {
        return blogRepository.save(request.toEntity());
    }

    // Article라는 list 에서 결과 모두 반환
    public List<Article> findAll() {
        return blogRepository.findAll();
    }

    // 파라미터 long id 받아서 Jpa 에서 받아 findById 실행
    public Article findById(long id) {
        // 값이 없을 경우 null 대신 예외 객체로 감싸 "not found: {id}" 반환
        return blogRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found: " + id));
    }

    // 파라미터 long id 받아서 jpa 에서 deleteById(id) 실행
    public void delete(long id) {
        blogRepository.deleteById(id);
    }

    // 트랜잭션
    @Transactional
    // 파라미터로 long id, UpdateArticleRequest request 받아 update 후 반환
    public Article update(long id, UpdateArticleRequest request) {
        Article article = blogRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found: " + id));
        article.update(request.getTitle(), request.getContent());

        return article;
    }
}
