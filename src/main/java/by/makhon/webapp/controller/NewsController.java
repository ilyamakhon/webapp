package by.makhon.webapp.controller;

import by.makhon.webapp.bean.News;
import by.makhon.webapp.dto.NewsDTO;
import by.makhon.webapp.newsconverter.NewsConverter;
import by.makhon.webapp.services.NewsService;

import java.sql.SQLException;

public class NewsController {

    private NewsService newsService;
    private News news;
    private NewsDTO newsDTO;
    private NewsConverter newsConverter;

    public NewsDTO getNewsByID(Long newsID) {
        try {
            news = newsService.getNewsByID(newsID);
            newsDTO = newsConverter.convertToDTO(news);
        }catch (NullPointerException ex) {
            System.out.println("newsID = null");
        }
        return newsDTO;
    }
}
