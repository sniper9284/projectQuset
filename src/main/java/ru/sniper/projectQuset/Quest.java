package ru.sniper.projectQuset;

import ru.sniper.projectQuset.entity.QuestEntity;
import ru.sniper.projectQuset.entity.ResultEntity;
import ru.sniper.projectQuset.entity.UserEntity;
import ru.sniper.projectQuset.service.QuestService;
import ru.sniper.projectQuset.service.ResultService;
import ru.sniper.projectQuset.service.UserService;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Quest {
    public void start(UserService userService, ResultService resultService, QuestService questService) {
        Scanner scanner = new Scanner(System.in);
        String login;
        String quest;
        String answer1;
        String answer2;
        String answer3;
        String answer4;
        int trueAnswer;
        int ball = 0;
        int userAnswer;
        Random random = new Random();
        List<QuestEntity> l = questService.getAll();
        List<Integer> arrayList = new ArrayList<>();

        //запрашиваем логин пользователя
        System.out.println("--------------------------------------------------");
        System.out.println("Перед началом тестирования представьтесь пожалуйста!");
        login = scanner.nextLine();
        System.out.println("--------------------------------------------------");
        UserEntity userEntity = new UserEntity(login);

        boolean b = true;
        l = questService.getAll();
        for (int i = 1; i <= l.size() - 5; i++) {
            int a = random.nextInt(l.size());
            //проверка на повтор вопроса
            if (b == arrayList.contains(a)) {
                a = random.nextInt(l.size());
            } else {
                arrayList.add(a);
                ResultEntity resultEntity = new ResultEntity();
                resultEntity.setUserId(userEntity.getId());
                QuestEntity q = l.get(a);
                quest = q.getQuest();
                answer1 = q.getAnswer1();
                answer2 = q.getAnswer2();
                answer3 = q.getAnswer3();
                answer4 = q.getAnswer4();
                trueAnswer = q.getTrueAnswer();

                System.out.println("--------------------------------------------------");
                System.out.println("Вопрос №" + i + ":");
                System.out.println(quest);
                System.out.println("--------------------------------------------------");
                System.out.println("Введите № ответа и нажмите Enter.");
                System.out.println("1: " + answer1);
                System.out.println("2: " + answer2);
                System.out.println("3: " + answer3);
                System.out.println("4: " + answer4);
                userAnswer = scanner.nextInt();
                System.out.println("--------------------------------------------------");
                if (userAnswer == trueAnswer) {
                    ball++;
                }
                //заполняем сущность результатов и пишем в базу
                resultEntity.setQuestResult(quest);
                resultEntity.setAnswerResult(String.valueOf(trueAnswer));
                resultEntity.setAnswerUser(String.valueOf(userAnswer));
                resultService.saveResult(resultEntity);
            }
        }
        //заполняем пользователя и пишем в базу
        userEntity.setBall(ball);
        System.out.println("--------------------------------------------------");
        System.out.println(userEntity.getLogin() + " вы прошли тест с результатом " + userEntity.getBall() + " Баллов!");
        System.out.println("--------------------------------------------------");
        userService.saveUser(userEntity);
    }
}
