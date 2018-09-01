package by.makhon.webapp.controller;

import by.makhon.webapp.dto.NewsDTO;
import by.makhon.webapp.newsconverter.NewsConverter;
import by.makhon.webapp.services.NewsService;

public class NewsController {

    private NewsService newsService;
    private NewsDTO newsDTO;
    private  NewsConverter newsConverter;

    public NewsDTO getNewsByID(Long newsID) {
        newsDTO = newsConverter.convertToDTO(newsService.getNewsByID(newsID));
        return newsDTO;
    }
}
