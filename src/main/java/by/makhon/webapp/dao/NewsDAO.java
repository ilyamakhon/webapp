package by.makhon.webapp.dao;

import java.util.List;

public interface NewsDAO<News> {
    void insertNews(News news);
    News getNewsByID(Long newsID);
    List<News> getAllNews();
    void updateNews(News news);
    void deleteNews(Long newsID);
    void deleteAllNews();
}
