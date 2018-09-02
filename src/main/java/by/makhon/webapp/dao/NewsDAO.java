package by.makhon.webapp.dao;

import java.util.ArrayList;

public interface NewsDAO<News> {
    void insertNews(News news);
    News getNewsByID(Long newsID);
    ArrayList<News> getAllNews();
    void updateNews(News adr);
    void deleteNews(Long newsID);
    void deleteAllNews();
}
