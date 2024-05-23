package com.techelevator;

import com.techelevator.dao.QuizQuestionDao;
import com.techelevator.model.QuizQuestion;

import java.util.List;

public class QuizMakerController {

    private QuizQuestionDao dao;
    private QuizMakerView view;

    /*
     * Input parameter to the constructor is the QuizQuestionDao interface and
     * NOT jdbcQuizQuestionDao or FileQuizQuestionDao.
     *
     * This input variable never has to change its type, leaving this code as a
     * whole unaffected by the kind of object loading the questions
     */
    public QuizMakerController(QuizQuestionDao loader) {
        this.dao = loader;
        this.view = new QuizMakerView();
    }

    public void run() {

        while(true) {

            /*
             * 1. Get all quizzes
             */
            List<String> quizzes = dao.getQuizzes();

            /*
             * 2. Let user select a quiz number or category
             */
            String quizName = view.askQuiz(quizzes);

            /*
             * 3. Get the list of questions for that quiz
             */
            List<QuizQuestion> quiz = dao.getQuestionsForQuiz(quizName);

            if(quiz.size() > 0) {
                /*
                 * 4. Let the user take the quiz
                 */
                int numberRight = view.deliverQuiz(quiz);

                /*
                 * 5. Display the quiz results
                 */
                view.displayQuizResults(numberRight, quiz.size());
            } else {
                view.displayEmptyQuiz();
            }

            /*
             * 6. Ask to take more quizzes
             */
            if(!view.askRetakeQuiz()) {
                break;
            }
        }
    }
}
