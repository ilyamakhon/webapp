package by.makhon.webapp.dao;

import by.makhon.webapp.bean.News;

import java.util.List;

public interface NewsDAO {
    void insertNews(News news);
    News getNewsByID(Long newsID);
    List<News> getAllNews();
    void updateNews(News news);
    void deleteNews(Long newsID);
}
