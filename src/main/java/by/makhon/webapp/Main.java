package by.makhon.webapp;

import by.makhon.webapp.controller.NewsController;

public class Main {
    public static void main(String[] args) {
        NewsController newsController = new NewsController();
        newsController.getNewsByID((long) 1);
    }
}
