package by.makhon.webapp.controller;

import by.makhon.webapp.dao.NewsDAO;
import by.makhon.webapp.bean.News;
import by.makhon.webapp.dto.NewsDTO;
import by.makhon.webapp.converter.NewsConverter;
import by.makhon.webapp.services.NewsService;

import java.util.ArrayList;

public class NewsController {

    private NewsService newsService ;
    private News news;
    private NewsConverter newsConverter;

    public NewsDTO getNewsByID(Long newsID) {
        NewsDTO newsDTO = new NewsDTO();
        if (newsID != null) {
            newsDTO = newsConverter.convertToDTO(newsService.getNewsByID(newsID));
        }else{
            System.out.println("ERROR - Could not find news newsID is null");
        }
        return newsDTO;
    }

    public ArrayList<NewsDTO> getAllNews() {
        return newsConverter.convertAllToDTO(newsService.getAllNews());
    }

    public void insertNews() { newsService.insertNews(news); }

    public void deleteNews(Long newsID) { newsService.deleteNews(newsID); }

    public void updateNews() { newsService.deleteAllNews(); }
}
