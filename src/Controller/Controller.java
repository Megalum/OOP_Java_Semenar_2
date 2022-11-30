package Controller;

import data.*;
import service.DataService;
import service.FlowService;
import service.StudyGroupServis;
import java.util.logging.Logger;

public class Controller {
    public void buttonClick(){
        Logger logger = Logger.getAnonymousLogger();

        User teacher = new Teacher("Математика","Анатолий", "20.06.1984");
        User student = new Student("012","Иван", "20.06.1996");
        User student1 = new Student("010","Дмитрий", "12.05.1996");
        User student2 = new Student("008","Виктор", "01.05.1996");
        User student3 = new Student("006","Сергей", "20.03.1996");
        User student4 = new Student("004","Роман", "01.01.1996");

        User teacher1 = new Teacher("Информатика","Игорь", "10.11.1979");
        User student10 = new Student("001","Станислав", "02.07.1998");
        User student11 = new Student("002","Марина", "12.06.1998");
        User student12 = new Student("003","Алла", "14.04.1998");
        User student13 = new Student("005","Сергей", "20.10.1998");
        User student14 = new Student("007","Анатолий", "09.08.1998");
        User student15 = new Student("009","Ирина", "09.08.1999");

        User group = new StudyGroup();
        ((StudyGroup)group).add(teacher);
        ((StudyGroup)group).add(student);
        ((StudyGroup)group).add(student1);
        ((StudyGroup)group).add(student2);
        ((StudyGroup)group).add(student3);
        ((StudyGroup)group).add(student4);
        DataService studyGroupServes = new StudyGroupServis();
        studyGroupServes.create((StudyGroup)group, "Group1.txt");
        logger.info(studyGroupServes.read("Group1.txt").toString());

        User group1 = new StudyGroup();
        ((StudyGroup)group1).add(teacher1);
        ((StudyGroup)group1).add(student10);
        ((StudyGroup)group1).add(student11);
        ((StudyGroup)group1).add(student12);
        ((StudyGroup)group1).add(student13);
        ((StudyGroup)group1).add(student14);
        ((StudyGroup)group1).add(student15);
        studyGroupServes.create((StudyGroup)group1, "Group2.txt");
        logger.info(studyGroupServes.read("Group2.txt").toString());

        User group2 = new StudyGroup();
        ((StudyGroup)group2).add(teacher1);
        ((StudyGroup)group2).add(student);
        ((StudyGroup)group2).add(student1);
        ((StudyGroup)group2).add(student2);
        ((StudyGroup)group2).add(student12);
        ((StudyGroup)group2).add(student13);
        ((StudyGroup)group2).add(student14);
        ((StudyGroup)group2).add(student15);

        User group3 = new StudyGroup();
        ((StudyGroup)group3).add(teacher);
        ((StudyGroup)group3).add(student1);
        ((StudyGroup)group1).add(student10);

        User group4 = new StudyGroup();
        ((StudyGroup)group4).add(teacher);
        ((StudyGroup)group4).add(student);
        ((StudyGroup)group4).add(student1);
        ((StudyGroup)group4).add(student2);
        ((StudyGroup)group4).add(student3);
        ((StudyGroup)group4).add(student4);
        ((StudyGroup)group4).add(student10);
        ((StudyGroup)group4).add(student11);
        ((StudyGroup)group4).add(student12);
        ((StudyGroup)group4).add(student13);
        ((StudyGroup)group4).add(student14);
        ((StudyGroup)group4).add(student15);

        Flow sgl = new Flow();
        sgl.add((StudyGroup) group);
        sgl.add((StudyGroup) group3);

        Flow sgl1 = new Flow();
        sgl1.add((StudyGroup) group1);
        sgl1.add((StudyGroup) group2);
        sgl1.add((StudyGroup) group4);

        Flow sgl2 = new Flow();
        sgl2.add((StudyGroup) group4);

        Flow sgl3 = new Flow();
        sgl3.add((StudyGroup) group);
        sgl3.add((StudyGroup) group2);
        sgl3.add((StudyGroup) group3);
        sgl3.add((StudyGroup) group1);
        sgl3.add((StudyGroup) group4);

        Flow sgl4 = new Flow();
        sgl3.add((StudyGroup) group2);
        sgl3.add((StudyGroup) group3);
        sgl3.add((StudyGroup) group1);
        sgl3.add((StudyGroup) group4);

        for (int i = 0; i < sgl.getSize(); i++) {
            for (Object object: sgl.get(i)) {
                logger.info(object.toString());
            }
        }
        logger.info("-----------------------------");

        for (int i = 0; i < sgl.getSize(); i++) {
            int k = 0;
            while (sgl.get(i).hasNext()){
                if (k++ == 3){
                    sgl.get(i).remove();
                }
                logger.info(sgl.get(i).next().toString());
            }
        }
        for (int i = 0; i < sgl.getSize(); i++) {
            sgl.get(i).removeStudentByName("Сергей");
            logger.info(sgl.get(i).toString());
        }

        FlowService fs = new FlowService();
        fs.add(sgl);
        fs.add(sgl1);
        fs.add(sgl2);
        fs.add(sgl3);
        fs.add(sgl4);
        logger.info(fs.toString());
        logger.info("------------------------------------------------------");

        fs.sort();
        logger.info(fs.toString());
    }
}
