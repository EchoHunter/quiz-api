package com.techelevator;

import com.techelevator.dao.ApiQuizQuestionDao;
import com.techelevator.dao.QuizQuestionDao;

public class QuizMakerCLI {

    public static void main(String[] args) {

        QuizQuestionDao quizDao = new ApiQuizQuestionDao();
        QuizMakerController quizMaker = new QuizMakerController(quizDao);
        quizMaker.run();
    }
}
