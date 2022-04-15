package com.example.testtemperament;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReadQuestions {
    /**
     * Метод для считування питань з файлу
     */
    public static void ReadQuestions(){
        QuestionContainer.questions = new ArrayList<String>();
        try(BufferedReader reader = new BufferedReader(new FileReader("src\\main\\resources\\questions_answers_txt\\Questions"))) {
            while(reader.ready()){
                QuestionContainer.questions.add(reader.readLine());
            }
        }  catch (IOException e) {
            e.printStackTrace();
        }
    }

}
