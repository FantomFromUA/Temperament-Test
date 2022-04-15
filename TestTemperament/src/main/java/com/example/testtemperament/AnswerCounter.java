package com.example.testtemperament;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AnswerCounter<балами> {
    // HashMap для зберігання питань і відповідей на них для рахування балів в полі Екстравертизм
    private static final HashMap<Integer, Boolean> extraversionAnswers = new HashMap<>();
    // List для зберігання питаня(всі відповіді так) для рахування балів в полі Невротизм
    private static final List<Integer> neuroticismAnswers = new ArrayList<>();
    // HashMap для зберігання питань і відповідей на них для рахування балів в полі Неправда
    private static final HashMap<Integer, Boolean> lieAnswers = new HashMap<>();

    // поле з балами Екстравертизм
    private static int countExtraversion = 0;
    // поле з балами Невротизм
    private static int countNeuroticism = 0;
    // поле з балами Неплавда
    private static int countLie = 0;

    /**
     * Геттер для балів Неправди
     * @return бали в категорії неправда
     */
    public static int getCountLie() {
        return countLie;
    }

    /**
     * Метод для оновлення всі полів
     */
    public static void recetAll(){
        countExtraversion = 0;
        countLie = 0;
        countNeuroticism = 0;
    }


    // поле силка на сайт з визначенням
    private static String urlInfo = null;

    /**
     * Гетер для силки на сайт з інформацією
     * @return силка на сайт з інформацією
     */
    public static String getUrlInfo() {
        return urlInfo;
    }

    /**
     * Метод для заповнення всіх колекції
     */
    public static void fillAnswers(){
        fillHashMap(extraversionAnswers, "src\\main\\resources\\questions_answers_txt\\answersExtraversion");
        fillList(neuroticismAnswers);
        fillHashMap(lieAnswers, "src\\main\\resources\\questions_answers_txt\\answersLie");
    }

    /**
     * Метод для заповнення колецкій HashMap
     * @param map HashMap який потрібно заповнити
     * @param dir директорія файла звідки беруться дані
     */
    private static void fillHashMap(HashMap<Integer, Boolean> map, String dir){
        try (BufferedReader reader = new BufferedReader(new FileReader(dir))) {
            while (reader.ready()){
                String[] line = reader.readLine().split(" ");
                map.put(Integer.parseInt(line[0]), Boolean.parseBoolean(line[1]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Метод для заповнення колецкій List
     * @param ls List для заповнення
     */
    private static void fillList(List<Integer> ls){
        try (BufferedReader reader = new BufferedReader(new FileReader("src\\main\\resources\\questions_answers_txt\\answersNeuroticism"))) {
          while (reader.ready()){
              ls.add(Integer.parseInt(reader.readLine()));
          }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Метод для вижнечення в яке поле додати бал залежно від відповіді на питання користувачем
     * @param question номер питання
     * @param answer відповідь на питання
     */
    public static void checkAnswer(int question, boolean answer){
        if (extraversionAnswers.containsKey(question) && extraversionAnswers.get(question) == answer){
            countExtraversion++;
            return;
        }
        if(neuroticismAnswers.contains(question) && answer){
            countNeuroticism++;
            return;
        }
        if(lieAnswers.containsKey(question) && answer == lieAnswers.get(question)){
            countLie++;
        }
    }

    /**
     * Метод визначає та повертає результат після завершення тесту
     * @return Темперамент користувача
     */
    public static String getResult(){
        if(countNeuroticism < 13 && countExtraversion < 13){
            urlInfo = "https://uk.wikipedia.org/wiki/Флегматик";
            return "Ви флегматик";
        }
        if(countNeuroticism > 12 && countExtraversion < 13){
            urlInfo = "https://uk.wikipedia.org/wiki/Меланхолік";
            return "Ви меланхолік";
        }
        if(countNeuroticism < 13 && countExtraversion > 13){
            urlInfo = "https://uk.wikipedia.org/wiki/Сангвінік";
            return "Ви сангвінік";
        }
        urlInfo = "https://uk.wikipedia.org/wiki/Холерик";
        return "Ви холерик";
    }

    /**
     * Повертає текст залежно від кількості балів в полі неправда
     * @return
     */
    public static String checkLie(){
        if(countLie < 4)
            return "Все добре";
        if (countLie < 6)
            return "Результат може бути не точним";
        return "Рекомендуємо пройти тест ще раз";
    }
}
