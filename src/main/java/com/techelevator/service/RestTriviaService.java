package com.techelevator.service;

import com.techelevator.model.TriviaApi;
import com.techelevator.service.model.TriviaCategories;
import com.techelevator.service.model.TriviaCategory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.*;

/*
 * Category #s here: https://opentdb.com/api_config.php
 */
public class RestTriviaService {
    private static final int STATUS_CODE_1_NO_AVAILABLE_QUESTIONS = 1;
    private static final int NUMBER_OF_QUESTIONS = 10;
    private static final String API_URL = "https://opentdb.com/api.php";
    private static final String CATEGORY_URL = "https://opentdb.com/api_category.php";

    private Integer numberOfQuestions, category;
    private String difficulty, type;
    private WebClient webClientCategory;
    private WebClient webClientApi;
    private TriviaCategories categories;

    public RestTriviaService(){
        this.webClientCategory = WebClient
                .builder()
                .baseUrl(CATEGORY_URL)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();

        this.webClientApi = WebClient
                .builder()
                .baseUrl(API_URL)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();

        this.categories = this.getCategories();
    }

    public RestTriviaService(String category){
        this();
        this.difficulty = "easy";
        this.type = "multiple";
        this.numberOfQuestions = NUMBER_OF_QUESTIONS;
        this.category = getCategoryIdByName(category);

        if (this.category == null) {
            this.category = getCategoryIdByName("general");
        }
    }

    public TriviaApi getTrivia() throws RestClientException {
        /*
         * Example:
         * "https://opentdb.com/api.php?amount=10&category=18&difficulty=medium&type=multiple"
         */
        final String url = API_URL +
                "?amount=" + this.numberOfQuestions +
                "&category=" + this.category +
                "&difficulty=" + this.difficulty +
                "&type=" + this.type;


        return null;
    }

    public List<String> getCategoryNames(){

        List<String> categoryNames = new ArrayList<>();

        return categoryNames;
    }

    private TriviaCategories getCategories(){

        TriviaCategories categories = null;

        return categories;
    }

    private Integer getCategoryIdByName(String category){

        return null;
    }
}
