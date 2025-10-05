package com.example.personal_blog.repository.impl;

import ch.qos.logback.core.util.FileUtil;
import com.example.personal_blog.model.Article;
import com.example.personal_blog.repository.ArticleRepository;
import com.example.personal_blog.utils.FileUtils;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Repository
public class JsonFileArticleRepository implements ArticleRepository {

    private final File storageFile;

    // Hardcode or inject the path for now
    public JsonFileArticleRepository() {
        this.storageFile = new File("articles.json");
    }

    @Override
    public List<Article> findAll() {
        try {
            return FileUtils.readArticle(storageFile);
        } catch (IOException e) {
            throw new RuntimeException("Error reading articles", e);
        }
    }

    @Override
    public Optional<Article> findById(String id) {
        return findAll().stream()
                .filter(article -> Objects.equals(article.getId(), id))
                .findFirst();
    }

    @Override
    public Article save(Article article) {
        List<Article> articles = findAll();
        article.setId(UUID.randomUUID().toString());
        article.setDatePublished(LocalDateTime.now());
        articles.add(article);
        persist(articles);
        return article;
    }

    @Override
    public Article update(Article article) {
        List<Article> articles = findAll();
        articles.removeIf(a -> Objects.equals(a.getId(), article.getId()));
        articles.add(article);
        persist(articles);
        return article;
    }

    @Override
    public void deleteById(String id) {
        List<Article> articles = findAll();
        articles.removeIf(a -> Objects.equals(a.getId(), id));
        persist(articles);
    }

    private void persist(List<Article> articles) {
        try {
            FileUtils.writeArticles(storageFile, articles);
        } catch (IOException e) {
            throw new RuntimeException("Error writing articles", e);
        }
    }
}
