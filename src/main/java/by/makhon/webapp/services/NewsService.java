package by.makhon.webapp.services;

import by.makhon.webapp.bean.News;
import by.makhon.webapp.dbconnection.ConnectionFactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class NewsService {

    public News getNewsByID(Long newsID) {
        Connection conn = ConnectionFactory.getConnection();
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
        return news;
    }
}
