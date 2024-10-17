package com.joaoaugusto.spring_api.service;

import com.joaoaugusto.spring_api.model.NewsResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class NewsService {

    private static final String API_KEY = "7d680b9a8dff43ffbc112a4489724f46";  // Substitua pela sua chave
    private static final String BASE_URL = "https://newsapi.org/v2/top-headlines?country=us&apiKey=" + API_KEY;
    private static final String SEARCH_URL = "https://newsapi.org/v2/everything?q=%s&apiKey=" + API_KEY;

    public NewsResponse getLatestNews() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<NewsResponse> response = restTemplate.getForEntity(BASE_URL, NewsResponse.class);
        return response.getBody();
    }

    public NewsResponse searchNews(String keyword) {
        String url = String.format(SEARCH_URL, keyword);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<NewsResponse> response = restTemplate.getForEntity(url, NewsResponse.class);
        return response.getBody();
    }
}
