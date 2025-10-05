package com.example.personal_blog.controller;

import com.example.personal_blog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class GuestPageController {

    @Autowired
    private ArticleService articleService;

    @GetMapping
    public String homePage(Model model) {
        model.addAttribute("articles", articleService.getAllArticles());
        return "home"; // resolves to resources/templates/home.html
    }

    @GetMapping("/article/{id}")
    public String articlePage(@PathVariable String id, Model model) {
        model.addAttribute("article", articleService.getArticleById(id));
        return "article"; // resolves to resources/templates/article.html
    }
}
