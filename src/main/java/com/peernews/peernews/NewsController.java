package com.peernews.peernews;

import com.peernews.peernews.model.News;
import com.peernews.peernews.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/news")
public class NewsController {
    @Autowired
    private NewsService newsService;

    @GetMapping("/demo")
    public String demo() {
        return "Hello from News Controller!";
    }

    @GetMapping
    public List<News> getAllNews() {
        return newsService.getAllNews();
    }

    @GetMapping("/{id}")
    public News getNewsById(@PathVariable Long id) {
        return newsService.getNewsById(id);
    }

    @PostMapping
    public News createNews(@RequestBody News news) {
        return newsService.saveNews(news);
    }

    @PutMapping("/{id}")
    public News updateNews(@PathVariable Long id, @RequestBody News news) {
        News existingNews = newsService.getNewsById(id);
        if (existingNews != null) {
            existingNews.setTitle(news.getTitle());
            existingNews.setDescription(news.getDescription());
            existingNews.setAuthor(news.getAuthor());
            existingNews.setDate(news.getDate());
            return newsService.saveNews(existingNews);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteNews(@PathVariable Long id) {
        newsService.deleteNews(id);
    }
}
