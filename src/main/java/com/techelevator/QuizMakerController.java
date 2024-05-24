package com.techelevator;

import com.techelevator.dao.QuizQuestionDao;
import com.techelevator.model.QuizQuestion;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

public class QuizMakerController {

    private QuizQuestionDao dao;
    private QuizMakerView view;
    public WebClient webClient;
    public String[] quizzes;
    public QuizMakerController(QuizQuestionDao loader) {
        this.dao = loader;
        this.view = new QuizMakerView();
    }

    public void run() {

        /*
         * 1. Get all quizzes
         */
        webClient = WebClient
                .builder()
                .baseUrl("https://opentdb.com/api.php?amount=10")
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();

        quizzes = webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .queryParam())



        /*
         * 2. Let user select a quiz number or category
         */


        /*
         * 3. Get the list of questions for that quiz
         */

        /*
         * 4. If there are quizzes to take
         */

        /*
         * 5. Let the user take the quiz
         */


        /*
         * 6. Display the quiz results
         */

        /*
         * 7. Ask to take more quizzes
         */


    }
}
