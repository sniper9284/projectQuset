package ru.sniper.projectQuset;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import ru.sniper.projectQuset.service.QuestService;
import ru.sniper.projectQuset.service.ResultService;
import ru.sniper.projectQuset.service.UserService;

@SpringBootApplication
public class ProjectQuestApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext context = SpringApplication.run(ProjectQuestApplication.class);
        UserService userService = context.getBean(UserService.class);
        QuestService questService = context.getBean(QuestService.class);
        ResultService resultService = context.getBean(ResultService.class);

        WriteFileToBD writeFileToBD = new WriteFileToBD();
        Quest quest = new Quest();

        if (questService.getAll().isEmpty()) {

            writeFileToBD.start(questService);
        }
        quest.start(userService, resultService, questService);
    }
}