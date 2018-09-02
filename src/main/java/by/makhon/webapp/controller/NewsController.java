package by.makhon.webapp.controller;

import by.makhon.webapp.bean.News;
import by.makhon.webapp.converter.NewsConverter;
import by.makhon.webapp.dto.NewsDTO;
import by.makhon.webapp.services.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.util.Collections.emptyList;
import static org.springframework.util.CollectionUtils.isEmpty;

@RestController("/news")
public class NewsController {

    @Autowired
    private NewsService newsService;
    @Autowired
    private NewsConverter newsConverter;

    @GetMapping("/{id}")
    public NewsDTO getNewsByID(@PathVariable("id") Long newsID) {
        if (newsID == null || newsID <= 0) {
            throw new IllegalArgumentException("avav gavno");
        }

        News news = newsService.getNewsByID(newsID);
        return newsConverter.convertToDTO(news);
    }

    @GetMapping
    public List<NewsDTO> getAllNews() {
        List<News> allNews = newsService.getAllNews();
        if (isEmpty(allNews)) {
            return emptyList();
        }

        return newsConverter.convertAllToDTO(allNews);
    }

    @PostMapping
    public void insertNews(@RequestBody NewsDTO newsDTO) {
//        TODO:
//            Convert to bean from DTO in NewsConverter
//            Create validator package - NewsValidator (validate news)
        News news = new News();
        newsService.insertNews(news);
    }

    @DeleteMapping("/{id}")
    public void deleteNews(@PathVariable("id") Long newsID) {
        if (newsID == null || newsID <= 0) {
            throw new IllegalArgumentException("avav gavno");
        }

        newsService.deleteNews(newsID);
    }

    @PutMapping("/{id}")
    public void updateNews(@PathVariable("id") Long newsID, @RequestBody NewsDTO newsDTO) {
        newsDTO.setId(newsID);
        newsService.updateNews(new News());
        //TODO:
//            Convert to bean from DTO in NewsConverter
//            Create validator package - NewsValidator (validate news)

    }
}
