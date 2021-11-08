package ru.sniper.projectQuset;

import ru.sniper.projectQuset.entity.QuestEntity;
import ru.sniper.projectQuset.service.QuestService;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class WriteFileToBD {
    public void start(QuestService questService) {
        List<String> list = new ArrayList<>();
        String line;
        try {
            File file = new File(
                    ProjectQuestApplication.class.getClassLoader().getResource("project.csv").getFile()
            );
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
                q.setTrueAnswer(Integer.parseInt(s[5]));
                questService.saveQuest(q);
                // считываем остальные строки в цикле
                line = reader.readLine();
            }
            reader.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

