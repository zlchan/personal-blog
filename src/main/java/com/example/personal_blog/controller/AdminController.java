package com.example.personal_blog.controller;

import com.example.personal_blog.model.Article;
import com.example.personal_blog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private ArticleService articleService;

    // Dashboard
    @GetMapping("/dashboard")
    public List<Article> dashboard() {
        return articleService.getAllArticles();
    }

    @PostMapping("/add")
    public Article addArticle(@RequestBody Article article) {
        return articleService.addArticle(article);
    }

    @PutMapping("/edit/{id}")
    public Article updateArticle(@PathVariable String id, @RequestBody Article article) {
        article.setId(id);
        return articleService.updateArticle(article);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteArticle(@PathVariable String id) {
        articleService.deleteArticle(id);
    }
}
