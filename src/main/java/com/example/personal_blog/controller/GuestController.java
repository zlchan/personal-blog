package com.example.personal_blog.controller;

import com.example.personal_blog.model.Article;
import com.example.personal_blog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class GuestController {

    @Autowired
    private ArticleService articleService;

    @GetMapping
    public List<Article> getHomePage() {
        return articleService.getAllArticles();
    }

    @GetMapping("/article/{id}")
    public Article getArticlePage(@PathVariable String id) {
        return articleService.getArticleById(id);
    }
}
