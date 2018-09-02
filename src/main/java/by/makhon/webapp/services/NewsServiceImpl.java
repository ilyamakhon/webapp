package by.makhon.webapp.services;

import by.makhon.webapp.bean.News;
import by.makhon.webapp.dao.NewsDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsServiceImpl implements NewsService {

    @Autowired
    private NewsDAO newsDAO;

    @Override
    public News getNewsByID(Long newsID) {
        return newsDAO.getNewsByID(newsID);
    }

    @Override
    public List<News> getAllNews() {
        return newsDAO.getAllNews();
    }

    @Override
    public void insertNews(News news) {
        newsDAO.insertNews(news);
    }

    @Override
    public void deleteNews(Long newsID) {
        newsDAO.deleteNews(newsID);
    }

    @Override
    public void updateNews(News news) {
        newsDAO.updateNews(news);
    }
}
