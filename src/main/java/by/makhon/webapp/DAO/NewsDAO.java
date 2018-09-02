package by.makhon.webapp.DAO;

import java.util.ArrayList;

public interface NewsDAO<T> {
    void insertNews(T adr);
    T getNewsByID(Long id);
    ArrayList<T> getAllNews();
    void updateNews(T adr);
    void deleteNews(T adr);
    void deleteAllNews();
}
