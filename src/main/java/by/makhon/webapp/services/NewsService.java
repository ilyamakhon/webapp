package by.makhon.webapp.services;

import by.makhon.webapp.DAO.NewsDAO;
import by.makhon.webapp.bean.News;
import by.makhon.webapp.dbconnection.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;

public class NewsService implements NewsDAO<News> {

    @Override
    public News getNewsByID(Long newsID) {
        News news = new News();
        String getByIDSQLQuery = "SELECT * FROM news WHERE news.newsID = " + newsID + ";";
        try(    Connection conn = ConnectionFactory.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet result = stmt.executeQuery(getByIDSQLQuery)){

            news.setId((long) result.getInt("newID"));
            news.setTitle(result.getString("newsTitle"));
            news.setContent(result.getString("newsContent"));
            news.setPicURL(result.getString("newsPic"));
            news.setDate(result.getDate("newsDate"));

        }catch (SQLException ex) {
            ex.printStackTrace();
        }
        return news;
    }

    @Override
    public ArrayList<News> getAllNews() {
        String getAllSQLQuery = "SELECT * FROM news;";
        ArrayList<News> newsList = new ArrayList<>();
        try(    Connection conn = ConnectionFactory.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet result = stmt.executeQuery(getAllSQLQuery)){
            while (result.next()) {
                newsList.add(new News((long) result.getInt("newID"), result.getString("newsTitle"),
                        result.getString("newsContent"), result.getDate("newsDate"), result.getString("newsPic")));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return newsList;
    }

    @Override
    public void insertNews(News news) {
        String insertDataQuery = "INSERT INTO news" + "(newsTitle,newsContent, newsDate, newsPic)" + "VALUES" + "(? , ?, ?, ?)";
        try (   Connection conn = ConnectionFactory.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(insertDataQuery)) {
            pstmt.setString(1, news.getTitle());
            pstmt.setString(2, news.getContent());
            pstmt.setDate(3, (Date) news.getDate());
            pstmt.setString(4, news.getPicURL());
            pstmt.execute();
        } catch (Exception sqlException) {
            sqlException.printStackTrace();
        }
    }

    @Override
    public void deleteNews(News news) {
        String deleteSQLQuery="DELETE FROM news WHERE news.newsID="+news.getId()+" ;";
        try (   Connection conn = ConnectionFactory.getConnection();
                Statement stm = conn.createStatement()){
            stm.executeUpdate(deleteSQLQuery);
        }
        catch (SQLException y){
            y.printStackTrace();
        }
    }

    @Override
    public void deleteAllNews() {
        String deleteAllSQLQuery="TRUNCATE TABLE news;";
        try (   Connection conn = ConnectionFactory.getConnection();
                Statement stm = conn.createStatement()){
            stm.executeUpdate(deleteAllSQLQuery);
        }
        catch (SQLException y){
            y.printStackTrace();
        }
    }

    @Override
    public void updateNews(News news) {
        String updateSQLQuery="UPDATE news SET newsTitle='"+news.getTitle()+"',newsContent='"+news.getContent()+"'," +
                "newsDate='"+news.getDate()+"',newsPic='"+news.getPicURL()+"'   WHERE newsID="+news.getId()+" ;";
        try (   Connection con = ConnectionFactory.getConnection();
                Statement stm = con.createStatement()){
            stm.executeUpdate(updateSQLQuery);
        }
        catch (SQLException y) {
            y.printStackTrace();	}
    }
}
