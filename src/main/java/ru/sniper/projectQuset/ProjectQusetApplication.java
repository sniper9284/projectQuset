package ru.sniper.projectQuset;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import ru.sniper.projectQuset.entity.QuestEntity;
import ru.sniper.projectQuset.entity.ResultEntity;
import ru.sniper.projectQuset.entity.UserEntity;
import ru.sniper.projectQuset.repository.QuestRepository;
import ru.sniper.projectQuset.repository.ResultRepository;
import ru.sniper.projectQuset.repository.UserRepository;
import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

@SpringBootApplication
public class ProjectQusetApplication {
	public static void main(String[] args) {

		ConfigurableApplicationContext context = SpringApplication.run(ProjectQusetApplication.class);
		UserRepository userRepository = context.getBean(UserRepository.class);
		QuestRepository questRepository = context.getBean(QuestRepository.class);
        ResultRepository resultRepository = context.getBean(ResultRepository.class);
		List<String> list = new LinkedList<>();
		Scanner scanner = new Scanner(System.in);
		String login;
		String line;
		String quest;
		String answer1;
		String answer2;
		String answer3;
		String answer4;
		int true_answer;
		int maxStr = 1;
		int ball = 0;
		int user_answer;
		Random random = new Random();

		//работаем с файлом. Сканируем построчно и пишем его в базу
		try {
			File file = new File("E:\\project.csv");
			FileReader fr = new FileReader(file);
			BufferedReader reader = new BufferedReader(fr);
			line = reader.readLine();
			while (line != null) {
				list.add(line);
				String[] s = line.split(";");
				QuestEntity q = new QuestEntity();
				q.setQuest(s[0]);
				q.setAnswer1(s[1]);
				q.setAnswer2(s[2]);
				q.setAnswer3(s[3]);
				q.setAnswer4(s[4]);
				q.setTrue_answer(Integer.parseInt(s[5]));
				questRepository.save(q);
				// считываем остальные строки в цикле
				line = reader.readLine();
				maxStr++;
			}

			//запрашиваем логин пользователя
			System.out.println("--------------------------------------------------");
			System.out.println("Перед началом тестирования представьтесь пожалуйста!");
			login = scanner.nextLine();
			System.out.println("--------------------------------------------------");
			UserEntity userEntity = new UserEntity(login);


			//запускаем цикл с вопросами
            List<QuestEntity> l = new LinkedList<>();
            l = questRepository.findAll();
			for (int i = 1; i <= maxStr - 10; i++) {
				int a = random.nextInt(maxStr);
				ResultEntity resultEntity = new ResultEntity();
				resultEntity.setUser_id(userEntity.getId());
				QuestEntity q = l.get(a);
				quest = q.getQuest();
				answer1 = q.getAnswer1();
				answer2 = q.getAnswer2();
				answer3 = q.getAnswer3();
				answer4 = q.getAnswer4();
				true_answer = q.getTrue_answer();

				System.out.println("--------------------------------------------------");
				System.out.println("Вопрос №" + i + ":");
				System.out.println(quest);
				System.out.println("--------------------------------------------------");
				System.out.println("Введите № ответа и нажмите Enter.");
				System.out.println("1: " + answer1);
				System.out.println("2: " + answer2);
				System.out.println("3: " + answer3);
				System.out.println("4: " + answer4);
				user_answer = scanner.nextInt();
				System.out.println("--------------------------------------------------");
				if (user_answer == true_answer) {
					ball++;
				}
				//заполняем сущность результатов и пишем в базу
				resultEntity.setQuest_result(quest);
				resultEntity.setAnswer_result(String.valueOf(true_answer));
				resultEntity.setAnswer_user(String.valueOf(user_answer));
				resultRepository.save(resultEntity);
			}
			//заполняем пользователя и пишем в базу
			userEntity.setBall(ball);
			System.out.println("--------------------------------------------------");
			System.out.println(userEntity.getLogin() + " вы прошли тест с результатом " + userEntity.getBall() + " Баллов!");
			System.out.println("--------------------------------------------------");
            userRepository.save(userEntity);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
