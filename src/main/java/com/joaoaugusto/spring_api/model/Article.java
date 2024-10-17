package com.joaoaugusto.spring_api.model;

import lombok.Data;

@Data
public class Article {
    private String author;
    private String title;
    private String description;
    private String url;
    private String publishedAt;
}