package by.makhon.webapp.dao;

import by.makhon.webapp.bean.News;
import by.makhon.webapp.dbconnection.ConnectionFactory;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class NewsDAOImpl implements NewsDAO {

    @Override
    public void insertNews(News news) {
        String insertDataQuery = "INSERT INTO news" + "(newsTitle,newsContent, newsDate, newsPic)" + "VALUES" + "(? , ?, ?, ?)";
        try (Connection conn = ConnectionFactory.getConnection();
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
    public News getNewsByID(Long newsID) {
        News news = new News();
        String getByIDSQLQuery = "SELECT * FROM news WHERE news.newsID = " + newsID + ";";
        try(Connection conn = ConnectionFactory.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet result = stmt.executeQuery(getByIDSQLQuery)){
            while (result.next()) {
                System.out.println(result.getString("newsContent"));
                news.setId((long) result.getInt("newsID"));
                news.setTitle(result.getString("newsTitle"));
                news.setContent(result.getString("newsContent"));
                news.setDate(result.getDate("newsDate"));
                news.setPicURL(result.getString("newsPic"));
            }
        }catch (SQLException ex) {
            ex.printStackTrace();
        }
        return news;
    }

    @Override
    public List<News> getAllNews() {
        String getAllSQLQuery = "SELECT * FROM news;";
        List<News> newsList = new ArrayList<>();
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
    public void updateNews(News news) {
        String updateSQLQuery="UPDATE news SET newsTitle='"+news.getTitle()+"',newsContent='"+news.getContent()+"'," +
                "newsDate='"+news.getDate()+"',newsPic='"+news.getPicURL()+"'   WHERE newsID="+news.getId()+" ;";
        try (   Connection con = ConnectionFactory.getConnection();
                Statement stm = con.createStatement()){
            stm.executeUpdate(updateSQLQuery);
        }
        catch (SQLException y) {
            y.printStackTrace();
        }
    }

    @Override
    public void deleteNews(Long newsID) {
        String deleteSQLQuery="DELETE FROM news WHERE news.newsID="+newsID+" ;";
        try (   Connection conn = ConnectionFactory.getConnection();
                Statement stm = conn.createStatement()){
            stm.executeUpdate(deleteSQLQuery);
        }
        catch (SQLException y){
            y.printStackTrace();
        }
    }
}
