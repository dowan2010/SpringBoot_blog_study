package com.example.springboot_study.repository;

import com.example.springboot_study.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

// JPA에선 Repository라고 부르며 인터페이스로 생성.
public interface BlogRepository extends JpaRepository<Article, Long> {
    // 인터페이스 생성 후 JpaRepository<Entity 클래스, PK 타입>을 상속하면 CRUD 메소드가 자동으로 생성.
}
