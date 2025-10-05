package com.example.personal_blog.controller;

import com.example.personal_blog.model.Article;
import com.example.personal_blog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class AdminPageController {

    @Autowired
    private ArticleService articleService;

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        model.addAttribute("articles", articleService.getAllArticles());
        return "admin/dashboard"; // -> resources/templates/admin/dashboard.html
    }

    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("article", new Article());
        return "admin/add";
    }

    @PostMapping("/add")
    public String saveArticle(@ModelAttribute Article article) {
        articleService.addArticle(article);
        return "redirect:/admin/dashboard";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable String id, Model model) {
        model.addAttribute("article", articleService.getArticleById(id));
        return "admin/edit";
    }

    @PostMapping("/edit/{id}")
    public String updateArticle(@PathVariable String id, @ModelAttribute Article article) {
        article.setId(id);
        articleService.updateArticle(article);
        return "redirect:/admin/dashboard";
    }

    @GetMapping("/delete/{id}")
    public String deleteArticle(@PathVariable String id) {
        articleService.deleteArticle(id);
        return "redirect:/admin/dashboard";
    }
}
