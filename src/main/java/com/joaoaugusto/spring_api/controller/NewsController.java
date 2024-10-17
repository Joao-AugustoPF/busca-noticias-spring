package com.joaoaugusto.spring_api.controller;

import com.joaoaugusto.spring_api.model.NewsRequest;
import com.joaoaugusto.spring_api.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/news")
public class NewsController {

    @Autowired
    private NewsService newsService;

    @GetMapping("/latest")
    public ResponseEntity<?> getLatestNews() {
        return ResponseEntity.ok(newsService.getLatestNews());
    }

    @PostMapping("/search")
    public ResponseEntity<?> searchNews(@RequestBody NewsRequest newsRequest) {
        return ResponseEntity.ok(newsService.searchNews(newsRequest.getKeyword()));
    }

    @GetMapping("/sobre")
    public ResponseEntity<String> getSobre() {
        return ResponseEntity.ok("{\"estudante\": \"João Augusto\", \"projeto\": \"Busca notícias\"}");
    }
}
