package by.makhon.webapp.services;

import by.makhon.webapp.bean.News;

import java.util.List;

public interface NewsService {

    News getNewsByID(Long newsID);

    List<News> getAllNews();

    void insertNews(News news);

    void deleteNews(Long newsID);

    void updateNews(News news);
}
