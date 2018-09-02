package by.makhon.webapp.bean;

import java.util.Date;
import java.util.Objects;

public class News {
    private Long id;
    private String title;
    private String content;
    private Date date;
    private String picURL;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getPicURL() {
        return picURL;
    }

    public void setPicURL(String picURL) {
        this.picURL = picURL;
    }

    public News() {
    }

    public News(Long id, String title, String content, Date date, String picURL) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.date = date;
        this.picURL = picURL;
    }

    public News(String title, String content, Date date, String picURL) {
        this.title = title;
        this.content = content;
        this.date = date;
        this.picURL = picURL;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        News news = (News) o;
        return Objects.equals(id, news.id) &&
                Objects.equals(title, news.title) &&
                Objects.equals(content, news.content) &&
                Objects.equals(date, news.date) &&
                Objects.equals(picURL, news.picURL);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, content, date, picURL);
    }

    @Override
    public String toString() {
        return "News{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", date=" + date +
                ", picURL='" + picURL + '\'' +
                '}';
    }
}
