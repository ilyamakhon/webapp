package by.makhon.webapp.services;

import by.makhon.webapp.bean.News;
import by.makhon.webapp.connectionpool.ConnectionPool;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class NewsService {

    private ConnectionPool connectionPool;

    public News getNewsByID(Long newsID) {
        Connection conn = connectionPool.getConnectionFromPool();
        News news = new News();
        try(Statement stmt = conn.createStatement();
            ResultSet result = stmt.executeQuery("SELECT news.newsID FROM news WHERE news.newsID = newsID" );){
            news.setId(newsID);
            news.setTitle(result.getString("newsTitle"));
            news.setContent(result.getString("newsContent"));
            news.setPicURL(result.getString("newsPic"));
            news.setDate(result.getDate("newsDate"));
        }catch (SQLException ex) {
            System.out.println("PLEASE CHECK YOUR SQL SYNTAX");
        }
        try {
            connectionPool.returnConnectionToPool(conn);
        }catch (SQLException ex) {
            System.out.println("CAN'T RETURN CONNECTION TO CONNECTION POOL");
        }
        return news;
    }
}
