package com.example.personal_blog.utils;

import com.example.personal_blog.model.Article;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {

    private static final ObjectMapper objectMapper = new ObjectMapper()
            .registerModule(new JavaTimeModule());

    public static List<Article> readArticle(File file) throws IOException {
        try {
            if (!file.exists()) {
                writeArticles(file, new ArrayList<>());
                return new ArrayList<>();
            }
            return new ArrayList<>(
                    objectMapper.readValue(file, new TypeReference<List<Article>>() {})
            );
        } catch (Exception e) {
            System.err.println("⚠️ Invalid or missing JSON file, resetting: " + e.getMessage());
            try {
                writeArticles(file, new ArrayList<>());
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            return new ArrayList<>();
        }
    }

    public static void writeArticles(File file, List<Article> articles) throws IOException {
        objectMapper.writerWithDefaultPrettyPrinter().writeValue(file, articles);
    }
}
