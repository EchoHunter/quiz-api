package com.techelevator;

import com.techelevator.model.QuizQuestion;

import java.util.List;
import java.util.Scanner;

public class QuizMakerView {

    private final Scanner userInput;

    public QuizMakerView(){
        this.userInput = new Scanner(System.in);
    }

    public String askQuiz(List<String> quizzes){

        for( int i = 0; i < quizzes.size(); i++){
            System.out.println(i + ". " + quizzes.get(i));
        }

        String prompt = "Please enter the quiz number you want to take: ";
        int quizNumber = promptForIntWithRange(prompt, 0, quizzes.size() - 1);

        String quizName = quizzes.get(quizNumber);
        System.out.println("Starting quiz for: " + quizName);

        return quizName;
    }

    public int deliverQuiz(List<QuizQuestion> quizQuestions) {
        int numberOfCorrectAnswers = 0;

        for (QuizQuestion quizQuestion : quizQuestions) {
            int answerNum = promptForInt(quizQuestion + "\nYour answer? ");
            int correctAnswer = quizQuestion.getCorrectAnswer();

            if (correctAnswer == answerNum) {
                System.out.println("Correct!");
                numberOfCorrectAnswers += 1;
            } else {
                System.out.println("Sorry that isn't correct!" + " The correct answer was " + correctAnswer);
            }
        }

        return numberOfCorrectAnswers;
    }

    public void displayQuizResults(int numberRight, int totalQuestions){
        System.out.println("You got " + numberRight + " answer(s) correct out of the "
                + totalQuestions + " question(s) asked.");
    }

    public void displayEmptyQuiz() {
        System.out.println("Unfortunately, there are no quiz questions for this quiz");
    }

    public boolean askRetakeQuiz() {
        return promptForYesNo("Would you like to retake the quiz (Y/N)? ");
    }

    private int promptForInt(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                String reply = userInput.nextLine();
                return Integer.parseInt(reply);
            } catch (NumberFormatException e) {
                System.out.println("---Only numbers, please.---");
            }
        }
    }

    private int promptForIntWithRange(String prompt, Integer smallestInt, Integer largestInt) {

        while (true) {

            Integer selection = promptForInt(prompt);

            boolean isWithinRange = (smallestInt == null || selection >= smallestInt) &&
                            (largestInt  == null || selection <= largestInt);

            if(isWithinRange) {
                return selection;
            }

            System.out.println("Please enter a valid number from " + smallestInt + " to " + largestInt);
        }
    }

    private boolean promptForYesNo(String prompt) {
        while (true) {
            System.out.print(prompt);
            String reply = userInput.nextLine();

            if(reply.equalsIgnoreCase("y") || reply.equalsIgnoreCase("yes")){
                return true;
            }
            else if (reply.equalsIgnoreCase("n") || reply.equalsIgnoreCase("no")){
                return false;
            }

            System.out.println("Please enter Y or N");
        }
    }
}
