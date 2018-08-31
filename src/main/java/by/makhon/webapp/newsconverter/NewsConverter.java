package by.makhon.webapp.newsconverter;

import by.makhon.webapp.bean.News;
import by.makhon.webapp.dto.NewsDTO;

public class NewsConverter {

    private NewsDTO newsDTO = new NewsDTO();

    public NewsDTO convertToDTO(News news) {
        newsDTO.setId(news.getId());
        newsDTO.setContent(news.getContent());
        newsDTO.setPicURL(news.getPicURL());
        newsDTO.setTitle(news.getTitle());
        newsDTO.setDate(news.getDate());

        return newsDTO;
    }
}