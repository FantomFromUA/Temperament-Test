package com.example.testtemperament;

import java.util.List;

public class QuestionContainer {

    /**
     * Гетер для номера питання на яке зараз відповідає користувач
     * @return номер питання
     */
    public static int getAnswerNumber() {
        return answerNumber;
    }

    /**
     * Сеттер для заттаня ліста з питаннями
     * @param answerNumber ліст з питаннями
     */
    public static void setAnswerNumber(int answerNumber) {
        QuestionContainer.answerNumber = answerNumber;
    }
    // Номер питання
    private static int answerNumber = 1;
    // Ліст з питаннями
    public static List<String> questions;

    /**
     * Метод для повернення наступного питання
     * @return наступне питання
     */
    public static String getNextQuestion(){
        if(answerNumber == 57){
            return null;
        }
        answerNumber += 1;
        return questions.get(answerNumber-1);
    }

}
