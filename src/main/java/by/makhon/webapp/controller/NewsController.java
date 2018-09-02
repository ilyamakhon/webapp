package by.makhon.webapp.controller;

import by.makhon.webapp.DAO.NewsDAO;
import by.makhon.webapp.bean.News;
import by.makhon.webapp.dto.NewsDTO;
import by.makhon.webapp.newsconverter.NewsConverter;
import by.makhon.webapp.services.NewsService;

import java.util.ArrayList;

public class NewsController {

    private NewsDAO<News> newsDAO;
    private NewsDTO newsDTO;
    private News news;
    private NewsConverter newsConverter;

    public NewsDTO getNewsByID(Long newsID) {
        if (newsID != null) {
            newsDTO = newsConverter.convertToDTO(newsDAO.getNewsByID(newsID));
        }else{
            System.out.println("ERROR - Could not find news newsID is null");
        }
        return newsDTO;
    }

    public ArrayList<NewsDTO> getAllNews() {
        return newsConverter.convertAllToDTO(newsDAO.getAllNews());
    }

    public void insertNews() { newsDAO.insertNews(news); }

    public void deleteNews() { newsDAO.deleteNews(news); }

    public void updateNews() { newsDAO.deleteAllNews(); }
}
