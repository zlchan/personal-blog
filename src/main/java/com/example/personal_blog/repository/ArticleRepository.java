package com.example.personal_blog.repository;

import com.example.personal_blog.model.Article;

import java.util.List;
import java.util.Optional;

public interface ArticleRepository {
    List<Article> findAll();
    Optional<Article> findById(String id);
    Article save(Article article);
    Article update(Article article);
    void deleteById(String id);
}
