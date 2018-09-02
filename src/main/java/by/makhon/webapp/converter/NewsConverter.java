package by.makhon.webapp.converter;

import by.makhon.webapp.bean.News;
import by.makhon.webapp.dto.NewsDTO;

import java.util.ArrayList;
import java.util.List;

public class NewsConverter {

    public NewsDTO convertToDTO(News news) {
        NewsDTO newsDTO = new NewsDTO();

        newsDTO.setId(news.getId());
        newsDTO.setContent(news.getContent());
        newsDTO.setPicURL(news.getPicURL());
        newsDTO.setTitle(news.getTitle());
        newsDTO.setDate(news.getDate());

        return newsDTO;
    }

    public List<NewsDTO> convertAllToDTO(List<News> newsList) {
        List<NewsDTO> newsDTOList = new ArrayList<>();
        for(News i: newsList) {
            newsDTOList.add(this.convertToDTO(i));
        }
        return newsDTOList;
    }
}